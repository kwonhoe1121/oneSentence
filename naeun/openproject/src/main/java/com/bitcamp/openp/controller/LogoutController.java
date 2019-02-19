package com.bitcamp.openp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.openp.service.MemberLogoutService;


@Controller
@RequestMapping("/memberLogout")
public class LogoutController {

	@Autowired
	MemberLogoutService service = new MemberLogoutService();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getForm(HttpSession session) {
		
		if(session.getAttribute("loginInfo") == null)			
			return "member/memberLogoutFailed";
		else {
			session.invalidate();
		
			return "member/memberLogout";
		}
	}

	
	
}
