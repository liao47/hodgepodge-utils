package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数  n  的质数的数量。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *   
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/3 15:56
 */
public class P0204CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (Integer j : list) {
                if (i % j == 0) {
                    isPrime = false;
                }
                if (!isPrime || j * j > i) {
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
            }
        }
        return list.size();
    }
}
