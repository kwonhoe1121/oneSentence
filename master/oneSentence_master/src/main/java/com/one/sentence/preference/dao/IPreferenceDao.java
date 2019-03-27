package com.one.sentence.preference.dao;

import java.util.List;

import com.one.sentence.common.vo.UserVo;

interface IPreferenceDao {
	public List<String> selectHashtagListByPreference(int userIdx);
	public UserVo selectUser_infoByuserIdx(int userIdx);
	public int selectTheNumberOfSentencesByUserIdx(int userIdx);
	public int selectTheNumberOfUsers();	
	public int selectUserRank(int userIdx);
}