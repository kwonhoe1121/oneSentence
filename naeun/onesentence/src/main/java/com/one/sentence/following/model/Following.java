package com.one.sentence.following.model;

public class Following {

	int userIdx;
	int followingUserIdx;
	
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getFollowingUserIdx() {
		return followingUserIdx;
	}
	public void setFollowingUserIdx(int followingUserIdx) {
		this.followingUserIdx = followingUserIdx;
	}
	
	public Following(int userIdx, int followingUserIdx) {
		this.userIdx = userIdx;
		this.followingUserIdx = followingUserIdx;
	}
	
	public Following() {
	}
	
	@Override
	public String toString() {
		return "Following [userIdx=" + userIdx + ", followingUserIdx=" + followingUserIdx + "]";
	}
	
	
	
}
