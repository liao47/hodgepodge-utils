package com.github.liao47.leetcode;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.05. 字母与数字
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 *
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 *
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 *
 * 输入: ["A","A"]
 *
 * 输出: []
 * 提示：
 *
 * array.length <= 100000
 * @author liaoshiqing
 * @date 2023/3/13 14:51
 */
public class I1705 {
    public String[] findLongestSubarray1(String[] array) {
        int n = array.length;
        int sum = 0;
        int index = -1;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            char c = array[i].charAt(0);
            sum += c >= '0' && c <= '9' ? 1 : -1;
            Integer idx = map.get(sum);
            if (idx == null) {
                map.put(sum, i);
            } else if (i - idx > max) {
                index = idx + 1;
                max = i - idx;
            }
        }
        return index == -1 ? new String[0] : Arrays.copyOfRange(array, index, index + max);
    }

    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int sum = n;
        int index = -1;
        int max = 0;
        int[] indexes = new int[2 * n + 1];
        indexes[sum] = 1;
        for (int i = 0; i < n; i++) {
            sum += (array[i].charAt(0) >> 5 & 2) - 1;
            int idx = indexes[sum];
            if (idx == 0) {
                indexes[sum] = i + 2;
            } else if (i + 2 - idx > max) {
                index = idx - 1;
                max = i + 2 - idx;
            }
        }
        return index == -1 ? new String[0] : Arrays.copyOfRange(array, index, index + max);
    }
}
