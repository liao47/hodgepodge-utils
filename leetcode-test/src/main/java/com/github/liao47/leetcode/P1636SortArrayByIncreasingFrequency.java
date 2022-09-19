package com.github.liao47.leetcode;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 *
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
 *
 * 请你返回排序后的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 *
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-array-by-increasing-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/19 9:19
 */
public class P1636SortArrayByIncreasingFrequency {
    public int[] frequencySort1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) :
                a.getValue().compareTo(b.getValue()));
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            for (int i = 0; i < entry.getValue(); i++) {
                nums[index++] = entry.getKey();
            }
        }
        return nums;
    }

    public int[] frequencySort2(int[] nums) {
        int[] arr = new int[201];
        for (int num : nums) {
            if (arr[num + 100] == 0) {
                arr[num + 100] = 100 - num;
            }
            arr[num + 100] += 1 << 8;
        }
        Arrays.sort(arr);
        int index = 0;
        for (int i : arr) {
            if (i != 0) {
                int count = i >>> 8;
                int num = 100 - (i & 0xff);
                while (count-- > 0) {
                    nums[index++] = num;
                }
            }
        }
        return nums;
    }

    public int[] frequencySort(int[] nums) {
        int[] arr = new int[201];
        for (int num : nums) {
            arr[num + 100]++;
        }
        List<Integer>[] lists = new List[101];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                continue;
            }
            if (lists[arr[i]] == null) {
                lists[arr[i]] = new ArrayList<>();
            }
            lists[arr[i]].add(i - 100);
        }
        int index = 0;
        for (int i = 1; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            for (Integer num : lists[i]) {
                int count = i;
                while (count-- > 0) {
                    nums[index++] = num;
                }
            }
        }
        return nums;
    }
}
