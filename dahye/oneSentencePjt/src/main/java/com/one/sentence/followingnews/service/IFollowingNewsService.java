package com.one.sentence.followingnews.service;

import java.util.List;

import com.one.sentence.search.model.SearchModel;

public interface IFollowingNewsService {

	public List<SearchModel>  selectFollowingNewsList(String followingnews);
}
