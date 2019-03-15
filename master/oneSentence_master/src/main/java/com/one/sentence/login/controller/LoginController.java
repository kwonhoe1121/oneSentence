package com.one.sentence.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.login.service.LoginService;

@Controller
public class LoginController {

	@Inject
	LoginService service;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String requestLoginForm(@RequestHeader String referer, HttpSession session) {
		
		System.out.println("referer: " + referer);
		//로그인 성공하면 이전 페이지로 이동하기위함.
		session.setAttribute("referer", referer);
		
		return "login";
	}
	
	// 세션 유무체크 interceptor에서 처리
	// 로그인 안되어 있는 상태에서 아래 작업 수행
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String requestLogin(HttpSession session, Model model, @RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword, @RequestHeader String referer) {
		System.out.println("로그인체크: " + userEmail + " " + userPassword);
		// 이메일 체크
		if (!service.isUser(userEmail)) {
			model.addAttribute("isNotUser", "회원이 아닙니다.");
			System.out.println("등록된 이메일 없음.");
			return "login";
		}

		// 유저 정보 가져오기.
		UserVo user = service.selectUser(userEmail);

		// 비밀번호 체크
		if (!userPassword.equals(user.getUserPassword())) {
			model.addAttribute("isNotPassword", "비밀번호가 다릅니다.");
			System.out.println("비밀번호 불일치!");
			return "login";
		}

		// 로그인 완료
		
		//viewpage 에서 nav 창 바꾸는데에 사용한다.
//		model.addAttribute("User", user);
		System.out.println("로그인 완료");
//		System.out.println(referer);
//		model.addAttribute("referer", referer);
		session.setAttribute("User", user);
		return "login";
	}

	// 로그아웃 controller
	@RequestMapping("user/logout")
	public String requestLogout(HttpSession session) {

		// 세션 종료.
		session.invalidate();
		System.out.println("로그아웃!");
		return "login";
	}

}
