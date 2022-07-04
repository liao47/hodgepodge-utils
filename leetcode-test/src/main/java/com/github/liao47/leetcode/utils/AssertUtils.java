package com.github.liao47.leetcode.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/7/1 15:43
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AssertUtils {
    public static void assertList(List<Integer> expected, List<Integer> actual) {
        expected.sort(Comparator.comparingInt(a -> a));
        actual.sort(Comparator.comparingInt(a -> a));
        Assert.assertEquals(expected, actual);
    }

    public static void assertArray(int[] expected, int[] actual) {
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}
