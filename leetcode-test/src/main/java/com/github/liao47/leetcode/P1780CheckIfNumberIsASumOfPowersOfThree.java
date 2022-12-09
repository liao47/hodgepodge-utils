package com.github.liao47.leetcode;

/**
 * 1780. 判断一个数字是否可以表示成三的幂的和
 *
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 *
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3x ，我们称这个整数 y 是三的幂。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 *
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 *
 * 输入：n = 21
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^7
 * @author liaoshiqing
 * @date 2022/12/9 10:00
 */
public class P1780CheckIfNumberIsASumOfPowersOfThree {

    private final int[] powers = new int[15];

    public boolean checkPowersOfThree1(int n) {
        initPowers();
        int p = powers.length - 1;
        while (p >= 0 && n < powers[p]) {
            p--;
        }
        return dfs(n, p, 0);
    }

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    private void initPowers() {
        if (powers[0] == 0) {
            powers[0] = 1;
            for (int i = 1; i < powers.length; i++) {
                powers[i] = powers[i - 1] * 3;
            }
        }
    }

    private boolean dfs(int n, int p, int i) {
        if (n == 0) {
            return true;
        }
        if (i > p || n < 0) {
            return false;
        }
        if (dfs(n - powers[i], p, i + 1)) {
            return true;
        }
        return dfs(n, p, i + 1);
    }
}
