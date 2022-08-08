package com.github.liao47.leetcode;

import com.github.liao47.leetcode.utils.UnionFind;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 952. 按公因数计算最大组件大小
 *
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 *
 * 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * 示例 2：
 *
 *
 *
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * 示例 3：
 *
 *
 *
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^5
 * nums 中所有值都 不同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-component-size-by-common-factor
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/8 10:04
 */
public class P0952LargestComponentSizeByCommonFactor {
    public int largestComponentSize1(int[] nums) {
        int max = 1;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        for (int num : nums) {
            List<Integer> gcdList = null;
            int n = queue.size();
            while (n-- > 0) {
                boolean notGcd = true;
                List<Integer> list = queue.poll();
                for (Integer i : list) {
                    if (gcd(i, num)) {
                        if (gcdList == null) {
                            gcdList = list;
                            gcdList.add(num);
                        } else {
                            gcdList.addAll(list);
                        }
                        notGcd = false;
                        break;
                    }
                }
                if (notGcd) {
                    queue.offer(list);
                }
            }
            if (gcdList == null) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                queue.offer(list);
            } else {
                queue.offer(gcdList);
                if (gcdList.size() > max) {
                    max = gcdList.size();
                }
            }
        }
        return max;
    }

    public int largestComponentSize(int[] nums) {
        int m = nums[0];
        for (int num : nums) {
            m = Math.max(m, num);
        }
        UnionFind uf = new UnionFind(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int max = 0;
        for (int num : nums) {
            int root = uf.find(num);
            max = Math.max(max, ++counts[root]);
        }
        return max;
    }

    private boolean gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b > 1;
    }
}
