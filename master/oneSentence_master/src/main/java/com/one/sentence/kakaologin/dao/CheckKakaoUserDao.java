package com.one.sentence.kakaologin.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;


@Repository
public class CheckKakaoUserDao implements ICheckKakaoUserDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";

	@Override
	public UserVo selectUserByUserEmail(String userEmail) {
		return sqlSession.selectOne(namespace + ".selectUserByUserEmail", userEmail);
	}	
}