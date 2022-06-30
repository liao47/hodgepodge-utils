package com.github.liao47.leetcode.bo;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public static Node of(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = null;
        Node node = null;
        for (int i : arr) {
            if (head == null) {
                head = new Node(i);
                head.next = head;
                node = head;
            } else {
                node.next = new Node(i, node.next);
                node = node.next;
            }
        }
        return head;
    }

    public static List<Integer> toList(Node head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        list.add(head.val);
        Node node = head.next;
        while (node != head) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}