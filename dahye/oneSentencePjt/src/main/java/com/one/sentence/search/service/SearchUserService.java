package com.one.sentence.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.search.dao.SearchUserDao;

@Service
public class SearchUserService implements ISearchUserService{

	@Autowired
	private SearchUserDao dao;
	
	@Override
	public List<String> selectUserList(String userName) {
		return dao.selectUserList(userName);
	}
} 
