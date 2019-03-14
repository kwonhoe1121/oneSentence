package com.one.sentence.common.vo;

import java.util.Date;

public class UserVo {

	private int userIdx;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String checkCode;
	private String emailStatus;
	private int userPoint;
	private Date userRegisteredTime;
	private String userIntroduction;

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

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public Date getUserRegisteredTime() {
		return userRegisteredTime;
	}

	public void setUserRegisteredTime(Date userRegisteredTime) {
		this.userRegisteredTime = userRegisteredTime;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	@Override
	public String toString() {
		return "UserVo [userIdx=" + userIdx + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", checkCode=" + checkCode + ", emailStatus=" + emailStatus
				+ ", userPoint=" + userPoint + ", userRegisteredTime=" + userRegisteredTime + ", userIntroduction="
				+ userIntroduction + "]";
	}

	

}
