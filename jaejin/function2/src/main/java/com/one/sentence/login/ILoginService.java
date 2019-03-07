package com.one.sentence.login;

import com.one.sentence.vo.UserVo;

public interface ILoginService {
	public boolean isUser(String email);
	public UserVo selectUser(String email);
}
