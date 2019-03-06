package com.one.sentence.following.dao;

import com.one.sentence.following.model.Following;

interface IFollowingDao {

	public Following selectFollower(Following following);	
	public int insertFollower(Following following);	
	public int deleteFollower(Following following);
	
}