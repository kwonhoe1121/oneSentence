package com.one.sentence.kakaologin.dao;

import com.one.sentence.common.vo.UserVo;

interface IKakaoLoginDao {
	public UserVo selectUserByUserEmail(String userEmail);
	public int insertKakaoUser(UserVo uservo);	
}