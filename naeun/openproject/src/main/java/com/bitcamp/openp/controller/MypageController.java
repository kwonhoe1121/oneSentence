package com.bitcamp.openp.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.openp.model.Member;
import com.bitcamp.openp.security.Aes256;
import com.bitcamp.openp.service.MemberLoginService;


@Controller
public class MypageController {
	
	@Autowired
	MemberLoginService service = new MemberLoginService();
	
	@Autowired
	private Aes256 aes256;
	
	@RequestMapping("/mypage")
	public String getForm(HttpSession session, Model model, HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
			String email = (String) session.getAttribute("loginInfo");
			Member member = service.selectMemberByEmail(email);
			
			String password = aes256.decrypt(member.getEncpw());
			
			model.addAttribute("result", member);
			model.addAttribute("password", password);
			return "member/mypage";

	}
}