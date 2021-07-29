package com.github.liao47.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/7/23 13:47
 */
public class P0034FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1, new int[]{-1, -1});
    }

    public int search(int[] nums, int target) {
        int[] result = new int[]{-1, -2};
        search(nums, target, 0, nums.length - 1, result);
        return result[1] - result[0] + 1;
    }

    private int[] search(int[] nums, int target, int left, int right, int[] result) {
        if (left > right) {
            return result;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            search(nums, target, left, mid - 1, result);
        } else if (nums[mid] < target) {
            search(nums, target, mid + 1, right, result);
        } else {
            if (mid == 0 || nums[mid - 1] != target) {
                result[0] = mid;
            } else {
                search(nums, target, left, mid - 1, result);
            }
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                result[1] = mid;
            } else {
                search(nums, target, mid + 1, right, result);
            }
        }
        return result;
    }
}
