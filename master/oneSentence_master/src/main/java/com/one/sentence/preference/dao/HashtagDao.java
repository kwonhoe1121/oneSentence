package com.one.sentence.preference.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class HashtagDao implements IHashtagDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";	
	
	@Override
	public List<String> selectHashtagListByPreference(int userIdx) {
		return sqlSession.selectList(namespace+".selectHashtagListByPreference", userIdx);
	}
		
}