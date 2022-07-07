package com.github.liao47.leetcode.bo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 648. 单词替换
 *
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another
 * (另一个)。
 *
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 *
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *  
 *
 * 提示：
 *
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
