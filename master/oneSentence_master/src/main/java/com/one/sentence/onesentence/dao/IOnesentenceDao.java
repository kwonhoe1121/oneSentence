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
	public List<ShowOnesentence> selectOnesentenceListByIsbn(long isbn);  
	public List<ShowOnesentence> selectOnesentenceListByIsbnWithoutlike(long isbn);
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnMy(int userIdx, long isbn);
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnFollowing(int userIdx, long isbn);
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOther(int userIdx1,int userIdx2, long isbn);
	
	public ShowOnesentence selectOnesentenceByoneSentenceIdx(int oneSentenceIdx);
	public OneSentence selectOnesentenceModel(int oneSentenceIdx);
	public int updateOneSentence(int oneSentenceIdx,String oneSentence, String page, long isbn);
	public int deleteOnesentence(int oneSentenceIdx);
	
	public int insertBook(Book book);
	public Book selectBookByisbn(long isbn);
	
	public int upUserPoint(int userIdx);
	public int downUserPoint(int userIdx);
	
	public int insertHashtag(Hashtag tag);
	public int findOneSentenceIdx(int userIdx, long isbn, String oneSentence);
	public List<String> selectHashtagList(int oneSentenceIdx);
	
	public int selectLikeTotal(int oneSentenceIdx);
}
