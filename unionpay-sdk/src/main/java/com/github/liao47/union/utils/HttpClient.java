package com.github.liao47.union.utils;

import com.github.liao47.common.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * HTTP连接工具
 * @author liao47
 * @date 2021/2/22 9:40
 */
@Slf4j
public class HttpClient {
    /**
     * 连接地址
     */
    private final URL url;

    /**
     * 连接超时时间
     */
    private final int connectTimeout;

    /**
     * 读超时时间
     */
    private final int readTimeout;

    /**
     * 连接
     */
    private HttpURLConnection connection;

    private HttpClient(String url, int connectTimeout, int readTimeout) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            log.error("url格式不正确:", e);
            throw new CustomException("url格式不正确");
        }
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    public static HttpClient of(String url, int connectTimeout, int readTimeout) {
        return new HttpClient(url, connectTimeout, readTimeout);
    }

    public static HttpClient of(String url) {
        return new HttpClient(url, 60000, 60000);
    }

    public String send(Map<String, String> params) {
        String encoding = params.get("encoding");

        this.connect(encoding);
        try {
            this.connection.connect();
            this.out(params, encoding);
            return this.in(encoding);
        } catch (IOException e) {
            log.error("请求失败:", e);
            throw new CustomException("请求失败:" + e.getMessage());
        } finally {
            this.connection.disconnect();
        }
    }

    private void connect(String encoding) {
        try {
            this.connection = (HttpURLConnection) url.openConnection();
            this.connection.setConnectTimeout(this.connectTimeout);
            this.connection.setReadTimeout(this.readTimeout);
            this.connection.setDoInput(true);
            this.connection.setDoOutput(true);
            this.connection.setUseCaches(false);
            this.connection.setRequestProperty("Content-type",
                    "application/x-www-form-urlencoded;charset=" + encoding);
            this.connection.setRequestMethod("POST");
        } catch (IOException e) {
            log.error("打开http连接失败:", e);
            throw new CustomException("打开http连接失败");
        }
    }

    private void out(Map<String, String> params, String encoding) throws IOException {
        try (PrintStream out = new PrintStream(connection.getOutputStream(), false, encoding)) {
            out.print(this.paramsToUrlEncoded(params, encoding));
            out.flush();
        } catch (UnsupportedEncodingException e) {
            log.error("编码不支持:", e);
            throw new CustomException("不支持的编码:" + encoding);
        }
    }

    private String in(String encoding) throws IOException {
        if (this.connection.getResponseCode() != 200) {
            throw new CustomException("远程调用失败");
        }

        try (InputStream is = this.connection.getInputStream();
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = is.read(buf, 0, buf.length)) > 0) {
                bout.write(buf, 0, length);
            }
            bout.flush();
            return new String(bout.toByteArray(), encoding);
        }
    }

    private String paramsToUrlEncoded(Map<String, String> params, String encoding) {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getValue())) {
                    sb.append(entry.getKey())
                            .append("=")
                            .append(URLEncoder.encode(entry.getValue(), encoding))
                            .append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            log.error("编码不支持:", e);
            throw new CustomException("不支持的编码:" + encoding);
        }
    }
}
