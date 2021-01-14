package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 *
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 *
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2021/1/14 9:44
 */
public class P1018BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5A(int[] A) {
        List<Boolean> answers = new ArrayList<>();
        int divisor = 0;
        for (int i : A) {
            divisor = divisor << 1 | i;
            answers.add(divisor %5 == 0);
            divisor %= 5;
        }
        return answers;
    }

    public List<Boolean> prefixesDivBy5B(int[] A) {
        List<Boolean> answers = new ArrayList<>();
        int remainder = 0;
        for (int i : A) {
            remainder = ((remainder << 1) + i) % 5;
            answers.add(remainder == 0);
        }
        return answers;
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        Boolean[] answers = new Boolean[A.length];
        int divisor = 0;
        for (int i = 0; i < A.length; i++) {
            divisor = divisor << 1 | A[i];
            divisor %= 5;
            answers[i] = divisor == 0;
        }
        return Arrays.asList(answers);
    }
}
