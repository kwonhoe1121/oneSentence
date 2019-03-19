package com.one.sentence.followingnews.dao;

import java.util.List;

import com.one.sentence.onesentence.model.ShowOnesentence;

public interface IFollowingNewsDao {

	public List<ShowOnesentence> selectOneSentenceListForFollowing(int userIdx);
}
