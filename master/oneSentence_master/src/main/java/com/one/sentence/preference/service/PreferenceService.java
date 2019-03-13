package com.one.sentence.preference.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.preference.dao.HashtagDao;

@Service
public class PreferenceService implements IPreferenceService{

	@Autowired
	private HashtagDao dao;
	
	@Override
	public List<String> genrePreference(int userIdx) {
		return dao.selectHashtagList(userIdx);
	}


	
}
