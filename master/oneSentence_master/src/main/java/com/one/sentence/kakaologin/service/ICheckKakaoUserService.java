package com.one.sentence.kakaologin.service;

import com.one.sentence.common.vo.UserVo;

interface ICheckKakaoUserService {
	
	public UserVo checkKakaoUser(String userEmail);
	
}
