package com.liao47.apt.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 掩码工具
 * @author liao47
 * @date 2020/10/27 11:46
 */
public class MaskUtils {
    private MaskUtils() {}

    /**
     * Mask String by maskStr
     * @param obj
     * @param prefix
     * @param suffix
     * @param maskStr
     * @return
     */
    public static String mask(Object obj, int prefix, int suffix, String maskStr) {
        if (obj == null) {
            return null;
        }
        String str = obj.toString();
        try {
            if (StringUtils.isEmpty(str) || prefix + suffix >= str.length()) {
                return str;
            }
            if (prefix < 0) {
                prefix = 0;
            }
            if (suffix < 0) {
                suffix = 0;
            }
            return StringUtils.left(str, prefix)
                    + StringUtils.repeat(maskStr, str.length() - suffix - prefix)
                    + StringUtils.right(str, suffix);
        } catch (Exception e) {
            return str;
        }
    }
}
