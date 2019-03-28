package com.one.sentence.userpage.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.following.model.Following;


@Repository
public class UserPageDao implements IUserPageDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";

	@Override
	public UserVo selectUser_infoByuserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".selectUser_infoByuserIdx", userIdx);
	}
	
	@Override
	public int selectTheNumberOfSentences() {
		return sqlSession.selectOne(namespace+".selectTheNumberOfSentences");
	}

	@Override
	public int selectTheNumberOfSentencesByUserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".selectTheNumberOfSentencesByUserIdx", userIdx);
	}

	@Override
	public Following selectFollower(Following following) {
		return sqlSession.selectOne(namespace+".selectFollower", following);
	}
	
}