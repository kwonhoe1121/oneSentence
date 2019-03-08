package com.bitcamp.rest;

import java.util.Date;

public class GuestMessage2 {

	private String id;
	private String message;
	private Date creationTime;
	

	public GuestMessage2(String id, String message, Date creationTime) {
		this.id = id;
		this.message = message;
		this.creationTime = creationTime;
	}
	
	public GuestMessage2() {
		
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	
	
	@Override
	public String toString() {
		return "GuestMessage2 [id=" + id + ", message=" + message + ", creationTime=" + creationTime + "]";
	}
	
	
	
	
}
