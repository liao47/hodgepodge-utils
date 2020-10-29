package com.liao47.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * FTP配置key
 * @author liao47
 * @date 2020/10/29 19:30
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FtpKeyConstants {
    /**
     * 主机名
     */
    public static final String HOSTNAME = "hostname";
    
    /**
     * 端口号
     */
    public static final String PORT = "port";

    /**
     * 用户名
     */
    public static final String USERNAME = "username";

    /**
     * 密码
     */
    public static final String PASSWORD = "password";

    /**
     * 连接超时时间 milliseconds
     */
    public static final String CONNECT_TIMEOUT = "connectTimeout";

    /**
     * 编码
     */
    public static final String ENCODING = "encoding";

    /**
     * FTP路径
     */
    public static final String FTP_DIR = "ftpDir";

    /**
     * 本地路径
     */
    public static final String LOCAL_DIR = "localDir";
}
