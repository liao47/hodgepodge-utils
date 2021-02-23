package com.github.liao47.union.model.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 银联响应报文
 * @author liao47
 * @date 2021/2/23 14:13
 */
@Data
@NoArgsConstructor
public class BaseResp implements Serializable {
    private static final long serialVersionUID = 6862738335129537841L;

    /**
     * 全渠道固定值
     */
    private String version;

    /**
     * 编码方式
     */
    private String encoding;

    /**
     * 签名方法
     * 非对称签名： 01（表示采用RSA签名） HASH表示散列算法 11：支持散列方式验证SHA-256 12：支持散列方式验证SM3
     */
    private String signMethod;

    /**
     * 接入类型，0：直连商户
     */
    private String accessType;

    /**
     * 交易类型
     */
    private String txnType;

    /**
     * 交易子类
     */
    private String txnSubType;

    /**
     * 签名
     */
    private String signature;

    /**
     * 应答码
     */
    private String respCode;

    /**
     * 应答信息
     */
    private String respMsg;
}
