package com.one.sentence.register.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.one.sentence.common.service.SecurityService;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.register.service.RegisterService;

@Controller
@SessionAttributes("UserVo")
public class RegisterController {

	@Inject
	private RegisterService service;

	@Inject
	SecurityService securityService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String requestRegisterForm(HttpSession session, @RequestHeader String referer) {

		System.out.println("referer: " + referer);

		session.setAttribute("referer", referer);

		return "register";
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String requestRegistration(UserVo user, Model model, HttpSession session)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		System.out.println(user + "등록 전");

		// id, pwd 암호화.
		user = securityService.encryptUserInfo(user);

		System.out.println("암호화 이후 유저 정보: " + user);

		// 유저 등록.
		if (service.registerUser(user) != -1) {
			service.registerUser(user);
			System.out.println("회원가입 완료!");
//			session.setAttribute("complete", true);
			// 자동로그인
//			session.setAttribute("User", user);
			return "index";
		}

		System.out.println(user + "return 전");
		return "register";
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String tempMethod() {
//		return "/main";
//	}

	// 이메일 중복 체크 확인.
	@RequestMapping("/emailCheck")
	@ResponseBody
	public Map<Object, Object> checkOverrapedEmail(@RequestBody String email) {

		Map<Object, Object> map = new HashMap<>();
		boolean chekUser = service.isUser(email);
		map.put("chekUser", chekUser);

		return map;
	}

	// 회원탈퇴
//	@RequestMapping("/user")
//	public String 

}
