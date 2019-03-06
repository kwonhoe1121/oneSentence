package com.one.sentence.following.service;

import com.one.sentence.following.model.Following;


interface IFollowingService {
	
	public Following checkFollowingState(Following following);	
	public int startFollowing(Following following);	
	public int unfollowing(Following following);
	
}
