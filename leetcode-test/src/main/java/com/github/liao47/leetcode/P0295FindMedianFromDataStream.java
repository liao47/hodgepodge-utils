package com.github.liao47.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/8/27 10:27
 */
public class P0295FindMedianFromDataStream {
    private P0295FindMedianFromDataStream() {}

    public static class MedianFinder {

        private final PriorityQueue<Integer> lessQueue;

        private final PriorityQueue<Integer> greatQueue;

        /** initialize your data structure here. */
        public MedianFinder() {
            lessQueue = new PriorityQueue<>(Comparator.reverseOrder());
            greatQueue = new PriorityQueue<>(Comparator.naturalOrder());
        }

        public void addNum(int num) {
            Integer min = lessQueue.peek();
            if (min == null || num <= min) {
                lessQueue.offer(num);
                if (lessQueue.size() > greatQueue.size() + 1) {
                    greatQueue.offer(lessQueue.poll());
                }
            } else {
                greatQueue.offer(num);
                if (greatQueue.size() > lessQueue.size()) {
                    lessQueue.offer(greatQueue.poll());
                }
            }
        }

        public double findMedian() {
            if (lessQueue.size() > greatQueue.size()) {
                return lessQueue.peek();
            }
            return (lessQueue.peek() + greatQueue.peek()) / 2.0;
        }
    }
}
