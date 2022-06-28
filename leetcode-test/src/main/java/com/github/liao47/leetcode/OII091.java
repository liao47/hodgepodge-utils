package com.github.liao47.leetcode;

/**
 * 剑指 Offer II 091. 粉刷房子
 *
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 *
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 *  
 *
 * 提示:
 *
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 *  
 *
 * 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/JEj789
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/6/28 16:48
 */
public class OII091 {
    public int minCost1(int[][] costs) {
        int[] dp = new int[costs[0].length];
        for (int[] cost : costs) {
            int[] dpTmp = new int[dp.length];
            for (int i = 0; i < dp.length; i++) {
                dpTmp[i] = Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + cost[i];
            }
            dp = dpTmp;
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }

    public int minCost(int[][] costs) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int[] cost : costs) {
            int r1 = Math.min(g, b) + cost[0];
            int g1 = Math.min(r, b) + cost[1];
            int b1 = Math.min(r, g) + cost[2];
            r = r1;
            g = g1;
            b = b1;
        }
        return Math.min(r, Math.min(g, b));
    }
}
