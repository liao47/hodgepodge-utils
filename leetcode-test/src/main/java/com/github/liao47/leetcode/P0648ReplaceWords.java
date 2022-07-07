package com.github.liao47.leetcode;

import com.github.liao47.leetcode.bo.Trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
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
