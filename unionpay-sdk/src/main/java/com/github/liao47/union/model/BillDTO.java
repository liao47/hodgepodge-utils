package com.github.liao47.union.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 对账文件行记录
 *
 * @author liao47
 * @date 2021/3/1 9:43
 */
@Data
public class BillDTO implements Serializable {
    /**
     * 交易代码
     */
    private String txnRespCode;
    /**
     * 代理机构标识码
     */
    private String acqInsCode;
    /**
     * 发送机构标识码
     */
    private String sendInsCode;
    /**
     * 系统跟踪号
     */
    private String traceNo;
    /**
     * 交易传输时间
     */
    private Date txnTime;
    /**
     * 帐号
     */
    private String payCardNo;
    /**
     * 交易金额
     */
    private Long txnAmt;
    /**
     * 商户类别
     */
    private String merCatCode;
    /**
     * 终端类型
     */
    private String termType;
    /**
     * 查询流水号
     */
    private String queryId;
    /**
     * 支付方式（旧）
     */
    private String oldPayType;
    /**
     * 商户订单号
     */
    private String orderId;
    /**
     * 支付卡类型
     */
    private String payCardType;
    /**
     * 原始交易的系统跟踪号
     */
    private String origSysNo;
    /**
     * 原始交易日期时间
     */
    private Date origTxnTime;
    /**
     * 商户手续费
     */
    private Long feeAmt;
    /**
     * 结算金额
     */
    private Long settleAmt;
    /**
     * 支付方式
     */
    private String payType;
    /**
     * 集团商户代码
     */
    private String groupMerId;
    /**
     * 交易类型
     */
    private String txnType;
    /**
     * 交易子类
     */
    private String txnSubType;
    /**
     * 业务类型
     */
    private String bizType;
    /**
     * 帐号类型
     */
    private String accType;
    /**
     * 账单类型
     */
    private String billType;
    /**
     * 账单号码
     */
    private String billNo;
    /**
     * 交互方式
     */
    private String interactMode;
    /**
     * 原交易查询流水号
     */
    private String origQryId;
    /**
     * 商户代码
     */
    private String merId;
    /**
     * 分账入账方式
     */
    private String splitAcctType;
    /**
     * 二级商户代码
     */
    private String subMerId;
    /**
     * 二级商户简称
     */
    private String subMerAbbr;
    /**
     * 二级商户分账入账金额
     */
    private Long splitAcctAmt;
    /**
     * 清算净额
     */
    private Long liquidationNetAmt;
    /**
     * 终端号
     */
    private String termId;
    /**
     * 商户自定义域
     */
    private String merReserved;
    /**
     * 优惠金额
     */
    private Long discountAmt;
    /**
     * 发票金额
     */
    private Long invoiceAmt;
    /**
     * 分期付款附加手续费
     */
    private Long instalmentFee;
    /**
     * 分期付款期数
     */
    private Long instalmentCount;
    /**
     * 交易介质
     */
    private String txnMedium;
    /**
     * 原始交易订单号
     */
    private String origOrderId;
    /**
     * 清算金额
     */
    private Long liquidationAmt;
    /**
     * 服务点输入方式码
     */
    private String poSentryModeCode;
    /**
     * 移动支付产品标志
     */
    private String mobilePaySign;
    /**
     * 检索参考号
     */
    private String referIndex;
    /**
     * 保留使用
     */
    private String reserve;

}
