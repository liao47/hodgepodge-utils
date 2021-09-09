package com.github.liao47.leetcode;

import java.util.*;

/**
 * 502. IPO
 *
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 
 * 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 *
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 *
 * 答案保证在 32 位有符号整数范围内。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * 输出：4
 * 解释：
 * 由于你的初始资本为 0，你仅可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * 示例 2：
 *
 * 输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * 输出：6
 *  
 *
 * 提示：
 *
 * 1 <= k <= 10^5
 * 0 <= w <= 10^9
 * n == profits.length
 * n == capital.length
 * 1 <= n <= 10^5
 * 0 <= profits[i] <= 10^4
 * 0 <= capital[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ipo
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/8 9:15
 */
public class P0502Ipo {
    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {
        sortByProfits(profits, capital, 0, profits.length - 1);
        Set<Integer> used = new HashSet<>();
        while (k > 0) {
            for (int i = 0; i < capital.length; i++) {
                if (w >= capital[i] && used.add(i)) {
                    w += profits[i];
                    break;
                }
            }
            k--;
        }
        return w;
    }

    private void sortByProfits(int[] profits, int[] capital, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int key = profits[j];
        int temp = capital[j];
        while (i < j) {
            while (i < j && (profits[i] > key || profits[i] == key && capital[i] <= temp)) {
                i++;
            }
            profits[j] = profits[i];
            capital[j] = capital[i];
            while (i < j && (profits[j] < key || profits[j] == key && capital[j] > temp)) {
                j--;
            }
            profits[i] = profits[j];
            capital[i] = capital[j];
        }
        profits[j] = key;
        capital[j] = temp;
        sortByProfits(profits, capital, left, j - 1);
        sortByProfits(profits, capital, j + 1, right);
    }

    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        long cost = -System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        cost += System.currentTimeMillis();
        System.out.println("sort cost:" + cost);

        cost = -System.currentTimeMillis();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        while (k > 0) {
            while (index < n && arr[index][1] <= w) {
                queue.offer(arr[index++][0]);
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
            k--;
        }
        cost += System.currentTimeMillis();
        System.out.println("queue cost:" + cost);
        return w;
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        boolean flag = true;
        for (int c : capital) {
            if (w < c) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if (k < n) {
                Arrays.sort(profits);
            }
            for (int i = 0; i < Math.min(k, n); i++) {
                w += profits[n - 1 - i];
            }
            return w;
        }

        sort(profits, capital, 0, n - 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        while (k > 0) {
            while (index < n && capital[index] <= w) {
                queue.offer(profits[index++]);
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
            k--;
        }
        return w;
    }

    private void sort(int[] profits, int[] capital, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int key = capital[j];
        int temp = profits[j];
        while (i < j) {
            while (i < j && capital[i] <= key) {
                i++;
            }
            capital[j] = capital[i];
            profits[j] = profits[i];
            while (i < j && capital[j] >= key) {
                j--;
            }
            capital[i] = capital[j];
            profits[i] = profits[j];
        }
        capital[j] = key;
        profits[j] = temp;
        sort(profits, capital, left, j - 1);
        sort(profits, capital, j + 1, right);
    }
}
