package com.github.liao47.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.function.Function;

/**
 * 枚举工具
 * @author liaoshiqing
 * @date 2022/8/19 17:19
 */
@Slf4j
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
        if (valueMapper == null) {
            return getEnumByCode(enumClass, val);
        }
        for (E e : enumClass.getEnumConstants()) {
            if (Objects.equals(val, valueMapper.apply(e))) {
                return e;
            }
        }
        return null;
    }

    /**
     * 通过字段值获取枚举，枚举不存在则抛异常
     * @param enumClass
     * @param valueMapper
     * @param val
     * @param nonExistentMsg
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Enum<E>, R> E getEnum(Class<E> enumClass, Function<E, R> valueMapper, R val,
                                                   String nonExistentMsg) {
        E e = getEnum(enumClass, valueMapper, val);
        if (e == null) {
            throw new CustomException(StringUtils.defaultIfEmpty(nonExistentMsg, "枚举值有误"));
        }
        return e;
    }

    /**
     * 通过code字段值获取枚举
     * @param enumClass
     * @param val
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> E getEnumByCode(Class<E> enumClass, Object val) {
        try {
            Method method = enumClass.getMethod("getCode");
            for (E e : enumClass.getEnumConstants()) {
                if (Objects.equals(val, method.invoke(e))) {
                    return e;
                }
            }
            return null;
        } catch (NoSuchMethodException e) {
            throw new CustomException(String.format("枚举【%s】里未找到getCode方法", enumClass.getSimpleName()));
        } catch (Exception e) {
            log.error("枚举【{}】反射调用getCode方法异常：", enumClass.getSimpleName(), e);
            throw new CustomException(String.format("枚举【%s】反射调用getCode方法异常", enumClass.getSimpleName()));
        }
    }

    /**
     * 通过code字段值获取枚举，枚举不存在则抛异常
     * @param enumClass
     * @param val
     * @param nonExistentMsg
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> E getEnumByCode(Class<E> enumClass, Object val, String nonExistentMsg) {
        return getEnum(enumClass, null, val, nonExistentMsg);
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
        E v = getEnum(enums[0].getDeclaringClass(), valueMapper, val);
        if (v == null) {
            return false;
        }
        for (E e : enums) {
            if (v == e) {
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

    /**
     * 判断code字段值是否在枚举中
     * @param val
     * @param enums
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> boolean in(Object val, E... enums) {
        return in(null, val, enums);
    }

    /**
     * 判断code字段值是否不在枚举中
     * @param val
     * @param enums
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> boolean notIn(Object val, E... enums) {
        return !in(val, enums);
    }
}
