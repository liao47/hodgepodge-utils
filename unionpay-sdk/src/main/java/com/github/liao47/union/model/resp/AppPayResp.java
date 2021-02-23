package com.github.liao47.union.model.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 手机支付控件（含安卓Pay）消费响应
 * @author liao47
 * @date 2021/2/23 14:24
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AppPayResp extends BaseResp {
    private static final long serialVersionUID = -335310536105907988L;

    /**
     * 银联受理订单号
     */
    private String tn;
}
