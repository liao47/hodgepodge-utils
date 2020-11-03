package com.github.liao47.utils;

import com.github.liao47.common.constants.PatternConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

/**
 * 日期转换工具
 * @author liao47
 * @date 2020/10/28 17:52
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    /**
     * Date to LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * timestamp to LocalDateTime
     * @param timestamp
     * @return
     */
    public static LocalDateTime toLocalDateTime(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Date to LocalDate
     * @param date
     * @return
     */
    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * timestamp to LocalDate
     * @param timestamp
     * @return
     */
    public static LocalDate toLocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDateTime to Date
     * @param localDateTime
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate to Date
     * @param localDate
     * @return
     */
    public static Date toDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Get timestamp
     * @param localDateTime
     * @return
     */
    public static long getTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Get timestamp
     * @param localDate
     * @return
     */
    public static long getTime(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Parse LocalDateTime
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Parse LocalDate
     * @param dateStr
     * @param pattern
     * @return
     */
    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Format LocalDateTime
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            return null;
        }
        if (StringUtils.isEmpty(pattern)) {
            return StringUtils.EMPTY;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Format LocalDate
     * @param localDate
     * @param pattern
     * @return
     */
    public static String format(LocalDate localDate, String pattern) {
        if (localDate == null) {
            return null;
        }
        if (StringUtils.isEmpty(pattern)) {
            return StringUtils.EMPTY;
        }
        return LocalDateTime.of(localDate, LocalTime.MIN).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Format Date
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        return format(toLocalDateTime(date), pattern);
    }

    /**
     * Parse Date
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parseDate(String dateStr, String pattern) {
        return toDate(parseLocalDateTime(dateStr, pattern));
    }

    /**
     * Format Date using pattern "yyyy-MM-dd HH:mm:ss"
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, PatternConstants.DATE_TIME);
    }

    /**
     * Parse Date using pattern "yyyy-MM-dd HH:mm:ss"
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, PatternConstants.DATE_TIME);
    }

    /**
     * date在interval单位时间后是否晚于当前时间
     * @param date
     * @param interval
     * @param unit
     * @return
     */
    public static boolean isLater(Date date, long interval, ChronoUnit unit) {
        Objects.requireNonNull(date, "date");
        return toLocalDateTime(date).plus(interval, unit).isAfter(LocalDateTime.now());
    }

    /**
     * date在interval单位时间后是否早于当前时间
     * @param date
     * @param interval
     * @param unit
     * @return
     */
    public static boolean isEarly(Date date, long interval, ChronoUnit unit) {
        Objects.requireNonNull(date, "date");
        return toLocalDateTime(date).plus(interval, unit).isBefore(LocalDateTime.now());
    }

    /**
     * date在interval毫秒后是否晚于当前时间
     * @param date
     * @param interval
     * @return
     */
    public static boolean isLater(Date date, long interval) {
        return isLater(date, interval, ChronoUnit.MILLIS);
    }

    /**
     * date在interval毫秒后是否早于当前时间
     * @param date
     * @param interval
     * @return
     */
    public static boolean isEarly(Date date, long interval) {
        return isEarly(date, interval, ChronoUnit.MILLIS);
    }
}
