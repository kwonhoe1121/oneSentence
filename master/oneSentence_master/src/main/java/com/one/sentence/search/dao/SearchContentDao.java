package com.one.sentence.search.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;


@Repository
public class SearchContentDao implements ISearchUserDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
	@Override
	public List<String> selectUserList(String userName) {
		return sqlSession.selectList(namespace+".selectUserList", userName);
	}

	@Override
	public List<UserVo> selectUserByUserName(String userName) {
		return sqlSession.selectList(namespace+".selectUserByUserName", userName);
	}

	
}