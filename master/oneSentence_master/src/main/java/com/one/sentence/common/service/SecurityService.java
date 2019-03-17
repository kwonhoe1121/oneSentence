package com.one.sentence.common.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.one.sentence.common.vo.Aes256;
import com.one.sentence.common.vo.UserVo;

@Service
public class SecurityService implements ISecurityService {

	@Inject
	private Aes256 aes256;

	@Override
	public UserVo encryptUserInfo(UserVo user)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {

		String encUserEmail = aes256.encrypt(user.getUserEmail());
		String encUserPassword = aes256.encrypt(user.getUserPassword());

		user.setUserEmail(encUserEmail);
		user.setUserPassword(encUserPassword);

		return user;
	}

	@Override
	public UserVo decryptUserInfo(UserVo user)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {

		String decryptUserEmail = aes256.decrypt(user.getUserEmail());
		String decryptUserPassword = aes256.decrypt(user.getUserPassword());

		user.setUserEmail(decryptUserEmail);
		user.setUserPassword(decryptUserPassword);

		return user;
	}

	@Override
	public String encryptUserEmail(String userEmail)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		String encUserEmail = aes256.encrypt(userEmail);
		return encUserEmail;
	}

	@Override
	public String decryptUserEmail(String userEmail)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		String decryptUserEmail = aes256.decrypt(userEmail);
		return decryptUserEmail;
	}

	@Override
	public String encryptUserPassword(String userPassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		String encUserPassword = aes256.encrypt(userPassword);
		return encUserPassword;
	}

	@Override
	public String decryptUserPassword(String userPassword)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		String decryptUserPassword = aes256.decrypt(userPassword);
		return decryptUserPassword;
	}

}
