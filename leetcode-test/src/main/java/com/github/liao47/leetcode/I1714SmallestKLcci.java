package com.github.liao47.leetcode;

import com.github.liao47.leetcode.utils.Bfprt;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/3 9:18
 */
public class I1714SmallestKLcci {
    /**
     * 直接全部排序
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK1(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

    /**
     * 试验，非常慢
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK2(int[] arr, int k) {
        int[] smallest = Arrays.copyOf(arr, k);
        Arrays.sort(smallest);
        for (int i = k; i < arr.length; i++) {
            for (int j = 0; j < k; j++) {
                if (arr[i] < smallest[j]) {
                    int temp = arr[i];
                    arr[i] = smallest[k - 1];
                    if (k - 1 - j >= 0) {
                        System.arraycopy(smallest, j, smallest, j + 1, k - 1 - j);
                    }
                    smallest[j] = temp;
                }
            }
        }
        return smallest;
    }

    /**
     * 大根堆保存最小的k个数
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK3(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            Integer top = queue.peek();
            if (top == null) {
                break;
            }
            if (top > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int[] smallest = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            smallest[i++] = queue.poll();
        }
        return smallest;
    }

    /**
     * 快排思想，减治法
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK4(int[] arr, int k) {
        smallestK(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void smallestK(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = arr[right];
        while (i < j) {
            while (i < j && arr[i] <= key) {
                i++;
            }
            arr[j] = arr[i];
            while (i < j && arr[j] >= key) {
                j--;
            }
            arr[i] = arr[j];
        }
        arr[j] = key;
        if (i < k - 1) {
            smallestK(arr, k, i + 1, right);
        } else if (i > k - 1) {
            smallestK(arr, k, left, i - 1);
        }
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        new Bfprt().bfprt(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }
}
