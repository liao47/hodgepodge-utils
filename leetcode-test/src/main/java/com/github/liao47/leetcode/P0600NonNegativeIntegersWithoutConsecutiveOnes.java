package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2021/9/14 13:52
 */
public class P0600NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int n) {
        int length = Integer.toBinaryString(n).length();
        int[] dp = new int[length + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0;
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            if ((n & 1 << i) != 0) {
                result += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                result++;
            }
        }

        return result;
    }
}
