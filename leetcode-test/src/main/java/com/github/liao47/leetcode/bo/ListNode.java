package com.github.liao47.leetcode.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/9/27 15:38
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode node = null;
        for (int i : arr) {
            if (head == null) {
                head = new ListNode(i);
                node = head;
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return head;
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }
        list.add(head.val);
        ListNode node = head.next;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
