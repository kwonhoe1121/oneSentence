package com.one.sentence.countsentence.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CountSentenceDao implements ICountSentenceDao{

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.one.sentence.mapper.Mapper";

	@Override
	public int countAllSentences() {
		return sqlSession.selectOne(namespace+".countAllSentences");
	}

	@Override
	public int countSentenceByUserIdx(int userIdx) {
		return sqlSession.selectOne(namespace+".countSentenceByUserIdx", userIdx);
	}

	
}