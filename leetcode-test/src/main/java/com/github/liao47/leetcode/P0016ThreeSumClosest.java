package com.github.liao47.leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/9 10:50
 */
public class P0016ThreeSumClosest {
    public int threeSumClosest1(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int sub = Math.abs(sum - target);
                    if (sub < min) {
                        min = sub;
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                sum += binarySearch(nums, j + 1, target - sum);
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }

    public int threeSumClosest3(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            for (int j = i + 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int twoSum = nums[i] + nums[j];
                while (j < k && twoSum + nums[k] > target) {
                    k--;
                }
                for (int l = k; l <= k + 1; l++) {
                    if (j < l && l < n) {
                        int sum = twoSum + nums[l];
                        if (Math.abs(sum - target) < Math.abs(closest - target)) {
                            closest = sum;
                        }
                    }
                }
            }
        }
        return closest;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                //target小于最小sum
                int sum = nums[i] + nums[j] + nums[j + 1];
                if (target < sum) {
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        closest = sum;
                    }
                    break;
                }
                //target大于最大sum
                sum = nums[i] + nums[k - 1] + nums[k];
                if (target > sum) {
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        closest = sum;
                    }
                    break;
                }

                while (j < k && nums[i] + nums[j] + nums[k] > target) {
                    k--;
                }
                //分别取k和k+1求值
                for (int k1 = k; k1 <= k + 1; k1++) {
                    if (j < k1 && k1 < n) {
                        sum = nums[i] + nums[j] + nums[k1];
                        if (sum == target) {
                            return sum;
                        }
                        int diff = Math.abs(sum - target);
                        if (diff < minDiff) {
                            minDiff = diff;
                            closest = sum;
                        }
                    }
                }
                while (++j < k && nums[j - 1] == nums[j]) {
                    ++j;
                }
            }
        }
        return closest;
    }

    private int binarySearch(int[] arr, int left, int target) {
        int right = arr.length - 1;
        if (target - arr[right] > 0) {
            return arr[right];
        }
        int min = arr[left];
        int minDiff = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = right + left >>> 1;
            int diff = Math.abs(target - arr[mid]);
            if (diff < minDiff) {
                minDiff = diff;
                min = arr[mid];
            }
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return min;
    }
}
