package com.liao47.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

/**
 * 方便使用的工具
 * @author liaoshiqing
 * @date 2020/10/29 10:50
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HandyUtils {
    /**
     * 不抛NPE调用
     * @param t
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> R nonNPE(T t, Function<T, R> function) {
        try {
            return function.apply(t);
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * 不抛异常调用
     * @param t
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> R nonEx(T t, Function<T, R> function) {
        try {
            return function.apply(t);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 如果值为null，则返回默认值
     * @param t
     * @param defaultVal
     * @param <T>
     * @return
     */
    public static <T> T defaultIfNull(T t, T defaultVal) {
        return t == null ? defaultVal : t;
    }
}
