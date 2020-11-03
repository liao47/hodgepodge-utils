package com.liao47.apt.utils;

import com.liao47.apt.annotation.Mask;
import com.liao47.apt.annotation.Format;
import com.liao47.utils.HandyUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;
import java.util.*;

/**
 * 注解缓存
 * @author liao47
 * @date 2020/11/2 11:27
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Annotations {

    private static final Map<Class<? extends Annotation>, Map<Name, Map<String, Annotation>>> MAP = new HashMap<>();

    /**
     * 初始化注解
     * @param roundEnv
     */
    public static void init(RoundEnvironment roundEnv) {
        List<Class<? extends Annotation>> list = Arrays.asList(Mask.class, Format.class);
        for (Class<? extends Annotation> aClass : list) {
            Set<? extends Element> set = roundEnv.getElementsAnnotatedWith(aClass);
            Map<Name, Map<String, Annotation>> map = new HashMap<>(list.size());
            for (Element element : set) {
                Element enclosingElement = element.getEnclosingElement();
                if (enclosingElement instanceof TypeElement) {
                    Name  enclosingName = ((TypeElement) enclosingElement).getQualifiedName();
                    Map<String, Annotation> item = map.computeIfAbsent(enclosingName, k -> new HashMap<>(set.size()));
                    item.put(element.getSimpleName().toString(), element.getAnnotation(aClass));
                }
            }

            MAP.put(aClass, map);
        }
    }

    /**
     * 获取注解
     * @param tClass
     * @param name
     * @param field
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T get(Class<T> tClass, Name name, String field) {
        return tClass.cast(HandyUtils.nonNPE(MAP, t -> t.get(tClass).get(name).get(field)));
    }
}
