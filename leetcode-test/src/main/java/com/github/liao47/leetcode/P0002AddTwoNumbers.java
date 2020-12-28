package com.github.liao47.leetcode;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/11 16:10
 */
public class P0002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0;
        while (null != cur1 || null != cur2) {
            int sum = (null == cur1 ? 0 : cur1.val) + (null == cur2 ? 0 : cur2.val) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            cur1 = null == cur1 ? null : cur1.next;
            cur2 = null == cur2 ? null : cur2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return result.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode result = new ListNode(0);
        ListNode tmpResult = result;
        ListNode previousResult;
        do {
            int sum = tmp1.val + tmp2.val + tmpResult.val;
            tmpResult.val = sum % 10;

            tmpResult.next = new ListNode(0);
            if (sum >= 10) {
                tmpResult.next.val += sum / 10;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            previousResult = tmpResult;
            tmpResult = tmpResult.next;
        } while (tmp1 != null && tmp2 != null);

        if (tmp2 != null) {
            tmp1 = tmp2;
        }
        while (tmp1 != null) {
            tmpResult.val += tmp1.val;
            tmpResult.next = new ListNode(0);
            if (tmpResult.val >= 10) {
                tmpResult.next.val += tmpResult.val / 10;
                tmpResult.val %= 10;
            }
            tmp1 = tmp1.next;
            previousResult = tmpResult;
            tmpResult = tmpResult.next;
        }
        if (tmpResult.val == 0) {
            previousResult.next = null;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode of(String str) {
            ListNode node = new ListNode(str.charAt(0) - '0');
            for (int i = 1; i < str.length(); i++) {
                node = new ListNode(str.charAt(i) - '0', node);
            }
            return node;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode node = next;
            while (node != null) {
                sb.append(node.val);
                node = node.next;
            }
            return sb.reverse().toString();
        }
    }
}
