package com.one.sentence.kakaologin.dao;

import com.one.sentence.common.vo.UserVo;

interface ICheckKakaoUserDao {
	public UserVo selectUserByUserEmail(String userEmail);
	
}