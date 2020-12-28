package com.github.liao47.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/11 16:02
 */
public class P0001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        int left = 0;
        int right = sortNums.length - 1;
        while (left < right) {
            long sum = sortNums[left] + sortNums[right];
            if (sum == target) {
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        if (left >= right) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortNums[left]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == sortNums[right]) {
                right = i;
                break;
            }
        }
        return left < right ? new int[]{left, right} : new int[]{right, left};
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public int[] twoSum4(int[] nums, int target) {
        int max = 2047;
        int[] temp = new int[max + 1];
        int diffPos;
        for (int i = 0; i < nums.length; i++) {
            diffPos = (target - nums[i]) & max;
            if (temp[diffPos] != 0) {
                return new int[]{temp[diffPos] - 1, i};
            }
            temp[nums[i] & max] = i + 1;
        }
        return null;
    }
}
