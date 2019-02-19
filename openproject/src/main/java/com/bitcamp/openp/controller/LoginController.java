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
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.openp.model.Member;
import com.bitcamp.openp.security.Aes256;
import com.bitcamp.openp.service.MemberLoginService;


@Controller
@RequestMapping("/memberLogin")
public class LoginController {

	@Autowired
	MemberLoginService service = new MemberLoginService();
	
	@Autowired
	private Aes256 aes256;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getForm(HttpSession session, HttpServletRequest request, Model model) {

		if(session.getAttribute("loginInfo") == null) {
			return "member/loginForm";
		}
		else
			return "member/memberLogin";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String memberLogin(
			HttpServletRequest request,
			HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		String paramencpw = aes256.encrypt(password);

		
		Member member = service.selectMemberByEmail(email);	
		String encpw = member.getEncpw();
		String chk = member.getEmailchk();
		
		
		if(encpw!=null && encpw.equals(paramencpw)) {
			if(chk!=null && chk.equals("1")) {
				session.setAttribute("loginInfo", email);
				return "member/memberLogin";
			}

			else
				return "mail/mailCheckFailed";
		}

		if(session.getAttribute("loginInfo") == null)
			return "member/memberLoginFailed";

		return "member/memberLoginFailed";

	}
	
	
}
