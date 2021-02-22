package com.github.liao47.union.utils;

import com.github.liao47.union.config.UnionConfig;
import com.github.liao47.union.config.UnionProp;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.*;
import java.util.*;

/**
 * Description:<>
 *
 * @author zyx
 * @Date 2020/7/22 16:31
 **/
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CertUtils {

    public static final String UNION_PAY_CN_NAME = "中国银联股份有限公司";

    /**
     * 签名证书类型，固定不需要修改
     */
    private static final String SIGN_CERT_TYPE = "PKCS12";
    //TODO fixme
    private static final UnionConfig UNION_CONFIG = new UnionConfig();

    /**
     * 证书容器集合，存储对商户请求报文签名私钥证书.
     */
    private static final Map<String, KeyStore> KEY_STORE_MAP = new HashMap<>(64);

    /**
     * 敏感信息加密公钥证书
     */
    private static X509Certificate encryptCert;
    /**
     * 验签中级证书
     */
    private static X509Certificate middleCert;
    /**
     * 验签根证书
     */
    private static X509Certificate rootCert;

    static {
        //添加签名，验签，加密算法提供者
        addProvider();
        init();
    }

    /**
     * 获取签名私钥证书
     * @param unionProp
     * @return
     */
    public static KeyStore getAndInit(UnionProp unionProp) {
        return KEY_STORE_MAP.computeIfAbsent(unionProp.getMerId(), k -> initSignCert(unionProp));
    }

    /**
     * 初始化所有证书.
     */
    private static void init() {
        try {
            //初始化验签证书的中级证书
            initMiddleCert();
            //初始化验签证书的根证书
            initRootCert();
            //初始化加密公钥
            initEncryptCert();
        } catch (Exception e) {
            log.error("init失败。（如果是用对称密钥签名的可无视此异常。）:", e);
        }
    }

    /**
     * 证书加载重置
     */
    public static void clearCertMap() {
        if (!KEY_STORE_MAP.isEmpty()) {
            KEY_STORE_MAP.clear();
        }
    }

    /**
     * 添加签名，验签，加密算法提供者
     */
    public static void addProvider() {
        if (Security.getProvider("BC") == null) {
            log.info("add BC provider");
            Security.addProvider(new BouncyCastleProvider());
        } else {
            //解决eclipse调试时tomcat自动重新加载时，BC存在不明原因异常的问题。
            Security.removeProvider("BC");
            Security.addProvider(new BouncyCastleProvider());
            log.info("re-add BC provider");
        }
    }

    /**
     * 加载签名证书
     */
    private static KeyStore initSignCert(UnionProp unionProp) {
        if (unionProp.getSignCertPath() == null || unionProp.getSignCertPwd() == null) {
            log.warn("SIGN_CERT_PATH或SIGN_CERT_PWD为空。 停止加载签名证书。");
            return null;
        }

        return getKeyInfo(unionProp.getSignCertPath(), unionProp.getSignCertPwd(), SIGN_CERT_TYPE);
    }

    /**
     * 加载敏感信息加密证书
     */
    private static void initMiddleCert() {
        log.info("加载中级证书==>{}", UNION_CONFIG.getMiddleCertPath());
        if (!StringUtils.isEmpty(UNION_CONFIG.getMiddleCertPath())) {
            middleCert = initCert(UNION_CONFIG.getMiddleCertPath());
            log.info("Load MiddleCert Successful");
        } else {
            log.warn("MiddleCert path is empty");
        }
    }

    /**
     * 加载敏感信息加密证书
     */
    private static void initRootCert() {
        log.info("加载根证书==>{}", UNION_CONFIG.getRootCertPath());
        if (!StringUtils.isEmpty(UNION_CONFIG.getRootCertPath())) {
            rootCert = initCert(UNION_CONFIG.getRootCertPath());
            log.info("Load RootCert Successful");
        } else {
            log.warn("RootCert path is empty");
        }
    }

    /**
     * 加载银联公钥上级证书（中级证书）
     */
    private static void initEncryptCert() {
        log.info("加载敏感信息加密证书==>{}", UNION_CONFIG.getEncryptCertPath());
        if (!StringUtils.isEmpty(UNION_CONFIG.getEncryptCertPath())) {
            encryptCert = initCert(UNION_CONFIG.getEncryptCertPath());
            log.info("Load EncryptCert Successful");
        } else {
            log.warn("EncryptCert path is empty");
        }
    }

    /**
     * 通过证书路径初始化为公钥证书
     *
     * @param path
     * @return
     */
    private static X509Certificate initCert(String path) {
        X509Certificate encryptCertTemp = null;
        try (InputStream inputStream = CertUtils.class.getClassLoader().getResourceAsStream(path)) {
            CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");
            encryptCertTemp = (X509Certificate) cf.generateCertificate(inputStream);
            // 打印证书加载信息,供测试阶段调试
            log.info("[{}][CertId={}]", path, encryptCertTemp.getSerialNumber().toString());
        } catch (CertificateException e) {
            log.error("Init cert Error:", e);
        } catch (NoSuchProviderException e) {
            log.error("Load cert error: No BC provider:", e);
        } catch (IOException e) {
            log.error("Load cert threw IOException:", e);
        }
        return encryptCertTemp;
    }

    /**
     * 将签名私钥证书文件读取为证书存储对象
     *
     * @param pfxKeyFile 证书文件名
     * @param keyPwd     证书密码
     * @param type       证书类型
     * @return 证书对象
     */
    private static KeyStore getKeyInfo(String pfxKeyFile, String keyPwd, String type) {
        log.info("加载签名证书==>{}", pfxKeyFile);
        try (InputStream inputStream = CertUtils.class.getClassLoader().getResourceAsStream(pfxKeyFile)) {
            KeyStore ks = KeyStore.getInstance(type, "BC");
            log.info("Load RSA CertPath=[{}],Pwd=[{}],type=[{}]", pfxKeyFile, keyPwd, type);

            char[] nPassword = StringUtils.isBlank(keyPwd) ? null : keyPwd.toCharArray();
            ks.load(inputStream, nPassword);
            log.info("Init signCert successful. certId=[{}]", getSignCertId(ks));
            return ks;
        } catch (Exception e) {
            log.error("getKeyInfo Error:", e);
            return null;
        }
    }

    /**
     * 获取签名私钥证书certId
     * @param unionProp
     * @return 证书的物理编号
     */
    public static String getSignCertId(UnionProp unionProp) {
        return getSignCertId(getAndInit(unionProp));
    }

    /**
     * 获取签名私钥证书certId
     * @param keyStore
     * @return 证书的物理编号
     */
    public static String getSignCertId(KeyStore keyStore) {
        try {
            Enumeration<String> aliasEnum = keyStore.aliases();
            String keyAlias = null;
            if (aliasEnum.hasMoreElements()) {
                keyAlias = aliasEnum.nextElement();
            }
            X509Certificate certificate = (X509Certificate) keyStore.getCertificate(keyAlias);
            return certificate.getSerialNumber().toString();
        } catch (Exception e) {
            log.error("getSignCertId Error", e);
            return null;
        }
    }

    /**
     * 证书文件过滤器
     */
    static class CerFilter implements FilenameFilter {
        public boolean isCer(String name) {
            return name.toLowerCase().endsWith(".cer");
        }

        @Override
        public boolean accept(File dir, String name) {
            return isCer(name);
        }
    }

    /**
     * 通过keyStore 获取私钥签名证书PrivateKey对象
     *
     * @return
     */
    public static PrivateKey getSignCertPrivateKey(UnionProp unionProp) {
        try {
            KeyStore keyStore = getAndInit(unionProp);
            Enumeration<String> aliasEnum = keyStore.aliases();
            String keyAlias = null;
            if (aliasEnum.hasMoreElements()) {
                keyAlias = aliasEnum.nextElement();
            }
            return (PrivateKey) keyStore.getKey(keyAlias, unionProp.getSignCertPwd().toCharArray());
        } catch (KeyStoreException | UnrecoverableKeyException | NoSuchAlgorithmException e) {
            log.error("getSignCertPrivateKey Error:", e);
            return null;
        }
    }

    /**
     * 将字符串转换为X509Certificate对象.
     *
     * @param x509CertString
     * @return
     */
    public static X509Certificate genCertificateByStr(String x509CertString) {
        X509Certificate x509Cert = null;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509", "BC");
            InputStream tIn = new ByteArrayInputStream(
                    x509CertString.getBytes(StandardCharsets.ISO_8859_1));
            x509Cert = (X509Certificate) cf.generateCertificate(tIn);
        } catch (Exception e) {
            log.error("gen certificate error:", e);
        }
        return x509Cert;
    }

    /**
     * 验证书链。
     *
     * @param cert
     * @return
     */
    private static boolean verifyCertificateChain(X509Certificate cert) {

        if (null == cert) {
            log.error("cert must Not null");
            return false;
        }

        X509Certificate middleCert = CertUtils.getMiddleCert();
        if (null == middleCert) {
            log.error("middleCert must Not null");
            return false;
        }

        X509Certificate rootCert = CertUtils.getRootCert();
        if (null == rootCert) {
            log.error("rootCert or cert must Not null");
            return false;
        }

        try {

            X509CertSelector selector = new X509CertSelector();
            selector.setCertificate(cert);

            Set<TrustAnchor> trustAnchors = new HashSet<>();
            trustAnchors.add(new TrustAnchor(rootCert, null));
            PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(
                    trustAnchors, selector);

            Set<X509Certificate> intermediateCerts = new HashSet<>();
            intermediateCerts.add(rootCert);
            intermediateCerts.add(middleCert);
            intermediateCerts.add(cert);

            pkixParams.setRevocationEnabled(false);

            CertStore intermediateCertStore = CertStore.getInstance("Collection",
                    new CollectionCertStoreParameters(intermediateCerts), "BC");
            pkixParams.addCertStore(intermediateCertStore);

            CertPathBuilder builder = CertPathBuilder.getInstance("PKIX", "BC");

            builder.build(pkixParams);
            return true;
        } catch (java.security.cert.CertPathBuilderException e) {
            log.error("verify certificate chain fail.", e);
        } catch (Exception e) {
            log.error("verify certificate chain exception: ", e);
        }
        return false;
    }

    /**
     * 从配置文件acp_sdk.properties中获取验签公钥使用的中级证书
     *
     * @return
     */
    public static X509Certificate getMiddleCert() {
        if (null == middleCert) {
            String path = UNION_CONFIG.getMiddleCertPath();
            if (!StringUtils.isEmpty(path)) {
                initMiddleCert();
            } else {
                log.warn("SDKConfig.SDK_MIDDLECERT_PATH is empty");
                return null;
            }
        }
        return middleCert;
    }


    /**
     * 从配置文件acp_sdk.properties中获取验签公钥使用的根证书
     *
     * @return
     */
    public static X509Certificate getRootCert() {
        if (null == rootCert) {
            initRootCert();
        }
        return rootCert;
    }

    /**
     * 检查证书链
     *
     * @param cert      待验证的证书
     * @return
     */
    public static boolean verifyCertificate(X509Certificate cert) {

        if (null == cert) {
            log.error("cert must Not null");
            return false;
        }
        try {
            cert.checkValidity();//验证有效期
            if (!verifyCertificateChain(cert)) {
                return false;
            }
        } catch (Exception e) {
            log.error("verifyCertificate fail", e);
            return false;
        }

        if (UNION_CONFIG.isIfValidateCnName()) {
            // 验证公钥是否属于银联
            if (!UNION_PAY_CN_NAME.equals(CertUtils.getIdentitiesFromCertficate(cert))) {
                log.warn("cer owner is not CUP:{}", CertUtils.getIdentitiesFromCertficate(cert));
                return false;
            }
        } else {
            // 验证公钥是否属于银联
            if (!UNION_PAY_CN_NAME.equals(CertUtils.getIdentitiesFromCertficate(cert))
                    && !"00040000:SIGN".equals(CertUtils.getIdentitiesFromCertficate(cert))) {
                log.warn("cer owner is not CUP:{}", CertUtils.getIdentitiesFromCertficate(cert));
                return false;
            }
        }
        return true;
    }

    /**
     * 获取证书的CN
     *
     * @param aCert
     * @return
     */
    private static String getIdentitiesFromCertficate(X509Certificate aCert) {
        String tDN = aCert.getSubjectDN().toString();
        String tPart = "";
        if ((tDN != null)) {
            String[] tSplitStr = tDN.substring(tDN.indexOf("CN=")).split("@");
            if (tSplitStr.length > 2 && tSplitStr[2] != null) {
                tPart = tSplitStr[2];
            }
        }
        return tPart;
    }
}
