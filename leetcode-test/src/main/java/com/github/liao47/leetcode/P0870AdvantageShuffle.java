package com.github.liao47.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 870. 优势洗牌
 *
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length <= 10^5
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/10/9 14:52
 */
public class P0870AdvantageShuffle {
    public int[] advantageCount1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums2[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums1[right] > arr[i][0]) {
                nums2[arr[i][1]] = nums1[right--];
            } else {
                nums2[arr[i][1]] = nums1[left++];
            }
        }
        return nums2;
    }

    public int[] advantageCount2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> nums2[b] - nums2[a]);
        int left = 0;
        int right = n - 1;
        for (Integer i : idx) {
            if (nums1[right] > nums2[i]) {
                nums2[i] = nums1[right--];
            } else {
                nums2[i] = nums1[left++];
            }
        }
        return nums2;
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ((long) nums2[i] << 32) + i;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums1[right] > arr[i] >> 32) {
                nums2[(int) arr[i]] = nums1[right--];
            } else {
                nums2[(int) arr[i]] = nums1[left++];
            }
        }
        return nums2;
    }
}
