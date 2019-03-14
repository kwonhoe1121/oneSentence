package com.one.sentence.search.model;

import java.util.Date;

public class SearchHashtagModel {
	private String userName;
	private String oneSentence;
	private String page;
	private Date oneSentenceRegisteredTime;
	private int isbn; 
	private String bookTitle;
	private String author;
	private String publisher;

	
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
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
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
	
	@Override
	public String toString() {
		return "한문장 [닉네임=" + userName + ", 한문장=" + oneSentence + ", page=" + page
				+ ", 작성시간=" + oneSentenceRegisteredTime + ", 제목="
				+ bookTitle + ", 저자=" + author + ", 출판사=" + publisher + "]";
	}
	

	
	
	
	
	
	

	
	
	
}
