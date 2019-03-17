package com.one.sentence.login.service;

import javax.inject.Inject;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSendService implements IMailSendService {

	@Inject
	private MailSender mailSender;
	
	@Override
	public void sendEmail(String to, String message) {
		
		//메일 내용 설정
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setSubject("[한문장] 비밀번호 메일 발송");
		simpleMessage.setText(message);
		simpleMessage.setTo(to);
		simpleMessage.setFrom("oneSentence@gmail.com");
		
		//메일 발송
		mailSender.send(simpleMessage);
	}

}
