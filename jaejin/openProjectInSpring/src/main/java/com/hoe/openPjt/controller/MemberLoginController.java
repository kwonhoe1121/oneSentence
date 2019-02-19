package com.hoe.openPjt.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hoe.openPjt.dto.Member;
import com.hoe.openPjt.service.MemberService;

@Controller
@RequestMapping("/member/memberLogin")
public class MemberLoginController {

	@Inject
	MemberService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(HttpSession session) {
		//로그인 폼으로 넘기기 전에 session확인.
		if(session != null) {
			Object obj = session.getAttribute("member");
			if(obj != null) {
				return "member/memberLogin";
			}
		}
		
		//fetch memberLoginForm
		return "member/memberLoginForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginMember(
			@RequestParam("email") String email,
			@RequestParam("password") int password,
			HttpSession session,
			Model model) {
				
		//member 찾기.
		Member member = service.searchMember(email);
		
		if(member == null) { // 해당하는 member 없으면
			return "member/memberLoginForm";
		}
		
		if(password != member.getPassword()) {
			return "member/memberLoginForm";
		}
		
		
		//세션등록 , 세션 등록 여부 확인은 interceptor에서 확인.
		session.setAttribute("member", member); //인자(sessionId, data);
		
		
//		if(member != null && session != null) {
//			//세션생성.
//			session.setAttribute("member", member);
//		} else {
//			//회원가입 페이지로 이동.
//		}

		return "member/memberLogin";
	}
}
