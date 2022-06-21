package com.github.liao47.leetcode;

import java.util.*;

/**
 * 1089. 复写零
 *
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
