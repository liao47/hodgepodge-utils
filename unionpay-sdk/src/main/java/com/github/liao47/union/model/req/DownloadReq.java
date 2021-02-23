package com.github.liao47.union.model.req;

import com.github.liao47.common.constants.UnionUriConstants;
import com.github.liao47.union.model.resp.DownloadResp;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Type;

/**
 * 对账文件下载请求
 * @author liaoshiqing
 * @date 2020/11/2 9:30
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DownloadReq extends BaseReq {
    private static final long serialVersionUID = 2113077977285169231L;

    /**
     * 产品类型
     */
    private String bizType = "000000";

    /**
     * 订单发送时间
     */
    private String txnTime;

    /**
     * 交易类型(01：消费)
     */
    private String txnType = "76";

    /**
     * 交易子类型(01：自助消费)
     */
    private String txnSubType = "01";

    /**
     * 清算日期
     */
    private String settleDate;

    /**
     * 文件类型
     */
    private String fileType = "00";

    /**
     * 证书ID
     */
    private String certId;

    /**
     * 请求方保留域
     */
    private String reqReserved;

    @Override
    public String getReqUrl() {
        return UnionUriConstants.DOWNLOAD;
    }

    @Override
    public Type getRespType() {
        return DownloadResp.class;
    }
}
