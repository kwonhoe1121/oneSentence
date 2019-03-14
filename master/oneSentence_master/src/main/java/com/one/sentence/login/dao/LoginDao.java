package com.one.sentence.login.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;

@Repository
public class LoginDao implements ILoginDao {

	@Inject
	SqlSessionTemplate sqlSession;

	String namespace = "com.one.sentence.mapper.Mapper";

	@Override
	public UserVo selectUserByEmail(String email) {
		return sqlSession.selectOne(namespace + ".selectUserByEmail", email);
	}

}
