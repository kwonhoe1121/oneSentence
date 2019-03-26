package com.one.sentence.common.vo;

import java.util.List;

public class OneSentence {

	private int oneSentenceIdx;
	private String oneSentence;
	private String page;
	private String oneSentenceRegisteredTime;
	private int userIdx;
	private String isbn;
	private List<OneSentence> oneSentenceList;

	public OneSentence() {}
	public OneSentence(String oneSentence, String page, int userIdx, String isbn) {
		this.oneSentence = oneSentence;
		this.page = page;
		this.userIdx = userIdx;
		this.isbn = isbn;
	}

	public OneSentence(int oneSentenceIdx, String oneSentence, String page, String oneSentenceRegisteredTime,
			int userIdx, String isbn) {
		this.oneSentenceIdx = oneSentenceIdx;
		this.oneSentence = oneSentence;
		this.page = page;
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
		this.userIdx = userIdx;
		this.isbn = isbn;
	}


	public int getOneSentenceIdx() {
		return oneSentenceIdx;
	}

	public void setOneSentenceIdx(int oneSentenceIdx) {
		this.oneSentenceIdx = oneSentenceIdx;
	}

	public String getOneSentence() {
		return oneSentence;
	}

	public void setOneSentence(String oneSentence) {
		this.oneSentence = oneSentence;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getOneSentenceRegisteredTime() {
		return oneSentenceRegisteredTime;
	}

	public void setOneSentenceRegisteredTime(String oneSentenceRegisteredTime) {
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<OneSentence> getOneSentenceList() {
		return oneSentenceList;
	}

	public void setOneSentenceList(List<OneSentence> oneSentenceList) {
		this.oneSentenceList = oneSentenceList;
	}

	@Override
	public String toString() {
		return "OneSentence [oneSentenceIdx=" + oneSentenceIdx + ", oneSentence=" + oneSentence + ", page=" + page
				+ ", oneSentenceRegisteredTime=" + oneSentenceRegisteredTime + ", userIdx=" + userIdx + ", isbn=" + isbn
				+ "]";
	}

}
