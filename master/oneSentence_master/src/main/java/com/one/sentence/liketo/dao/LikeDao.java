package com.one.sentence.liketo.dao;

import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.common.vo.UserVo;

@Repository
public class LikeDao implements ILikeDao {

	@Inject
	SqlSessionTemplate sqlSession;

	String namespace = "com.one.sentence.mapper.Mapper";

	@Override
	public UserVo selectUserByEmail(String email) {
		return sqlSession.selectOne(namespace + ".selectUserByEmail", email);
	}

	@Override
	public OneSentence selectOneSentence(int oneSentenceIdx) {
		return sqlSession.selectOne(namespace + ".selectOneSentence", oneSentenceIdx);
	}

	@Override
	public Integer selectLikedSentence(Map<String, Integer> mapIdx) {
		return sqlSession.selectOne(namespace + ".selectLikedSentence", mapIdx);
	}

	@Override
	public int insertLikedSentence(Map<String, Integer> mapIdx) {
		return sqlSession.update(namespace + ".insertLikedSentence", mapIdx);
	}

	@Override
	public int deleteLikedSentence(Map<String, Integer> mapIdx) {
		return sqlSession.update(namespace + ".deleteLikedSentence", mapIdx);
	}

}
