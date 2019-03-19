package com.one.sentence.onesentence.model;

import java.util.Date;

public class ShowOnesentence {
	private int userIdx; // 占쏙옙占쏙옙占� 占쏙옙占쏙옙
	private String userName;
	private int oneSentenceIdx;
	private String oneSentence;
	private String page;
	private Date oneSentenceRegisteredTime;
	private String isbn; // 占쏙옙占쏙옙占� 占쏙옙占쏙옙
	private String bookTitle;
	private String author;
	private String publisher;
	private String hashtag;
	private int likeTotal;

	public ShowOnesentence() {
	}

	
	public ShowOnesentence(int userIdx, String userName, int oneSentenceIdx, String oneSentence, String page,
			Date oneSentenceRegisteredTime, String isbn, String bookTitle, String author, String publisher) {
		this.userIdx = userIdx;
		this.userName = userName;
		this.oneSentenceIdx = oneSentenceIdx;
		this.oneSentence = oneSentence;
		this.page = page;
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
	}


	public ShowOnesentence(int userIdx, String userName, int oneSentenceIdx, String oneSentence, String page,
			Date oneSentenceRegisteredTime, String isbn, String bookTitle, String author, String publisher, String hashtag,
			int likeTotal) {
		this.userIdx = userIdx;
		this.userName = userName;
		this.oneSentenceIdx = oneSentenceIdx;
		this.oneSentence = oneSentence;
		this.page = page;
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.hashtag = hashtag;
		this.likeTotal = likeTotal;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public int getLikeTotal() {
		return likeTotal;
	}

	public void setLikeTotal(int likeTotal) {
		this.likeTotal = likeTotal;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getOneSentenceRegisteredTime() {
		return oneSentenceRegisteredTime;
	}

	public void setOneSentenceRegisteredTime(Date oneSentenceRegisteredTime) {
		this.oneSentenceRegisteredTime = oneSentenceRegisteredTime;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getOneSentenceIdx() {
		return oneSentenceIdx;
	}

	public void setOneSentenceIdx(int oneSentenceIdx) {
		this.oneSentenceIdx = oneSentenceIdx;
	}

	@Override
	public String toString() {
		return "ShowOnesentence [userIdx=" + userIdx + ", userName=" + userName + ", oneSentenceIdx=" + oneSentenceIdx
				+ ", oneSentence=" + oneSentence + ", page=" + page + ", oneSentenceRegisteredTime="
				+ oneSentenceRegisteredTime + ", isbn=" + isbn + ", bookTitle=" + bookTitle + ", author=" + author
				+ ", publisher=" + publisher + ", hashtag=" + hashtag + ", likeTotal=" + likeTotal + "]";
	}

}
