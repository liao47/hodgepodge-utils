package com.github.liao47.union.model.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 对账文件下载响应
 * @author liao47
 * @date 2021/2/23 14:23
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DownloadResp extends BaseResp {
    private static final long serialVersionUID = -5060531201616803017L;

    /**
     * 批量文件内容
     */
    private String fileContent;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 清算日期
     */
    private String settleDate;

    /**
     * 文件类型
     */
    private String fileType;
}
