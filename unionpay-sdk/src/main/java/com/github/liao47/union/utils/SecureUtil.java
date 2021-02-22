/**
 * Licensed Property to China UnionPay Co., Ltd.
 * <p>
 * (C) Copyright of China UnionPay Co., Ltd. 2010
 * All Rights Reserved.
 * <p>
 * <p>
 * Modification History:
 * =============================================================================
 * Author         Date          Description
 * ------------ ---------- ---------------------------------------------------
 * xshu       2014-05-28     报文加密解密等操作的工具类
 * =============================================================================
 */
package com.github.liao47.union.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;


/**
 * 安全算法工具类
 * @author liao47
 * @date 2020/11/16 10:24
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecureUtil {
    /**
     * 算法常量： SHA256
     */
    private static final String ALGORITHM_SHA256 = "SHA-256";
    /**
     * 算法常量：SHA256withRSA
     */
    private static final String BC_PROV_ALGORITHM_SHA256RSA = "SHA256withRSA";

    /**
     * sha256计算后进行16进制转换
     *
     * @param data     待计算的数据
     * @param encoding 编码
     * @return 计算结果
     */
    public static byte[] sha256X16(String data, String encoding) {
        byte[] bytes = sha256(data, encoding);
        StringBuilder sha256StrBuff = new StringBuilder();
        for (byte b : bytes) {
            sha256StrBuff.append(String.format("%02x", b));
        }
        try {
            return sha256StrBuff.toString().getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported encoding[{}]:", encoding, e);
            throw new CustomException(String.format("不支持的字符集编码[%s]", encoding));
        }
    }

    /**
     * sha256计算.
     *
     * @param data 待计算的数据
     * @return 计算结果
     */
    private static byte[] sha256(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_SHA256);
            md.reset();
            md.update(data);
            return md.digest();
        } catch (Exception e) {
            log.error("SHA256计算失败:", e);
            throw new CustomException("SHA256计算失败");
        }
    }

    /**
     * sha256计算
     *
     * @param data     待计算的数据
     * @param encoding 字符集编码
     * @return
     */
    private static byte[] sha256(String data, String encoding) {
        try {
            return sha256(data.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported encoding[{}]:", encoding, e);
            throw new CustomException(String.format("不支持的字符集编码[%s]", encoding));
        }
    }

    public static byte[] signBySoft256(PrivateKey privateKey, byte[] data)
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature st = Signature.getInstance(BC_PROV_ALGORITHM_SHA256RSA, "BC");
        st.initSign(privateKey);
        st.update(data);
        return st.sign();
    }

    public static boolean validateSignBySoft256(PublicKey publicKey, byte[] signData, byte[] srcData)
            throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature st = Signature.getInstance(BC_PROV_ALGORITHM_SHA256RSA, "BC");
        st.initVerify(publicKey);
        st.update(srcData);
        return st.verify(signData);
    }

    /**
     * BASE64解码
     *
     * @param inputByte 待解码数据
     * @return 解码后的数据
     */
    public static byte[] base64Decode(byte[] inputByte) {
        return Base64.decode(inputByte);
    }

    /**
     * BASE64编码
     *
     * @param inputByte 待编码数据
     * @return 解码后的数据
     */
    public static byte[] base64Encode(byte[] inputByte) {
        return Base64.encode(inputByte);
    }
}
