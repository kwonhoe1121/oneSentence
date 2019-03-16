package com.one.sentence.register;

import com.one.sentence.vo.UserVo;

public interface IRegisterService {

	public int registerUser(UserVo user);
	public boolean isUser(String email);
	public int withdrawUser(UserVo user);
	
}
