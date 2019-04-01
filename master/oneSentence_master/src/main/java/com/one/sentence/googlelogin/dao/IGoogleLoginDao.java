package com.one.sentence.googlelogin.dao;

import com.one.sentence.common.vo.UserVo;

public interface IGoogleLoginDao {

	public int insertGoogleUser(UserVo uservo);
	public UserVo selectGoogleUserByUserEmail(String email);
	
}
