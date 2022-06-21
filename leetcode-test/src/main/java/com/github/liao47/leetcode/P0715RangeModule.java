package com.github.liao47.leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 715. Range 模块
 *
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 *
 * 半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。
 *
 * 实现 RangeModule 类:
 *
 * RangeModule() 初始化数据结构的对象。
 * void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right)
 *  中尚未跟踪的任何数字到该区间中。
 * boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
 * void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
 *
 *
 * 示例 1：
 *
 * 输入
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * 输出
 * [null, null, null, true, false, true]
 *
 * 解释
 * RangeModule rangeModule = new RangeModule();
 * rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
 * rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *
 *
 * 提示：
 *
 * 1 <= left < right <= 10^9
 * 在单个测试用例中，对 addRange 、  queryRange 和 removeRange 的调用总数不超过 10^4 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-module
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/20 9:22
 */
public class P0715RangeModule {
    private P0715RangeModule() {}

    public static class RangeModule1 {

        Map<Integer, Integer> diff;

        public RangeModule1() {
            diff = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            add(left, diff.getOrDefault(left, 0) + 1);
            add(right, diff.getOrDefault(right, 0) - 1);

            //清除交叉区间，可省略
            int curr = 0;
            Iterator<Map.Entry<Integer, Integer>> it = diff.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                int val = next.getValue();
                curr += val;
                if (val > 0 && curr > val || val < 0 && curr > 0) {
                    it.remove();
                } else if (curr == val && val > 1) {
                    next.setValue(1);
                } else if (curr == 0 && val < -1) {
                    next.setValue(-1);
                }
            }
        }

        public boolean queryRange(int left, int right) {
            int curr = 0;
            int prev = 0;
            for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
                if (prev <= left && left < entry.getKey() && curr <= 0) {
                    return false;
                }
                curr += entry.getValue();
                if (left <= entry.getKey() && entry.getKey() < right && curr <= 0) {
                    return false;
                }
                prev = entry.getKey();
                if (prev >= right) {
                    break;
                }
            }
            return left <= prev;
        }

        public void removeRange(int left, int right) {
            int curr = 0;
            int prev = 0;
            int vl = 0;
            Iterator<Map.Entry<Integer, Integer>> it = diff.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                int key = next.getKey();
                if (curr > 0 && prev < left && left <= key) {
                    vl = -curr;
                }
                prev = key;
                if (key <= right) {
                    curr += next.getValue();
                    if (left <= key) {
                        it.remove();
                    }
                }
                if (key >= right) {
                    break;
                }
            }
            if (vl != 0) {
                diff.put(left, vl);
            }
            if (curr > 0) {
                diff.put(right, curr);
            }
        }

        private void add(int key, int val) {
            if (val == 0) {
                diff.remove(key);
            } else {
                diff.put(key, val);
            }
        }
    }

    public static class RangeModule {

        TreeMap<Integer, Integer> ranges;

        public RangeModule() {
            ranges = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = ranges.higherEntry(left);
            Map.Entry<Integer, Integer> prev = entry == null ? ranges.lastEntry() : ranges.lowerEntry(entry.getKey());
            if (prev != null) {
                if (prev.getValue() >= right) {
                    return;
                }
                if (prev.getValue() >= left) {
                    left = prev.getKey();
                    ranges.remove(prev.getKey());
                }
            }
            while (entry != null && entry.getKey() <= right) {
                right = Math.max(right, entry.getValue());
                ranges.remove(entry.getKey());
                entry = ranges.higherEntry(entry.getKey());
            }
            ranges.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = ranges.higherEntry(left);
            Map.Entry<Integer, Integer> prev = entry == null ? ranges.lastEntry() : ranges.lowerEntry(entry.getKey());
            return prev != null && right <= prev.getValue();
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = ranges.higherEntry(left);
            Map.Entry<Integer, Integer> prev = entry == null ? ranges.lastEntry() : ranges.lowerEntry(entry.getKey());
            if (prev != null && prev.getValue() >= right) {
                if (prev.getKey() == left) {
                    ranges.remove(prev.getKey());
                } else {
                    ranges.put(prev.getKey(), left);
                }
                if (right != prev.getValue()) {
                    ranges.put(right, prev.getValue());
                }
                return;
            } else if (prev != null && prev.getValue() > left) {
                ranges.put(prev.getKey(), left);
            }
            while (entry != null && entry.getKey() < right) {
                ranges.remove(entry.getKey());
                if (entry.getValue() > right) {
                    ranges.put(right, entry.getValue());
                    break;
                }
                entry = ranges.higherEntry(entry.getKey());
            }
        }
    }
}
