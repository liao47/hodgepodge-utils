package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 592. 分数加减运算
 *
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
 *
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 *  示例 2:
 *
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 *
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 *  
 *
 * 提示:
 *
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/8/3 14:23
 */
public class P0592FractionAdditionAndSubtraction {
    public String fractionAddition1(String expression) {
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        int flag = 1;
        int val = 0;
        for (char c : expression.toCharArray()) {
            if (c == '-' || c == '+') {
                if (val != 0) {
                    denominators.add(val);
                    val = 0;
                }
                //+(43),-(45)
                flag = 44 - c;
            } else if (c == '/') {
                numerators.add(val * flag);
                val = 0;
            } else {
                val = val * 10 + c - '0';
            }
        }
        denominators.add(val);
        //分母最小公倍数
        int lcm = denominators.get(0);
        for (int i = 1; i < denominators.size(); i++) {
            lcm = lcm * denominators.get(i) / gcd(lcm, denominators.get(i));
        }

        int numerator = 0;
        for (int i = 0; i < numerators.size(); i++) {
            numerator += numerators.get(i) * lcm / denominators.get(i);
        }
        if (numerator == 0) {
            return "0/1";
        }
        int divisor = gcd(lcm, Math.abs(numerator));
        return numerator / divisor + "/" + lcm / divisor;
    }

    public String fractionAddition(String expression) {
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        int flag = 1;
        int val = 0;
        for (char c : expression.toCharArray()) {
            if (c == '-' || c == '+') {
                if (val != 0) {
                    denominators.add(val);
                    val = 0;
                }
                //+(43),-(45)
                flag = 44 - c;
            } else if (c == '/') {
                numerators.add(val * flag);
                val = 0;
            } else {
                val = val * 10 + c - '0';
            }
        }
        denominators.add(val);

        long numerator = numerators.get(0);
        long denominator = denominators.get(0);
        for (int i = 1; i < numerators.size(); i++) {
            numerator = numerator * denominators.get(i) + numerators.get(i) * denominator;
            denominator *= denominators.get(i);
        }
        if (numerator == 0) {
            return "0/1";
        }
        long divisor = gcd(Math.abs(numerator), denominator);
        return numerator / divisor + "/" + denominator / divisor;
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    private long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
