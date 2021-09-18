package com.github.liao47.leetcode;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *  
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/18 10:33
 */
public class O1001FeiBoNaQiShuLieLcof {
    public int fib1(int n) {
        int prev = 1;
        int fib = 0;
        while (n-- > 0) {
            int tmp = (fib + prev) % 1000000007;
            prev = fib;
            fib = tmp;
        }
        return fib;
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[][] ans = quickPow(new int[][]{{1, 1}, {1, 0}}, n - 1);
        return ans[0][0];
    }

    private int[][] quickPow(int[][] arr, int n) {
        int[][] ans = new int[arr.length][arr.length];
        //初始化斜边值为1，类似于相乘时1的效果，方阵A * 1 = 方阵A
        for (int i = 0; i < ans.length; i++) {
            ans[i][i] = 1;
        }

        //快速幂
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = multiply(ans, arr);
            }
            arr = multiply(arr, arr);
            n >>= 1;
        }
        return ans;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        //m*s矩阵 * s*n矩阵 = m*n矩阵
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                long product = 0;
                for (int k = 0; k < b.length; k++) {
                    product += (long) a[i][k] * b[k][j];
                }
                res[i][j]= (int) (product % 1000000007);
            }
        }
        return res;
    }
}
