package com.bitcamp.openp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.openp.model.Member;
import com.bitcamp.openp.service.MemberListService;


@Controller
public class MemberListController {

	@Autowired
	MemberListService service = new MemberListService();
	
	@RequestMapping("/memberList")
	public String getMemberlist(HttpSession session, Model model, HttpServletRequest request) {

			List<Member> memberlist = service.selectMemberList();
			model.addAttribute("memberlist", memberlist);
			return "member/memberList";
		}
	}
