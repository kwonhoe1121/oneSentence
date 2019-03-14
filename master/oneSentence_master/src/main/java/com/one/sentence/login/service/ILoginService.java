package com.one.sentence.login.service;

import com.one.sentence.common.vo.UserVo;

public interface ILoginService {
	public boolean isUser(String email);

	public UserVo selectUser(String email);
}
