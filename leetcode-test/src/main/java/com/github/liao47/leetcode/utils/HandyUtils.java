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
        System.out.println(humpTitle("number-of-different-integers-in-a-string"));
        //bh3Dispatch();
    }

    private static void bh3Dispatch() {
        int total = 160;
        int n = 8;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
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
