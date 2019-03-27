package com.one.sentence.preference.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.UserVo;


@Repository
public class PreferenceDao implements IPreferenceDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";	
	
	@Override
	public List<String> selectHashtagListByPreference(int userIdx) {
		return sqlSession.selectList(namespace+".selectHashtagListByPreference", userIdx);
	}
		
	@Override
	public UserVo selectUser_infoByuserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".selectUser_infoByuserIdx", userIdx);
	}
	
	@Override
	public int selectTheNumberOfSentencesByUserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".selectTheNumberOfSentencesByUserIdx", userIdx);
	}
	
	@Override
	public int selectTheNumberOfUsers() {
		return sqlSession.selectOne(namespace+".selectTheNumberOfUsers");
	}

	@Override
	public int selectUserRank(int userIdx) {
		return sqlSession.selectOne(namespace+".selectUserRank", userIdx);
	}
}