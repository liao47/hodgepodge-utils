package com.liao47.utils.test;

import com.liao47.common.constants.PatternConstants;
import com.liao47.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtilsTest {

    @Test
    public void test() {
        String pattern = PatternConstants.DATE_TIME + ".SSS";

        String dateStr = DateUtils.format(new Date(), pattern);
        System.out.println(dateStr);
        System.out.println(DateUtils.format(LocalDate.now(), pattern));
        System.out.println(DateUtils.format(new Date()));

        System.out.println("--------------------------------");
        Date date = DateUtils.parseDate(dateStr, pattern);
        System.out.println(date);
        System.out.println(DateUtils.parseLocalDate(dateStr, pattern));
        System.out.println(DateUtils.parseDate(dateStr.substring(0, dateStr.length() - 4)));

        System.out.println("--------------------------------");
        System.out.println(DateUtils.toDate(LocalDate.now()));
        System.out.println(DateUtils.toLocalDateTime(System.currentTimeMillis()));
        System.out.println(DateUtils.toLocalDate(new Date()));
        System.out.println(DateUtils.toLocalDate(System.currentTimeMillis()));

        System.out.println("--------------------------------");
        System.out.println(System.currentTimeMillis() + " -- " + DateUtils.getTime(LocalDateTime.now()));
        System.out.println(DateUtils.getTime(LocalDate.now()));

        System.out.println("--------------------------------");
        System.out.println(DateUtils.isLater(date, 0L));
        System.out.println(DateUtils.isEarly(date, 0L));
        Assert.assertTrue(DateUtils.isEarly(date, 0L));
    }
}
