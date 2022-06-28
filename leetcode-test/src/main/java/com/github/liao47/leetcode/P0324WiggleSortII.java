package com.github.liao47.leetcode;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 *
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 *
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 10^4
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 *  
 *
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/28 9:14
 */
public class P0324WiggleSortII {
    public void wiggleSort1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] arr = new int[n];
        int idx = 0;
        for (int i = 0; i < n / 2; i++) {
            arr[idx++] = nums[(n - 1) / 2 - i];
            arr[idx++] = nums[n - i - 1];
        }
        if (idx < n) {
            arr[idx] = nums[0];
        }
        System.arraycopy(arr, 0, nums, 0, n);
    }

    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int j = i % 2 == 0 ? (n - i - 1) >> 1 : n - i / 2 - 1;
            nums[i] = arr[j];
        }
    }

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[5001];
        for (int num : nums) {
            cnt[num]++;
        }

        int index = 5000;
        for (int i = 1; i < n; i += 2) {
            while (cnt[index] == 0) {
                index--;
            }
            nums[i] = index;
            cnt[index]--;
        }
        for (int i = 0; i < n; i += 2) {
            while (cnt[index] == 0) {
                index--;
            }
            nums[i] = index;
            cnt[index]--;
        }
    }
}
