package com.one.sentence.chatting.model;

public class OldChatting {
	private String isbn;
	private String userName;
	private String message;
	private String time;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "OldChatting [isbn=" + isbn + ", userName=" + userName + ", message=" + message + ", time=" + time + "]";
	}
}
