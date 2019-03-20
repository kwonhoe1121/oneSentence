package com.one.sentence.register.dao;

import com.one.sentence.common.vo.UserVo;

public interface IRegisterDao {

	public int insertUser(UserVo user);

	public UserVo selectUserByEmail(String email);

	public int updateEmailStatus(UserVo user);
	
	public int deleteFollowingRelation(UserVo user);

}
