package com.bitcamp.openp.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.openp.dao.MemberDao;
import com.bitcamp.openp.model.Member;

@Service
public class MemberLogoutService {

	@Autowired
	private MemberDao dao;
	
	public void logout(HttpSession logininfo) {
		logininfo.invalidate();
	}
	
}
