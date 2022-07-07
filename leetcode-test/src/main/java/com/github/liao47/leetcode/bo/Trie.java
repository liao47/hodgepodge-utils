package com.github.liao47.leetcode.bo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liaoshiqing
 * @date 2022/7/7 9:36
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Trie {
    public static class Node {
        String end;
        int count;
        Node[] next;
        //Map<Character, Node> next

        public Node() {
            this.end = null;
            this.count = 0;
            this.next = new Node[26];
        }
    }

    public static Node of(List<String> dict) {
        Node trie = new Node();
        for (String s : dict) {
            Node node = trie;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new Node();
                }
                node = node.next[idx];
            }
            node.end = s;
            node.count++;
        }
        return trie;
    }

    /**
     * 获取词根
     * @param word
     * @param trie
     * @return
     */
    public static String root(String word, Node trie) {
        Node node = trie;
        for (char c : word.toCharArray()) {
            node = node.next[c - 'a'];
            if (node == null) {
                break;
            }
            if (node.end != null) {
                return node.end;
            }
        }
        return word;
    }
}
