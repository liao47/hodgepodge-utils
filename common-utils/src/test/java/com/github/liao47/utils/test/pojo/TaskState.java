package com.github.liao47.utils.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 权益中心-任务状态
 * @author liaoshiqing
 * @date 2022/8/18 16:32
 */
@AllArgsConstructor
@Getter
public enum TaskState {
    /**
     * 草稿
     */
    DRAFT((byte) 0, "草稿"),
    /**
     * 待审核
     */
    PENDING((byte) 1, "待审核"),
    /**
     * 启用
     */
    ENABLE((byte) 2, "启用"),
    /**
     * 禁用
     */
    DISABLE((byte) 3, "禁用"),
    /**
     * 审核不通过
     */
    REJECT((byte) 4, "审核不通过"),
    /**
     * 已过期
     */
    EXPIRED((byte) 5, "已过期");

    private final Byte code;
    private final String desc;
}
