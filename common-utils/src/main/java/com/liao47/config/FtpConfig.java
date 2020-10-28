package com.liao47.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * FTP配置
 * @author liao47
 * @date 2020/10/27 16:27
 */
@Slf4j
@Data
public class FtpConfig {

    /**
     * 主机名
     */
    private String hostname;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 连接超时时间 milliseconds
     */
    private Integer connectTimeout;

    /**
     * 编码
     */
    private String encoding;

    /**
     * FTP路径
     */
    private String ftpDir;

    /**
     * 本地路径
     */
    private String localDir;

    public static FtpConfig create() {
        return new FtpConfig();
    }

    public FtpConfig hostname(String hostname) {
        this.setHostname(hostname);
        return this;
    }

    public FtpConfig port(int port) {
        this.setPort(port);
        return this;
    }

    public FtpConfig username(String username) {
        this.setUsername(username);
        return this;
    }

    public FtpConfig password(String password) {
        this.setPassword(password);
        return this;
    }

    public FtpConfig connectTimeout(int connectTimeout) {
        this.setConnectTimeout(connectTimeout);
        return this;
    }

    public FtpConfig encoding(String encoding) {
        this.setEncoding(encoding);
        return this;
    }

    public FtpConfig ftpDir(String ftpDir) {
        this.setFtpDir(ftpDir);
        return this;
    }

    public FtpConfig localDir(String localDir) {
        this.setLocalDir(localDir);
        return this;
    }
}
