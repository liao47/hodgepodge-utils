package com.github.liao47.union.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 银联基础配置
 * @author liao47
 * @date 2020/9/23 11:12
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "unionpay")
public class UnionConfig {
    /**
     * 银联请求地址
     */
    private String url;

    /**
     * 支付完成返回商户页面跳转url，非必须
     */
    private String frontUrl;

    /**
     * 后台回调通知地址
     */
    private String notifyUrl;

    /**
     * 退款后台回调通知地址
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
