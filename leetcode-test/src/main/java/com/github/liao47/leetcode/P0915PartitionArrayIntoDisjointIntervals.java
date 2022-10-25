package com.github.liao47.leetcode;

/**
 * 915. 分割数组
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 *
 * 用例可以保证存在这样的划分方法。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 *
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/10/24 17:58
 */
public class P0915PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (max <= min[i]) {
                return i;
            }
            max = Math.max(max, nums[i]);
        }
        return n - 1;
    }

    public int partitionDisjoint2(int[] nums) {
        int left = 1;
        int max = nums[0];
        int prevMax = max;
        boolean smaller = false;
        for (int i = 1; i < nums.length; i++) {
            if (max <= nums[i]) {
                if (smaller) {
                    left = i;
                    prevMax = max;
                    smaller = false;
                }
                max = nums[i];
            } else if (nums[i] < prevMax) {
                smaller = true;
            }
        }
        return left;
    }

    public int partitionDisjoint(int[] nums) {
        int left = 0;
        int max = nums[0];
        int prevMax = max;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < prevMax) {
                prevMax = max;
                left = i;
            }
        }
        return left + 1;
    }
}
