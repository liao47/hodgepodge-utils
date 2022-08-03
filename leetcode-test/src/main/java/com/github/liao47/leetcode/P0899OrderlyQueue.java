package com.github.liao47.leetcode;

import java.util.Arrays;

/**
 * 899. 有序队列
 *
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 *
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 * 示例 2：
 *
 * 输入：s = "baaca", k = 3
 * 输出："aaabc"
 * 解释：
 * 在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
 * 在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 *  
 *
 * 提示：
 *
 * 1 <= k <= S.length <= 1000
 * s 只由小写字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/orderly-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/3 9:36
 */
public class P0899OrderlyQueue {
    public String orderlyQueue1(String s, int k) {
        if (k >= 2) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        StringBuilder sb = new StringBuilder(s);
        String min = s;
        int n = s.length();
        while (--n > 0) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            String str = sb.toString();
            if (str.compareTo(min) < 0) {
                min = str;
            }
        }
        return min;
    }

    public String orderlyQueue(String s, int k) {
        if (k < 2) {
            StringBuilder sb = new StringBuilder(s);
            String smallest = s;
            int n = s.length();
            while (--n > 0) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                String str = sb.toString();
                if (str.compareTo(smallest) < 0) {
                    smallest = str;
                }
            }
            return smallest;
        }

        int[] arr = new int[26];
        char c = 'a';
        for (char ch : s.toCharArray()) {
            arr[ch - c]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            while (i-- > 0) {
                sb.append(c);
            }
            c++;
        }
        return sb.toString();
    }
}
