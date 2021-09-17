package com.github.liao47.leetcode;

/**
 * @author liaoshiqing
 * @date 2021/9/17 9:28
 */
public class P0036ValidSudoku {
    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int k = 0;
            int x = i / 3 * 3;
            int y = i * 3 % 9;
            for (int j = 0; j < board.length; j++) {
                int offset = 0;
                for (char c : new char[]{board[i][j], board[j][i], board[x + j / 3][y + j % 3]}) {
                    int val = c - '0';
                    if (val >= 0) {
                        val = 1 << val + offset;
                        if ((k & val) != 0) {
                            return false;
                        }
                        k |= val;
                    }
                    offset += 9;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int[] arr = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = 1 << board[i][j] - '1';
                for (int idx : new int[]{i, j, i / 3 * 3 + j / 3}) {
                    if ((arr[idx] & val) != 0) {
                        return false;
                    }
                    arr[idx] |= val;
                    val <<= 9;
                }
            }
        }
        return true;
    }
}
