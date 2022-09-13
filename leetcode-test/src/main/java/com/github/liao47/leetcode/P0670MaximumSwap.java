package com.github.liao47.leetcode;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 10^8]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/13 10:50
 */
public class P0670MaximumSwap {
    public int maximumSwap1(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int left = -1;
        int right = -1;
        for (int i = 1; i < chars.length; i++) {
            if (right == -1) {
                if (chars[i] > chars[i - 1]) {
                    left = i - 1;
                    right = i;
                }
            } else if (chars[i] >= chars[right]) {
                right = i;
            }
        }
        if (left != right) {
            while (left - 1 >= 0 && chars[left - 1] < chars[right]) {
                left--;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            return Integer.parseInt(new String(chars));
        }
        return num;
    }

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int max = chars.length - 1;
        int left = -1;
        int right = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] > chars[max]) {
                max = i;
            } else if (chars[i] < chars[max]) {
                left = i;
                right = max;
            }
        }
        if (left >= 0) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            return Integer.parseInt(new String(chars));
        }
        return num;
    }
}
