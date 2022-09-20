package com.github.liao47.leetcode;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *  
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/20 9:24
 */
public class P0698PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int avg = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > avg) {
            return false;
        }
        boolean[] dp = new boolean[1 << nums.length];
        Arrays.fill(dp, true);
        return dfs(nums, avg, dp, (1 << nums.length) - 1, 0);
    }

    private boolean dfs(int[] nums, int avg, boolean[] dp, int s, int p) {
        if (s == 0) {
            return true;
        }
        if (!dp[s]) {
            return false;
        }
        dp[s] = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + p > avg) {
                break;
            }
            if ((s >> i & 1) != 0 && dfs(nums, avg, dp, s ^ 1 << i, (p + nums[i]) % avg)) {
                return true;
            }
        }
        return false;
    }
}
