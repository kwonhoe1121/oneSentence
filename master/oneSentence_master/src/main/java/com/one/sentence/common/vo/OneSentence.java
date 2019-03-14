package com.one.sentence.common.vo;

public class OneSentence {

	private int oneSentenceIdx;
	private String oneSentence;
	private String page;
	private String oneSentenceRegisteredTime;
	private int userIdx;
	private int isbn;

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

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "OneSentence [oneSentenceIdx=" + oneSentenceIdx + ", oneSentence=" + oneSentence + ", page=" + page
				+ ", oneSentenceRegisteredTime=" + oneSentenceRegisteredTime + ", userIdx=" + userIdx + ", isbn=" + isbn
				+ "]";
	}

}
