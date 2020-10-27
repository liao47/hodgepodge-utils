package com.liao47.utils;

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
     * @param str
     * @param prefix
     * @param suffix
     * @param maskStr
     * @return
     */
    public static String mask(String str, int prefix, int suffix, String maskStr) {
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

    /**
     * Mask String by maskChar
     * @param str
     * @param prefix
     * @param suffix
     * @param maskChar
     * @return
     */
    public static String mask(String str, int prefix, int suffix, char maskChar) {
        return mask(str, prefix, suffix, String.valueOf(maskChar));
    }

    /**
     * Mask String by '*'
     * @param str
     * @param prefix
     * @param suffix
     * @return
     */
    public static String mask(String str, int prefix, int suffix) {
        return mask(str, prefix, suffix, '*');
    }

    /**
     * Mask Object by maskStr
     * @param obj
     * @param prefix
     * @param suffix
     * @param maskStr
     * @return
     */
    public static String mask(Object obj, int prefix, int suffix, String maskStr) {
        return obj == null ? null : mask(obj.toString(), prefix, suffix, maskStr);
    }

    /**
     * Mask Object by maskChar
     * @param obj
     * @param prefix
     * @param suffix
     * @param maskChar
     * @return
     */
    public static String mask(Object obj, int prefix, int suffix, char maskChar) {
        return mask(obj, prefix, suffix, String.valueOf(maskChar));
    }

    /**
     * Mask Object by '*'
     * @param obj
     * @param prefix
     * @param suffix
     * @return
     */
    public static String mask(Object obj, int prefix, int suffix) {
        return mask(obj, prefix, suffix, '*');
    }
}
