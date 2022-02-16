package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2021/11/22 10:42
 */
public class P0384ShuffleAnArray {
    public static class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle() {
            int[] arr = new int[nums.length];
            System.arraycopy(nums, 0, arr, 0, nums.length);
            for (int i = 0; i < arr.length; i++) {
                int index = (int) Math.floor(Math.random() * arr.length);
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
            return arr;
        }
    }
}
