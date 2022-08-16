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
        System.out.println(humpTitle("max-chunks-to-make-sorted-ii"));
    }
}
