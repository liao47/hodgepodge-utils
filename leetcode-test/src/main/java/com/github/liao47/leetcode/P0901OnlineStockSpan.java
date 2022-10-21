package com.github.liao47.leetcode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 *  
 *
 * 示例：
 *
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *  
 *
 * 提示：
 *
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/10/21 9:24
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class P0901OnlineStockSpan {
    public static class StockSpanner1 {
        private final List<Integer> list;
        private final List<Integer> spans;

        public StockSpanner1() {
            list = new ArrayList<>();
            spans = new ArrayList<>();
        }

        public int next(int price) {
            int i = list.size() - 1;
            int count = 1;
            while (i >= 0 && list.get(i) <= price) {
                count += spans.get(i);
                i -= spans.get(i);
            }
            list.add(price);
            spans.add(count);
            return count;
        }
    }

    public static class StockSpanner2 {
        private final List<Integer> list;

        public StockSpanner2() {
            list = new ArrayList<>();
        }

        public int next(int price) {
            int i = 1;
            while (i <= list.size()) {
                int val = list.get(list.size() - i);
                if ((val & 0xffff) > price) {
                    break;
                }
                i += val >> 16;
            }
            list.add(price | i << 16);
            return i;
        }
    }

    public static class StockSpanner {
        private final int[] nums;
        private final int[] spans;
        private int size;

        public StockSpanner() {
            nums = new int[10000];
            spans = new int[10000];
            size = 0;
        }

        public int next(int price) {
            int i = size - 1;
            while (i >=0 && nums[i] <= price) {
                i -= spans[i];
            }
            spans[size] = size - i;
            nums[size] = price;
            return spans[size++];
        }
    }
}
