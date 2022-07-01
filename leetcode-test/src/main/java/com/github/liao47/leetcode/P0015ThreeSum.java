package com.github.liao47.leetcode;

import java.util.*;

/**
 * 15. 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/30 15:14
 */
public class P0015ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            for (int j = i + 1; j < n - 1 && nums[i] + nums[j] <= 0; j++) {
                int k = binarySearch(nums, j + 1, -nums[i] - nums[j]);
                if (k != -1) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num >= 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = -nums[i] - nums[j];
                int k = map.getOrDefault(num, 0);
                if (num == nums[i]) {
                    k--;
                }
                if (num == nums[j]) {
                    k--;
                }
                if (k > 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], num);
                    list.sort(Comparator.comparingInt(a -> a));
                    set.add(list);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            for (int j = i + 1; j < k && nums[i] + nums[j] <= 0; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return list;
    }

    private int binarySearch(int[] arr, int left, int target) {
        int right = arr.length - 1;
        while (left <= right) {
            int mid = right + left >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
