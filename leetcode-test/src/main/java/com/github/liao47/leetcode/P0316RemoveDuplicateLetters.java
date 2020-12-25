package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2020/12/22 11:05
 */
public class P0316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int vis = 0;
        int[] num = new int[26];
        for (char ch : s.toCharArray()) {
            num[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ((vis & 1 << ch - 'a') == 0) {
                char tail;
                while (sb.length() > 0 && (tail = sb.charAt(sb.length() - 1)) > ch && num[tail - 'a'] > 0) {
                    vis &= ~(1 << tail - 'a');
                    sb.deleteCharAt(sb.length() - 1);
                }
                vis |= 1 << ch - 'a';
                sb.append(ch);
            }
            num[ch - 'a']--;
        }
        return sb.toString();
    }
}
