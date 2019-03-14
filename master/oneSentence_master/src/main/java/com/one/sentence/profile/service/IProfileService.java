package com.one.sentence.profile.service;

import com.one.sentence.common.vo.UserVo;

public interface IProfileService {
	public UserVo showUser_infoByuserIdx(int userIdx);
	public void changeUser_info(int userIdx,String userPassword, String userName, String userIntroduction);
	
}
