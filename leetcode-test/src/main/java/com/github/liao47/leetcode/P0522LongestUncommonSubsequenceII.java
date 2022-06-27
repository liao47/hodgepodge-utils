package com.github.liao47.leetcode;

import java.util.*;

/**
 * 522. 最长特殊序列 II
 *
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 *
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 *
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *  
 *
 * 示例 1：
 *
 * 输入: strs = ["aba","cdc","eae"]
 * 输出: 3
 * 示例 2:
 *
 * 输入: strs = ["aaa","aaa","aa"]
 * 输出: -1
 *  
 *
 * 提示:
 *
 * 2 <= strs.length <= 50
 * 1 <= strs[i].length <= 10
 * strs[i] 只包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-uncommon-subsequence-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/27 11:52
 */
public class P0522LongestUncommonSubsequenceII {

    public int findLUSlength1(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        Set<String> set = new LinkedHashSet<>();
        Set<String> candidates = new LinkedHashSet<>();
        for (String str : strs) {
            if (set.add(str)) {
                candidates.add(str);
            } else {
                candidates.remove(str);
            }
        }
        for (String candidate : candidates) {
            boolean isSub = false;
            for (String s : set) {
                if (candidate.length() >= s.length()) {
                    break;
                }
                if (isSub(s, candidate)) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                return candidate.length();
            }
        }
        return -1;
    }

    public int findLUSlength2(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            boolean isSub = false;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                if (strs[i].length() > strs[j].length()) {
                    break;
                }
                isSub = isSub(strs[j], strs[i]);
                if (isSub) {
                    break;
                }
            }
            if (!isSub) {
                return strs[i].length();
            }
        }
        return -1;
    }

    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() > max && isSpecial(strs, i)) {
                max = strs[i].length();
            }
        }
        return max;
    }

    private boolean isSub(String str, String sub) {
        char[] chars = sub.toCharArray();
        int index = 0;
        for (char c : str.toCharArray()) {
            if (c == chars[index] && ++index == sub.length()) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpecial(String[] strs, int idx) {
        for (int i = 0; i < strs.length; i++) {
            if (i != idx && isSub(strs[i], strs[idx])) {
                return false;
            }
        }
        return true;
    }
}
