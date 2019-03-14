package com.one.sentence.onesentence.dao;


import java.util.List;

import com.one.sentence.common.vo.Hashtag;
import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

public interface IOnesentenceDao {
 
	public int insertOneSentence(OneSentence onesentence);
	public List<ShowOnesentence> selectOnesentenceList();
	public List<ShowOnesentence> selectOnesentenceListByuserIdx(int userIdx);
	public List<ShowOnesentence> selectOnesentenceListForLiketo(int userIdx);
	
	public ShowOnesentence selectOnesentenceByoneSentenceIdx(int oneSentenceIdx);
	public OneSentence selectOnesentenceModel(int oneSentenceIdx);
	public int updateOneSentence(int oneSentenceIdx,String oneSentence, String page, int isbn);
	public int deleteOnesentence(int oneSentenceIdx);
	
	public int insertBook(Book book);
	public Book selectBookByisbn(int isbn);
	
	public int upUserPoint(int userIdx);
	public int downUserPoint(int userIdx);
	
	public int insertHashtag(Hashtag tag);
	public int findOneSentenceIdx(int userIdx, int isbn, String oneSentence);
}
