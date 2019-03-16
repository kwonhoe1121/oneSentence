package com.one.sentence.register;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.vo.UserVo;

@Repository
public class RegisterDao implements IRegisterDao {

	@Inject
	SqlSessionTemplate sqlSession; // Mapper Container

	String namespace = "com.one.sentence.mapper.jaejinMapper";

	@Override
	public int insertUser(UserVo user) {
		return sqlSession.update(namespace + ".insertUser", user);
	}

	@Override
	public UserVo selectUserByEmail(String email) {
		return sqlSession.selectOne(namespace + ".selectUserByEmail", email);
	}

	@Override
	public int deleteUser(UserVo user) {
		sqlSession.update(namespace + ".deleteUser", user);
		return 0;
	}

}
