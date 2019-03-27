package com.one.sentence.userpage.dao;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.following.model.Following;

interface IUserPageDao {
	public UserVo selectUser_infoByuserIdx(int userIdx);
	public int selectTheNumberOfSentences();
	public int selectTheNumberOfSentencesByUserIdx(int userIdx);
	public Following selectFollower(Following following);	
}