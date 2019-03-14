package com.one.sentence.userpage.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.one.sentence.common.vo.UserVo;


@Repository
public class UserPageDao implements IUserPageDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.mybatis";

	@Override
	public UserVo selectUser_infoByuserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".selectUser_infoByuserIdx", userIdx);
	}
	

	
}