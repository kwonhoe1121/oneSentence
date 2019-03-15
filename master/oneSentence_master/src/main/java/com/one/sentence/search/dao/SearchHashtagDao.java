package com.one.sentence.search.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SearchHashtagDao implements ISearchHashtagDao {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
	@Override
	public List<String> selectHashsearchList(String hashtag) {
		return sqlSession.selectList(namespace+ ".selectHashsearchList", hashtag);
	}
}
