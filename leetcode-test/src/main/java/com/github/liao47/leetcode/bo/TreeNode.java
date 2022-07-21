package com.github.liao47.leetcode.bo;

import lombok.Data;

import java.util.*;

/**
 *
 * @author liaoshiqing
 * @date 2022/6/22 17:01
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> toList() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
            } else {
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        int index = list.size() - 1;
        while (index >= 0 && list.get(index) == null) {
            index--;
        }
        return list.subList(0, index + 1);
    }

    public static TreeNode of(Integer[] params) {
        TreeNode root = new TreeNode(params[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int i = 1;
        while (i < params.length) {
            Integer left = params[i++];
            Integer right = i < params.length ? params[i++] : null;

            TreeNode node = deque.poll();
            if (node == null) {
                break;
            }
            if (left != null) {
                node.left = new TreeNode(left);
                deque.offer(node.left);
            }
            if (right != null) {
                node.right = new TreeNode(right);
                deque.offer(node.right);
            }
        }
        return root;
    }
}