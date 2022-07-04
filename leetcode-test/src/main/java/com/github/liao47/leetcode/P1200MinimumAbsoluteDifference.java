package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 *
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 *
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/4 9:17
 */
public class P1200MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int length = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < min) {
                list.clear();
                min = diff;
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == min) {
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return list;
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        return new java.util.AbstractList<List<Integer>>() {
            private int[] buffer;
            private int size;
            private boolean initialed;
            private int min = Integer.MAX_VALUE;

            private void init() {
                if (initialed) {
                    return;
                }
                buffer = new int[arr.length - 1];
                Arrays.sort(arr);
                for (int i = 1; i < arr.length; i++) {
                    int diff = arr[i] - arr[i - 1];
                    if (diff > min) {
                        continue;
                    } else if (diff < min) {
                        size = 0;
                        min = diff;
                    }
                    buffer[size++] = arr[i - 1];
                }
                initialed = true;
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return Arrays.asList(buffer[index], buffer[index] + min);
            }

            @Override
            public int size() {
                init();
                return size;
            }
        };
    }
}
