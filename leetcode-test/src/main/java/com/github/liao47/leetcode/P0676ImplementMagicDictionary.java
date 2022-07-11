package com.github.liao47.leetcode;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 676. 实现一个魔法字典
 *
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true 
 * ；否则，返回 false 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 *
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *  
 *
 * 提示：
 *
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-magic-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/11 13:54
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P0676ImplementMagicDictionary {
    public static class MagicDictionary1 {
        static class Node {
            Map<Character, Node> next = new HashMap<>();
            boolean end;
        }

        private final Node trie;

        public MagicDictionary1() {
            trie = new Node();
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                Node node = this.trie;
                for (char c : s.toCharArray()) {
                    node = node.next.computeIfAbsent(c, t -> new Node());
                }
                node.end = true;
            }
        }

        public boolean search(String searchWord) {
            return search(this.trie, searchWord.toCharArray(), 0, false);
        }

        private boolean search(Node node, char[] arr, int idx, boolean changed) {
            if (idx >= arr.length) {
                return changed && node.end;
            }
            for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
                boolean change = changed;
                if (entry.getKey() != arr[idx]) {
                    if (changed) {
                        continue;
                    }
                    change = true;
                }
                if (search(entry.getValue(), arr, idx + 1, change)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class MagicDictionary2 {
        private String[] words;

        public MagicDictionary2() {
            //nothing
        }

        public void buildDict(String[] dictionary) {
            this.words = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : this.words) {
                if (word.length() != searchWord.length()) {
                    continue;
                }
                boolean changed = false;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        changed = !changed;
                        if (!changed) {
                            break;
                        }
                    }
                }
                if (changed) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class MagicDictionary {
        private final List<String>[] words;

        public MagicDictionary() {
            words = new List[100];
            for (int i = 0; i < words.length; i++) {
                words[i] = new ArrayList<>();
            }
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                words[word.length() - 1].add(word);
            }
        }

        public boolean search(String searchWord) {
            for (String word : words[searchWord.length() - 1]) {
                boolean changed = false;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        changed = !changed;
                        if (!changed) {
                            break;
                        }
                    }
                }
                if (changed) {
                    return true;
                }
            }
            return false;
        }
    }
}
