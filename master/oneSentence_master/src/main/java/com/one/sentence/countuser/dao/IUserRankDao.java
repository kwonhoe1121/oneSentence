package com.one.sentence.countuser.dao;

interface IUserRankDao {
	public int countAllUsers();	
	public int selectUserRank(int userIdx);
}