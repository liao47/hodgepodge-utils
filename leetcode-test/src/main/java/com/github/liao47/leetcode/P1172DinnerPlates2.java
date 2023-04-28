package com.github.liao47.leetcode;

import java.util.*;

/**
 * 1172. 餐盘栈
 * @author liaoshiqing
 * @date 2023/4/28 17:39
 */
public class P1172DinnerPlates2 {
    private final List<Deque<Integer>> list;
    private final TreeSet<Integer> inIdx;
    private final TreeSet<Integer> outIdx;
    private final int capacity;

    public P1172DinnerPlates2(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
        inIdx = new TreeSet<>();
        outIdx = new TreeSet<>();
    }
    
    public void push(int val) {
        if (inIdx.isEmpty()) {
            list.add(new ArrayDeque<>());
            inIdx.add(list.size() - 1);
        }
        int idx = inIdx.first();
        list.get(idx).push(val);
        if (list.get(idx).size() == capacity) {
            inIdx.remove(idx);
        }
        outIdx.add(idx);
    }
    
    public int pop() {
        if (outIdx.isEmpty()) {
            return -1;
        }
        int last = outIdx.last();
        if (list.get(last).size() == 1) {
            outIdx.remove(last);
        }
        inIdx.add(last);
        return list.get(last).pop();
    }
    
    public int popAtStack(int index) {
        if (index >= list.size()) {
            return -1;
        }
        inIdx.add(index);
        Integer pop = list.get(index).pollFirst();
        if (list.get(index).isEmpty()) {
            outIdx.remove(index);
        }
        return pop == null ? -1 : pop;
    }
}