package com.github.liao47.leetcode;

import java.util.*;

/**
 * @author liao47
 * @date 2020/12/22 15:44
 */
public class P1015SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        Set<Integer> remainderSet = new HashSet<>();
        int length = 1;
        int remainder = 1 % k;
        while (remainderSet.add(remainder)) {
            if (remainder == 0) {
                return length;
            }
            length++;
            remainder = (remainder * 10 + 1) % k;
        }
        return -1;
    }

    public int smallestRepunitDivByK2(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int length = 1;
        int remainder = 0;
        while (true) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                break;
            }
            length++;
        }
        return length;
    }
}
