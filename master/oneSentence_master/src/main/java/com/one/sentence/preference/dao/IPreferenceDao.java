package com.one.sentence.preference.dao;

import java.util.List;

import com.one.sentence.common.vo.UserVo;

interface IPreferenceDao {
	public List<String> selectHashtagListByPreference(int userIdx);
	public UserVo selectUser_infoByuserIdx(int userIdx);
	public int countSentenceByUserIdx(int userIdx);
	public int countAllUsers();	
	public int selectUserRank(int userIdx);
}