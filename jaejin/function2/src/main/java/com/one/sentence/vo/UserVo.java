package com.one.sentence.vo;

public class UserVo {

	private int userIdx;
	private String userEmail;
	private String userPassword;
	private String userName;

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userIdx=" + userIdx + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + "]";
	}

}
