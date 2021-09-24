package com.github.liao47.leetcode;

import java.util.*;

/**
 * @author liaoshiqing
 * @date 2021/9/22 17:20
 */
public class P0673NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] arr = new int[2];
        find(nums, arr, new ArrayDeque<>(), 0,new HashSet<>());
        return arr[1];
    }

    private void find(int[] nums, int[] arr, Deque<Integer> deque, int i, Set<String> set) {
        if (i >= nums.length) {
            return;
        }

        if (deque.isEmpty() || nums[deque.peek()] < nums[i]) {
            deque.push(i);
            boolean absent = set.add(deque.toString());
            if (arr[0] == deque.size()) {
                if (absent) {
                    arr[1]++;
                }
            } else if (arr[0] < deque.size()) {
                arr[0] = deque.size();
                arr[1] = 1;
            }
            find(nums, arr, deque, i + 1, set);
            deque.pop();
        } else {
            find(nums, arr, deque, i + 1, set);

            Integer val = deque.pop();
            find(nums, arr, deque, i, set);
            deque.push(val);
        }
    }

    public int findNumberOfLIS1(int[] nums) {
        int[] arr = new int[2];
        List<String> list = new ArrayList<>();
        find1(nums, arr, new ArrayDeque<>(), 0, list, 0);
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        return arr[1];
    }

    private void find1(int[] nums, int[] arr, Deque<Integer> deque, int i, List<String> list, int flag) {
        if (i >= nums.length) {
            return;
        }

        if (deque.isEmpty() || nums[deque.peek()] < nums[i]) {
            deque.push(i);
            list.add(deque.toString());
            if (arr[0] == deque.size()) {
                arr[1]++;
            } else if (arr[0] < deque.size()) {
                arr[0] = deque.size();
                arr[1] = 1;
            }
            if (flag > 0) {
                flag++;
            }
            find1(nums, arr, deque, i + 1, list, flag);
            deque.pop();
        } else {
            find1(nums, arr, deque, i + 1, list, flag);

            Integer val = deque.pop();
            if (deque.size() >= flag) {
                find1(nums, arr, deque, i, list, deque.size());
            }
            deque.push(val);
        }
    }
}
