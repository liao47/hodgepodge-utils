package com.liao47.utils.test;

import com.liao47.utils.FtpUtils;
import com.liao47.utils.config.FtpConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FtpUtilsTest {

    private FtpConfig ftpConfig;

    @Before
    public void init() {
        ftpConfig = FtpConfig.create()
                .hostname("118.24.61.49").port(21)
                .username("liao47").password("liao47")
                .connectTimeout(10000)
                .encoding("UTF-8")
                .ftpDir("verification/success")
                .localDir("/home/download");
    }

    @Test
    public void downloadTest() {
        String fileName = "20200926success.txt";

        boolean result = FtpUtils.download(ftpConfig.ftpDir("verification/success"), fileName);
        Assert.assertTrue(result);

        result = FtpUtils.download(FtpConfig.of("/ftp.properties"), fileName);
        Assert.assertTrue(result);
    }

    @Test
    public void uploadTest() {
        String[] fileNames = {"testUpload.txt", "20200926success.txt"};

        List<String> successFiles = FtpUtils.batchUpload(ftpConfig.ftpDir("verification/upload"), fileNames);
        Assert.assertEquals(fileNames.length, successFiles.size());

        successFiles = FtpUtils.batchUpload(FtpConfig.of("/ftp.properties").ftpDir("verification/upload"), fileNames);
        Assert.assertEquals(fileNames.length, successFiles.size());
    }
}
