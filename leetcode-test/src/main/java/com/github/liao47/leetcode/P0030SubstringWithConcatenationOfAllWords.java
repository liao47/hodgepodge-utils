package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 *
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 *
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/23 13:39
 */
public class P0030SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length();
        int length = wordLen * words.length;
        List<Integer> list = new ArrayList<>();
        if (s.length() < length) {
            return list;
        }

        //字典树构建
        int[][] dict = new int[length][26];
        //id从1开始，0位空闲，空间定义多1位
        int[] cnt = new int[length + 1];
        int id = 0;
        for (String word : words) {
            int p = 0;
            for (char c : word.toCharArray()) {
                int x = c - 'a';
                if (dict[p][x] == 0) {
                    dict[p][x] = ++id;
                }
                p = dict[p][x];
            }
            //单词结尾，记录单词出现次数
            cnt[p]++;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i <= arr.length - length; i++) {
            int[] count = new int[cnt.length];
            int p = 0;
            for (int j = i; j < i + length; j++) {
                int x = arr[j] - 'a';
                if (dict[p][x] == 0) {
                    break;
                }
                p = dict[p][x];
                if (cnt[p] != 0) {
                    count[p]++;
                    if (count[p] > cnt[p]) {
                        //单词重复次数超出
                        break;
                    }
                    //用空余的第0位存储匹配的单词总数
                    count[0]++;
                    p = 0;
                }
            }
            if (count[0] == words.length) {
                list.add(i);
            }
        }
        return list;
    }
}
