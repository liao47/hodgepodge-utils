package com.github.liao47.union.model.req;

import com.github.liao47.common.constants.UnionUriConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Type;

/**
 * 网关在线支付--下单请求参数
 * @author liao47
 * @date 2021/2/22 9:27
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PayReq extends BaseReq {
    private static final long serialVersionUID = 7884555565369766079L;

    public static final String TXN_TYPE = "01";

    /**
     * 交易类型(01：消费)
     */
    private String txnType = TXN_TYPE;

    /**
     * 交易子类型(01：自助消费)
     */
    private String txnSubType = "01";

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
     * 交易币种（境内商户一般是156 人民币）
     */
    private String currencyCode = "156";

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 订单描述
     */
    private String orderDesc;

    /**
     * 交易金额（单位：分）
     */
    private String txnAmt;

    /**
     * **非必填
     * 前台通知地址,有前端上送，用户跳到银联网页支付成功后的页面 点击“返回商户”按钮的时候将异步通知报文post到该地址
     */
    private String frontUrl;

    /**
     * 后台通知地址
     */
    private String backUrl;

    /**
     * 订单发送时间
     */
    private String txnTime;

    /**
     * 订单超时时间
     * 超过此时间后，除网银交易外，其他交易银联系统会拒绝受理，提示超时。 跳转银行网银交易如果超时后交易成功，会自动退款，大约5个工作日金额返还到持卡人账户内
     * 暂时默认20分钟
     */
    private String payTimeout;

    @Override
    public String getReqUrl() {
        return UnionUriConstants.PAY;
    }

    @Override
    public Type getRespType() {
        return null;
    }
}
