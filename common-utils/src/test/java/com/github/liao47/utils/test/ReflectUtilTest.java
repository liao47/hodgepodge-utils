package com.github.liao47.utils.test;

import com.github.liao47.utils.ReflectUtil;
import com.github.liao47.utils.test.pojo.ClassA;
import com.github.liao47.utils.test.pojo.ClassB;
import com.github.liao47.utils.test.pojo.TaskState;
import org.junit.Test;

import java.util.List;

/**
 * @author liaoshiqing
 * @date 2023/6/10 9:06
 */
public class ReflectUtilTest {
    @Test
    public void testGet() {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        b.setName("World");
        a.setB(b);
        a.setFieldStr("Hello");
        a.setFieldLong(233L);

        ClassA a1 = new ClassA();
        a1.setFieldLong(666L);
        System.out.println((String) ReflectUtil.get(a, "b.name"));
        System.out.println((ClassB) ReflectUtil.getExNull(a, "b"));
        System.out.println(ReflectUtil.getMulti("fieldLong", true, a, a1, null));
        List<String> list = ReflectUtil.getMulti("desc", false, TaskState.class.getEnumConstants());
        System.out.println(list);
    }
}
