package com.github.liao47.union.utils;

import com.github.liao47.common.constants.PatternConstants;
import com.github.liao47.common.exception.CustomException;
import com.github.liao47.union.config.UnionProp;
import com.github.liao47.utils.DateUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 银联请求工具
 * @author liao47
 * @date 2021/2/22 9:30
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AcpUtils {
    /**
     * 签文字段
     */
    private static final String SIGNATURE = "signature";

    /**
     * 请求报文签名(使用配置文件中配置的私钥证书或者对称密钥签名)<br>
     * 功能：对请求报文进行签名,并计算赋值certid,signature字段并返回<br>
     *
     * @param reqData 请求报文map<br>
     * @return　签名后的map对象<br>
     */
    public static Map<String, String> sign(Map<String, String> reqData, UnionProp unionProp) {
        reqData = filterBlank(reqData);
        signV510(reqData, StandardCharsets.UTF_8.toString(), unionProp);
        return reqData;
    }

    /**
     * 根据signMethod的值，(版本5.1.0算法)
     *
     * @param data     待签名数据Map键值对形式
     * @param encoding 编码
     * @param unionProp
     * @return 签名是否成功
     */
    public static boolean signV510(Map<String, String> data, String encoding, UnionProp unionProp) {

        // 设置签"名证书序列号
        data.put("certId", CertUtils.getSignCertId(unionProp));
        // 将Map信息转换成key1=value1&key2=value2的形式
        String stringData = coverMap2String(data);
        log.info("待签名请求报文串:[{}]", stringData);
        byte[] byteSign = null;
        String stringSign = null;
        try {
            // 通过SHA256进行摘要并转16进制
            byte[] signDigest = SecureUtil.sha256X16(stringData, encoding);
            log.info("摘要:[{}]", new String(signDigest));
            byteSign = SecureUtil.base64Encode(SecureUtil.signBySoft256(CertUtils.getSignCertPrivateKey(unionProp),
                    signDigest));
            stringSign = new String(byteSign);
            // 设置签名域值
            data.put(SIGNATURE, stringSign);
            return true;
        } catch (Exception e) {
            log.info("Sign Error", e);
            return false;
        }
    }

    /**
     * 将Map中的数据转换成key1=value1&key2=value2的形式 不包含签名域signature
     *
     * @param data 待拼接的Map数据
     * @return 拼接好后的字符串
     */
    public static String coverMap2String(Map<String, String> data) {
        TreeMap<String, String> tree = new TreeMap<>();
        Iterator<Map.Entry<String, String>> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> en = it.next();
            if (SIGNATURE.equals(en.getKey().trim())) {
                continue;
            }
            tree.put(en.getKey(), en.getValue());
        }
        it = tree.entrySet().iterator();
        StringBuilder sf = new StringBuilder();
        while (it.hasNext()) {
            Map.Entry<String, String> en = it.next();
            sf.append(en.getKey()).append("=").append(en.getValue()).append("&");
        }
        return sf.substring(0, sf.length() - 1);
    }

    /**
     * 过滤请求报文中的空字符串或者空字符串
     *
     * @param contentData
     * @return
     */
    public static Map<String, String> filterBlank(Map<String, String> contentData) {
        Map<String, String> submitFromData = new HashMap<>(contentData.size());
        for (Map.Entry<String, String> entry : contentData.entrySet()) {
            if (StringUtils.isNotBlank(entry.getValue())) {
                // 对value值进行去除前后空处理
                submitFromData.put(entry.getKey(), entry.getValue().trim());
            }
        }
        return submitFromData;
    }

    /**
     * 功能：前台交易构造HTTP POST自动提交表单<br>
     *
     * @param reqUrl   表单提交地址<br>
     * @param hiddens  以MAP形式存储的表单键值<br>
     * @param encoding 上送请求报文域encoding字段的值<br>
     * @return 构造好的HTTP POST交易表单<br>
     */
    public static String createAutoFormHtml(String reqUrl, Map<String, String> hiddens, String encoding) {
        StringBuilder sf = new StringBuilder();
        sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=").append(encoding)
                .append("\"/></head><body>");
        sf.append("<form id = \"pay_form\" action=\"").append(reqUrl).append("\" method=\"post\">");
        if (null != hiddens && !hiddens.isEmpty()) {
            for (Map.Entry<String, String> ey : hiddens.entrySet()) {
                String key = ey.getKey();
                String value = ey.getValue();
                sf.append("<input type=\"hidden\" name=\"").append(key).append("\" id=\"").append(key)
                        .append("\" value=\"").append(value).append("\"/>");
            }
        }
        sf.append("</form>");
        sf.append("</body>");
        sf.append("<script type=\"text/javascript\">");
        sf.append("document.all.pay_form.submit();");
        sf.append("</script>");
        sf.append("</html>");
        return sf.toString();
    }

    /**
     * 功能：前台交易构造HTTP POST自动提交表单<br>
     *
     * @param reqUrl  表单提交地址<br>
     * @param hiddens 以MAP形式存储的表单键值<br>
     * @return 构造好的HTTP POST交易表单<br>
     */
    public static String createAutoForm(String reqUrl, Map<String, String> hiddens) {
        StringBuilder sf = new StringBuilder();
        sf.append("<!doctype html>");
        sf.append("<html>");
        sf.append("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head>");
        sf.append("<body>");
        sf.append("<form id = \"pay_form\" action=\"").append(reqUrl).append("\" method=\"post\">");
        if (null != hiddens && !hiddens.isEmpty()) {
            for (Map.Entry<String, String> ey : hiddens.entrySet()) {
                String key = ey.getKey();
                String value = ey.getValue();
                sf.append("<input type=\"hidden\" name=\"").append(key).append("\" id=\"")
                        .append(key).append("\" value=\"").append(value).append("\">");
            }
        }
        sf.append("</form>");
        sf.append("</body>");
        sf.append("<script type=\"text/javascript\">");
        sf.append("document.all.pay_form.submit();");
        sf.append("</script>");
        sf.append("</html>");
        return sf.toString();
    }

    /**
     * 将形如key=value&key=value的字符串转换为相应的Map对象
     *
     * @param result
     * @return
     */
    public static Map<String, String> convertResultStringToMap(String result) {
        Map<String, String> map = null;

        if (result != null && !"".equals(result.trim())) {
            if (result.startsWith("{") && result.endsWith("}")) {
                result = result.substring(1, result.length() - 1);
            }
            map = parseQString(result);
        }

        return map;
    }

    /**
     * 解析应答字符串，生成应答要素
     *
     * @param str 需要解析的字符串
     * @return 解析的结果map
     */
    public static Map<String, String> parseQString(String str) {

        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(str)) {
            return map;
        }

        StringBuilder temp = new StringBuilder();
        String key = null;
        boolean isKey = true;
        boolean isOpen = false;
        char openName = 0;
        for (char curChar : str.toCharArray()) {
            if (isKey) {
                // 如果当前生成的是key
                if (curChar == '=') {
                    key = temp.toString();
                    temp.setLength(0);
                    isKey = false;
                } else {
                    temp.append(curChar);
                }
            } else {
                // 如果当前生成的是value
                if (isOpen) {
                    if (curChar == openName) {
                        isOpen = false;
                    }
                } else {
                    if (curChar == '{') {
                        isOpen = true;
                        openName = '}';
                    }
                    if (curChar == '[') {
                        isOpen = true;
                        openName = ']';
                    }
                }

                if (curChar == '&' && !isOpen) {
                    putKeyValueToMap(temp, isKey, key, map);
                    temp.setLength(0);
                    isKey = true;
                } else {
                    temp.append(curChar);
                }
            }

        }
        putKeyValueToMap(temp, isKey, key, map);
        return map;
    }

    private static void putKeyValueToMap(StringBuilder temp, boolean isKey,
                                         String key, Map<String, String> map) {
        if (isKey) {
            key = temp.toString();
            if (key.length() == 0) {
                throw new CustomException("QString format illegal");
            }
            map.put(key, "");
        } else {
            if (key.length() == 0) {
                throw new CustomException("QString format illegal");
            }
            map.put(key, temp.toString());
        }
    }

    /**
     * 验证签名
     *
     * @param resData 返回报文数据
     * @return
     */
    public static boolean validate(Map<String, String> resData) {

        // 1.从返回报文中获取公钥信息转换成公钥对象
        String strCert = resData.get("signPubKeyCert");
        log.info("验签公钥证书：[{}]", strCert);

        X509Certificate x509Cert = CertUtils.genCertificateByStr(strCert);
        if (x509Cert == null) {
            log.info("convert signPubKeyCert failed");
            return false;
        }
        // 2.验证证书链
        if (!CertUtils.verifyCertificate(x509Cert)) {
            log.info("验证公钥证书失败，证书信息：[{}]", strCert);
            return false;
        }

        // 3.验签
        String stringSign = resData.get(SIGNATURE);
        log.info("签名原文：[{}]", stringSign);
        // 将Map信息转换成key1=value1&key2=value2的形式
        String stringData = coverMap2String(resData);
        log.info("待验签返回报文串：[{}]", stringData);
        try {
            // 验证签名需要用银联发给商户的公钥证书.
            boolean result = SecureUtil.validateSignBySoft256(x509Cert.getPublicKey(),
                    SecureUtil.base64Decode(stringSign.getBytes(StandardCharsets.UTF_8)),
                    SecureUtil.sha256X16(stringData, StandardCharsets.UTF_8.toString()));
            log.info("验证签名{}", result ? "成功" : "失败");
            return result;
        } catch (Exception e) {
            log.error("Threw an Exception, cause:", e);
        }
        return false;
    }

    /**
     * 解析日期
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return new Date();
        }
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(LocalDate.now().format(DateTimeFormatter
                    .ofPattern("yyyy")) + dateStr, DateTimeFormatter.ofPattern(PatternConstants.SIMPLE_DATE_TIME));
            if (localDateTime.isAfter(LocalDateTime.now().plusMonths(10L))) {
                //跨年比当前时间大几乎一年，则减去一年
                localDateTime = localDateTime.minusYears(1L);
            }
            return DateUtils.toDate(localDateTime);
        } catch (Exception e) {
            log.error("Parse date error, cause:", e);
        }
        return new Date();
    }
}
