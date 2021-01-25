package com.example.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	private static final Logger logger = LogManager.getLogger(EmailUtil.class);
	
	public static void isSend() throws AddressException, MessagingException {
		logger.info("< mail sending... >");
		Session session = Session.getInstance(props(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username", "password");
			}
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("from_mail", true));
		
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to_mail"));
		message.setSubject("It's me");

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Hi, It's me", "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		
		message.setContent(multipart);
		
		Transport.send(message);
		logger.info("< Mail sent >");
	}
	
	private static Properties props() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		return props;
	}
}
