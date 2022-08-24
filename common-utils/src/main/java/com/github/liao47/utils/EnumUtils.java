package com.github.liao47.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.function.Function;

/**
 * 枚举工具
 * @author liaoshiqing
 * @date 2022/8/19 17:19
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumUtils {
    /**
     * 通过字段值获取枚举
     * @param enumClass
     * @param valueMapper
     * @param val
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Enum<E>, R> E getEnum(Class<E> enumClass, Function<E, R> valueMapper, R val) {
        for (E e : enumClass.getEnumConstants()) {
            if (Objects.equals(val, valueMapper.apply(e))) {
                return e;
            }
        }
        return null;
    }

    /**
     * 判断字段值是否在枚举中
     * @param val
     * @param valueMapper
     * @param enums
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Enum<E>, R> boolean in(Function<E, R> valueMapper, R val, E... enums) {
        if (enums == null || enums.length == 0) {
            return false;
        }
        for (E e : enums) {
            if (Objects.equals(val, valueMapper.apply(e))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字段值是否不在枚举中
     * @param val
     * @param valueMapper
     * @param enums
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Enum<E>, R> boolean notIn(Function<E, R> valueMapper, R val, E... enums) {
        return !in(valueMapper, val, enums);
    }
}
