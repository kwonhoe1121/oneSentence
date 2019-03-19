package com.one.sentence.search.service;

import java.util.List;

import com.one.sentence.common.vo.UserVo;

public interface ISearchUserService {

	public List<String> selectUserList(String query);
	public List<UserVo> selectUserByUserName(String query);
}
