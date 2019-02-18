package com.hoe.openPjt.dto;

//커맨드 객체는 1:1 맵핑.
public class Member {

	private int altKey; // not null - 대리키를 커맨드 객체에 넣을 필요가 있을까? 따로 마지막에 추가해주면?- 그냥 db에서 auto increment
						// 하면?
	private String email;// not null
	private int password; // not null
	private String name;// not null
	private String photo;
	

	public int getAltKey() {
		return altKey;
	}

	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "Member [altkey=" + altKey + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", photo=" + photo + "]";
	}

}
