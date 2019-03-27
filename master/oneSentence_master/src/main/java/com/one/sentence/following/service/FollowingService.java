package com.one.sentence.following.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.following.dao.FollowingDao;

@Service
public class FollowingService implements IFollowingService {

	@Autowired
	private FollowingDao dao;
	
//	@Override
//	public Following checkFollowingState(Following following) {
//		return dao.selectFollower(following);
//	}
//
//	@Override
//	public int startFollowing(Following following) {
//		return dao.insertFollower(following);
//	}
//
//	@Override
//	public int unfollowing(Following following) {
//		return dao.deleteFollower(following);
//	}

	@Override
	public int followingProc(Map<String, Object> followingMap) {
		return dao.followingProc(followingMap);
	}

	
}
