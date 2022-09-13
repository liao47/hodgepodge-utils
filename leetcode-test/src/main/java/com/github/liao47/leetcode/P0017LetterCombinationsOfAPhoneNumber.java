package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/9 15:55
 */
public class P0017LetterCombinationsOfAPhoneNumber {
    private static final char[][] LETTERS = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return list;
        }
        list.add("");
        for (char num : digits.toCharArray()) {
            int size = list.size();
            while (size-- > 0) {
                String s = list.remove(0);
                for (char c : LETTERS[num - '2']) {
                    list.add(s + c);
                }
            }
        }
        return list;
    }

    public List<String> letterCombinations(String digits) {
        List<char[]> list = new ArrayList<>();
        int size = 1;
        for (char c : digits.toCharArray()) {
            list.add(LETTERS[c - '2']);
            size *= LETTERS[c - '2'].length;
        }
        List<String> ans = new ArrayList<>();
        if (!list.isEmpty()) {
            char[][] chars = new char[size][digits.length()];
            int s = size;
            for (int i = 0; i < digits.length(); i++) {
                char[] letter = list.get(i);
                s /= letter.length;
                for (int j = 0; j < size; j++) {
                    chars[j][i] = letter[j / s % letter.length];
                }
            }
            for (char[] arr : chars) {
                ans.add(new String(arr));
            }
        }
        return ans;
    }
}
