//package com.one.sentence.register.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.security.GeneralSecurityException;
//import java.security.NoSuchAlgorithmException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.inject.Inject;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.one.sentence.common.service.SecurityService;
//import com.one.sentence.common.vo.UserVo;
//import com.one.sentence.register.service.RegisterService;
//
//@RestController
//public class RegisterRestController {
//
//	@Inject
//	RegisterService service;
//	
//	@Inject
//	SecurityService securityService;
//
//	// 로그인 focusing out 방식으로 행하는 것.
////	@PostMapping("/users/emailCheck")
////	@ResponseBody
////	public Map<String, String> restEmailChek(@RequestBody UserVo inputUser) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
////		Map<String, String> map = new HashMap<>();
////
////		System.out.println(inputUser);
////
////		// 암호화
////		String encrytUserEmail = securityService.encryptUserEmail(inputUser.getUserEmail());
////
////		if (inputUser.getUserEmail().equals("")) {
//////			map.put("emailCheck", "이메일을 입력하세요");
////			return map;
////		}
////
////		// 유저 확인
////		if (!service.isUser(encrytUserEmail)) {
////			map.put("emailCheck", "이메일이 틀렸습니다.");
////			map.put("overrapedEmail", "이메일 사용 가능합니다.");
////			return map;
////		}
////
//////		map.put("emailCheck", "이메일 일치");
//////		map.put("overrapedEmail", "이메일 중복입니다.!");
////		return map;
////	}
//
////	@PostMapping("/users/registerCheck")
////	@ResponseBody
////	public Map<String, String> requestRegister(@RequestBody UserVo inputUser) {
////
////		Map<String, String> map = new HashMap<>();
////		System.out.println(inputUser);
////		// email 중복 체크
////		if (!service.isUser(inputUser.getUserEmail())) {
////	
////			service.registerUser(inputUser);
//////			map.put("emailCheck", "회원가입 완료 되었습니다.");
////
////			return map;
////		}
////
////		map.put("emailCheck", "이메일이 중복됩니다.");
////
////		return map;
////	}
//}
