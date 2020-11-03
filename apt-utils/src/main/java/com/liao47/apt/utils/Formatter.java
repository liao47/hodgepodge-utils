package com.liao47.apt.utils;

import com.liao47.utils.DateUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 格式化工具
 * @author liao47
 * @date 2020/11/3 11:15
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Formatter {

    /**
     * 格式化
     * @param obj
     * @param pattern
     * @return
     */
    public static Object format(Object obj, String pattern) {
        try {
            if (obj instanceof Date) {
                return DateUtils.format((Date) obj, pattern);
            } else if (obj instanceof LocalDateTime) {
                return DateUtils.format((LocalDateTime) obj, pattern);
            } else if (obj instanceof LocalDate) {
                return DateUtils.format((LocalDate) obj, pattern);
            } else if (obj instanceof Number) {
                return new DecimalFormat(pattern).format(obj);
            }
        } catch (Exception e) {
            log.warn("Format data failure:{}", e.getMessage());
        }
        return obj;
    }

    /**
     * 掩码
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
            log.warn("Mask value failure:{}", e.getMessage());
            return str;
        }
    }
}
