package com.github.liao47.leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/14 15:54
 */
public class P0049GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            if (str != null && !str.isEmpty()) {
                for (char c : str.toCharArray()) {
                    arr[c - 'a']++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    sb.append((char) (i + 'a')).append(arr[i]);
                }
            }
            List<String> list = map.computeIfAbsent(sb.toString(), k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] prime = generatePrimeArr(26);

        Map<Long, List<String>> map = new HashMap<>();
        for (String str : strs) {
            long p = 1;
            for (char c : str.toCharArray()) {
                p *= prime[c - 'a'];
            }
            List<String> list = map.computeIfAbsent(p, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public int[] generatePrimeArr(int length) {
        int[] arr = new int[length];
        int item = 2;
        int index = 0;
        while (index < length) {
            boolean isPrime = true;
            for (int i = 0; i < index; i++) {
                if (item % arr[i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                arr[index++] = item;
            }
            item++;
        }
        return arr;
    }
}
