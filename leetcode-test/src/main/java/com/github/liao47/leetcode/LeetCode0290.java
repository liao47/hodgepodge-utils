package com.github.liao47.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/16 14:59
 */
public class LeetCode0290 {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || pattern.isEmpty()) {
            return s == null || s.isEmpty();
        }
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map<String, String> map = new HashMap<>(pattern.length() * 2);
        for (int i = 0; i < pattern.length(); i++) {
            String c = String.valueOf(pattern.charAt(i));
            String val = map.get(c);
            if (val == null) {
                if (map.get("*" + arr[i]) != null) {
                    return false;
                }
                map.put(c, arr[i]);
                map.put("*" + arr[i], c);
            } else if (!val.equals(arr[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> patternMap = new HashMap<>(pattern.length());
        Map<String, Character> strMap = new HashMap<>();
        patternMap.put(pattern.charAt(0), arr[0]);
        strMap.put(arr[0], pattern.charAt(0));
        for (int i = 1; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c != pattern.charAt(i - 1)) {
                if (arr[i].equals(arr[i - 1])) {
                    return false;
                }
                String str = patternMap.get(c);
                if (str == null) {
                    patternMap.put(c, arr[i]);
                } else if (!str.equals(arr[i])) {
                    return false;
                }
                Character c1 = strMap.get(arr[i]);
                if (c1 == null) {
                    strMap.put(arr[i], c);
                } else if (c1 != c) {
                    return false;
                }
            } else if (!arr[i].equals(arr[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
