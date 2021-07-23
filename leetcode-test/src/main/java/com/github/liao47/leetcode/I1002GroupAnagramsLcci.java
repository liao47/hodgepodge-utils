package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 10.02. 变位词组
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
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
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/7/22 15:02
 */
public class I1002GroupAnagramsLcci {
    public List<List<String>> groupAnagrams(String[] strs) {
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
