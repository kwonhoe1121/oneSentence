package com.one.sentence.naverLogin.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;

@Repository
public class NaverDAO {
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
	public int insertNaverUser(UserVo uservo) {
		return sqlSession.insert(namespace+".insertNaverUser", uservo);
	}
	public UserVo selectNaverUserByEmail(String email) {
		return sqlSession.selectOne(namespace+".selectNaverUserByEmail", email);
	}
	
	
	
}
