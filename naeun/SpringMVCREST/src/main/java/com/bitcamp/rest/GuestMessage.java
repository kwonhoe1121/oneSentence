package com.bitcamp.rest;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"id", "message", "creationTime"})
public class GuestMessage {

	private String id;
	private String message;
	private Date creationTime;
	

	public GuestMessage(String id, String message, Date creationTime) {
		this.id = id;
		this.message = message;
		this.creationTime = creationTime;
	}
	
	public GuestMessage() {
		
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
		return "GuestMessage [id=" + id + ", message=" + message + ", creationTime=" + creationTime + "]";
	}
	
	
	
	
}
