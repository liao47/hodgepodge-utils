package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2021/9/18 16:53
 */
public class OII1072bCMpM {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        int max = ans.length * ans[0].length + 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    refresh(ans, i, j, 1);
                } else {
                    int min = max;
                    if (i > 0) {
                        min = ans[i - 1][j];
                    }
                    if (j > 0 && ans[i][j - 1] < min) {
                        min = ans[i][j - 1];
                    }
                    ans[i][j] = min + 1;
                }
            }
        }
        return ans;
    }

    private void refresh(int[][] arr, int i, int j, int d) {
        if (i > 0 && arr[i - 1][j] > d) {
            arr[i - 1][j] = d;
            refresh(arr, i - 1, j, d + 1);
        }
        if (j > 0 && arr[i][j - 1] > d) {
            arr[i][j - 1] = d;
            refresh(arr, i, j - 1, d + 1);
        }
        if (j < arr[i].length - 1 && arr[i][j + 1] > d) {
            arr[i][j + 1] = d;
            refresh(arr, i, j + 1, d + 1);
        }
    }
}
