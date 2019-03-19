package com.one.sentence.followingnews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.followingnews.dao.FollowingNewsDao;
import com.one.sentence.onesentence.model.ShowOnesentence;


@Service
public class FollowingNewsService implements IFollowingNewsService {

	@Autowired
	private FollowingNewsDao dao;
	
	@Override
	public List<ShowOnesentence> selectOneSentenceListForFollowing(int userIdx) {
		return dao.selectOneSentenceListForFollowing(userIdx);
	}
}
