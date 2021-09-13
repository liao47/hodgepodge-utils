package com.github.liao47.leetcode;

/**
 * 678. 有效的括号字符串
 *
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parenthesis-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/13 13:53
 */
public class P0678ValidParenthesisString {
    public boolean checkValidString1(String s) {
        int wildcard = 0;
        int flag = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                wildcard++;
            } else if (c == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                if (--wildcard < 0) {
                    return false;
                }
                flag++;
            }
        }
        if (wildcard < flag) {
            return false;
        }
        wildcard = 0;
        flag = 0;
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                wildcard++;
            } else if (c == ')') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                if (--wildcard < 0) {
                    return false;
                }
                flag++;
            }
        }
        return wildcard >= flag;
    }

    public boolean checkValidString(String s) {
        int flag = 0;
        int opening = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                flag++;
                opening--;
            } else if (c == '(') {
                flag++;
                opening++;
            } else {
                if (flag == 0) {
                    return false;
                }
                flag--;
                opening--;
            }
            if (opening < 0) {
                opening = 0;
            }
        }
        return opening == 0;
    }
}
