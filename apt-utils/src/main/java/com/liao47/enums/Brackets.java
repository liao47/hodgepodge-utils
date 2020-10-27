package com.liao47.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 括号
 * @author liao47
 * @date 2020/10/27 11:45
 */
@AllArgsConstructor
@Getter
public enum Brackets {
    /**
     * 圆括号
     */
    PARENTHESES('(', ')'),

    /**
     * 花括号
     */
    BRACES('{', '}'),

    /**
     * 方括号
     */
    BRACKETS('[', ']');

    /**
     * 开始
     */
    private final char opening;

    /**
     * 闭合
     */
    private final char closing;
}
