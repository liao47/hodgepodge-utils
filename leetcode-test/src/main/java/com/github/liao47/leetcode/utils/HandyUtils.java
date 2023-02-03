package com.github.liao47.leetcode.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author liaoshiqing
 * @date 2022/7/8 14:14
 */
public class HandyUtils {
    /**
     * 将标题转换为驼峰格式
     * @param str
     * @return
     */
    public static String humpTitle(String str) {
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split("-");
        for (String s : arr) {
            sb.append(StringUtils.capitalize(s));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(humpTitle("binary-tree-coloring-game"));
        bh3Dispatch();
    }

    private static void bh3Dispatch() {
        int total = 170;
        int n = 8;
        for (int i = 0; i < 1; i++) {
            for (int j = 2; j < n; j++) {
                for (int k = 1; k < 2; k++) {
                    for (int l = 1; l < n; l++) {
                        for (int m = 1; m < n; m++) {
                            if (i * 20 + j * 18 + k * 16 + l * 14 + m * 12 == total) {
                                System.out.printf("20: %d, 18: %d, 16: %d, 14: %d, 12 %d%n", i, j, k, l, m);
                            }
                        }
                    }
                }
            }
        }
    }
}
