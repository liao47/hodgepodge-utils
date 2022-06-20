package com.github.liao47.leetcode;

import java.util.*;

/**
 * @author liaoshiqing
 * @date 2022/6/17 15:43
 */
public class P1089DuplicateZeros {

    public void duplicateZeros1(int[] arr) {
        int i = -1;
        while (++i < arr.length) {
            if (arr[i] == 0) {
                int prev = 0;
                for (int j = ++i; j < arr.length; j++) {
                    int tmp = arr[j];
                    arr[j] = prev;
                    prev = tmp;
                }
            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        int i = -1;
        while (++i < arr.length) {
            Integer a = deque.poll();
            if (a != null) {
                deque.offer(arr[i]);
                arr[i] = a;
            }
            if (arr[i] == 0 && i < arr.length - 1) {
                deque.offer(arr[++i]);
                arr[i] = 0;
            }
        }
    }

    public void duplicateZeros3(int[] arr) {
        int[] ans = new int[arr.length];
        int idx = 0;
        for (int a : arr) {
            if (a == 0) {
                idx += 2;
            } else if (idx < arr.length) {
                ans[idx++] = a;
            }
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[i++] == 0) {
                j++;
            }
            j++;
        }
        i--;
        j--;
        while (i >= 0) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j >= 0) {
                arr[j] = 0;
            }
            i--;
            j--;
        }
    }
}
