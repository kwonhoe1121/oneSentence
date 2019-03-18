package com.one.sentence.countuser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.countuser.dao.CountUserDao;

@Service
public class CountUserService implements ICountUserService {

	@Autowired
	private CountUserDao dao;

	@Override
	public int selectUserGrade(float percent) {
		return dao.selectUserGrade(percent);
	}

}
