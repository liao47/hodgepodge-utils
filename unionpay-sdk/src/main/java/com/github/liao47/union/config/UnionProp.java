package com.github.liao47.union.config;

import lombok.Data;

/**
 * 银联商户配置<br>
 *     可配置多个商户，如多个分公司申请不同商户
 * @author liao47
 * @date 2020/11/16 9:41
 */
@Data
public class UnionProp {

    /**
     * 商户代码
     */
    private String merId;

    /**
     * 签名密码
     */
    private String signCertPwd;

    /**
     * 签名证书路径
     */
    private String signCertPath;
}
