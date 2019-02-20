package com.bitcamp.openp.model;

public class Member {

	private int id;
	private String email;
	private String encpw;
	private String name;
	private String photo;
	private String enccode;
	private String emailchk;

	
	public Member() {
		
	}
		
	public Member(int id, String email, String encpw, String name, String photo, String enccode, String emailchk) {
		this.id = id;
		this.email = email;
		this.encpw = encpw;
		this.name = name;
		this.photo = photo;
		this.enccode = enccode;
		this.emailchk = emailchk;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEnccode() {
		return enccode;
	}

	public void setEnccode(String enccode) {
		this.enccode = enccode;
	}

	public String getEmailchk() {
		return emailchk;
	}

	public void setEmailchk(String emailchk) {
		this.emailchk = emailchk;
	}


	public String getEncpw() {
		return encpw;
	}

	public void setEncpw(String encpw) {
		this.encpw = encpw;
	}

	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", encpw=" + encpw + ", name=" + name + ", photo=" + photo
				+ ", enccode=" + enccode + ", emailchk=" + emailchk + "]";
	}

	
	
}
