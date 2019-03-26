package com.one.sentence.kakaologin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.kakaologin.dao.RegisterKakaoUserDao;

@Service
public class RegisterKakaoUserService implements IRegisterKakaoUserService {
	
	@Autowired
	private RegisterKakaoUserDao dao;
	
	@Override
	public int registerKakaoUser(UserVo uservo) {
		return dao.insertKakaoUser(uservo);
	}
	
}
