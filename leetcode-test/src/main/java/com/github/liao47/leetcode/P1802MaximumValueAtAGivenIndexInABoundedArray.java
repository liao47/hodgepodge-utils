package com.github.liao47.leetcode;

/**
 * 1802. 有界数组中指定下标处的最大值
 *
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 *
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 *
 * 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * 示例 2：
 *
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= maxSum <= 10^9
 * 0 <= index < n
 * @author liaoshiqing
 * @date 2023/1/4 10:36
 */
public class P1802MaximumValueAtAGivenIndexInABoundedArray {
    public int maxValue(int n, int index, int maxSum) {
        int sum = n;
        int max = 0;
        int interval = 1;
        while (sum <= maxSum) {
            max++;
            if (interval == n) {
                return max + (maxSum - sum) / n;
            }
            sum += interval;
            if (index - max >= 0) {
                interval++;
            }
            if (index + max < n) {
                interval++;
            }
        }
        return max;
    }

    public int maxValue2(int n, int index, int maxSum) {
        int left = 1;
        int right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (sum(mid - 1, index) + sum(mid, n - index) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long sum(int x, int cnt) {
        return x >= cnt ? (x + x - cnt + 1L) * cnt / 2 : (x + 1L) * x / 2 + cnt - x;
    }
}
