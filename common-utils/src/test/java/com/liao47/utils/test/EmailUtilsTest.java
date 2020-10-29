package com.liao47.utils.test;

import com.liao47.common.exception.CustomException;
import com.liao47.utils.EmailUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.mail.Message;

public class EmailUtilsTest {

    @Test
    public void test() {
        EmailUtils emailUtils = EmailUtils.getInstance("/email.properties")
                .addRecipients(Message.RecipientType.TO, "liao647@foxmail.com", "xxx@yy.com")
                .addRecipients(Message.RecipientType.CC, "liao_47@163.com");
        Assert.assertThrows(CustomException.class, () ->
                emailUtils.send("Hello", "Hello, This is a test mail"));
    }
}
