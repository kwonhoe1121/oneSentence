package com.one.sentence.search.dao;

import java.util.List;

interface ISearchUserDao {

	public List<String> selectUserList(String userName);	
	
}