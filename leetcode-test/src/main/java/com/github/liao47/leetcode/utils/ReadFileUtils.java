package com.github.liao47.leetcode.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoshiqing
 * @date 2021/9/8 15:05
 */
public class ReadFileUtils {
    private ReadFileUtils() {}

    public static List<String> read(String dir) {
        List<String> dataList = new ArrayList<>();
        try (InputStream is = ReadFileUtils.class.getClassLoader().getResourceAsStream(dir);
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            String lineData;
            while ((lineData = br.readLine()) != null) {
                dataList.add(lineData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
