package com.one.sentence.preference.service;

import java.util.List;

import com.one.sentence.common.vo.UserVo;


interface IPreferenceService {
	public List<String> userPreference(int userIdx);	
	public UserVo showUser_infoByuserIdx(int userIdx);
	public int countSentenceByUserIdx(int userIdx);
	public int countAllUsers();
	public int selectUserRank(int userIdx);
}
