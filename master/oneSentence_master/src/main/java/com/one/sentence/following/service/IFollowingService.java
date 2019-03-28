package com.one.sentence.following.service;

import java.util.Map;


interface IFollowingService {
	
//	public Following checkFollowingState(Following following);	
//	public int startFollowing(Following following);	
//	public int unfollowing(Following following);
	public int followingProc(Map<String, Object> followingMap);
	
}
