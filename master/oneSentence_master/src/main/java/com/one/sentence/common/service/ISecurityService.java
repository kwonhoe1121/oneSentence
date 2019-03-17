package com.one.sentence.common.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import com.one.sentence.common.vo.UserVo;

public interface ISecurityService {

	//암호화 메서드
	public UserVo encryptUserInfo(UserVo user) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException;
	public String encryptUserEmail(String userEmail) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException;
	public String encryptUserPassword(String userPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException;
	
	//복호화 메서드
	public UserVo decryptUserInfo(UserVo user) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException;
	public String decryptUserEmail(String userEmail) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException;
	public String decryptUserPassword(String userPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException;
}
