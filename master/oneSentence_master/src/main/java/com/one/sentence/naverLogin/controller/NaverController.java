package com.one.sentence.naverLogin.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.naverLogin.service.NaverService;

@Controller
@RequestMapping("/login/naver")
public class NaverController {
	
	@Inject
	NaverService nService;
	
	@RequestMapping("/callback")
	public String naverCallback() {
		return "naver/callback";
	}
	
	@RequestMapping("/finish")
	public String naverLogin(HttpSession session, 
			HttpServletRequest request) {
		String email =request.getParameter("email");
		UserVo user = nService.showNaverUser(email);
		if(user==null) {
		user = new UserVo();
		user.setUserEmail(email);
		user.setUserName(request.getParameter("name"));
		user.setUserPassword("");
		user.setEmailStatus("4");
		nService.makeNaverUser(user);
			}
		session.setAttribute("User", user);
		return "naver/end";
	}
}

