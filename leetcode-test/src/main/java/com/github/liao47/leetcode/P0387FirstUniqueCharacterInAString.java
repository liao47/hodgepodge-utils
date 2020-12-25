package com.github.liao47.leetcode;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/23 9:14
 */
public class P0387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (arr[ch - 'a'] == 0 && s.indexOf(ch, i + 1) == -1) {
                return i;
            }
            arr[ch - 'a']++;
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        int index = s.length();
        for (char i = 'a'; i <= 'z'; i++) {
            int idx = s.indexOf(i);
            if (idx != -1 && idx == s.lastIndexOf(i) && idx < index) {
                index = idx;
            }
        }
        return index == s.length() ? -1 : index;
    }
}
