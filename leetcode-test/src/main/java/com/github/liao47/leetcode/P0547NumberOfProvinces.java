package com.github.liao47.leetcode;

import java.util.*;

/**
 * 547. 省份数量
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2021/1/7 10:10
 */
public class P0547NumberOfProvinces {
    public int findCircleNum1(int[][] M) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                count++;
            }
            set.add(i);
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    deque.offer(j);
                    set.add(j);
                }
            }
            while (!deque.isEmpty()) {
                int k = deque.poll();
                for (int j = 0; j < M.length; j++) {
                    if (!set.contains(j) && M[k][j] == 1) {
                        deque.offer(j);
                        set.add(j);
                    }
                }
            }
        }
        return count;
    }

    public int findCircleNum2(int[][] M) {
        boolean[] arr = new boolean[M.length];
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (arr[i]) {
                continue;
            } else {
                count++;
            }
            arr[i] = true;
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {
                    deque.offer(j);
                    arr[j] = true;
                }
            }
            while (!deque.isEmpty()) {
                int k = deque.poll();
                for (int j = 0; j < M.length; j++) {
                    if (!arr[j] && M[k][j] == 1) {
                        deque.offer(j);
                        arr[j] = true;
                    }
                }
            }
        }
        return count;
    }

    public int findCircleNum3(int[][] M) {
        boolean[] arr = new boolean[M.length];
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!arr[i]) {
                arr[i] = true;
                deque.add(i);
                count++;

                while (!deque.isEmpty()) {
                    int k = deque.poll();
                    for (int j = 0; j < M.length; j++) {
                        if (!arr[j] && M[k][j] == 1) {
                            arr[j] = true;
                            deque.offer(j);
                        }
                    }
                }
            }
        }
        return count;
    }

    public int findCircleNum(int[][] M) {
        boolean[] arr = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!arr[i]) {
                arr[i] = true;
                dfs(M, arr, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] arr, int i) {
        for (int j = 0; j < M.length; j++) {
            if (!arr[j] && M[i][j] == 1) {
                arr[j] = true;
                dfs(M, arr, j);
            }
        }
    }
}
