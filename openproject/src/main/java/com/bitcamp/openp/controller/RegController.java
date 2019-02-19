package com.bitcamp.openp.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.openp.model.Member;
import com.bitcamp.openp.security.Aes256;
import com.bitcamp.openp.service.MailSendService;
import com.bitcamp.openp.service.MemberRegService;


@Controller
@RequestMapping("/memberReg")
public class RegController {

	@Autowired
	MemberRegService service = new MemberRegService();
	
	@Autowired
	MailSendService mservice = new MailSendService();
	
	@Autowired
	private Aes256 aes256;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getForm() {
		return "member/regForm";
	}


	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(
			HttpServletRequest request,
			Model model) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String photo = request.getParameter("photo");
		
		// 암호화
		String encpw = aes256.encrypt(password);
		String enccode = aes256.encrypt(name);
		
		Member member = new Member();
		member.setEmail(email);
		member.setEncpw(encpw);
		member.setName(name);
		member.setPhoto(photo);
		member.setEnccode(enccode);

		service.insertMember(member);
		mservice.mailSender("naeeeun@naver.com", enccode);

		
		model.addAttribute("result", member);
	
		return "member/memberReg";
	}
	
	
	
}
