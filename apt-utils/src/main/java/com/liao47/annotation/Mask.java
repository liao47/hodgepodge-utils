package com.liao47.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * toString掩码处理
 * @author liao47
 * @date 2020/10/27 11:44
 * @see ToString
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Mask {

    /**
     * 前缀保留长度
     * @return
     */
    int prefix() default 0;

    /**
     * 后缀保留长度
     * @return
     */
    int suffix() default 0;

    /**
     * 掩码字符
     * @return
     */
    char maskChar() default '*';
}
