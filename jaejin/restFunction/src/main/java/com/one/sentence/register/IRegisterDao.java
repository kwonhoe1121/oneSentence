package com.one.sentence.register;

import com.one.sentence.vo.UserVo;

public interface IRegisterDao {

	public int insertUser(UserVo user);

	public UserVo selectUserByEmail(String email);

	public int deleteUser(UserVo user);

}
