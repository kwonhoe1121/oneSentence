package com.bitcamp.openp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.openp.model.Member;
import com.bitcamp.openp.service.MemberLoginService;


@Controller
public class MypageController {
	
	@Autowired
	MemberLoginService service = new MemberLoginService();
	
	@RequestMapping("/mypage")
	public String getForm(HttpSession session, Model model, HttpServletRequest request) {
		if(session.getAttribute("loginInfo") == null) {
			return "redirect:/memberLogin";
		}

		else {
			String email = (String) session.getAttribute("loginInfo");
			Member member = service.selectMemberByEmail(email);
			model.addAttribute("result", member);
			return "member/mypage";
		}
	}
}






// 
//	@RequestMapping(method=RequestMethod.POST)
//	public String memberReg(
//			HttpServletRequest request,
//			Model model,
//			HttpSession session) {		
//		
//		List<Member> memberlist = service.selectMemberList();
//		request.setAttribute("memberlist", memberlist);
//		model.addAttribute("memberlist", memberlist);
//		
//		return "member/memberList";
//	}
	
	

