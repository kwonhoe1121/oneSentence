package com.one.sentence.userpage.service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.following.model.Following;


interface IUserPageService {	
	public UserVo showUser_infoByuserIdx(int userIdx);
	public int countAllSentences();
	public int countSentenceByUserIdx(int userIdx);
	public Following checkFollowingState(Following following);	
}
