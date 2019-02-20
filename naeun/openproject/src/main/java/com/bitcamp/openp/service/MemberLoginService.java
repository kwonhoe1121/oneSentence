package com.bitcamp.openp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.openp.dao.MemberDao;
import com.bitcamp.openp.model.Member;

@Service
public class MemberLoginService {

	@Autowired
	private MemberDao dao;
	
	public Member selectMemberByEmail(String email) {
		return dao.selectMemberByEmail(email);
	}
	
}
