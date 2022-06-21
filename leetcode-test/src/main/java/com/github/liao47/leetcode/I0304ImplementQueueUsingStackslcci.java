package com.github.liao47.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 03.04. 化栈为队
 *
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2020/12/23 10:45
 */
public class I0304ImplementQueueUsingStackslcci {
    private I0304ImplementQueueUsingStackslcci() {}

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
