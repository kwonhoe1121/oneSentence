package com.one.sentence.register.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;

@Repository
public class RegisterDao implements IRegisterDao {

	@Inject
	SqlSessionTemplate sqlSession; // Mapper Container

	String namespace = "com.one.sentence.mapper.Mapper";

	@Override
	public int insertUser(UserVo user) {
		return sqlSession.update(namespace + ".insertUser", user);
	}

	@Override
	public UserVo selectUserByEmail(String email) {
		return sqlSession.selectOne(namespace + ".selectUserByEmail", email);
	}

	@Override
	public int updateEmailStatus(UserVo user) {
		sqlSession.update(namespace + ".updateEmailStatus", user);
		return 0;
	}

}
