package com.one.sentence.register.service;

import com.one.sentence.common.vo.UserVo;

public interface IRegisterService {

	public int registerUser(UserVo user);

	public boolean isUser(String email);

	public int withdrawUser(UserVo user);
	
	public int cutFollwing(UserVo user);

}
