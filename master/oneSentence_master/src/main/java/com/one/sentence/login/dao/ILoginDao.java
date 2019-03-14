package com.one.sentence.login.dao;

import com.one.sentence.common.vo.UserVo;

public interface ILoginDao {

	public UserVo selectUserByEmail(String email);

}
