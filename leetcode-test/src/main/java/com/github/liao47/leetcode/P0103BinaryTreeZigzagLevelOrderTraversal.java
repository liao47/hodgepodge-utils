package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/22 9:23
 */
public class P0103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<TreeNode> item = new ArrayList<>();
        item.add(root);
        boolean flag = false;
        while (!item.isEmpty()) {
            List<Integer> valList = new ArrayList<>();
            for (TreeNode node : item) {
                if (node != null) {
                    valList.add(node.val);
                }
            }
            if (!valList.isEmpty()) {
                list.add(valList);
            }

            List<TreeNode> temp = new ArrayList<>();
            for (int i = item.size() - 1; i >= 0; i--) {
                TreeNode node = item.get(i);
                if (node != null) {
                    if (flag) {
                        temp.add(node.left);
                        temp.add(node.right);
                    } else {
                        temp.add(node.right);
                        temp.add(node.left);
                    }
                }
            }
            item = temp;
            flag = !flag;
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public static TreeNode of(Integer[] arr) {
            TreeNode root = new TreeNode(arr[0]);
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            int i = 1;
            while (i < arr.length) {
                List<TreeNode> temp = new ArrayList<>();
                for (TreeNode node : list) {
                    if (node == null) {
                        i += 2;
                        continue;
                    }
                    Integer val = arr[i++];
                    node.left = val == null ? null : new TreeNode(val);
                    val = arr[i++];
                    node.right = val == null ? null : new TreeNode(val);
                    temp.add(node.left);
                    temp.add(node.right);
                }
                list = temp;
            }
            return root;
        }
    }
}
