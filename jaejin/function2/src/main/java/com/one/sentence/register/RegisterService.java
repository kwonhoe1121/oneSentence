package com.one.sentence.register;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.vo.UserVo;

@Service
public class RegisterService implements IRegisterService {

	@Inject
	RegisterDao dao;

	@Override
	public int registerUser(UserVo user) {
		if (!isUser(user.getUserEmail())) { // 중복된 유저가 없다면.
			return dao.insertUser(user);
		}
		return -1;
	}

	@Override
	public boolean isUser(String email) {
		if (dao.selectUserByEmail(email) != null) {
			return true;
		}
		return false;
	}

	@Override
	public int withdrawUser(UserVo user) {
		dao.deleteUser(user);
		return 0;
	}

}
