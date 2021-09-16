package com.github.liao47.leetcode;

import java.util.*;

/**
 * @author liaoshiqing
 * @date 2021/9/16 9:51
 */
public class P0212WordSearchII {
    public List<String> findWords1(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            label : for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (findWords(board, chars, i, j, 0)) {
                        list.add(word);
                        break label;
                    }
                }
            }

        }
        return list;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>(26);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<Integer> indexes = map.computeIfAbsent(board[i][j], k -> new ArrayList<>());
                indexes.add(i << 4 | j);
            }
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            List<Integer> indexes = map.get(chars[0]);
            if (indexes == null || indexes.isEmpty()) {
                continue;
            }
            for (Integer index : indexes) {
                if (findWords(board, chars, index >>> 4, index & 0xF, 0)) {
                    list.add(word);
                    break;
                }
            }
        }
        return list;
    }

    private boolean findWords(char[][] board, char[] words, int i, int j, int index) {
        if (words[index] != board[i][j]) {
            return false;
        }
        if (++index == words.length) {
            return true;
        }

        board[i][j] = 0;
        boolean match = j < board[i].length - 1 && findWords(board, words, i, j + 1, index)
                || j > 0 && findWords(board, words, i, j - 1, index)
                || i < board.length - 1 && findWords(board, words, i + 1, j, index)
                || i > 0 && findWords(board, words, i - 1, j, index);
        board[i][j] = words[index - 1];
        return match;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }

        return new ArrayList<>(ans);
    }

    public void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
        char ch = board[i][j];
        if (!now.children.containsKey(ch)) {
            return;
        }
        Trie nxt = now.children.get(ch);
        if (!nxt.word.isEmpty()) {
            ans.add(nxt.word);
            nxt.word = "";
        }

        if (!nxt.children.isEmpty()) {
            board[i][j] = 0;
            if (j > 0) {
                dfs(board, nxt, i, j - 1, ans);
            }
            if (j < board[0].length - 1) {
                dfs(board, nxt, i, j + 1, ans);
            }
            if (i > 0) {
                dfs(board, nxt, i - 1, j, ans);
            }
            if (i < board.length - 1) {
                dfs(board, nxt, i + 1, j, ans);
            }
            board[i][j] = ch;
        }

        if (nxt.children.isEmpty()) {
            now.children.remove(ch);
        }
    }

    static class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }

        public void insert(String word) {
            Trie cur = this;
            for (char c : word.toCharArray()) {
                cur = cur.children.computeIfAbsent(c, k -> new Trie());
            }
            cur.word = word;
        }
    }
}
