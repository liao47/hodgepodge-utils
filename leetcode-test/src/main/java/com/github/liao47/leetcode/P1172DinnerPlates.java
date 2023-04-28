package com.github.liao47.leetcode;

import java.util.TreeSet;

/**
 * 1172. 餐盘栈
 *
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 *
 * 实现一个叫「餐盘」的类 DinnerPlates：
 *
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 *
 *
 * 示例：
 *
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop",
 * "pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 *
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 *                                     1  3  5
 *                                     ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 *                                           1  3  5
 *                                           ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 *                                    1  3  5
 *                                    ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 *                                    1  3  5
 *                                    ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 *                                             1  3  5
 *                                             ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 *                                             1  3  5
 *                                             ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 *                                             1  3
 *                                             ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 *                                            ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 *                                            ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 *
 *
 * 提示：
 *
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 * @author liaoshiqing
 * @date 2023/4/28 17:38
 */
public class P1172DinnerPlates {
    public static final int OFFSET = 1000000;
    private final int[] arr;
    private final int capacity;
    private int inIdx;
    private int outIdx;
    private final TreeSet<Integer> indexes;
    private boolean last;

    public P1172DinnerPlates(int capacity) {
        this.capacity = capacity;
        arr = new int[200000];
        inIdx = 0;
        outIdx = 0;
        last = false;
        indexes = new TreeSet<>();
        indexes.add(0);
    }
    
    public void push(int val) {
        indexes.add(inIdx / capacity + OFFSET);
        arr[inIdx++] = val;
        if (inIdx % capacity == 0) {
            indexes.remove((inIdx - 1) / capacity);
            if (arr[inIdx] == 0) {
                indexes.add(inIdx / capacity);
            }
        }
        if (arr[inIdx] != 0) {
            int index = indexes.first();
            int l = index * capacity;
            int r = l + capacity - 1;
            while (l <= r) {
                int m = l + r >> 1;
                if (arr[m] == 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            inIdx = l;
        }
        if (outIdx < inIdx - 1) {
            outIdx = inIdx - 1;
        }
    }
    
    public int pop() {
        if (outIdx < 0) {
            return -1;
        }
        if (arr[outIdx] == 0) {
            int index = indexes.last();
            if (index < OFFSET) {
                return -1;
            }
            last = true;
            return popAtStack(index - OFFSET);
        }
        indexes.add(outIdx / capacity);
        if (inIdx > outIdx) {
            inIdx = outIdx;
        }
        if (outIdx % capacity == 0) {
            indexes.remove(outIdx / capacity + OFFSET);
        }
        int val = arr[outIdx];
        arr[outIdx--] = 0;
        return val;
    }
    
    public int popAtStack(int index) {
        int l = index * capacity;
        if (arr[l] == 0) {
            return -1;
        }

        int r = l + capacity - 1;
        if (arr[r] == 0) {
            while (l <= r) {
                int m = l + r >> 1;
                if (arr[m] == 0) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        
        if (inIdx > r) {
            inIdx = r;
        }
        if (last) {
            outIdx = r - 1;
            last = false;
        } else if (outIdx == r) {
            outIdx--;
        }
        indexes.add(r / capacity);
        if (r % capacity == 0) {
            indexes.remove(r / capacity + OFFSET);
        }
        int val = arr[r];
        arr[r] = 0;
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */