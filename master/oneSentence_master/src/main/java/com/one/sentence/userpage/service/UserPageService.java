package com.one.sentence.userpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.userpage.dao.UserPageDao;

@Service
public class UserPageService implements IUserPageService {

	@Autowired
	private UserPageDao dao;

	@Override
	public UserVo showUser_infoByuserIdx(int userIdx) {
		return dao.selectUser_infoByuserIdx(userIdx);
	}
	


	
}
