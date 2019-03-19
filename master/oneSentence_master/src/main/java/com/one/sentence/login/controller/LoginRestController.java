package com.one.sentence.login.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.one.sentence.common.service.SecurityService;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.login.service.LoginService;

@RestController
public class LoginRestController {

	@Inject
	LoginService service;

	@Inject
	SecurityService securityService;

	// 로그인 focusout 방식으로 mapping 하는 방식.
	@PostMapping("/users/emailCheck")
	@ResponseBody
	public Map<String, String> restEmailCheck(@RequestBody UserVo inputUser)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {

		Map<String, String> map = new HashMap<>();

		System.out.println(inputUser);

		// 암호화
		String encrytUserEmail = securityService.encryptUserEmail(inputUser.getUserEmail());

		if (inputUser.getUserEmail().equals("")) {
//			map.put("emailCheck", "이메일을 입력하세요");
			return map;
		}

		// 유저 확인
		if (!service.isUser(encrytUserEmail)) {
			map.put("emailCheck", "이메일이 틀렸습니다.");
//			map.put("overrapedEmail", "이메일 사용 가능합니다.");
			return map;
		}

//		map.put("emailCheck", "이메일 일치");
		map.put("overrapedEmail", "이메일 중복입니다.");
		return map;
	}

	@PostMapping("/users/pwdCheck")
	@ResponseBody
	public Map<String, String> restPwdCheck(@RequestBody UserVo inputUser)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		Map<String, String> map = new HashMap<>();

		System.out.println(inputUser);

		// 유저 정보 암호화
		UserVo encrytedUser = securityService.encryptUserInfo(inputUser);

		if (inputUser.getUserPassword().equals("")) {
//			map.put("passwordCheck", "비밀번호를 입력하세요!");
			return map;
		}

		// 등록된 유저 패스워드와 요청 패스워드 비교.
		if (!encrytedUser.getUserPassword().equals(service.selectUser(encrytedUser.getUserEmail()).getUserPassword())) {
			map.put("passwordCheck", "비밀번호가 틀립니다.");
			return map;
		}

//		map.put("passwordCheck", "비밀번호가 일치합니다.");
		return map;
	}

//	@PostMapping("/users/login")
//	@ResponseBody
//	public List<Map<String, String>> restLogin(@RequestBody UserVo inputUser) {
//
//		System.out.println("ajax 요청 시작!");
//		System.out.println(inputUser);
//		List<Map<String, String>> list = new ArrayList<>();
//		Map<String, String> map = new HashMap<String, String>();
//		// id 일치여부 확인
//		if (!service.isUser(inputUser.getUserEmail())) {
//			map.put("loginMessage", "아이디를 잘 못 입력하셨습니다.");
//			list.add(map);
//			return list;
//		}
//		// pwd 일치여부 확인
//		if (!inputUser.getUserPassword().equals(service.selectUser(inputUser.getUserEmail()).getUserPassword())) {
//			map.put("loginMessage", "비밀번호를 잘 못 입력하셨습니다.");
//			list.add(map);
//			return list;
//		}
//
//		map.put("loginMessage", "로그인 완료!");
//		list.add(map);
//		return list;
//	}

}
