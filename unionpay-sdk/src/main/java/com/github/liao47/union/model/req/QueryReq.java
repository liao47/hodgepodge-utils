package com.github.liao47.union.model.req;

import com.github.liao47.common.constants.UnionUriConstants;
import com.github.liao47.union.model.resp.QueryResp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Type;

/**
 * 订单查询
 * @author liao47
 * @date 2021/2/23 14:28
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class QueryReq extends BaseReq {
    private static final long serialVersionUID = 1076560156969354658L;

    /**
     * 交易类型
     */
    private String txnType = "00";

    /**
     * 交易子类型
     */
    private String txnSubType = "00";

    /**
     * 交易类型
     */
    private String bizType = "000201";

    /**
     * 商户订单号
     */
    private String orderId;

    /**
     * 订单发送时间(原订单交易时间)
     */
    private String txnTime;

    @Override
    public String getReqUrl() {
        return UnionUriConstants.QUERY;
    }

    @Override
    public Type getRespType() {
        return QueryResp.class;
    }
}
