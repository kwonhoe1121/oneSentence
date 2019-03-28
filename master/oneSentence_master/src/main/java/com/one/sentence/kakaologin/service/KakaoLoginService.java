package com.one.sentence.kakaologin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.kakaologin.dao.KakaoLoginDao;

@Service
public class KakaoLoginService implements IKakaoLoginService {
	
	@Autowired
	private KakaoLoginDao dao;

	@Override
	public UserVo checkKakaoUser(String userEmail) {
		return dao.selectUserByUserEmail(userEmail);
	}
	
	@Override
	public int registerKakaoUser(UserVo uservo) {
		return dao.insertKakaoUser(uservo);
	}
	
}
