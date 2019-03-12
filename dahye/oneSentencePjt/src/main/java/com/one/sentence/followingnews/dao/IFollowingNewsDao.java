package com.one.sentence.followingnews.dao;

import java.util.List;

import com.one.sentence.search.model.SearchModel;

public interface IFollowingNewsDao {

	public List<SearchModel> selectFollowingNewsList(String followingnews);
}
