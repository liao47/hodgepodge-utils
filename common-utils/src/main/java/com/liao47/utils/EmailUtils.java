package com.liao47.utils;

import com.liao47.common.exception.CustomException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 邮件发送工具类
 * @author liao47
 * @date 2020/10/28 13:44
 */
@Slf4j
@Getter
public class EmailUtils {
	private final Properties properties;

	private final Session session;

	private final ThreadLocal<Map<Message.RecipientType, List<String>>> recipients;

	public EmailUtils(Properties properties) {
		this.properties = properties;
		this.recipients = new ThreadLocal<>();

		final String username = properties.getProperty("mail.smtp.user");
		final String password = properties.getProperty("mail.smtp.password");
		this.session = Session.getInstance(properties, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	/**
	 * 通过配置路径获取实例
	 * @param configPath
	 * @return
	 */
	public static EmailUtils getInstance(String configPath) {
		try {
			InputStream in = EmailUtils.class.getResourceAsStream(configPath);
			Properties properties = new Properties();
			properties.load(in);
			return new EmailUtils(properties);
		} catch (IOException e) {
			log.error("Get EMailUtil instance error, cause:", e);
			throw new CustomException("Get EMailUtil instance failure", e);
		}
	}

	/**
	 * 添加接收者
	 * @param type
	 * @param recipients
	 * @return
	 */
	public EmailUtils addRecipients(Message.RecipientType type, String... recipients) {
		Map<Message.RecipientType, List<String>> map = this.recipients.get();
		if (map == null) {
			map = new HashMap<>(3);
			this.recipients.set(map);
		}
		List<String> list = map.computeIfAbsent(type, s -> new ArrayList<>());
		list.addAll(Arrays.asList(recipients));
		return this;
	}

	/**
	 * 发送邮件
	 * @param title
	 * @param content
	 */
	public void send(String title, String content) {
		Map<Message.RecipientType, List<String>> recipientMap = this.recipients.get();
		this.recipients.remove();
		if (recipientMap == null || recipientMap.isEmpty()) {
			throw new CustomException("Recipients is empty");
		}
		String encoding = StringUtils.defaultIfEmpty(properties.getProperty("mail.encoding"),
				StandardCharsets.UTF_8.toString());
		String from = StringUtils.defaultIfEmpty(properties.getProperty("mail.smtp.from"),
				properties.getProperty("mail.smtp.user"));

		try {
			MimeMessage message = new MimeMessage(session);
			log.info("Send email [{}] to: {}", title, recipientMap);
			message.setFrom(new InternetAddress(from));
			for (Map.Entry<Message.RecipientType, List<String>> entry : recipientMap.entrySet()) {
				InternetAddress[] addresses = new InternetAddress[entry.getValue().size()];
				for (int i = 0; i < entry.getValue().size(); i++) {
					addresses[i] = new InternetAddress(entry.getValue().get(i));
				}
				message.addRecipients(entry.getKey(), addresses);
			}
			message.setSubject(title);
			message.setContent(content, "text/plain;charset=" + encoding);
			Transport.send(message);
			log.info("Send email [{}] successfully", title);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Send email [{}] error, cause:", title, e);
		}
	}

	public static void main(String[] args) {
		EmailUtils.getInstance("/email.properties")
				.addRecipients(Message.RecipientType.TO, "liao647@foxmail.com")
				.addRecipients(Message.RecipientType.CC, "liao_47@163.com")
				.send("Hello", "Hello, This is a test mail");
	}
}
