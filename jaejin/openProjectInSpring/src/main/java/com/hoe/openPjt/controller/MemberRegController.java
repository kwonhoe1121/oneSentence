package com.hoe.openPjt.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoe.openPjt.dto.Member;
import com.hoe.openPjt.service.MemberService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Inject
	MemberService service;

	@RequestMapping(method=RequestMethod.GET)  
	public String getRegForm(HttpSession session) {
		
		if(session != null) {
			Object obj = session.getAttribute("member");
			if(obj != null) {
				return "member/memberLogin";
			}
		}
		//fetch memberRegisterForm
		return "member/memberRegForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String regMember(Member member, Model model) {
		
		System.out.println("회원등록전!");
		
		//save data in DB 
		//추가사항 - email 중복이라면 다시 입력 - 다시 입력하라는 view 페이지 보이기(ajax,중복검사 해보기.). if
		if(service.isMember(member.getEmail())) {
			
			model.addAttribute("overrapedEmail", "다른 아이디를 사용하세요.");
			return "member/memberRegForm";
		} 
		
		service.registerMember(member);
		
		System.out.println("회원등록후!:" + member);
		
		String result = 
				"ID(email):" + member.getEmail() + ",PW:" + member.getPassword() + ", name:" + member.getName() +", photo:" + member.getPhoto();
		//register data to use view
		model.addAttribute("result", result);
		
		return "member/memberReg";
	}
	
}
