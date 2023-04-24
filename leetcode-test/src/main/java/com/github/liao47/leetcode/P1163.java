package com.github.liao47.leetcode;

/**
 * 1163. 按字典序排在最后的子串
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 *
 * 输入：s = "leetcode"
 * 输出："tcode"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 4 * 10^5
 * s 仅含有小写英文字符。
 * @author liaoshiqing
 * @date 2023/4/24 15:18
 */
public class P1163 {
    public String lastSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] indexes = new int[n];
        int idx = 0;
        while (idx < n) {
            indexes[idx] = idx++;
        }
        int offset = 0;
        boolean eqd = false;
        while (idx > 1) {
            char c = 0;
            int index = 0;
            int interval = 0;
            if (eqd && indexes[0] + offset >= indexes[1]) {
                break;
            }
            for (int i = 0; i < idx; i++) {
                int j = indexes[i] + offset;
                if (j >= n) {
                    continue;
                }
                if (chars[j] >= c) {
                    if (chars[j] > c) {
                        index = 0;
                        c = chars[j];
                    }
                    indexes[index] = indexes[i];
                    if (index == 1) {
                        interval = indexes[1] - indexes[0];
                        eqd = true;
                    } else if (index > 1 && interval != indexes[index] - indexes[index - 1]) {
                        eqd = false;
                    }
                    index++;
                }
            }
            idx = index;
            offset++;
        }
        return s.substring(indexes[0]);
    }
}
