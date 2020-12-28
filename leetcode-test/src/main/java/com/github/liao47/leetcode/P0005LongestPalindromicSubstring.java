package com.github.liao47.leetcode;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/11 16:51
 */
public class P0005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            String temp = getPalindromic(s, left, right);
            if (temp.length() > result.length()) {
                result = temp;
            }

            if (i != s.length() - 1) {
                left = i;
                right = i + 1;
                temp = getPalindromic(s, left, right);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }

        }

        return result;
    }

    private String getPalindromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
