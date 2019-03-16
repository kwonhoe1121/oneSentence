package com.one.sentence.following.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.following.model.Following;


@Repository
public class FollowingDao implements IFollowingDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
	@Override
	public Following selectFollower(Following following) {
		return sqlSession.selectOne(namespace+".selectFollower", following);
	}

	@Override
	public int insertFollower(Following following) {
		return sqlSession.update(namespace+".insertFollower", following);
	}

	@Override
	public int deleteFollower(Following following) {
		return sqlSession.update(namespace+".deleteFollower", following);
	}

	
}