package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.TreeNode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 *
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 *
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 *
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 *  
 *
 * 提示：
 *
 * 树中节点数量范围为 [1, 1000] 
 * 0 <= Node.val <= 5000
 * root 是完全二叉树
 * 0 <= val <= 5000 
 * 每个测试用例最多调用 insert 和 get_root 操作 10^4 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/25 14:08
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P0919CompleteBinaryTreeInserter {
    public static class CBTInserter1 {
        TreeNode[] nodes;
        int index;

        public CBTInserter1(TreeNode root) {
            nodes = new TreeNode[10001];
            index = 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                nodes[++index] = node;
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode p = nodes[++index >> 1];
            nodes[index] = new TreeNode(val);
            if (p.left == null) {
                p.left = nodes[index];
            } else {
                p.right = nodes[index];
            }
            return p.val;
        }

        public TreeNode get_root() {
            return nodes[1];
        }
    }

    public static class CBTInserter2 {
        Queue<TreeNode> candidate;
        TreeNode root;

        public CBTInserter2(TreeNode root) {
            this.candidate = new ArrayDeque<>();
            this.root = root;

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if (node.left == null || node.right == null) {
                    candidate.offer(node);
                }
            }
        }

        public int insert(int val) {
            TreeNode child = new TreeNode(val);
            TreeNode node = candidate.peek();
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                candidate.poll();
            }
            candidate.offer(child);
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static class CBTInserter {
        List<TreeNode> nodes;

        public CBTInserter(TreeNode root) {
            nodes = new ArrayList<>();
            nodes.add(null);
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                nodes.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode p = nodes.get(nodes.size() >> 1);
            TreeNode node = new TreeNode(val);
            nodes.add(node);
            if (p.left == null) {
                p.left = node;
            } else {
                p.right = node;
            }
            return p.val;
        }

        public TreeNode get_root() {
            return nodes.get(1);
        }
    }
}
