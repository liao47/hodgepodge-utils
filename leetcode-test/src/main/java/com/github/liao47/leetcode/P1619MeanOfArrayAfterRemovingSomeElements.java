package com.github.liao47.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1619. 删除某些元素后的数组均值
 *
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 *
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 * 示例 2：
 *
 * 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * 输出：4.00000
 * 示例 3：
 *
 * 输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 * 输出：4.77778
 * 示例 4：
 *
 * 输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,
 * 2,9,7,7,3,0,1,6,1,10,3]
 * 输出：5.27778
 * 示例 5：
 *
 * 输入：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,
 * 0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
 * 输出：5.29167
 *  
 *
 * 提示：
 *
 * 20 <= arr.length <= 1000
 * arr.length 是 20 的 倍数 
 * 0 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/14 13:43
 */
public class P1619MeanOfArrayAfterRemovingSomeElements {
    public double trimMean1(int[] arr) {
        Arrays.sort(arr);
        int delSize = arr.length / 20;
        int sum = 0;
        for (int i = delSize; i < arr.length - delSize; i++) {
            sum += arr[i];
        }
        return 1.0 * sum / (arr.length - 2 * delSize);
    }

    public double trimMean2(int[] arr) {
        int delSize = arr.length / 20;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(delSize, Comparator.reverseOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(delSize);
        int sum = 0;
        for (int num : arr) {
            minQueue.offer(num);
            if (minQueue.size() > delSize) {
                sum += minQueue.poll();
            }
            maxQueue.offer(num);
            if (maxQueue.size() > delSize) {
                sum += maxQueue.poll();
            }
            sum -= num;
        }
        return 1.0 * sum / (arr.length - 2 * delSize);
    }

    public double trimMean3(int[] arr) {
        int length = arr.length / 20;
        int[] min = new int[length];
        int[] max = new int[length];
        Arrays.fill(min, Integer.MAX_VALUE);
        int sum = 0;
        for (int num : arr) {
            sum += num;
            sort(max, min, num);
        }
        for (int i = 0; i < length; i++) {
            sum -= min[i];
            sum -= max[i];
        }
        return 1.0 * sum / (arr.length - 2 * length);
    }

    public double trimMean(int[] arr) {
        int length = arr.length / 20;
        int[] minArr = new int[length];
        int[] maxArr = new int[length];
        int sum = 0;
        int index = 0;
        for (int num : arr) {
            sum -= num;
            if (index < length) {
                minArr[index] = num;
                maxArr[index++] = num;
            } else {
                //sum += displace(minArr, num, 1);
                //sum += displace(maxArr, num, -1);
                sum += displace(minArr, maxArr, num);
            }
        }
        return sum / (arr.length * 0.9);
    }

    private int displace(int[] arr, int num, int flag) {
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - num) * flag > 0) {
                int tmp = num;
                num = arr[i];
                arr[i] = tmp;
            }
        }
        return num;
    }

    private int displace(int[] minArr, int[] maxArr, int num) {
        int min = num;
        for (int i = 0; i < minArr.length; i++) {
            if (minArr[i] > min) {
                int tmp = min;
                min = minArr[i];
                minArr[i] = tmp;
            }
        }
        int max = num;
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] < max) {
                int tmp = max;
                max = maxArr[i];
                maxArr[i] = tmp;
            }
        }
        return min + max;
    }

    private void sort(int[] max, int[] min, int num) {
        for (int i = 0; i < max.length; i++) {
            if (num < max[i]) {
                break;
            }
            if (i > 0) {
                max[i - 1] = max[i];
            }
            max[i] = num;
        }
        for (int i = 0; i < min.length; i++) {
            if (num > min[i]) {
                break;
            }
            if (i > 0) {
                min[i - 1] = min[i];
            }
            min[i] = num;
        }
    }
}
