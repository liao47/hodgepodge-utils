package com.github.liao47.union.model.req;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * 基础请求类
 * @author liao47
 * @date 2021/2/22 9:21
 */
@Data
@NoArgsConstructor
public abstract class BaseReq implements Serializable {
    private static final long serialVersionUID = -5578898650474654637L;

    /**
     * 全渠道固定值
     */
    private String version = "5.1.0";

    /**
     * 编码方式
     */
    private String encoding = "UTF-8";

    /**
     * 签名方法
     * 非对称签名： 01（表示采用RSA签名） HASH表示散列算法 11：支持散列方式验证SHA-256 12：支持散列方式验证SM3
     */
    private String signMethod = "01";

    /**
     * 接入类型，0：直连商户
     */
    private String accessType = "0";

    /**
     * 商户号
     */
    private String merId;

    /**
     * 请求地址
     * @return
     */
    @JSONField(serialize = false)
    public abstract String getReqUrl();

    /**
     * 响应类型
     * @return
     */
    @JSONField(serialize = false)
    public abstract Type getRespType();
}
