package com.bitcamp.open0207.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.open0207.model.Member;
import com.bitcamp.open0207.model.MemberList;
import com.bitcamp.open0207.service.LoginService;

@RestController
public class RestApiController {
	
	private LoginService logService;
	
	@GetMapping("/rest/memberList")
	public MemberList getMemberList() {
		List<Member> list = logService.selectList();
		return new MemberList(list);
	}
}
