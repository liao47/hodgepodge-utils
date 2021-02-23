package com.github.liao47.union.model.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.liao47.common.constants.UnionUriConstants;
import com.github.liao47.union.model.resp.AppPayResp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Type;

/**
 * 手机支付控件（含安卓Pay）消费请求
 * @author liao47
 * @date 2021/2/23 14:27
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AppPayReq extends PayReq {
    private static final long serialVersionUID = 3492549150523508981L;

    public AppPayReq() {
        super.setChannelType("08");
    }

    @JSONField(serialize = false)
    @Override
    public String getReqUrl() {
        return UnionUriConstants.APP_PAY;
    }

    @JSONField(serialize = false)
    @Override
    public Type getRespType() {
        return AppPayResp.class;
    }
}
