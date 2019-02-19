package com.hoe.openPjt.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hoe.openPjt.dto.Member;
import com.hoe.openPjt.service.MemberService;

@Controller
public class MemberListController {

	@Inject
	MemberService service;

	@RequestMapping("/member/memberList")
	public String getMemberList(Model model ,HttpSession session) {

		//현재 회원정보 확인.
		Member member = (Member) session.getAttribute("member");
		System.out.println("로그인 회원 정보: " + member);
		
		//서비스에서 바로 회원리스트 가져와야함.
		List<Member> memberList = service.getMemberListAll();
		//회원리스트 null체크 따로 안해줘도 된다.
		
		
		//회원 정보 리스트 확인
//		System.out.println("이거 보면 회원정보 가져온거야");
//		for(Member mem : memberList) {
//			System.out.println(mem);
//		}
		
		model.addAttribute("memberList",memberList);
		
		return "member/memberList";
	}

}
