package com.one.sentence.countsentence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.sentence.countsentence.dao.CountSentenceDao;

@Service
public class CountSentenceService implements ICountSentenceService {

	@Autowired
	private CountSentenceDao dao;

	@Override
	public int countAllSentences() {
		return dao.countAllSentences();
	}




	
}
