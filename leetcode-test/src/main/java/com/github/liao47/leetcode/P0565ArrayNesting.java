package com.github.liao47.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 565. 数组嵌套
 *
 *索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释: 
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] < nums.length
 * A中不含有重复的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/array-nesting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/18 16:56
 */
public class P0565ArrayNesting {
    public int arrayNesting1(int[] nums) {
        int max = 0;
        int size = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            while (set.add(num)) {
                num = nums[num];
            }
            if (set.size() - size > max) {
                max = set.size() - size;
                if (max >= (nums.length + 1) / 2) {
                    return max;
                }
            }
            size = set.size();
        }
        return max;
    }

    public int arrayNesting(int[] nums) {
        int max = 1;
        int mid = (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            while (nums[i] != i) {
                int tmp = nums[i];
                nums[i] = i;
                i = tmp;
                count++;
            }
            if (count > max) {
                max = count;
                if (max >= mid) {
                    return max;
                }
            }
        }
        return max;
    }
}
