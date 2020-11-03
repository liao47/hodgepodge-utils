package com.github.liao47.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Pattern常量
 * @author liao47
 * @date 2020/10/28 17:53
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PatternConstants {

    /**
     * 日期时间：yyyyMMddHHmmss
     */
    public static final String SIMPLE_DATE_TIME = "yyyyMMddHHmmss";

    /**
     * 日期时间：yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期：yyyyMMdd
     */
    public static final String SIMPLE_DATE = "yyyyMMdd";

    /**
     * 日期：yyyy-MM-dd
     */
    public static final String DATE = "yyyy-MM-dd";

    /**
     * 日期：yyMMdd
     */
    public static final String SMALL_DATE = "yyMMdd";

    /**
     * 日期：MMdd
     */
    public static final String SIMPLE_MD = "MMdd";

    /**
     * 年月：yyyyMM
     */
    public static final String SIMPLE_YM = "yyyyMM";
}
