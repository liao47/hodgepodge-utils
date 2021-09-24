package com.github.liao47.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 430. 扁平化多级双向链表
 *
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *
 *
 * 扁平化后的链表如下图：
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 如何表示测试用例中的多级链表？
 *
 * 以 示例 1 为例：
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 序列化其中的每一级之后：
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *  
 *
 * 提示：
 *
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/24 9:18
 */
public class P0430FlattenAMultilevelDoublyLinkedList {
    public static class Node {
        private int val;
        private Node prev;
        private Node next;
        private Node child;

        public Node(int val) {
            this.val = val;
        }

        public Integer[] toArray() {
            return toArray(this);
        }

        public static Node parse(Integer[] arr) {
            Node head = new Node(0);
            Node node = head;
            int index = 0;
            boolean endFlag = false;
            Queue<Node> queue = new ArrayDeque<>();
            while (index < arr.length) {
                if (arr[index] == null) {
                    if (!endFlag) {
                        endFlag = true;
                    } else if (!queue.isEmpty()) {
                        queue.poll();
                    }
                } else {
                    if (endFlag) {
                        node = new Node(arr[index]);
                        queue.poll().child = node;
                        endFlag = false;
                        queue.clear();
                    } else {
                        node.next = new Node(arr[index]);
                        node.next.prev = node;
                        node = node.next;
                    }
                    queue.offer(node);
                }
                index++;
            }
            if (head.next != null) {
                head.next.prev = null;
            }
            return head.next;
        }

        public static Integer[] toArray(Node head) {
            List<Integer> list = new ArrayList<>();
            Node child = head;
            while (child != null) {
                Node node = child;
                child = null;
                int count = 0;
                while (node != null) {
                    list.add(node.val);
                    if (node.child != null) {
                        child = node.child;
                    }
                    if (child == null) {
                        count++;
                    }
                    node = node.next;
                }
                if (child != null) {
                    while (count-- >= 0) {
                        list.add(null);
                    }
                }
            }
            return list.toArray(new Integer[0]);
        }
    }

    public Node flatten(Node head) {
        flattenChild(head);
        return head;
    }

    private Node flattenChild(Node node) {
        Node prev = null;
        while (node != null) {
            if (node.child != null) {
                Node next = node.next;
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                Node end = flattenChild(node.next);
                end.next = next;
                if (next != null) {
                    next.prev = end;
                }
                prev = end;
                node = next;
            } else {
                prev = node;
                node = node.next;
            }
        }
        return prev;
    }
}
