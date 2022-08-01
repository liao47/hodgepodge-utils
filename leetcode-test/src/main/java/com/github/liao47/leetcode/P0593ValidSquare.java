package com.github.liao47.leetcode;

/**
 * 593. 有效的正方形
 *
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 *
 * 点的坐标 pi 表示为 [xi, yi] 。 输入没有任何顺序 。
 *
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 *
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 *
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 *  
 *
 * 提示:
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -10^4 <= xi, yi <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2022/7/29 15:23
 */
public class P0593ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] arr = {p1, p2, p3, p4};
        //最小值放0位
        swap(arr, 0, 1);
        swap(arr, 0, 2);
        swap(arr, 0, 3);
        //最大值放3位
        swap(arr, 1, 3);
        swap(arr, 2, 3);
        //对角线中点是否相同
        if (arr[0][0] + arr[3][0] != arr[1][0] + arr[2][0]
                || arr[0][1] + arr[3][1] != arr[1][1] + arr[2][1]) {
            return false;
        }
        //对角线是否相等
        if (!equalsLength(arr[0], arr[3], arr[1], arr[2])) {
            return false;
        }
        //随便取两条边是否相等
        return equalsLength(arr[0], arr[1], arr[0], arr[2]);
    }

    private void swap(int[][] arr, int i, int j) {
        if (arr[j][0] == arr[i][0] ? arr[j][1] < arr[i][1] : arr[j][0] < arr[i][0]) {
            int[] tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private boolean equalsLength(int[] p1, int[] p2, int[] p3, int[] p4) {
        int x1 = p2[0] - p1[0];
        int y1 = p2[1] - p1[1];
        int x2 = p4[0] - p3[0];
        int y2 = p4[1] - p3[1];
        int l1 = x1 * x1 + y1 * y1;
        int l2 = x2 * x2 + y2 * y2;
        return l1 != 0 && l1 == l2;
    }
}
