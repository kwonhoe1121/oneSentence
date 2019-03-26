package com.one.sentence.onesentence.model;

public class Book {
	private String isbn;
	private String bookTitle;
	private String bookGenre;
	private String author;
	private String publisher; 
	
	public Book() {}
	
	public Book(String isbn, String bookTitle, String bookGenre, String author, String publisher) {
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.bookGenre = bookGenre;
		this.author = author;
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
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
		return "Book [isbn=" + isbn + ", bookTitle=" + bookTitle + ", bookGenre=" + bookGenre + ", author=" + author
				+ ", publisher=" + publisher + "]";
	} 
	
	
	
}
