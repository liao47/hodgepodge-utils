package com.github.liao47.leetcode;

/**
 * 640. 求解方程
 *
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *  
 *
 * 提示:
 *
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/10 10:21
 */
public class P0640SolveTheEquation {
    public String solveEquation(String equation) {
        int sign = 1;
        int val = 0;
        int coefficient = 0;
        int value = 0;
        boolean hasVal = false;
        for (char c : equation.toCharArray()) {
            switch (c) {
                case '+':
                case '-':
                    if (hasVal) {
                        value += sign * val;
                        val = 0;
                        hasVal = false;
                    }
                    sign = 44 - c;
                    break;
                case 'x':
                    coefficient += sign * (hasVal ? val : 1);
                    val = 0;
                    hasVal = false;
                    break;
                case '=':
                    if (hasVal) {
                        value += sign * val;
                        val = 0;
                        hasVal = false;
                    }
                    value = -value;
                    coefficient = -coefficient;
                    sign = 1;
                    break;
                default:
                    val = val * 10 + c - '0';
                    hasVal = true;
                    break;
            }
        }
        value += sign * val;
        if (coefficient == 0) {
            return value == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + -value / coefficient;
    }
}
