package com.one.sentence.userpage.dao;

import com.one.sentence.common.vo.UserVo;

interface IUserPageDao {
	public UserVo selectUser_infoByuserIdx(int userIdx);
	
}