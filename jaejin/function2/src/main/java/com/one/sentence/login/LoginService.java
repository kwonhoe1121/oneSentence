package com.one.sentence.login;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.vo.UserVo;

@Service
public class LoginService implements ILoginService {

	@Inject
	LoginDao dao;

	@Override
	public boolean isUser(String email) {
		if (dao.selectUserByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public UserVo selectUser(String email) {
		return dao.selectUserByEmail(email);
	}

}
