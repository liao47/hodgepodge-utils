package com.liao47.utils;

import com.liao47.config.FtpConfig;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * FTP util
 * @author liaoshiqing
 * @date 2020/10/27 16:15
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FtpUtils {
    /**
     * FTP文件路径分隔符
     */
    public static final String SEPARATOR = "/";

    /**
     * 根路径正则
     */
    private static final String ROOT_REGEX = "^[\\\\/].*";

    /**
     * 连接ftp
     * @return
     */
    public static FTPClient connect(FtpConfig ftpConfig) {
        log.info("Connecting ftp {}:{}", ftpConfig.getHostname(), ftpConfig.getPort());
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(ftpConfig.getConnectTimeout());
        ftpClient.setControlEncoding(StringUtils.defaultIfEmpty(ftpConfig.getEncoding(),
                StandardCharsets.UTF_8.toString()));
        try {
            ftpClient.connect(ftpConfig.getHostname(), ftpConfig.getPort());
            ftpClient.login(ftpConfig.getUsername(), ftpConfig.getPassword());
            //设置被动模式，文件传输端口设置
            ftpClient.enterLocalPassiveMode();
            //设置文件传输模式为二进制，可以保证传输的内容不会被改变
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)){
                log.error("Connect ftp {}:{} failed", ftpConfig.getHostname(), ftpConfig.getPort());
                ftpClient.disconnect();
                return null;
            }
            log.info("Connect ftp replyCode:{}", replyCode);
            return ftpClient;
        } catch (IOException e) {
            log.error("Connect ftp error, cause:", e);
            return null;
        }
    }

    /**
     * 断开连接
     * @param ftpClient
     */
    public static void disconnect(FTPClient ftpClient) {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                log.error("Disconnect ftp error, cause:", e);
            }
        }
    }

    /**
     * 下载文件
     * @param ftpConfig
     * @param fileName
     * @return
     */
    public static boolean download(FtpConfig ftpConfig, String fileName) {
        return download(ftpConfig, fileName, fileName);
    }

    /**
     * 下载文件
     * @param ftpConfig
     * @param remoteFileName
     * @param localFileName
     * @return
     */
    public static boolean download(FtpConfig ftpConfig, String remoteFileName, String localFileName) {
        FTPClient ftpClient = connect(ftpConfig);
        if (ftpClient == null) {
            return false;
        }

        try {
            if (!ftpClient.changeWorkingDirectory(ftpConfig.getFtpDir())) {
                log.warn("Ftp directory does not exists[{}]", ftpConfig.getFtpDir());
                return false;
            }
            log.info("Ftp directory[{}]", ftpClient.printWorkingDirectory());

            String[] names = ftpClient.listNames();
            log.info("List file names:{}", Arrays.toString(names));
            if (names == null || !Arrays.asList(names).contains(remoteFileName)) {
                log.error("File does not exists[{}{}{}]", ftpConfig.getFtpDir(), SEPARATOR, remoteFileName);
                return false;
            }
            //创建本地路径
            File localDirectory = new File(ftpConfig.getLocalDir());
            if (!localDirectory.exists() && !localDirectory.mkdirs()) {
                log.info("Make directories fail[{}]", ftpConfig.getLocalDir());
                return false;
            }
        } catch (IOException e) {
            log.error("Check file exists error, cause:", e);
            return false;
        }

        try (OutputStream outputStream =
                     new FileOutputStream(ftpConfig.getLocalDir() + File.separator + localFileName)) {
            boolean success = ftpClient.retrieveFile(remoteFileName, outputStream);
            log.info("Download file[{}] result:[successfully:{}]", remoteFileName, success);

            ftpClient.logout();
            return success;
        } catch (IOException e) {
            log.error("Download file[{}] error, cause:", remoteFileName, e);
        } finally {
            disconnect(ftpClient);
        }
        return false;
    }

    /**
     * 上传文件
     * @param ftpClient
     * @param remoteDir
     * @param localDir
     * @param fileName
     * @return
     */
    public static boolean upload(FTPClient ftpClient, String remoteDir, String localDir, String fileName) {
        if (ftpClient == null) {
            return false;
        }

        try (InputStream is = new FileInputStream(localDir + File.separator + fileName)) {
            Boolean success = ftpClient.storeFile(fileName, is);
            log.info("Upload file[{}{}{}] result:[success:{}]", remoteDir, SEPARATOR, fileName, success);
            return true;
        } catch (IOException e) {
            log.error("Upload file[{}{}{}] error, cause:", remoteDir, SEPARATOR, fileName, e);
        }
        return false;
    }

    /**
     * 上传多个文件
     *
     * @param ftpConfig
     * @param fileNames
     * @return 成功的记录
     */
    public static List<String> batchUpload(FtpConfig ftpConfig, List<String> fileNames) {
        FTPClient ftpClient = connect(ftpConfig);
        if (ftpClient == null) {
            return Collections.emptyList();
        }

        List<String> successfulList = new ArrayList<>();
        try {
            if (!ftpClient.changeWorkingDirectory(ftpConfig.getFtpDir()) && !mkdirs(ftpClient, ftpConfig.getFtpDir())) {
                log.info("Change working directory or make directories permission denied.[{}]", ftpConfig.getFtpDir());
                return Collections.emptyList();
            }

            for (String fileName : fileNames) {
                if (upload(ftpClient, ftpConfig.getFtpDir(), ftpConfig.getLocalDir(), fileName)) {
                    successfulList.add(fileName);
                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            log.error("Upload files error, cause:", e);
        } finally {
            disconnect(ftpClient);
        }
        return successfulList;
    }

    /**
     * 创建文件夹
     * @param ftpClient
     * @param path
     * @throws IOException
     */
    private static boolean mkdirs(FTPClient ftpClient, String path) throws IOException {
        if (path.matches(ROOT_REGEX)) {
            ftpClient.changeWorkingDirectory(SEPARATOR);
        }
        String[] dirArr = path.split("[\\\\/]");
        for (String dir : dirArr) {
            if (StringUtils.isNotBlank(dir) && !ftpClient.changeWorkingDirectory(dir)) {
                ftpClient.makeDirectory(dir);
                if (!ftpClient.changeWorkingDirectory(dir)) {
                    log.warn("Make directory[{} -> {}] fail", ftpClient.printWorkingDirectory(), dir);
                    return false;
                }
            }
        }
        return true;
    }
}