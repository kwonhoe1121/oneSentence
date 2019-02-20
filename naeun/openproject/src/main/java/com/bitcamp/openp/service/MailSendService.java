package com.bitcamp.openp.service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void mailSender(String to, String enccode) {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			// 메일 제목 설정
			mimeMessage.setSubject("회원가입을 위한 이메일 인증입니다", "utf-8");
			
			// 메일 수신인 설정
			mimeMessage.addRecipient(
					RecipientType.TO, 
					new InternetAddress(to));
			
			// 메일 내용 설정
			String HtmlMsg 
				= "<h1>안녕하세요</h1> <a href=\"http://localhost/openp/mailcheck/"+enccode+"\">이메일 인증</a>";			
			mimeMessage.setText(HtmlMsg, "utf-8", "html");
			
			// 메일 발송
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
						
	}

}
