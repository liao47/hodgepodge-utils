package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 828. 统计子串中的唯一字符
 *
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 *
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 *
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 *
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 *      其中，每一个子串都由独特字符构成。
 *      所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 * 示例 2：
 *
 * 输入: s = "ABA"
 * 输出: 8
 * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
 * 示例 3：
 *
 * 输入：s = "LEETCODE"
 * 输出：92
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 只包含大写英文字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/6 13:49
 */
public class P0828CountUniqueCharactersOfAllSubstringsOfAGivenString {
    //timeout
    public int uniqueLetterString1(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int pre = 0;
            for (int j = i; j < s.length(); j++) {
                int tmp = ++cnt[chars[j] - 'A'];
                if (tmp == 1) {
                    pre++;
                } else if (tmp == 2) {
                    pre--;
                }
                count += pre;
            }
        }
        return count;
    }

    public int uniqueLetterString2(String s) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            indexMap.computeIfAbsent(chars[i], t -> {
                List<Integer> list = new ArrayList<>();
                list.add(-1);
                return list;
            }).add(i);
        }
        int count = 0;
        for (Map.Entry<Character, List<Integer>> entry : indexMap.entrySet()) {
            List<Integer> list = entry.getValue();
            list.add(s.length());
            for (int i = 1; i < list.size() - 1; i++) {
                count += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return count;
    }

    public int uniqueLetterString(String s) {
        int[] curr = new int[26];
        int[] prev = new int[26];
        int count = 0;
        int index = 1;
        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            if (curr[idx] > 0) {
                count += (index - curr[idx]) * (curr[idx] - prev[idx]);
            }
            prev[idx] = curr[idx];
            curr[idx] = index++;
        }

        for (int i = 0; i < curr.length; i++) {
            if (curr[i] > 0) {
                count += (curr[i] - prev[i]) * (s.length() - curr[i] + 1);
            }
        }
        return count;
    }
}
