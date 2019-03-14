package com.one.sentence.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.search.dao.SearchHashtagDao;

@Service
public class SearchHashtagService implements ISearchHashtagService{

	@Autowired
	private SearchHashtagDao dao;
	
	@Override
	public List<String> selectHashtagList(String hashtag) {
		return dao.selectHashtagList(hashtag);
	}
	
}
