package com.one.sentence.countuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.countuser.dao.UserRankDao;

@Service
public class UserRankService implements IUserRankrService {

	@Autowired
	private UserRankDao dao;

	@Override
	public int countAllUsers() {
		return dao.countAllUsers();
	}

	@Override
	public int selectUserRank(int userIdx) {
		return dao.selectUserRank(userIdx);
	}

}
