package com.github.liao47.leetcode;

/**
 *
 * 1031. 两个非重叠子数组的最大和
 *
 * 给你一个整数数组 nums 和两个整数 firstLen 和 secondLen，请你找出并返回两个非重叠 子数组 中元素的最大和，长度分别为 firstLen 和 secondLen 。
 *
 * 长度为 firstLen 的子数组可以出现在长为 secondLen 的子数组之前或之后，但二者必须是不重叠的。
 *
 * 子数组是数组的一个 连续 部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 *
 * 输入：nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 *
 * 输入：nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 *
 *
 * 提示：
 *
 * 1 <= firstLen, secondLen <= 1000
 * 2 <= firstLen + secondLen <= 1000
 * firstLen + secondLen <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * @author liaoshiqing
 * @date 2023/4/26 11:22
 */
public class P1031 {
    public int maxSumTwoNoOverlap1(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int sum = 0;
        for (int i = 0; i < firstLen; i++) {
            sum += nums[i];
        }
        leftMax[0] = sum;
        for (int i = firstLen; i < n; i++) {
            sum += nums[i] - nums[i - firstLen];
            leftMax[i - firstLen + 1] = sum;
        }
        int[] rightMax = new int[n + 1];
        for (int i = n - firstLen; i >= 0; i--) {
            rightMax[i] = Math.max(leftMax[i], rightMax[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i], leftMax[i - 1]);
        }
        sum = 0;
        for (int i = 0; i < secondLen; i++) {
            sum += nums[i];
        }
        int max = sum + rightMax[secondLen];
        for (int i = secondLen; i < n; i++) {
            sum += nums[i] - nums[i - secondLen];
            int l = i - secondLen - firstLen + 1;
            if (l >= 0) {
                l = leftMax[l];
            }
            max = Math.max(max, sum + Math.max(l, rightMax[i + 1]));
        }
        return max;
    }

    public static final int MOD = 10000;

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max1 = 0;
        if (firstLen == 0) {
            firstLen = secondLen % MOD;
            secondLen /= MOD;
        } else {
            max1 = maxSumTwoNoOverlap(nums, 0, firstLen * MOD + secondLen);
        }

        int n = nums.length;
        int sumL = 0;
        for (int i = 0; i < firstLen; i++) {
            sumL += nums[i];
        }
        int sumR = 0;
        for (int i = firstLen; i < firstLen + secondLen; i++) {
            sumR += nums[i];
        }
        int maxL = sumL;
        int max = sumL + sumR;
        for (int i = firstLen + secondLen; i < n; i++) {
            sumL += nums[i - secondLen] - nums[i - secondLen - firstLen];
            sumR += nums[i] - nums[i - secondLen];
            maxL = Math.max(maxL, sumL);
            max = Math.max(max, maxL + sumR);
        }
        return Math.max(max1, max);
    }
}
