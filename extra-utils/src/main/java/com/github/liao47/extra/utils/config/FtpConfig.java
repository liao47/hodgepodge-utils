package com.github.liao47.extra.utils.config;

import com.github.liao47.common.constants.FtpKeyConstants;
import com.github.liao47.common.exception.CustomException;
import com.github.liao47.extra.utils.EmailUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

    /**
     * 通过Properties获取配置
     * @param properties
     * @return
     */
    public static FtpConfig of(Properties properties) {
        return create()
                .hostname(properties.getProperty(FtpKeyConstants.HOSTNAME))
                .port(Integer.parseInt(properties.getProperty(FtpKeyConstants.PORT)))
                .username(properties.getProperty(FtpKeyConstants.USERNAME))
                .password(properties.getProperty(FtpKeyConstants.PASSWORD))
                .connectTimeout(Integer.parseInt(properties.getProperty(FtpKeyConstants.CONNECT_TIMEOUT)))
                .encoding(properties.getProperty(FtpKeyConstants.ENCODING))
                .ftpDir(properties.getProperty(FtpKeyConstants.FTP_DIR))
                .localDir(properties.getProperty(FtpKeyConstants.LOCAL_DIR));
    }

    /**
     * 通过Properties路径获取配置
     * @param configPath
     * @return
     */
    public static FtpConfig of(String configPath) {
        try {
            InputStream in = EmailUtils.class.getResourceAsStream(configPath);
            Properties properties = new Properties();
            properties.load(in);
            return of(properties);
        } catch (IOException e) {
            log.error("Get FtpConfig error, cause:", e);
            throw new CustomException("Get FtpConfig failure", e);
        }
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
