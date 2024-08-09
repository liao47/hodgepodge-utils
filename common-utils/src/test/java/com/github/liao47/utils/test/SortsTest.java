package com.github.liao47.utils.test;

import com.github.liao47.utils.Sorts;
import com.github.liao47.utils.test.pojo.ClassA;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortsTest {
    @Test
    public void test() {
        List<ClassA> list = new ArrayList<>();
        list.add(ClassA.of("Bob", "b", 1L));
        list.add(ClassA.of("Ali", "a", 2L));
        list.add(ClassA.of("Alex", "a", 3L));
        list.add(ClassA.of("Sim", "s", 4L));
        list.add(ClassA.of("Bill", "b", 5L));

        Sorts.<ClassA>of().asc(ClassA::getFieldStr).desc(t -> t.getB().getName()).sort(list);
        Assert.assertArrayEquals(new Long[]{2L, 3L, 1L, 5L, 4L},
                list.stream().map(ClassA::getFieldLong).toArray());

        new Sorts<ClassA>().asc(ClassA::getFieldStr).desc(ClassA::getFieldLong).sort(list);
        Assert.assertArrayEquals(new Long[]{3L, 2L, 5L, 1L, 4L},
                list.stream().map(ClassA::getFieldLong).toArray());
    }
}
