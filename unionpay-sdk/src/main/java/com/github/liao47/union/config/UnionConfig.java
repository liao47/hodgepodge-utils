package com.github.liao47.union.config;

import lombok.Data;

/**
 * 银联基本配置
 * @author liao47
 * @date 2020/9/23 11:12
 */
@Data
public class UnionConfig {
    /**
     * 地址
     */
    private String url;

    /**
     * 支付rul
     */
    private String payUrl;

    /**
     * 页面通知url
     */
    private String frontUrl;

    /**
     * 后台通知地址
     */
    private String notifyUrl;

    /**
     * 退款后台通知地址
     */
    private String refundNotifyUrl;

    /**
     * 对账文件下载地址
     */
    private String downloadUrl;

    /**
     * 是否验证验签证书的CN，测试环境请设置false，生产环境请设置true。非false的值默认都当true处理。
     */
    private boolean ifValidateCnName;

    /**
     * 是否启用APP支付
     */
    private boolean enableApp;

    /**
     * 支付逾期分钟数
     */
    private long expireMinutes;

    /**
     * 敏感信息加密证书路径
     */
    private String encryptCertPath;

    /**
     * 验签中级证书路径
     */
    private String middleCertPath;

    /**
     * 验签根证书路径
     */
    private String rootCertPath;
}
