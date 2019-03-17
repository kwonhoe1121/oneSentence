package com.one.sentence.login.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.sentence.common.service.SecurityService;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.login.service.LoginService;
import com.one.sentence.login.service.MailSendService;

@Controller
public class MailSenderController {

	@Inject
	private MailSendService mailService;

	@Inject
	private LoginService loginService;

	@Inject
	private SecurityService securityService;

	@RequestMapping(value = "/mail/send", method = RequestMethod.POST)
	public String sendEmailForPassword(@RequestParam String userEmail)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		userEmail = securityService.encryptUserEmail(userEmail);
		System.out.println("암호화: " + userEmail);
		
		UserVo user = loginService.selectUser(userEmail);
		System.out.println("유저정보: " + user);
		
		String message = user.getUserName() + "님의 비밀번호는 " + securityService.decryptUserPassword(user.getUserPassword());
		System.out.println(message);

		// 또는 임시 비밀번호 주고 db에도 저장하기.

		// 메일 전송하기.
		mailService.sendEmail(securityService.decryptUserEmail(user.getUserEmail()), message);

		return "login";
	}

}
