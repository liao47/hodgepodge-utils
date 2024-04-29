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
     * @param val
     * @param valueMapper
     * @param enumClass
     * @param <E>
     * @param <R>
     * @return
     */
    public static <E extends Enum<E>, R> E get(R val, Function<E, R> valueMapper, Class<E> enumClass) {
        if (valueMapper == null) {
            return getByCode(val, enumClass);
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
    public static <E extends Enum<E>, R> E get(R val, Function<E, R> valueMapper, Class<E> enumClass,
                                               String nonExistentMsg) {
        E e = get(val, valueMapper, enumClass);
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
    public static <E extends Enum<E>> E getByCode(Object val, Class<E> enumClass) {
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
    public static <E extends Enum<E>> E getByCode(Object val, Class<E> enumClass, String nonExistentMsg) {
        return get(val, null, enumClass, nonExistentMsg);
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
    public static <E extends Enum<E>, R> boolean in(R val, Function<E, R> valueMapper, E... enums) {
        if (enums == null || enums.length == 0) {
            return false;
        }
        E v = get(val, valueMapper, enums[0].getDeclaringClass());
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
    public static <E extends Enum<E>, R> boolean notIn(R val, Function<E, R> valueMapper, E... enums) {
        return !in(val, valueMapper, enums);
    }

    /**
     * 判断code字段值是否在枚举中
     * @param val
     * @param enums
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> boolean codeIn(Object val, E... enums) {
        return in(val, null, enums);
    }

    /**
     * 判断code字段值是否不在枚举中
     * @param val
     * @param enums
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> boolean codeNotIn(Object val, E... enums) {
        return !codeIn(val, enums);
    }
}
