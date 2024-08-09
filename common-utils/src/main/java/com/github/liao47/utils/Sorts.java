package com.github.liao47.utils;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * 排序工具类
 * list.sort(new Sorts<T>().asc(T::getName).desc(T::getId).comparator());
 * Sorts.<T>of().asc(T::getName).desc(T::getId).sort(list);
 * @author Shiqing.Liao
 * @date 2024/08/09 15:20
 */
public class Sorts<T> {
    private final List<Triple<Function<T, Comparable<Object>>, Boolean, Boolean>> orders = new ArrayList<>();

    public static <T> Sorts<T> of() {
        return new Sorts<>();
    }

    /**
     * 排序
     * @param getter 排序字段
     * @param isAsc 是否升序
     * @param isNullGreater 是否null值最大
     * @return
     */
    public Sorts<T> orderBy(Function<T, ? extends Comparable<?>> getter, boolean isAsc, boolean isNullGreater) {
        orders.add(Triple.of((Function<T, Comparable<Object>>) getter, isAsc, isNullGreater));
        return this;
    }

    public Sorts<T> orderBy(Function<T, ? extends Comparable<?>> getter, boolean isAsc) {
        return this.orderBy(getter, isAsc, false);
    }

    public Sorts<T> asc(Function<T, ? extends Comparable<?>> getter) {
        return this.orderBy(getter, true);
    }

    public Sorts<T> desc(Function<T, ? extends Comparable<?>> getter) {
        return this.orderBy(getter, false);
    }

    public Comparator<T> comparator() {
        return (o1, o2) -> {
            for (Triple<Function<T, Comparable<Object>>, Boolean, Boolean> sort : orders) {
                Function<T, Comparable<Object>> getter = sort.getLeft();
                Comparable<Object> v1 = getter.apply(o1);
                Comparable<Object> v2 = getter.apply(o2);
                if (Boolean.FALSE.equals(sort.getMiddle())) {
                    // 降序，交换值
                    Comparable<Object> tmp = v1;
                    v1 = v2;
                    v2 = tmp;
                }
                int compare = compare(v1, v2, Boolean.TRUE.equals(sort.getRight()));
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        };
    }

    public void sort(List<T> list) {
        if (list == null || list.isEmpty() || this.orders.isEmpty()) {
            return;
        }
        list.sort(this.comparator());
    }

    public static <T extends Comparable<? super T>> int compare(T c1, T c2, boolean isNullGreater) {
        if (c1 == c2) {
            return 0;
        } else if (c1 == null) {
            return isNullGreater ? 1 : -1;
        } else if (c2 == null) {
            return isNullGreater ? -1 : 1;
        }
        return c1.compareTo(c2);
    }
}
