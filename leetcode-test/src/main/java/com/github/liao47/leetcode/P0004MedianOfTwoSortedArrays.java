package com.github.liao47.leetcode;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/11 16:42
 */
public class P0004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            //保证数组1一定最短
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = 0;
        int l2 = 0;
        int r1 = 0;
        int r2 = 0;
        int c1;
        int c2;
        int lo = 0;
        int hi = 2 * n;
        while (lo <= hi) {
            c1 = (lo + hi) / 2;
            c2 = m + n - c1;
            l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            r1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
            l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            r2 = (c2 == 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];

            if (l1 > r2) {
                hi = c1 - 1;
            } else if (l2 > r1) {
                lo = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }
}
