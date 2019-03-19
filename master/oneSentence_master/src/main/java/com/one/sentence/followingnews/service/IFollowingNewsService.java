package com.one.sentence.followingnews.service;

import java.util.List;

import com.one.sentence.onesentence.model.ShowOnesentence;


public interface IFollowingNewsService {

	
	public List<ShowOnesentence> selectOneSentenceListForFollowing(int userIdx);
}
