package com.one.sentence.countuser.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CountUserDao implements ICountUserDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";

	@Override
	public int selectUserGrade(float percent) {
		return sqlSession.selectOne(namespace+".selectUserGrade", percent);
	}

	
}