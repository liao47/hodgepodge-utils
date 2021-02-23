package com.github.liao47.union.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author liao47
 * @date 2021/2/23 14:08
 */
@Configuration
public class AppConfig {

    @Bean("restTemplateSsl")
    public RestTemplate restTemplateSsl() {
        //“java.security.cert.CertificateException: Illegal given domain name”，需要去掉对SSL证书校验
        SimpleClientHttpRequestFactory requestFactory = new SslClientHttpRequestFactory();
        requestFactory.setConnectTimeout(60000);
        requestFactory.setReadTimeout(60000);
        return new RestTemplate(requestFactory);
    }
}
