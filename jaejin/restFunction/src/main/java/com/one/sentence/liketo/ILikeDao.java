package com.one.sentence.liketo;

import java.util.Map;

import com.one.sentence.vo.OneSentence;
import com.one.sentence.vo.UserVo;

public interface ILikeDao {

	public UserVo selectUserByEmail(String email);

	public OneSentence selectOneSentence(int oneSentenceIdx);

	// param 2개 넘기고 싶으면 map 사용!
	public Integer selectLikedSentence(Map<String, Integer> idxMap);

	public int insertLikedSentence(Map<String, Integer> idxMap);

	public int deleteLikedSentence(Map<String, Integer> idxMap);

}
