package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 738. 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/15 9:47
 */
public class P0738MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        int index = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                index = i;
                list.set(i, 9);
                list.set(i + 1, list.get(i + 1) - 1);
            }
        }
        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i < index) {
                res = res * 10 + 9;
            } else {
                res = res * 10 + list.get(i);
            }
        }
        return res;
    }

    public int monotoneIncreasingDigits2(int n) {
        List<Integer> list = new ArrayList<>();

        int index = 0;
        while (n != 0) {
            int mod = n % 10;
            if (!list.isEmpty() && mod > list.get(list.size() - 1)) {
                index = list.size() - 1;
                list.set(index, 9);
                list.add(mod - 1);
            } else {
                list.add(mod);
            }
            n /= 10;
        }

        int res = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i < index) {
                res = res * 10 + 9;
            } else {
                res = res * 10 + list.get(i);
            }
        }
        return res;
    }

    public int monotoneIncreasingDigits3(int n) {
        int res = 0;
        int p = 1;
        int prev = 9;
        while (n > 0) {
            int mod = n % 10;
            if (mod <= prev) {
                res += mod * p;
                prev = mod;
            } else {
                res = mod * p - 1;
                prev = mod - 1;
            }
            n /= 10;
            p *= 10;
        }
        return res;
    }
}
