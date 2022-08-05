package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 *
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *  
 *
 * 示例 1：
 *
 * ![示例 1](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/08/17/capture.jpeg)
 *
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 *
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *  
 *
 * 提示：
 *
 * 树中的节点数在 [1, 10^4]范围内
 * -10^5 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/5 14:53
 */
public class P1161MaximumLevelSumOfABinaryTree {
    public int maxLevelSum1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            int sum = 0;
            int n = queue.size();
            while (!queue.isEmpty() && n-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public int maxLevelSum2(TreeNode root) {
        List<Integer> sumList = new ArrayList<>();
        dfs(root, sumList, 0);
        int max = 0;
        for (int i = 1; i < sumList.size(); i++) {
            if (sumList.get(i) > sumList.get(max)) {
                max = i;
            }
        }
        return max + 1;
    }

    private void dfs(TreeNode root, List<Integer> sumList, int level) {
        if (root == null) {
            return;
        }
        if (sumList.size() <= level) {
            sumList.add(root.val);
        } else {
            sumList.set(level, sumList.get(level) + root.val);
        }
        dfs(root.left, sumList, ++level);
        dfs(root.right, sumList, level);
    }

    public int maxLevelSum(TreeNode root) {
        int[] sumArr = new int[10001];
        dfs(root, sumArr, 1);
        int max = 1;
        for (int i = 2; i <= sumArr[0]; i++) {
            if (sumArr[i] > sumArr[max]) {
                max = i;
            }
        }
        return max;
    }

    private void dfs(TreeNode node, int[] sumArr, int level) {
        if (node == null) {
            return;
        }
        if (sumArr[0] < level) {
            sumArr[0] = level;
        }
        sumArr[level++] += node.val;
        dfs(node.left, sumArr, level);
        dfs(node.right, sumArr, level);
    }
}
