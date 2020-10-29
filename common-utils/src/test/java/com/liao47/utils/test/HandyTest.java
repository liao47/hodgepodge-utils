package com.liao47.utils.test;

import com.liao47.utils.test.pojo.ClassA;
import com.liao47.utils.test.pojo.ClassB;
import com.liao47.utils.Handy;
import com.liao47.utils.HandyUtils;
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
        String name = handy.nonNPE(t -> a.getB().getName().trim());
        Long amount = handy.nonNPE(t -> a.getFieldLong());
        System.out.println("1. " + name);
        System.out.println("2. " + amount);

        a.setB(null);
        name = HandyUtils.nonNPE(a, t -> a.getB().getName().trim());
        System.out.println("3. " + name);

        System.out.println("4. " + HandyUtils.defaultIfNull(name, "IsNull"));
        System.out.println("5. " + handy.defaultIfEmpty(t -> a.getFieldStr(), "Empty"));

        Assert.assertNotNull(handy.nonNPE(t -> a.getFieldStr().trim()));
    }
}
