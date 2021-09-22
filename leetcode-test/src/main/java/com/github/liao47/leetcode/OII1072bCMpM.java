package com.github.liao47.leetcode;

/**
 * 剑指 Offer II 107. 矩阵中的距离
 * 
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0 
 *  
 *
 * 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2bCMpM
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liaoshiqing
 * @date 2021/9/18 16:53
 */
public class OII1072bCMpM {
    public int[][] updateMatrix1(int[][] mat) {
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

    /**
     * wrong answer
     * @param mat
     * @return
     */
    public int[][] updateMatrix2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int max = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    int min = max;
                    if (j > 0) {
                        min = mat[i][j - 1];
                    }
                    if (i > 0) {
                        min = Math.min(min, mat[i - 1][j]);
                    }

                    if (i * n + j < (max + 1) / 2) {
                        mat[i][j] = min + 1;
                    } else {
                        mat[i][j] = Math.min(mat[i][j], min + 1);
                    }
                }

                if (mat[n - i - 1][m - j - 1] != 0) {
                    int min = max;
                    if (j > 0) {
                        min = mat[n - i - 1][m - j];
                    }
                    if (i > 0) {
                        min = Math.min(min, mat[n - i][m - j - 1]);
                    }

                    if (i * n + j >= max / 2) {
                        mat[n - i - 1][m - j - 1] = Math.min(mat[n - i - 1][m - j - 1], min + 1);
                    } else {
                        mat[n - i - 1][m - j - 1] = min + 1;
                    }
                }
            }
        }
        return mat;
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int max = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    int min = max;
                    if (j > 0) {
                        min = mat[i][j - 1];
                    }
                    if (i > 0 && mat[i - 1][j] < min) {
                        min = mat[i - 1][j];
                    }
                    mat[i][j] = min + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int min = max;
                    if (j < m - 1) {
                        min = mat[i][j + 1];
                    }
                    if (i < n - 1 && mat[i + 1][j] < min) {
                        min = mat[i + 1][j];
                    }
                    mat[i][j] = Math.min(mat[i][j], min + 1);
                }
            }
        }
        return mat;
    }
}
