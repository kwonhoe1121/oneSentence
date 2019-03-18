package com.one.sentence.countuser.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserRankDao implements IUserRankDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";

	@Override
	public int countAllUsers() {
		return sqlSession.selectOne(namespace+".countAllUsers");
	}

	@Override
	public int selectUserRank(int userIdx) {
		return sqlSession.selectOne(namespace+".selectUserRank", userIdx);
	}

	
}