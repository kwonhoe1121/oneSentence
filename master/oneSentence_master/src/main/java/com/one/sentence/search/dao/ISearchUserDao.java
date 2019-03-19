package com.one.sentence.search.dao;

import java.util.List;

import com.one.sentence.common.vo.UserVo;

interface ISearchUserDao {

	public List<String> selectUserList(String userName);	
	public List<UserVo> selectUserByUserName(String userName);
}