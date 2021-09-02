package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/2 9:09
 */
public class O0022LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode parse(String str) {
            String[] arr = str.split("->");
            ListNode head = new ListNode(0);
            ListNode node = head;
            for (String nodeStr : arr) {
                node.next = new ListNode(Integer.parseInt(nodeStr));
                node = node.next;
            }
            return head.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                sb.append(node.val).append("->");
                node = node.next;
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            return sb.toString();
        }
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        return list.get(list.size() - k);
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode right = head;
        for (; k > 0; k--) {
            right = right.next;
        }
        ListNode left = head;
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        return left;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        for (ListNode right = head; right != null; right = right.next) {
            if (--k < 0) {
                left = left.next;
            }
        }
        return left;
    }
}
