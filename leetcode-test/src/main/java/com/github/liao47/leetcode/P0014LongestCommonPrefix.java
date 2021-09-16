package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2021/9/15 16:40
 */
public class P0014LongestCommonPrefix {
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder maxPrefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int index = 0;
            while (index < Math.min(maxPrefix.length(), str.length())
                    && maxPrefix.charAt(index) == str.charAt(index)) {
                index++;
            }
            maxPrefix.delete(index, maxPrefix.length());
            if (maxPrefix.length() == 0) {
                break;
            }
        }
        return maxPrefix.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        int[][] arr = new int[200][26];
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                arr[i][charArray[i] - 'a']++;
            }
        }

        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            if (arr[i][prefix.charAt(i) - 'a'] != strs.length) {
                prefix = prefix.substring(0, i);
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix3(String[] strs) {
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (i >= str.length() || c != str.charAt(i)) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefix4(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            if (prefix.isEmpty()) {
                return prefix;
            }
            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        int index = chars.length;
        for (int i = 1; i < strs.length; i++) {
            index = Math.min(index, strs[i].length());
            if (index == 0) {
                break;
            }
            char[] strArr = strs[i].toCharArray();
            for (int j = 0; j < index; j++) {
                if (chars[j] != strArr[j]) {
                    index = j;
                    break;
                }
            }
        }
        return new String(chars, 0, index);
    }
}
