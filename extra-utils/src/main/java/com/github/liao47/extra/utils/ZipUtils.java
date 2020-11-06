package com.github.liao47.extra.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
            if (StringUtils.isEmpty(outputDirPath)) {
                outputDirPath = new File(zipFilePath).getParent();
            } else {
                File outputDir = new File(outputDirPath);
                if (!outputDir.exists() && !outputDir.mkdirs()) {
                    log.warn("Make unzip output directories fail[{}]", outputDirPath);
                }
            }

            ZipFile zipFile = new ZipFile(zipFilePath);
            if (charset != null) {
                zipFile.setCharset(charset);
            }

            if (!zipFile.isValidZipFile()) {
                throw new CustomException("The zip file is invalid");
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
            throw new CustomException("Unzip file failure:" + e.getMessage());
        }
    }

    /**
     * 压缩文件或文件夹
     * @param src 要压缩的文件或文件夹路径
     * @param dest 压缩文件存放路径
     * @param password 压缩使用的密码
     * @return
     */
    public static String zip(String src, String dest, String password) {
        File srcFile = new File(src);
        String destPath = buildDestZipFilePath(srcFile, dest);
        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(CompressionMethod.DEFLATE);
        parameters.setCompressionLevel(CompressionLevel.NORMAL);
        if (!StringUtils.isEmpty(password)) {
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
        }
        try {
            ZipFile zipFile = new ZipFile(destPath);
            if (parameters.isEncryptFiles()) {
                zipFile.setPassword(password.toCharArray());
            }
            if (srcFile.isDirectory()) {
                zipFile.addFolder(srcFile, parameters);
            } else {
                zipFile.addFile(srcFile, parameters);
            }
            return destPath;
        } catch (ZipException e) {
            log.error("Zip file error, cause:", e);
            throw new CustomException("Zip file failure:" + e.getMessage());
        }
    }

    /**
     * 创建压缩文件路径
     * @param srcFile
     * @param dest
     * @return
     */
    private static String buildDestZipFilePath(File srcFile, String dest) {
        if (StringUtils.isEmpty(dest)) {
            if (srcFile.isDirectory()) {
                return srcFile.getParent() + File.separator + srcFile.getName() + ".zip";
            }
            return srcFile.getParent() + File.separator + StringUtils.substringBefore(srcFile.getName(), ".") + ".zip";
        }

        String destPath = dest;
        File destDir = new File(dest);
        if (destDir.isDirectory() || !destDir.getName().contains(".")) {
            if (srcFile.isDirectory()) {
                destPath += File.separator + srcFile.getName();
            } else {
                destPath += File.separator + StringUtils.substringBefore(srcFile.getName(), ".");
            }
            destPath += ".zip";
        } else {
            destDir = destDir.getParentFile();
        }
        if (!destDir.exists() && !destDir.mkdirs()) {
            throw new CustomException("Make dest dirs failure");
        }
        return destPath;
    }
}
