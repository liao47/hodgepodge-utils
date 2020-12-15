package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 10. 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/12 13:42
 */
public class LeetCode0010_2 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        List<Status> statuses = new ArrayList<>();
        statuses.add(new Status('>', 1));
        int index = 0;
        while (index < p.length()) {
            if (index + 1 < p.length() && p.charAt(index + 1) == '*') {
                for (int i = statuses.size() - 1; i >= 0; i--) {
                    Status prev = statuses.get(i);
                    prev.next.add(statuses.size() + 1);
                    if (!prev.next.contains(i)) {
                        break;
                    }
                }

                statuses.add(new Status(p.charAt(index), statuses.size(), statuses.size() + 1));
                index += 2;
            } else {
                statuses.add(new Status(p.charAt(index), statuses.size() + 1));
                index++;
            }
        }

        if (s.isEmpty()) {
            for (int j = 1; j < statuses.size(); j++) {
                if (!statuses.get(j).next.contains(j)) {
                    return false;
                }
            }
            return true;
        }
        return matches(s, 0, statuses, 0);
    }

    private boolean matches(String str, int i, List<Status> statuses, int index) {
        int next = index == 0 ? i : i + 1;
        for (Integer nextIndex : statuses.get(index).next) {
            if (nextIndex == statuses.size()) {
                return next == str.length();
            }
            if (next == str.length()) {
                for (int j = nextIndex; j < statuses.size(); j++) {
                    if (!statuses.get(j).next.contains(j)) {
                        return false;
                    }
                }
                return true;
            }

            Status nextStatus = statuses.get(nextIndex);
            boolean matches = nextStatus.key == '.' || nextStatus.key == str.charAt(next);
            if (matches && matches(str, next, statuses, nextIndex)) {
                return true;
            }
        }
        return false;
    }

    class Status {
        private char key;
        private List<Integer> next;

        public Status(char key, Integer... next) {
            this.key = key;
            this.next = new ArrayList<>(Arrays.asList(next));
        }
    }
}
