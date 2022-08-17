package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.TreeNode;

/**
 * 1302. 层数最深叶子节点的和
 *
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 10^4] 之间。
 * 1 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/deepest-leaves-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/17 10:32
 */
public class P1302DeepestLeavesSum {
    private int deepest;
    private int sum;

    public int deepestLeavesSum(TreeNode root) {
        deepest = 0;
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        //这层判断可省略
        if (node.left == null && node.right == null) {
            if (depth == deepest) {
                sum += node.val;
            } else if (depth > deepest) {
                deepest = depth;
                sum = node.val;
            }
        }
        dfs(node.left, ++depth);
        dfs(node.right, depth);
    }
}
