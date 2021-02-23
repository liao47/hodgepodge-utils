package com.github.liao47.union.model.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 退款响应
 * @author liao47
 * @date 2021/2/23 14:25
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RefundResp extends BaseResp {
    private static final long serialVersionUID = 863684034818456508L;

    /**
     * 二维码数据
     */
    private String qrCode;

    /**
     * 产品类型
     */
    private String bizType;

    /**
     * 订单发送时间
     */
    private String txnTime;

    /**
     * 交易类型
     */
    private String txnType;

    /**
     * 交易子类型
     */
    private String txnSubType;

    /**
     * 商户代码
     */
    private String merId;

    /**
     * 商户订单号
     */
    private String orderId;

    /**
     * 查询流水号
     */
    private String queryId;
}
