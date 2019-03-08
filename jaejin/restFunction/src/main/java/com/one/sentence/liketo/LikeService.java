package com.one.sentence.liketo;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.vo.OneSentence;
import com.one.sentence.vo.UserVo;

@Service
public class LikeService implements ILikeService {

	@Inject
	LikeDao dao;

	@Override
	public UserVo getUserVo(String email) {
		return dao.selectUserByEmail(email);
	}

	@Override
	public OneSentence fetchOneSenteceInfo(int oneSentenceIdx) {
		return dao.selectOneSentence(oneSentenceIdx);
	}

	@Override
	public boolean isLikedTheSentence(Map<String, Integer> mapIdx) {

		if (getLikedIdx(mapIdx) != null) {
			return true;
		}

		return false;
	}

	@Override
	public Integer getLikedIdx(Map<String, Integer> mapIdx) {
		return dao.selectLikedSentence(mapIdx);
	}

	@Override
	public int pushLikeButton(Map<String, Integer> mapIdx) {
		return dao.insertLikedSentence(mapIdx);
	}

	@Override
	public int rePushLikeButton(Map<String, Integer> mapIdx) {
		return dao.deleteLikedSentence(mapIdx);
	}

}
