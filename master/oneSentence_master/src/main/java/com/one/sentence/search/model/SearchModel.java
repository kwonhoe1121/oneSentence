package com.one.sentence.search.model;

public class SearchModel {

	public String cover;
	public String title;
	public String publisher;
	public String author;
	public String isbn;
	public String categoryName;
	public String pubDate;
	public String description;
	public String fulldescription;
	public String toc;
	public int itemPage;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFulldescription() {
		return fulldescription;
	}
	public void setFulldescription(String fulldescription) {
		this.fulldescription = fulldescription;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public int getItemPage() {
		return itemPage;
	}
	public void setItemPage(int itemPage) {
		this.itemPage = itemPage;
	}
	
	@Override
	public String toString() {
		return "SearchModel [cover=" + cover + ", title=" + title + ", publisher=" + publisher + ", author=" + author
				+ ", isbn=" + isbn + ", categoryName=" + categoryName + ", pubDate=" + pubDate + ", description="
				+ description + ", fulldescription=" + fulldescription + ", toc=" + toc + ", itemPage=" + itemPage
				+ "]";
	}
	
	
	
	

	
	
	

	
	
	
	
	
	
}
