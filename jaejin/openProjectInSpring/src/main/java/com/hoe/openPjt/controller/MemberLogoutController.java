package com.hoe.openPjt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLogoutController {

	@RequestMapping("/member/memberLogout")
	public String logoutMember(HttpSession session) {
		
		session.invalidate();
		
		return "member/memberLogout";
	}
	
}
