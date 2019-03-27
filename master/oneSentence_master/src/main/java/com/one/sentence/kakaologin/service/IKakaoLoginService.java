package com.one.sentence.kakaologin.service;

import com.one.sentence.common.vo.UserVo;

interface IKakaoLoginService {
	
	public UserVo checkKakaoUser(String userEmail);
	public int registerKakaoUser(UserVo uservo);
	
}
