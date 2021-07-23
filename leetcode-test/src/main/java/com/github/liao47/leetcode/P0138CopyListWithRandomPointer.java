package com.github.liao47.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 
 * 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/7/22 10:21
 */
public class P0138CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public static Node parse(String str) {
            List<JSONArray> arr = JSON.parseArray(str, JSONArray.class);
            Node head = new Node(0);
            Node p = head;
            List<Node> list = new ArrayList<>();
            for (JSONArray node : arr) {
                p.next = new Node(node.getInteger(0));
                list.add(p.next);
                p = p.next;
            }
            p = head.next;
            for (JSONArray node : arr) {
                Integer random = node.getInteger(1);
                if (random != null) {
                    p.random = list.get(random);
                }
                p = p.next;
            }
            return head.next;
        }

        public static String toString(Node head) {
            if (head == null) {
                return "[]";
            }
            Map<Node, Integer> map = new HashMap<>();
            Node p = head;
            int index = 0;
            while (p != null) {
                map.put(p, index++);
                p = p.next;
            }
            List<Integer[]> list = new ArrayList<>();
            p = head;
            while (p != null) {
                Integer[] node = new Integer[2];
                node[0] = p.val;
                node[1] = map.get(p.random);
                list.add(node);
                p = p.next;
            }
            return JSON.toJSONString(list);
        }
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node headNew = new Node(0);
        Node p = head;
        Node pNew = headNew;
        Map<Node, Node> map = new HashMap<>();
        while (p != null) {
            pNew.next = new Node(p.val);
            map.put(p, pNew.next);

            p = p.next;
            pNew = pNew.next;
        }
        p = head;
        pNew = headNew.next;
        while (p != null) {
            Node node = map.get(p.random);
            if (node != null) {
                pNew.random = node;
            }
            p = p.next;
            pNew = pNew.next;
        }
        return headNew.next;
    }

    Map<Node, Node> cached = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cached.containsKey(head)) {
            Node node = new Node(head.val);
            cached.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return cached.get(head);
    }
}
