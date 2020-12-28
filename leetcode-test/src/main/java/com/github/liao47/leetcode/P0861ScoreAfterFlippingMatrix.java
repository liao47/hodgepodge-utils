package com.github.liao47.leetcode;

/**
 * 861. 翻转矩阵后的得分
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-after-flipping-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author liao47
 * @date 2020/12/10 16:21
 */
public class P0861ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 0) {
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j] ^= 1;
                }
            }
        }
        for (int j = 1; j < a[0].length; j++) {
            int count = 0;
            for (int[] ints : a) {
                if (ints[j] == 1) {
                    count++;
                    if (count > a.length / 2) {
                        break;
                    }
                }
            }
            if (count <= a.length / 2) {
                for (int i = 0; i < a.length; i++) {
                    a[i][j] ^= 1;
                }
            }
        }
        int sum = 0;
        for (int[] ints : a) {
            int row = 0;
            for (int j = 0; j < ints.length; j++) {
                row |= ints[j] << ints.length - j - 1;
            }
            sum += row;
        }
        return sum;
    }

    public int matrixScore2(int[][] a) {
        int score = a.length * (1 << a[0].length - 1);
        for (int i = 1; i < a[0].length; i++) {
            int count = 0;
            for (int[] ints : a) {
                if ((ints[0] ^ ints[i]) == 0) {
                    count++;
                }
            }
            score += Math.max(count, a.length - count) * (1 << a[0].length - i - 1);
        }
        return score;
    }
}
