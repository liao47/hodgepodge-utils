package com.github.liao47.leetcode;

import java.util.*;

/**
 * 229. 求众数 II
 *
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 *  
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 *  
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/10/22 9:42
 */
public class P0229MajorityElementII {
    public List<Integer> majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count == nums.length / 3) {
                list.add(num);
            }
            map.put(num, ++count);
        }
        return list;
    }

    public List<Integer> majorityElement2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count > nums.length / 3) {
                    list.add(nums[i - 1]);
                }
                count = 1;
            }
        }
        if (count > nums.length / 3) {
            list.add(nums[nums.length - 1]);
        }
        return list;
    }

    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for (int num : nums) {
            if (num == element1) {
                vote1++;
            } else if (num == element2) {
                vote2++;
            } else if (vote1 == 0) {
                element1 = num;
                vote1++;
            } else if (vote2 == 0) {
                element2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        vote1 = 0;
        vote2 = 0;
        for (int num : nums) {
            if (num == element1) {
                vote1++;
            } else if (num == element2) {
                vote2++;
            }
        }

        List<Integer> list = new ArrayList<>();
        if (vote1 > nums.length / 3) {
            list.add(element1);
        }
        if (vote2 > nums.length / 3) {
            list.add(element2);
        }
        return list;
    }
}
