package com.one.sentence.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.search.dao.SearchDao;

@Service
public class SearchUserService {

	@Autowired
	private SearchDao dao;
	
	@Override
	public List<String> selectUserList() {
		return dao.selectUserList();
	}
} 
