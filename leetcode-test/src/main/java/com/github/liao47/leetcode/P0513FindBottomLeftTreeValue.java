package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.TreeNode;

/**
 * 513. 找树左下角的值
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 示例 1:
 *   2
 *  / \
 * 1   3
 * 输入: root = [2,1,3]
 * 输出: 1
 *
 * 示例 2:
 *      1
 *    /  \
 *   2    3
 *  /    / \
 * 4    5   6
 *     /
 *    7
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *  
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/22 9:22
 */
public class P0513FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        return postorderTraversal(root, 0)[1];
    }

    private int[] postorderTraversal(TreeNode node, int layer) {
        if (node == null) {
            return new int[]{-1, 0};
        }
        int[] left = postorderTraversal(node.left, layer + 1);
        int[] right = postorderTraversal(node.right, layer + 1);
        if (left[0] != -1 || right[0] != -1) {
            return right[0] > left[0] ? right : left;
        }
        return new int[]{layer, node.val};
    }
}
