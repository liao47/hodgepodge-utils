package com.github.liao47.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VersionUtil {

    public static final String PATTERN = "^\\d+\\.\\d+\\.\\d+$";

    /**
     * 下一个版本，逢十进一
     * @param version
     * @return
     */
    public static String next(String version) {
        if (StringUtils.isEmpty(version)) {
            return "1.0.0";
        }
        String[] arr = version.split("\\.");
        int val = 1;
        for (int i = arr.length - 1; i >= 0 && val != 0; i--) {
            int v = Integer.parseInt(arr[i]) + val;
            val = v / 10;
            arr[i] = String.valueOf(i == 0 ? v : v % 10);
        }
        return String.join(".", arr);
    }

    /**
     * 计算属于第几个版本，从0开始
     * @param version
     * @return
     */
    public static int value(String version) {
        if (StringUtils.isEmpty(version)) {
            return 0;
        }
        if (!Pattern.matches(PATTERN, version)) {
            throw new CustomException("版本号格式不正确");
        }
        String[] arr = version.split("\\.");
        int val = 0;
        for (String s : arr) {
            val = val * 10 + Integer.parseInt(s);
        }
        return val - 100;
    }

    /**
     * 版本号格式化
     * @param version
     * @return
     */
    public static String format(Integer version) {
        if (version == null) {
            return "1.0.0";
        }
        int divisor = 100;
        version += divisor;
        StringBuilder sb = new StringBuilder();
        while (divisor > 1) {
            sb.append(version / divisor).append('.');
            version %= divisor;
            divisor /= 10;
        }
        sb.append(version);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(value("1.0.0"));
        System.out.println(value("1.1.3"));
        System.out.println(value("2.1.9"));
        System.out.println(value("10.08.9"));
        int val = value("1.1.2");
        val = 1 << val % 64;
        System.out.println(val);
    }
}
