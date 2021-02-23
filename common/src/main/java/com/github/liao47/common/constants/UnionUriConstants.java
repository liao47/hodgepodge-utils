package com.github.liao47.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author liaoshiqing
 * @date 2021/2/23 14:15
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UnionUriConstants {
    /**
     * 消费
     */
    public static final String PAY = "/gateway/api/frontTransReq.do";

    /**
     * 交易状态查询
     */
    public static final String QUERY = "/gateway/api/queryTrans.do";

    /**
     * 退款
     */
    public static final String REFUND = "/gateway/api/backTransReq.do";

    /**
     * APP消费
     */
    public static final String APP_PAY = "/gateway/api/appTransReq.do";

    /**
     * 对账文件下载
     */
    public static final String DOWNLOAD = "DOWNLOAD";
}
