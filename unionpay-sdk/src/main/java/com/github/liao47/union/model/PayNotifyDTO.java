package com.github.liao47.union.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 银联消费回调
 * @author liao47
 * @date 2021/2/23 14:32
 */
@Data
public class PayNotifyDTO implements Serializable {
    private static final long serialVersionUID = -1979583122517032482L;

    /**
     * 查询流水号
     */
    private String queryId;
    /**
     * 交易币种
     */
    private String currencyCode;
    /**
     * 交易传输时间 MMDDhhmmss
     */
    private String traceTime;
    /**
     * 签名
     */
    private String signature;
    /**
     * 签名方法
     */
    private String signMethod;
    /**
     * 清算币种
     */
    private String settleCurrencyCode;
    /**
     * 清算金额
     */
    private String settleAmt;
    /**
     * 清算日期 MMDD
     */
    private String settleDate;
    /**
     * 系统跟踪号
     */
    private String traceNo;
    /**
     * 应答码
     */
    private String respCode;
    /**
     * 应答信息
     */
    private String respMsg;
    /**
     * 兑换日期 MMDD
     */
    private String exchangeDate;
    /**
     * 签名公钥证书
     */
    private String signPubKeyCert;
    /**
     * 清算汇率
     */
    private String exchangeRate;
    /**
     * 账号
     */
    private String accNo;
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 支付卡标识
     */
    private String payCardNo;
    /**
     * 支付卡类型
     */
    private String payCardType;
    /**
     * 支付卡名称
     */
    private String payCardIssueName;
    /**
     * 版本号
     */
    private String version;
    /**
     * 绑定标识号
     */
    private String bindId;
    /**
     * 编码方式
     */
    private String encoding;
    /**
     * 产品类型
     */
    private String bizType;
    /**
     * 订单发送时间
     */
    private String txnTime;
    /**
     * 交易金额
     */
    private String txnAmt;
    /**
     * 交易类型
     */
    private String txnType;
    /**
     * 交易子类
     */
    private String txnSubType;
    /**
     * 接入类型
     */
    private String accessType;
    /**
     * 请求方保留域
     */
    private String reqReserved;
    /**
     * 商户代码
     */
    private String merId;
    /**
     * 商户订单号
     */
    private String orderId;
    /**
     * 保留域
     */
    private String reserved;
    /**
     * 分账域
     */
    private String accSplitData;
}
