package com.hoe.openPjt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/memberMypage")
public class MemberMypageController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMypage() {
		return "member/memberMypage";
	}
}
