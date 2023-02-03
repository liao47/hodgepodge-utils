package com.github.liao47.leetcode;

import java.util.*;

/**
 * 1129. 颜色交替的最短路径
 *
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
 *
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
 *
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 示例 2：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 示例 3：
 *
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 示例 4：
 *
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 示例 5：
 *
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 *
 *
 * 提示：
 *
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * @author liaoshiqing
 * @date 2023/2/3 9:10
 */
public class P1129ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] edges = new List[2][n];
        for (int[] redEdge : redEdges) {
            if (edges[0][redEdge[0]] == null) {
                edges[0][redEdge[0]] = new ArrayList<>();
            }
            edges[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            if (edges[1][blueEdge[0]] == null) {
                edges[1][blueEdge[0]] = new ArrayList<>();
            }
            edges[1][blueEdge[0]].add(blueEdge[1]);
        }

        int[][] dict = new int[2][n];
        Arrays.fill(dict[0], Integer.MAX_VALUE);
        Arrays.fill(dict[1], Integer.MAX_VALUE);
        dict[0][0] = 0;
        dict[1][0] = 0;

        //DFS
        dfs(dict, edges, 0, 0);
        dfs(dict, edges, 1, 0);

        //BFS
        /*Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        queue.offer(1);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int x = i >> 1;
            int t = i & 1;
            List<Integer> list = edges[t][x];
            if (list == null || list.isEmpty()) {
                continue;
            }
            for (Integer y : list) {
                if (dict[t ^ 1][y] == Integer.MAX_VALUE) {
                    dict[t ^ 1][y] = dict[t][x] + 1;
                    queue.offer((y << 1) | t ^ 1);
                }
            }
        }*/

        for (int i = 0; i < n; i++) {
            dict[0][i] = Math.min(dict[0][i], dict[1][i]);
            if (dict[0][i] == Integer.MAX_VALUE) {
                dict[0][i] = -1;
            }
        }
        return dict[0];
    }

    private void dfs(int[][] dict, List<Integer>[][] edges, int t, int x) {
        if (edges[t][x] == null || edges[t][x].isEmpty()) {
            return;
        }
        for (Integer y : edges[t][x]) {
            if (dict[t ^ 1][y] > dict[t][x] + 1) {
                dict[t ^ 1][y] = dict[t][x] + 1;
                dfs(dict, edges, t ^ 1, y);
            }
        }
    }
}
