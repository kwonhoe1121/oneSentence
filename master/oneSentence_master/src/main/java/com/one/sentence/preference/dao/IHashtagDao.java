package com.one.sentence.preference.dao;

import java.util.List;


interface IHashtagDao {
	
	public List<String> selectHashtagList(int userIdx);
	
}