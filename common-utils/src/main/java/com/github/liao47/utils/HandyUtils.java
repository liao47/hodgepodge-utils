package com.github.liao47.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 便利工具
 * @author liaoshiqing
 * @date 2020/10/29 10:50
 */
@Slf4j
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

    /**
     * 判断是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        } else if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        } else if (obj instanceof Iterable) {
            return !((Iterable<?>) obj).iterator().hasNext();
        } else if (obj instanceof Iterator) {
            return !((Iterator<?>) obj).hasNext();
        } else if (obj instanceof Enumeration) {
            return !((Enumeration<?>) obj).hasMoreElements();
        }
        return false;
    }

    /**
     * Iterable toString
     * @param iterable
     * @param function
     * @param <E>
     * @return
     */
    public static <E> String toString(Iterable<E> iterable, Function<E, String> function) {
        return iterable == null ? null : toString(iterable.iterator(), function);
    }

    /**
     * Iterator toString
     * @param it
     * @param function
     * @param <E>
     * @return
     */
    public static <E> String toString(Iterator<E> it, Function<E, String> function) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            E e = it.next();
            sb.append(function == null || e == null ? e : function.apply(e));
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }

    /**
     * 转换为属性字段list
     * @param list
     * @param mapper
     * @param <E>
     * @param <T>
     * @return
     */
    public static <E, T> List<T> toList(List<E> list, Function<E, T> mapper) {
        if (isEmpty(list)) {
            return Collections.emptyList();
        }
        return list.stream().map(mapper).collect(Collectors.toList());
    }

    /**
     * 按属性字段转换为map
     * @param list
     * @param keyMapper
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> toMap(List<V> list, Function<V, K> keyMapper) {
        if (isEmpty(list)) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.toMap(keyMapper, v -> v, (v1, v2) -> v1));
    }

    /**
     * 分组
     * @param list
     * @param classifier
     * @param mapFactory
     * @param <K>
     * @param <E>
     * @param <M>
     * @return
     */
    public static <K, E, M extends Map<K, List<E>>> Map<K, List<E>> grouping(List<E> list, Function<E, K> classifier,
                                                                             Supplier<M> mapFactory) {
        if (isEmpty(list)) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.groupingBy(classifier, mapFactory, Collectors.toList()));
    }

    /**
     * 分组
     * @param list
     * @param classifier
     * @param <K>
     * @param <E>
     * @return
     */
    public static <K, E> Map<K, List<E>> grouping(List<E> list, Function<E, K> classifier) {
        return grouping(list, classifier, HashMap::new);
    }
}
