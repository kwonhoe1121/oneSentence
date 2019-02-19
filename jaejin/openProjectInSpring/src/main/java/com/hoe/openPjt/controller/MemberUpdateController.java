package com.hoe.openPjt.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoe.openPjt.dto.Member;
import com.hoe.openPjt.service.MemberService;

@Controller
@RequestMapping("/member/memberUpdate")
public class MemberUpdateController {
	
	@Inject
	MemberService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getMemberUpdateForm(Member member) {
		
		return "member/MemberUpdateForm";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String updateMemberInfo(HttpSession session, 
			@ModelAttribute(value="member") Member updatedMember) {
		
		Member previousMember = (Member) session.getAttribute("member");
		//회원정보 수정.
		System.out.println("이전 멤버 정보: " + previousMember);
		session.setAttribute("member", updatedMember);
		updatedMember.setAltKey(previousMember.getAltKey());
		System.out.println("수정된 멤버 정보: " + updatedMember);
		//수정된 정보 세션에 저장
		session.setAttribute("member", updatedMember);
		
		//수정된 정보 db에 저장
		service.changeMemberInfo(updatedMember);
		
		return "member/memberLogin";
	}
	
}
