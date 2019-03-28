package com.one.sentence.following.dao;

import java.util.Map;

interface IFollowingDao {

//	public Following selectFollower(Following following);	
//	public int insertFollower(Following following);	
//	public int deleteFollower(Following following);
	
	public int followingProc(Map<String, Object> followingMap);
	
}