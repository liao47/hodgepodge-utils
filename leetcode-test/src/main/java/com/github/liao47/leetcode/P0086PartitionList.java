package com.github.liao47.leetcode;

/**
 * 86. 分隔链表
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2021/1/4 10:22
 */
public class P0086PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode otherHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode other = otherHead;
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = null;

            if (node.val < x) {
                small.next = node;
                small = small.next;
            } else {
                other.next = node;
                other = other.next;
            }
        }
        small.next = otherHead.next;
        return smallHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode of(int... arr) {
            ListNode head = new ListNode(0);
            ListNode node = head;
            for (int i : arr) {
                node.next = new ListNode(i);
                node = node.next;
            }
            return head.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode node = next;
            while (node != null) {
                sb.append(" → ").append(node.val);
                node = node.next;
            }
            return sb.toString();
        }
    }
}
