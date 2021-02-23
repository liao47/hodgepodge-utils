package com.github.liao47.union.model.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 订单查询
 * @author liao47
 * @date 2021/2/23 14:24
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QueryResp extends BaseResp {
    private static final long serialVersionUID = -8079726473932812699L;

    /**
     * 查询流水号（被查询交易查询流水号）
     */
    private String queryId;

    /**
     * 交易传输时间
     */
    private String traceTime;

    /**
     * 清算币种
     */
    private String settleCurrencyCode;

    /**
     * 清算金额
     */
    private String settleAmt;

    /**
     * 	清算日期
     */
    private String settleDate;

    /**
     * 	系统跟踪号
     */
    private String traceNo;

    /**
     * 	订单号
     */
    private String orderId;

    /**
     * 商户号
     */
    private String merId;

    /**
     * 原交易应答码
     */
    private String origRespCode;

    /**
     * 原交易应答信息
     */
    private String origRespMsg;
}
