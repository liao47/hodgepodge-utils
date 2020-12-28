package com.github.liao47.leetcode;

import java.util.*;

/**
 * 895. 最大频率栈
 *
 * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
 *
 * FreqStack 有两个函数：
 *
 * push(int x)，将整数 x 推入栈中。
 * pop()，它移除并返回栈中出现最频繁的元素。
 * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
 *
 * pop() -> 返回 5，因为 5 是出现频率最高的。
 * 栈变成 [5,7,5,7,4]。
 *
 * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
 * 栈变成 [5,7,5,4]。
 *
 * pop() -> 返回 5 。
 * 栈变成 [5,7,4]。
 *
 * pop() -> 返回 4 。
 * 栈变成 [5,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-frequency-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/11 14:33
 */
public class P0895MaximumFrequencyStack {
    private P0895MaximumFrequencyStack() {}

    public static class FreqStack {
        Map<Integer, Integer> map;
        TreeMap<Integer, Integer> top;
        int index;

        public FreqStack() {
            map = new HashMap<>();
            top = new TreeMap<>();
            index = 0;
        }

        public void push(int x) {
            int count = map.getOrDefault(x, 0) + 1;
            map.put(x, count);
            top.put(count * 10000 + index++, x);
        }

        public int pop() {
            Map.Entry<Integer, Integer> entry = top.lastEntry();
            top.remove(entry.getKey());
            map.put(entry.getValue(), map.getOrDefault(entry.getValue(), 0) - 1);
            return entry.getValue();
        }
    }

    public static class FreqStack2 {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxFreq;

        public FreqStack2() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxFreq) {
                maxFreq = f;
            }

            group.computeIfAbsent(f, k -> new Stack<>()).push(x);
        }

        public int pop() {
            int x = group.get(maxFreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxFreq).isEmpty()) {
                maxFreq--;
            }
            return x;
        }
    }
}
