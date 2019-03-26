package com.one.sentence.kakaologin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.kakaologin.dao.CheckKakaoUserDao;

@Service
public class CheckKakaoUserService implements ICheckKakaoUserService {
	
	@Autowired
	private CheckKakaoUserDao dao;

	@Override
	public UserVo checkKakaoUser(String userEmail) {
		return dao.selectUserByUserEmail(userEmail);
	}

	
}
