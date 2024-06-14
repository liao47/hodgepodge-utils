package com.github.liao47.extra.utils.test;

import com.github.liao47.common.exception.CustomException;
import com.github.liao47.extra.utils.EmailUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.mail.Message;

public class EmailUtilsTest {

    @Test
    public void test() {
        EmailUtils emailUtils = EmailUtils.getInstance("/email.properties")
                .to("liao647@foxmail.com", "xxx@yy.com")
                .cc("liao_47@163.com");
        Assert.assertThrows(CustomException.class, () ->
                emailUtils.send("Hello", "Hello, This is a test mail"));
    }
}
