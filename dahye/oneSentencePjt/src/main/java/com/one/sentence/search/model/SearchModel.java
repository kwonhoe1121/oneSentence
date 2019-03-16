package com.one.sentence.search.model;

public class SearchModel {

	public String cover;
	public String title;
	public String publisher;
	public String author;
	public String isbn;
	public String categoryName;
	public String pubDate;
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	@Override
	public String toString() {
		return "SearchModel [cover=" + cover + ", title=" + title + ", publisher=" + publisher + ", author=" + author
				+ ", isbn=" + isbn + ", categoryName=" + categoryName + ", startIndex=" + pubDate + "]";
	}

	
	
	
	
	
}
