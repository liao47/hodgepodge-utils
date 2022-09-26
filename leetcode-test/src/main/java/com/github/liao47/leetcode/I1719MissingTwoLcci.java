package com.github.liao47.leetcode;

/**
 * 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 *
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 *
 * nums.length <= 30000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/missing-two-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/9/26 16:46
 */
public class I1719MissingTwoLcci {
    public int[] missingTwo1(int[] nums) {
        int n = nums.length + 2;
        int[] res = {n, n - 1};
        int index = 2;
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (idx >= n - 2) {
                res[n - idx - 1] = 0;
                index--;
            } else if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        if (index == 2) {
            return res;
        }
        if (res[0] == 0) {
            res[0] = res[1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res[index++] = i + 1;
                if (index == 2) {
                    break;
                }
            }
        }
        return res;
    }

    public int[] missingTwo2(int[] nums) {
        int xor = 0;
        int n = nums.length + 2;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        // 防止溢出
        int lsb = xor == Integer.MIN_VALUE ? xor : xor & -xor;
        int type1 = 0;
        int type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }
        return new int[]{type1, type2};
    }

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = n * (n + 1) >> 1;
        for (int num : nums) {
            sum -= num;
        }
        int avg = sum >> 1;
        int one = avg * (avg + 1) >> 1;
        for (int num : nums) {
            if (num <= avg) {
                one -= num;
            }
        }
        return new int[]{one, sum - one};
    }
}
