package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *  
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 10^4
 * s 和 p 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/24 13:54
 */
public class P0438FindAllAnagramsInAString {
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] count = new int[26];
            int size = 0;
            for (int j = i; j < i + p.length(); j++) {
                int k = arr[j] - 'a';
                if (cnt[k] == 0 || ++count[k] > cnt[k]) {
                    break;
                }
                size++;
            }
            if (size == p.length()) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sl = s.length();
        int pl = p.length();
        if (sl < pl) {
            return list;
        }

        int[] cnt = new int[26];
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }

        int[] count = new int[26];
        int start = 0;
        int i = 0;
        char[] arr = s.toCharArray();
        while (i < sl) {
            int k = arr[i++] - 'a';
            count[k]++;
            while (count[k] > cnt[k]) {
                count[arr[start++] - 'a']--;
            }
            if (i - start == pl) {
                list.add(start);
            }
        }
        return list;
    }
}
