package com.one.sentence.profile.dao;

import com.one.sentence.common.vo.UserVo;

public interface IProfileDao {
	public UserVo selectUser_infoByuserIdx(int userIdx);
	public int updateUser_info(int userIdx,String userPassword, String userName, String userIntroduction);
}
