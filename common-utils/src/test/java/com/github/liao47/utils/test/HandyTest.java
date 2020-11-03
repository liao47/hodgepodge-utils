package com.github.liao47.utils.test;

import com.github.liao47.utils.Handy;
import com.github.liao47.utils.test.pojo.ClassB;
import com.github.liao47.utils.test.pojo.ClassA;
import com.github.liao47.utils.HandyUtils;
import org.junit.Assert;
import org.junit.Test;

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
}
