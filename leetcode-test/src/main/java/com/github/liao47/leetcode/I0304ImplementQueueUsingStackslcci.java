package com.github.liao47.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaoshiqing
 * @date 2020/12/23 10:45
 */
public class I0304ImplementQueueUsingStackslcci {
    public static class MyQueue {
        private Deque<Integer> in;
        private Deque<Integer> out;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.in = new LinkedList<>();
            this.out = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            this.in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            this.move();
            return this.out.pop();
        }

        /** Get the front element. */
        public int peek() {
            this.move();
            return this.out.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.in.isEmpty() && this.out.isEmpty();
        }

        private void move() {
            if (this.out.isEmpty()) {
                while (!this.in.isEmpty()) {
                    this.out.push(this.in.pop());
                }
            }
        }
    }
}
