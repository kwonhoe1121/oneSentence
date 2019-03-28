package com.one.sentence.onesentence.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.Hashtag;
import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.onesentence.dao.OnesentenceDao;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.ShowOnesentence;

@Service
public class OnesentenceService implements IOnesentenceService {

	@Inject
	private OnesentenceDao dao;
	
	@Override
	public void makeOneSentence(OneSentence onesentence) {
		dao.insertOneSentence(onesentence);
	}
 
	@Override
	public List<ShowOnesentence> showOneSentenceList() {
		return dao.selectOnesentenceList();
		
	}

	@Override
	public List<ShowOnesentence> showOneSentenceListByuserIdx(int userIdx) {
		return dao.selectOnesentenceListByuserIdx(userIdx);
		
	}

	
	@Override
	public List<ShowOnesentence> showOneSentenceListForLiketo(int userIdx) {
		return dao.selectOnesentenceListForLiketo(userIdx);
		
	}
	
	@Override
	public ShowOnesentence showOneSentenceByoneSentenceIdx(int oneSentenceIdx) {
		return dao.selectOnesentenceByoneSentenceIdx(oneSentenceIdx);
	}
	@Override
	public OneSentence showOneSentenceModel(int oneSentenceIdx) {
		return dao.selectOnesentenceModel(oneSentenceIdx);
	}

	@Override
	public void changeOneSentence(int oneSentenceIdx,String oneSentence, String page, String isbn) {
		System.out.println(isbn);
	
		dao.updateOneSentence(oneSentenceIdx,oneSentence,page,isbn);
		
	}

	@Override
	public int removeOneSentence(int oneSentenceIdx) {
		return dao.deleteOnesentence(oneSentenceIdx);
		
	}

	@Override
	public void makeBook(Book book) {
		dao.insertBook(book);
		
	}

	@Override
	public int showBookByisbn(String isbn) {
		return dao.selectBookByisbn(isbn);
	}

	@Override
	public void upUserPoint(int userIdx) {
		dao.upUserPoint(userIdx);
		
	}

	@Override
	public void downUserPoint(int userIdx) {
		dao.downUserPoint(userIdx);
		
	}

	@Override
	public void makeHashtag(Hashtag tag) {
		dao.insertHashtag(tag);
		
	}

	@Override
	public int findOneSentenceIdx(int userIdx, String isbn, String oneSentence) {
		return dao.findOneSentenceIdx(userIdx, isbn, oneSentence);
	}

	@Override
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnMy(int userIdx, String isbn) {
		return dao.selectOnesentenceByoneSentenceIdxAndIsbnMy(userIdx, isbn);
	}

	@Override
	public ShowOnesentence selectOnesentenceByoneSentenceIdxAndIsbnFollowing(int userIdx, String isbn) {
		return dao.selectOnesentenceByoneSentenceIdxAndIsbnFollowing(userIdx, isbn);
	}

	@Override
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOther(int userIdx1, int userIdx2,
			String isbn) {
		return dao.selectOnesentenceListByoneSentenceIdxAndIsbnOther(userIdx1, userIdx2, isbn);
	}

	@Override
	public List<String> showHashtagList(int oneSentenceIdx) {
		return dao.selectHashtagList(oneSentenceIdx);
	}

	@Override
	public int showLikeTotal(int oneSentenceIdx) {
		return dao.selectLikeTotal(oneSentenceIdx);
	}

	@Override
	public List<ShowOnesentence> showOneSentenceListByIsbn(String isbn) {
		return dao.selectOnesentenceListByIsbn(isbn);
	}



	@Override
	public List<ShowOnesentence> showOnesentenceListByHashtag(String hashtag) {
		// TODO Auto-generated method stub
		return dao.selectOnesentenceListByHashtag(hashtag);
	}

	@Override
	public List<ShowOnesentence> selectOnesentenceListByoneSentenceIdxAndIsbnOtherNoFollwing(int userIdx, String isbn) {
		// TODO Auto-generated method stub
		return dao.selectOnesentenceListByoneSentenceIdxAndIsbnOtherNoFollwing(userIdx, isbn);
	}

	@Override
	public String showBookTitleByisbn(String isbn) {
		// TODO Auto-generated method stub
		return dao.selectBookTitleByisbn(isbn);
	}

	@Override
	public void makeNewSentence(String oneSentence, int page, int userIdx, String isbn, String bookTitle,
			String bookGenre, String author, String publisher, String hashtag1, String hashtag2, String hashtag3) {
		dao.insertNewSentence(oneSentence, page, userIdx, isbn, bookTitle, bookGenre, author, publisher, hashtag1, hashtag2, hashtag3);
	}

}
