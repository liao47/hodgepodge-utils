package com.github.liao47.extra.utils.test;

import com.github.liao47.extra.utils.ZipUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ZipUtilsTest {

    @Test
    public void unzip() {
        String zipFiles = "C:\\home\\test\\zipFiles\\a.zip";
        List<String> list = ZipUtils.unzip(zipFiles, null, "pwd233", null);
        assertFalse(list.isEmpty());

        list = ZipUtils.unzip(zipFiles, "C:\\home\\test\\unzipFiles\\a", "pwd233", null);
        assertFalse(list.isEmpty());

        zipFiles = "C:\\home\\test\\zipFiles\\test_zip.zip";
        list = ZipUtils.unzip(zipFiles, "C:\\home\\test\\unzipFiles", null, null);
        assertFalse(list.isEmpty());
    }

    @Test
    public void zip() {
        String src = "C:\\home\\test\\test_zip";
        String dest = "";
        String zipPath = ZipUtils.zip(src, dest, null, false);
        assertTrue(StringUtils.isNotEmpty(zipPath));

        dest = "C:\\home\\test\\zipFiles\\";
        zipPath = ZipUtils.zip(src, dest, null, false);
        assertTrue(StringUtils.isNotEmpty(zipPath));

        dest = "C:\\home\\test\\zipFiles\\a.zip";
        zipPath = ZipUtils.zip(src, dest, "pwd233", true);
        assertTrue(StringUtils.isNotEmpty(zipPath));
    }
}