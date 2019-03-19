package com.one.sentence.followingnews.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.onesentence.model.ShowOnesentence;

@Repository
public class FollowingNewsDao implements IFollowingNewsDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	

	@Override
	public List<ShowOnesentence> selectOneSentenceListForFollowing(int userIdx) {
		return sqlSession.selectList(namespace+".selectOnesentenceListForFollowing", userIdx);
	}
	
	
}
