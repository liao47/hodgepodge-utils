package com.github.liao47.leetcode;

/**
 * 面试题 01.01. 判定字符是否唯一
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/18 14:19
 */
public class Interview0101 {
    /**
     * 题目并未说明字符范围，尝试只有小写字母可通过。
     * 思考：范围是ASCII、Unicode怎么处理
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        int i = 0;
        for (char c : astr.toCharArray()) {
            if ((i & 1 << c - 'a') != 0) {
                return false;
            }
            i |= 1 << c - 'a';
        }
        return true;
    }
}
