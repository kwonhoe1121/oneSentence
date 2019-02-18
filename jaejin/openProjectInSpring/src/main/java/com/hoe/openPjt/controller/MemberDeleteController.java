package com.hoe.openPjt.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoe.openPjt.dto.Member;
import com.hoe.openPjt.service.MemberService;

@Controller
public class MemberDeleteController {
	
	@Inject
	MemberService service;
	
	@RequestMapping("/member/memberDelete")
	public String deleteMember(HttpSession session) {
		
		Member member = (Member) session.getAttribute("member");
		service.withdrawMember(member);
		session.invalidate();
		System.out.println("회원정보 삭제");
		
		return "member/memberRegForm";
	}
	
}
