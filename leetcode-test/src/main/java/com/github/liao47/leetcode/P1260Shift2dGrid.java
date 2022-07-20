package com.github.liao47.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1260. 二维网格迁移
 *
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *  
 *
 * 示例 1：
 * 1 2 3    9 1 2
 * 4 5 6 →  3 4 5
 * 7 8 9    6 7 8
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *  3  8  1  9      13  3  8  1      21 13  3  8       0 21 13  3      12  0 21 13
 * 19  7  2  5   →   9 19  7  2   →   1  9 19  7   →   8  1  9 19   →   3  8  1  9
 *  4  6 11 10       5  4  6 11       2  5  4  6       7  2  5  4      19  7  2  5
 * 12  0 21 13      10 12  0 21      11 10 12  0       6 11 10 12       4  6 11 10
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shift-2d-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/20 9:18
 */
public class P1260Shift2dGrid {
    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int p = m * n;
        k %= p;
        k = p - k;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int cur = i * n + j + k;
                list.add(grid[cur / n % m][cur % n]);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        int i = k / n;
        int j = k % n;
        Integer[][] arr = new Integer[m][n];
        for (int[] row : grid) {
            for (int num : row) {
                arr[i][j] = num;
                if (++j == n) {
                    j = 0;
                    if (++i == m) {
                        i = 0;
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer[] row : arr) {
            res.add(Arrays.asList(row));
        }
        //List res = Arrays.asList(arr)
        return res;
    }
}
