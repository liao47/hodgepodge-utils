package com.liao47.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 解压缩工具
 * @author liao47
 * @date 2020/10/29 19:20
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ZipUtils {

    /**
     * 解压
     * @param zipFilePath
     * @param outputDirPath
     * @param password
     * @param charset
     * @return
     */
    public static List<String> unzip(String zipFilePath, String outputDirPath, String password, Charset charset) {
        try {
            File outputDir = new File(outputDirPath);
            if (!outputDir.exists() && !outputDir.mkdirs()) {
                log.warn("Make unzip output directories fail[{}]", outputDirPath);
            }

            ZipFile zipFile = new ZipFile(zipFilePath);
            if (charset != null) {
                zipFile.setCharset(charset);
            }

            if (zipFile.isEncrypted() && StringUtils.isNotEmpty(password)) {
                zipFile.setPassword(password.toCharArray());
            }
            zipFile.extractAll(outputDirPath);

            List<String> filePaths = new ArrayList<>();
            List<FileHeader> headers = zipFile.getFileHeaders();
            for (FileHeader header : headers) {
                filePaths.add(outputDirPath + File.separatorChar + header.getFileName());
            }
            return filePaths;
        } catch (Exception e) {
            log.error("Unzip file[{}] error, cause:", zipFilePath, e);
            return Collections.emptyList();
        }
    }
}
