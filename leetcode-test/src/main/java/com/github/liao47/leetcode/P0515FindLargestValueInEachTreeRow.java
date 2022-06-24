package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *  
 *
 * 示例1：
 *
 *     1*
 *    / \
 *   3*  2
 *  / \   \
 * 5   3   9*
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 *  
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是 [0,10^4]
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/24 10:50
 */
public class P0515FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        return traversal(root, 0, new ArrayList<>());
    }

    private List<Integer> traversal(TreeNode node, int layer, List<Integer> list) {
        if (node == null) {
            return list;
        }
        if (list.size() <= layer) {
            list.add(node.val);
        } else if (node.val > list.get(layer)) {
            list.set(layer, node.val);
        }
        layer++;
        traversal(node.left, layer, list);
        traversal(node.right, layer, list);
        return list;
    }
}
