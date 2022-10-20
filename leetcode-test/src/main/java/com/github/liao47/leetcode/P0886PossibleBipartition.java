package com.github.liao47.leetcode;

/**
 * 886. 可能的二分法
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 10^4
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/possible-bipartition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/10/17 15:04
 */
public class P0886PossibleBipartition {
    private int[] parent;

    public boolean possibleBipartition1(int n, int[][] dislikes) {
        parent = new int[2 * n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] dislike : dislikes) {
            if (query(dislike[0], dislike[1])) {
                return false;
            }
            union(dislike[0], dislike[1] + n);
            union(dislike[1], dislike[0] + n);
        }
        return true;
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private void union(int x, int y) {
        parent[find(x)] = parent[find(y)];
    }

    private boolean query(int x, int y) {
        return find(x) == find(y);
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        boolean[][] g = new boolean[n + 1][n + 1];
        for (int[] dislike : dislikes) {
            g[dislike[0]][dislike[1]] = true;
            g[dislike[1]][dislike[0]] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int index, int nowColor, int[] color, boolean[][] g) {
        color[index] = nowColor;
        for (int i = 1; i < g.length; i++) {
            if (g[index][i]) {
                if (color[i] != 0) {
                    if (color[i] == color[index]) {
                        return true;
                    }
                } else if (dfs(i, 3 ^ nowColor, color, g)) {
                    return true;
                }
            }
        }
        return false;
    }
}
