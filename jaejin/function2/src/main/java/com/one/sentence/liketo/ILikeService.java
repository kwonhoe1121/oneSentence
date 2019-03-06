package com.one.sentence.liketo;

import java.util.Map;

import com.one.sentence.vo.OneSentence;
import com.one.sentence.vo.UserVo;

public interface ILikeService {

	// 회원정보 가져오기 - 세션에서 가져온다.
	public UserVo getUserVo(String email);

	// 한문장 정보 가져오기.
	public OneSentence fetchOneSenteceInfo(int oneSentenceIdx);

	// 좋아요 문장 Idx 가져오기
	public Integer getLikedIdx(Map<String, Integer> mapIdx);

	// 좋아요 표시 여부 확인.
	public boolean isLikedTheSentence(Map<String, Integer> mapIdx);

	// 좋아요 표시
	public int pushLikeButton(Map<String, Integer> mapIdx);

	// 좋아요 표시 삭제.
	public int rePushLikeButton(Map<String, Integer> mapIdx);

}
