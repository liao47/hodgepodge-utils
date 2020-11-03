package com.github.liao47.apt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 格式化
 * @author liao47
 * @date 2020/11/3 10:27
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Format {
    String pattern();
}
