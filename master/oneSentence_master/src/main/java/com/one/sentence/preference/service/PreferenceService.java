package com.one.sentence.preference.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.preference.dao.PreferenceDao;

@Service
public class PreferenceService implements IPreferenceService{

	@Autowired
	private PreferenceDao dao;
	
	@Override
	public List<String> userPreference(int userIdx) {
		return dao.selectHashtagListByPreference(userIdx);
	}

	@Override
	public UserVo showUser_infoByuserIdx(int userIdx) {
		return dao.selectUser_infoByuserIdx(userIdx);
	}
	
	@Override
	public int countSentenceByUserIdx(int userIdx) {
		return dao.selectTheNumberOfSentencesByUserIdx(userIdx);
	}
	
	@Override
	public int countAllUsers() {
		return dao.selectTheNumberOfUsers();
	}

	@Override
	public int selectUserRank(int userIdx) {
		return dao.selectUserRank(userIdx);
	}
	
}
