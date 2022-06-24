package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 *
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 *  
 *
 * 示例 1：
 *   5
 *  / \
 * 2  -3
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 *   5
 *  / \
 * 2  -5
 * 输入: root = [5,2,-5]
 * 输出: [2]
 *  
 *
 * 提示:
 *
 * 节点数在 [1, 10^4] 范围内
 * -10^5 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/most-frequent-subtree-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/22 16:55
 */
public class P0508MostFrequentSubtreeSum {

    int max;
    List<Integer> list;

    public int[] findFrequentTreeSum(TreeNode root) {
        max = 0;
        list = new ArrayList<>();
        traversalSum(root, new HashMap<>());

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
        //return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int traversalSum(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        node.val += traversalSum(node.left, map) + traversalSum(node.right, map);
        int count = map.compute(node.val, (k, v) -> v == null ? 1 : v + 1);
        if (count > max) {
            max = count;
            list.clear();
            list.add(node.val);
        } else if (count == max) {
            list.add(node.val);
        }
        return node.val;
    }

    public int traversalSum2(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + traversalSum2(node.left, map) + traversalSum2(node.right, map);
        int count = map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
        if (count > max) {
            max = count;
            list.clear();
            list.add(sum);
        } else if (count == max) {
            list.add(sum);
        }
        return sum;
    }
}
