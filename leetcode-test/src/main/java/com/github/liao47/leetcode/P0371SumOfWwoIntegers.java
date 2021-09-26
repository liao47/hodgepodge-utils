package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2021/9/26 9:30
 */
public class P0371SumOfWwoIntegers {
    public int getSum1(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
