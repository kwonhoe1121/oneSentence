package com.one.sentence.search.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class SearchUserDao implements ISearchUserDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.mapper";
	
	@Override
	public List<String> selectUserList(String userName) {
		return sqlSession.selectList(namespace+".selectUserList", userName);
	}

	
}