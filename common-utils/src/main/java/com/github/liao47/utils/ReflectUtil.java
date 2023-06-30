package com.github.liao47.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2023/6/9 17:17
 */
@Slf4j
public class ReflectUtil {

    /**
     * 反射获取值
     * @param path 支持parent.children.name
     * @param nullable
     * @param objs
     * @return
     * @param <T>
     * @param <E>
     */
    public static <T, E> List<T> getMulti(String path, boolean nullable, E... objs) {
        if (StringUtils.isEmpty(path) || objs == null || objs.length == 0) {
            return Collections.emptyList();
        }

        try {
            String[] arr = path.split("\\.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = "get" + StringUtils.capitalize(arr[i]);
            }

            List<T> list = new ArrayList<>();
            for (Object o : objs) {
                for (String getter : arr) {
                    if (o == null) {
                        break;
                    }
                    Method method = o.getClass().getMethod(getter);
                    o = method.invoke(o);
                }
                if (nullable || o != null) {
                    list.add((T) o);
                }
            }
            return list;
        } catch (Exception e) {
            log.error("反射获取值[{}.{}]失败:", objs[0].getClass().getSimpleName(), path, e);
            throw new CustomException("反射获取值失败");
        }
    }

    /**
     * 反射获取值，异常返回空集合
     * @param path
     * @param nullable
     * @param objs
     * @return
     * @param <T>
     * @param <E>
     */
    public static <T, E> List<T> getMultiExEmpty(String path, boolean nullable, E... objs) {
        try {
            return getMulti(path, nullable, objs);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    /**
     * 反射获取值
     * @param obj
     * @param path 支持parent.children.name
     * @return
     * @param <T>
     */
    public static <T> T get(Object obj, String path) {
        List<T> list = getMulti(path, false, obj);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 反射获取值，异常返回null
     * @param obj
     * @param path
     * @return
     * @param <T>
     */
    public static <T> T getExNull(Object obj, String path) {
        try {
            return get(obj, path);
        } catch (Exception e) {
            return null;
        }
    }
}
