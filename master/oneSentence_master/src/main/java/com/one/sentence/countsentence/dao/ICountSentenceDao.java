package com.one.sentence.countsentence.dao;

interface ICountSentenceDao {
	public int countAllSentences();
	public int countSentenceByUserIdx(int userIdx);
}