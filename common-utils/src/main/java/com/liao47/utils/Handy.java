package com.liao47.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

/**
 * 便捷使用类
 * @author liaoshiqing
 * @date 2020/10/29 14:46
 */
@Getter
@AllArgsConstructor
public class Handy<T> {
    private final T payload;

    /**
     * 创建Handy对象
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Handy<T> of(T obj) {
        return new Handy<>(obj);
    }

    /**
     * 不抛NPE调用
     * @param function
     * @param <R>
     * @return
     */
    public <R> R nonNPE(Function<T, R> function) {
        return HandyUtils.nonNPE(this.payload, function);
    }

    /**
     * 不抛异常调用
     * @param function
     * @param <R>
     * @return
     */
    public <R> R nonEx(Function<T, R> function) {
        return HandyUtils.nonEx(this.payload, function);
    }

    /**
     * 如果值为null，则返回默认值
     * @param defaultVal
     * @return
     */
    public T defaultVal(T defaultVal) {
        return HandyUtils.defaultIfNull(this.payload, defaultVal);
    }

    /**
     * 如果属性值为null，则返回默认值
     * @param function
     * @param defaultVal
     * @param <R>
     * @return
     */
    public <R> R defaultVal(Function<T, R> function, R defaultVal) {
        return HandyUtils.defaultIfNull(this.nonNPE(function), defaultVal);
    }

    /**
     * 如果字符串属性值为空，则返回默认值
     * @param function
     * @param defaultVal
     * @return
     */
    public String defaultIfEmpty(Function<T, String> function, String defaultVal) {
        return StringUtils.defaultIfEmpty(this.nonNPE(function), defaultVal);
    }

    /**
     * 如果字符串属性值为blank，则返回默认值
     * @param function
     * @param defaultVal
     * @return
     */
    public String defaultIfBlank(Function<T, String> function, String defaultVal) {
        return StringUtils.defaultIfBlank(this.nonNPE(function), defaultVal);
    }
}
