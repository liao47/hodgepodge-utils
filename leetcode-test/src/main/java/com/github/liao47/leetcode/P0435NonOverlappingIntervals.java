package com.github.liao47.leetcode;

import java.util.*;

/**
 * 435. 无重叠区间
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2021/1/8 15:51
 */
public class P0435NonOverlappingIntervals {
    public int eraseOverlapIntervals1(int[][] intervals) {
        int count = 0;
        //使用有序集合排序
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            Integer end = map.get(interval[0]);
            if (end == null) {
                map.put(interval[0], interval[1]);
            } else {
                //起点相同的，移除终点较大的
                count++;
                if (interval[1] < end) {
                    map.put(interval[0], interval[1]);
                }
            }
        }

        Integer end = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (end != null && entry.getKey() < end) {
                //发现相交，移除终点较大的
                count++;
                if (entry.getValue() < end) {
                    end = entry.getValue();
                }
            } else  {
                //不相交，更新终点
                end = entry.getValue();
            }
        }
        return count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[index][1]) {
                count++;
                if (intervals[i][1] < intervals[index][1]) {
                    index = i;
                }
            } else {
                index = i;
            }
        }
        return count;
    }
}
