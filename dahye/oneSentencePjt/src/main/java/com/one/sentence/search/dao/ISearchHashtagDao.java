package com.one.sentence.search.dao;

import java.util.List;

interface ISearchHashtagDao {

	public List<String> selectHashtagList(String hashtag);	
	
}