package com.github.liao47.union.model.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 支付下单响应
 * @author liao47
 * @date 2021/2/23 14:17
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class PayResp extends BaseResp {
    private static final long serialVersionUID = 2728634298761358764L;

    /**
     * 在线支付页面
     */
    private String html;
}
