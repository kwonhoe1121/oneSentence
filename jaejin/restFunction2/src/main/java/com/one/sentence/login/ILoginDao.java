package com.one.sentence.login;

import com.one.sentence.vo.UserVo;

public interface ILoginDao {

	public UserVo selectUserByEmail(String email);

}
