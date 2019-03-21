package com.one.sentence.onesentence.service;

import java.util.List;

import com.one.sentence.common.vo.Hashtag;
import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

public interface IOnesentenceService {
	public void makeOneSentence(OneSentence onesentence);
	public List<ShowOnesentence> showOneSentenceList();
	public List<ShowOnesentence> showOneSentenceListByuserIdx(int userIdx);
	public List<ShowOnesentence> showOneSentenceListByIsbn(String isbn);
	public List<ShowOnesentence> showOneSentenceListForLiketo(int userIdx); 
	public List<ShowOnesentence> showOnesentenceListByHashtag(String hashtag);
	public ShowOnesentence showOneSentenceByoneSentenceIdx(int oneSentenceIdx);
	public OneSentence showOneSentenceModel(int oneSentenceIdx);
	
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnMy(int userIdx, String isbn);
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnFollowing(int userIdx, String isbn);
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOther(int userIdx1,int userIdx2, String isbn);
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOtherNoFollwing(int userIdx,String isbn);
	
	 
	public void changeOneSentence(int oneSentenceIdx, String oneSentence, String page, String isbn);
	public int removeOneSentence(int oneSentenceIdx);
	
	public void makeBook(Book book); 
	public int showBookByisbn(String isbn);
	
	public void upUserPoint(int userIdx);
	public void downUserPoint(int userIdx);
	
	public void makeHashtag(Hashtag tag);
	public int findOneSentenceIdx(int userIdx, String isbn, String oneSentence);
	public List<String> showHashtagList(int oneSentenceIdx);
	
	public int showLikeTotal(int oneSentenceIdx);
	
}
