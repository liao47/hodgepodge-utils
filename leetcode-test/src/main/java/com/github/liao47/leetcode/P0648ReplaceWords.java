package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.Trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
 * @date 2022/7/7 9:10
 */
public class P0648ReplaceWords {
    public String replaceWords1(List<String> dictionary, String sentence) {
        //字典树构建
        int[][] dict = new int[dictionary.size() * 100][26];
        String[] words = new String[dictionary.size() * 100 + 1];
        int id = 0;
        for (String word : dictionary) {
            int p = 0;
            for (char c : word.toCharArray()) {
                int x = c - 'a';
                if (dict[p][x] == 0) {
                    dict[p][x] = ++id;
                }
                p = dict[p][x];
            }
            words[p] = word;
        }

        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            int p = 0;
            for (char c : arr[i].toCharArray()) {
                p = dict[p][c - 'a'];
                if (p == 0) {
                    break;
                }
                if (words[p] != null) {
                    arr[i] = words[p];
                    break;
                }
            }
        }
        return String.join(" ", arr);
    }

    public String replaceWords2(List<String> dictionary, String sentence) {
        Trie.Node trie = Trie.of(dictionary);
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split(" ")) {
            sb.append(Trie.root(s, trie)).append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie.Node trie = Trie.of(dictionary);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = Trie.root(words[i], trie);
        }
        return String.join(" ", words);
    }

    public String replaceWords3(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (String s : arr) {
            String word = null;
            for (String w : dictionary) {
                if (s.startsWith(w) && (word == null || w.length() < word.length())) {
                    word = w;
                }
            }
            sb.append(word == null ? s : word).append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String replaceWords4(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (set.contains(arr[i].substring(0, j + 1))) {
                    arr[i] = arr[i].substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join(" ", arr);
    }
}
