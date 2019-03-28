package com.one.sentence.onesentence.dao;


import java.util.List;

import com.one.sentence.common.vo.Hashtag;
import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

public interface IOnesentenceDao {
 
	public int insertOneSentence(OneSentence onesentence);
	public void insertNewSentence(String oneSentence, int page,int userIdx, String isbn, String bookTitle,String bookGenre,String author, String publisher,String hashtag1, String hashtag2, String hashtag3); //프로시져
	public List<ShowOnesentence> selectOnesentenceList();
	public List<ShowOnesentence> selectOnesentenceListByuserIdx(int userIdx);
	public List<ShowOnesentence> selectOnesentenceListForLiketo(int userIdx);
	public List<ShowOnesentence> selectOnesentenceListByIsbn(String isbn);  
	public List<ShowOnesentence> selectOnesentenceListByHashtag(String hashtag);
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnMy(int userIdx, String isbn);
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnFollowing(int userIdx, String isbn);
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOther(int userIdx1,int userIdx2, String isbn);
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOtherNoFollwing(int userIdx, String isbn);
	
	public ShowOnesentence selectOnesentenceByoneSentenceIdx(int oneSentenceIdx);
	public OneSentence selectOnesentenceModel(int oneSentenceIdx);
	public int updateOneSentence(int oneSentenceIdx,String oneSentence, String page, String isbn);
	public int deleteOnesentence(int oneSentenceIdx);
	
	public int insertBook(Book book);
	public int selectBookByisbn(String isbn);
	public String selectBookTitleByisbn(String isbn);
	
	public int upUserPoint(int userIdx);
	public int downUserPoint(int userIdx);
	
	public int insertHashtag(Hashtag tag);
	public int findOneSentenceIdx(int userIdx, String isbn, String oneSentence);
	public List<String> selectHashtagList(int oneSentenceIdx);
	
	public int selectLikeTotal(int oneSentenceIdx);
}
