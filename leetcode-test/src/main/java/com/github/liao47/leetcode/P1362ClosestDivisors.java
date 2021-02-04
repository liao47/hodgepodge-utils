package com.github.liao47.leetcode;

/**
 * 1362. 最接近的因数
 *
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 *
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 * 示例 2：
 *
 * 输入：num = 123
 * 输出：[5,25]
 * 示例 3：
 *
 * 输入：num = 999
 * 输出：[40,25]
 *  
 *
 * 提示：
 *
 * 1 <= num <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-divisors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2021/1/7 16:02
 */
public class P1362ClosestDivisors {
    public int[] closestDivisors1(int num) {
        int i = (int) Math.sqrt(num + 2.0);
        int j = i;
        int product = i * j;
        while (product != num + 1 && product != num + 2) {
            if (product > num + 2) {
                i--;
            } else {
                j++;
            }
            product = i * j;
        }
        return new int[]{i, j};
    }

    public int[] closestDivisors(int num) {
        int divisor = num == 1 ? num + 1 : num + 2;
        int i = (int) Math.sqrt(divisor);
        while (divisor % i > 1) {
            i--;
        }
        return new int[]{i, divisor / i};
    }
}
