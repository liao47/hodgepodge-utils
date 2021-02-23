package com.github.liao47.union.model.req;

import com.github.liao47.common.constants.UnionUriConstants;
import com.github.liao47.union.model.resp.RefundResp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Type;

/**
 * 退款请求
 * @author liao47
 * @date 2021/2/23 14:26
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RefundReq extends BaseReq {
    private static final long serialVersionUID = -9059778488529617904L;
    public static final String TXN_TYPE = "04";

    /**
     * 交易类型 04-退货
     */
    private String txnType = TXN_TYPE;

    /**
     * 交易子类型
     */
    private String txnSubType = "00";
    
    /**
     * 业务类型，B2C网关支付，手机wap支付
     */
    private String bizType = "000201";

    /**
     * 渠道类型，这个字段区分B2C网关支付和手机wap支付
     * 07：PC,平板  08：手机
     */
    private String channelType = "07";

    /**
     * 商户订单号（退款订单号）
     */
    private String orderId;

    /**
     * 订单发送时间
     */
    private String txnTime;

    /**
     * 交易币种（境内商户一般是156 人民币）
     */
    private String currencyCode = "156";

    /**
     * 退货金额(支持半分退款)
     */
    private String txnAmt;

    /**
     * 后台通知地址
     */
    private String backUrl;

    /**
     * 原消费交易返回的的queryId
     */
    private String origQryId;

    @Override
    public String getReqUrl() {
        return UnionUriConstants.REFUND;
    }

    @Override
    public Type getRespType() {
        return RefundResp.class;
    }
}
