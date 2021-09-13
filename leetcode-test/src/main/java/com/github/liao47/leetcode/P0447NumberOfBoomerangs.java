package com.github.liao47.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 *
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 *  
 * 示例 1：
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/13 9:27
 */
public class P0447NumberOfBoomerangs {
    public int numberOfBoomerangs1(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = j + 1; k < points.length && i != j; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (distance(points[i], points[j]) == distance(points[i], points[k])) {
                        count += 2;
                    }
                }
            }
        }
        return count;
    }

    public int numberOfBoomerangs2(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int a = distance(points[i], points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    int b = distance(points[i], points[k]);
                    int c = distance(points[j], points[k]);
                    if (a == c) {
                        count += 2;
                    }
                    if (a == b) {
                        count += 2;
                    }
                    if (b == c) {
                        count += 2;
                    }
                }
            }
        }
        return count;
    }

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>(points.length);
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int distance = distance(points[i], points[j]);
                    int count = map.getOrDefault(distance, 0);
                    result += count * 2;
                    map.put(distance, ++count);
                }
            }
        }
        return result;
    }

    private int distance(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}
