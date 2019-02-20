package com.bitcamp.openp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.openp.dao.MemberDao;
import com.bitcamp.openp.model.Member;

@Service
public class MemberListService {

	@Autowired
	private MemberDao dao;
	
	public List<Member> selectMemberList() {	
		return dao.selectMemberList();
	}
	
}
