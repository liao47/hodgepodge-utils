package com.github.liao47.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2021/9/14 9:19
 */
public class P0524LongestWordInDictionaryThroughDeleting {
    public String findLongestWord1(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> {
            int compare = Integer.compare(b.length(), a.length());
            return compare == 0 ? a.compareTo(b) : compare;
        });
        for (String word : dictionary) {
            int index = 0;
            for (char c : s.toCharArray()) {
                if (c == word.charAt(index) && ++index == word.length()) {
                    return word;
                }
            }
        }
        return "";
    }

    public String findLongestWord2(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            int index = 0;
            for (char c : s.toCharArray()) {
                if (c == word.charAt(index) && ++index == word.length()) {
                    result = order(result, word);
                    break;
                }
            }
        }
        return result;
    }

    public String findLongestWord(String s, List<String> dictionary) {
        int n = s.length();
        int[][] f = new int[n + 1][26];
        Arrays.fill(f[n], n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < f[i].length; j++) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        String result = "";
        for (String word : dictionary) {
            boolean match = true;
            int i = 0;
            for (char c : word.toCharArray()) {
                if (f[i][c - 'a'] == n) {
                    match = false;
                    break;
                }
                i = f[i][c - 'a'] + 1;
            }
            if (match) {
                result = order(result, word);
            }
        }
        return result;
    }

    private String order(String str, String newStr) {
        if (str.length() > newStr.length()) {
            return str;
        } else if (str.length() < newStr.length()) {
            return newStr;
        }
        return str.compareTo(newStr) <= 0 ? str : newStr;
    }
}
