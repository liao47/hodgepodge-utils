package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 725. 分隔链表
 *
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 *  
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/22 13:48
 */
public class P0725SplitLinkedListInParts {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            ListNode node = this;
            while (node != null) {
                sb.append(node.val);
                sb.append(",");
                node = node.next;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]");
            return sb.toString();
        }
    }

    public ListNode[] splitListToParts1(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int q = list.size() / k;
        int r = list.size() % k;
        int index = 0;
        int i = 0;
        ListNode[] arr = new ListNode[k];
        while (index < list.size()) {
            if (index > 0) {
                list.get(index - 1).next = null;
            }
            arr[i++] = list.get(index);
            index += q;
            if (r-- > 0) {
                index++;
            }
        }
        return arr;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int q = count / k;
        int r = count % k;
        int index = 0;
        int i = 0;
        count = 0;
        ListNode[] arr = new ListNode[k];
        ListNode prev = null;
        node = head;
        while (node != null) {
            if (count++ == index) {
                arr[i++] = node;
                if (prev != null) {
                    prev.next = null;
                }

                index += q;
                if (r-- > 0) {
                    index++;
                }
            }
            prev = node;
            node = node.next;
        }
        return arr;
    }
}
