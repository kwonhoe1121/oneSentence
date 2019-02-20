package com.bitcamp.openp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.openp.model.Member;
import com.bitcamp.openp.service.MemberRegService;


@Controller
public class MailCheckController {

	@Autowired
	MemberRegService service = new MemberRegService();
	
	@RequestMapping("/mailcheck/{mail}")
	public String mailchk(
			HttpServletRequest request,
			@PathVariable("mail") String fromemail) {

		Member member = service.mailCheck(fromemail);
		String enccode = member.getEnccode();
		
		if(enccode!=null && enccode.equals(fromemail)) {
			service.chkComplete(enccode);
			return "mail/mailCheck";
		}
		else
			return "mail/mailCheckFailed";
		
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
	
	

