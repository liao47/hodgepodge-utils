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

    public static String readString(String dir) {
        List<String> list = read(dir);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void write(String str, String filename) {
        try {
            File file = new File(filename);
            if (!file.exists() && !file.createNewFile()) {
                System.out.println("create new file fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
