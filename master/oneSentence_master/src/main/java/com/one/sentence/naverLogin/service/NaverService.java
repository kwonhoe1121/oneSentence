package com.one.sentence.naverLogin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.naverLogin.dao.NaverDAO;

@Service
public class NaverService {
	@Inject
	private NaverDAO dao;
	
	public void makeNaverUser(UserVo uservo) {
		dao.insertNaverUser(uservo);
	}
	public UserVo showNaverUser(String email) {
		return dao.selectNaverUserByEmail(email);
	}
}
