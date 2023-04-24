package com.github.liao47.leetcode;

import java.io.*;
import java.util.Arrays;

/**
 * @author liaoshiqing
 * @date 2023/4/17 10:07
 */
public class JavaTest {
    public static void main(String[] args) {
        testIn();
    }

    public static void testIn() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out))) {
            StreamTokenizer in = new StreamTokenizer(br);
            while (in.nextToken() != StreamTokenizer.TT_EOF) {
                int n = (int) in.nval;
                if (n <= 0) {
                    break;
                }
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    in.nextToken();
                    arr[i] = (int) in.nval;
                }
                out.println(Arrays.toString(arr));
                out.flush();
            }
            out.println("EOF");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
