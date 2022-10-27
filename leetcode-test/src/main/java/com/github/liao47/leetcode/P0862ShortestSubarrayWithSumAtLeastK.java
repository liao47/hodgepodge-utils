package com.github.liao47.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. 和至少为 K 的最短子数组
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 *
 * 子数组 是数组中 连续 的一部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1], k = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [1,2], k = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [2,-1,2], k = 3
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -105 <= nums[i] <= 10^5
 * 1 <= k <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/10/26 14:03
 */
public class P0862ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (sum <= 0) {
                left = right + 1;
                sum = 0;
            } else if (sum >= k) {
                while (left <= right && sum >= k) {
                    min = Math.min(min, right - left + 1);
                    sum -= nums[left++];

                    int tmp = left;
                    int tmpSum = 0;
                    while (tmp <= right) {
                        tmpSum += nums[tmp++];
                        if (tmpSum < 0) {
                            left = tmp;
                            sum -= tmpSum;
                            tmpSum = 0;
                        }
                    }
                }
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int shortestSubarray2(int[] nums, int k) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        int min = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for (int i = 1; i <= n; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
            while (!deque.isEmpty() && sums[i] - sums[deque.peek()] >= k) {
                min = Math.min(min, i - deque.poll());
            }
            while (!deque.isEmpty() && sums[deque.peekLast()] >= sums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        return min == n + 1 ? -1 : min;
    }

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int min = n + 1;
        long[] sums = new long[min];
        int[] indexes = new int[min];
        int left = 0;
        int right = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
            while (left <= right && sums[i] - sums[indexes[left]] >= k) {
                min = Math.min(min, i - indexes[left++]);
            }
            while (left <= right && sums[indexes[right]] >= sums[i]) {
                right--;
            }
            indexes[++right] = i;
        }
        return min == n + 1 ? -1 : min;
    }
}
