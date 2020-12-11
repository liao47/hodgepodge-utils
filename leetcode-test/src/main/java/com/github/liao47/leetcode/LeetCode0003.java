package com.github.liao47.leetcode;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/11 16:34
 */
public class LeetCode0003 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int index = sb.toString().indexOf(c);
            if (index > -1) {
                length = sb.length();
                if (length > maxLength) {
                    maxLength = length;
                }
                sb.delete(0, index + 1);
            }
            sb.append(c);
        }
        return Math.max(sb.length(), maxLength);
    }

    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        if (2 > chars.length) {
            return chars.length;
        }
        int max = 0;
        int splitAt = 0;
        int curLen = 1;
        for (int i = 1; i < chars.length; i++) {
            int j = splitAt;
            for (; j < i; j++) {
                if (chars[i] == chars[j]) {
                    break;
                }
            }
            if (j < i) {
                splitAt = j + 1;
                curLen = i - j;
            } else {
                curLen++;
            }
            if (curLen > max) {
                max = curLen;
            }
        }
        return max;
    }
}
