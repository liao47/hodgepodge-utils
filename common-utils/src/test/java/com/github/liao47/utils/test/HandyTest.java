package com.github.liao47.utils.test;

import com.github.liao47.utils.Handy;
import com.github.liao47.utils.test.pojo.ClassB;
import com.github.liao47.utils.test.pojo.ClassA;
import com.github.liao47.utils.HandyUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class HandyTest {

    @Test
    public void test() {
        ClassA a = new ClassA();
        a.setB(new ClassB());
        a.getB().setName("Hello ");
        a.setFieldStr("value");
        a.setFieldLong(233L);

        Handy<ClassA> handy = Handy.of(a);
        String name = handy.nonNPE(t -> t.getB().getName().trim());
        Long amount = handy.nonNPE(ClassA::getFieldLong);
        System.out.println(name);
        System.out.println(amount);

        a.setB(null);
        name = HandyUtils.nonNPE(a, t -> t.getB().getName().trim());
        System.out.println("-------------------------------");
        System.out.println(name);
        System.out.println((String) handy.nonEx(t -> t.getB().getName().replace(".", "")));

        System.out.println("-------------------------------");
        System.out.println(HandyUtils.defaultIfNull(name, "IsNull"));
        System.out.println(handy.defaultIfEmpty(ClassA::getFieldStr, "Empty"));
        System.out.println((String) Handy.of((ClassA) null).nonNPE(t -> t.getB().getName().trim()));

        Assert.assertNotNull(handy.nonNPE(t -> t.getFieldStr().trim()));
    }

    @Test
    public void testUtils() {
        List<Integer> list = Arrays.asList(1, 2, null, 8, 5, 7);
        System.out.println(HandyUtils.toString(list, null));
        System.out.println(HandyUtils.toString(list, e -> "I" + e));

        Assert.assertFalse(HandyUtils.isEmpty(new int[]{2, 7, 8, 4, 6, 5}));
        Assert.assertTrue(HandyUtils.isEmpty(new double[0]));
        Assert.assertTrue(HandyUtils.isEmpty(new Integer[0]));
        Assert.assertFalse(HandyUtils.isEmpty(list));
        Assert.assertTrue(HandyUtils.isEmpty(Collections.emptyMap()));
        Assert.assertFalse(HandyUtils.isEmpty("233"));

        List<ClassA> aList = Arrays.asList(ClassA.of("A1", "a", 2L),
                ClassA.of("A2", "a", 1L), ClassA.of("A3", "b", 3L));
        System.out.println(HandyUtils.toList(aList, ClassA::getFieldLong));
        System.out.println(HandyUtils.toMap(aList, ClassA::getB));
        System.out.println(HandyUtils.grouping(aList, ClassA::getFieldStr, LinkedHashMap::new));
        System.out.println(HandyUtils.grouping(aList, ClassA::getFieldStr));
    }
}
