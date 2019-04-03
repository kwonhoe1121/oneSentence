package com.one.sentence.googlelogin.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.googlelogin.dao.GoogleLoginDao;

@Service
public class GoogleLoginService {

	@Inject
	private GoogleLoginDao dao;
	
	public void insertGoogleUser(UserVo uservo) {
		dao.insertGoogleUser(uservo);
	}
	public UserVo selectGoogleUser(String email) {
		return dao.selectGoogleUserByUserEmail(email);
	}
}
