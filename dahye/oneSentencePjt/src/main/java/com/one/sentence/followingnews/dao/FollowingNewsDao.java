package com.one.sentence.followingnews.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.search.model.SearchModel;

@Repository
public class FollowingNewsDao implements IFollowingNewsDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.mapper";
	
	@Override
	public List<SearchModel> selectFollowingNewsList(String followingnews) {
		return sqlSession.selectList(namespace+ ".selectFollowingNewsList", followingnews);
	}
}
