package com.one.sentence.googlelogin.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;

@Repository
public class GoogleLoginDao implements IGoogleLoginDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";
	
	@Override
	public UserVo selectGoogleUserByUserEmail (String email) {
		return sqlSession.selectOne(namespace + ".selectGoogleUserByUserEmail", email);
	}	
	
	@Override
	public int insertGoogleUser(UserVo uservo) {
		return sqlSession.insert(namespace + ".insertGoogleUser", uservo);
	}	
}
