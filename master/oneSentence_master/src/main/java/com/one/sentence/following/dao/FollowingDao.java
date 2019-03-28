package com.one.sentence.following.dao;

import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class FollowingDao implements IFollowingDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
//	@Override
//	public Following selectFollower(Following following) {
//		return sqlSession.selectOne(namespace+".selectFollower", following);
//	}
//
//	@Override
//	public int insertFollower(Following following) {
//		return sqlSession.update(namespace+".insertFollower", following);
//	}
//
//	@Override
//	public int deleteFollower(Following following) {
//		return sqlSession.update(namespace+".deleteFollower", following);
//	}

	@Override
	public int followingProc(Map<String, Object> followingMap) {
		return sqlSession.update(namespace+".followingProc", followingMap);
	}

	
}