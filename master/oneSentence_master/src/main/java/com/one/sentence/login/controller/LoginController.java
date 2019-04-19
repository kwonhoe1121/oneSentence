package com.one.sentence.login.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.sentence.common.service.SecurityService;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.kakaologin.controller.KakaoLoginController;
import com.one.sentence.login.service.LoginService;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Inject
	private LoginService service;

	@Inject
	private SecurityService securityService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String requestLoginForm(@RequestHeader String referer, HttpSession session) {

		logger.debug("referer(/login): {}", referer);
		// 로그인 성공하면 이전 페이지로 이동하기위함.
		session.setAttribute("referer", referer);

		return "login";
	}

	// 세션 유무체크 interceptor에서 처리
	// 로그인 안되어 있는 상태에서 아래 작업 수행
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String requestLogin(HttpSession session, UserVo user)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		logger.debug("로그인체크: {} {}", user.getUserEmail(), user.getUserPassword());

		// user 정보 암호화- 입력 파라미터를 UserVo로 바꾸자.
		UserVo encrytInputUser = securityService.encryptUserInfo(user);
		logger.debug("암호화된 유저 정보: {}", encrytInputUser);
		logger.debug("isUser: {}", service.isUser(encrytInputUser.getUserEmail()));
		// 이메일 체크
		if (!service.isUser(encrytInputUser.getUserEmail())) {
			logger.debug("등록된 이메일 없음.");
			return "login";
		}

		// 유저 정보 가져오기.
		UserVo registeredUser = service.selectUser(encrytInputUser.getUserEmail());
		logger.debug("registeredUser: {}", registeredUser);

		// 비밀번호 체크
		if (!encrytInputUser.getUserPassword().equals(registeredUser.getUserPassword())) {
			logger.debug("비밀번호 불일치!");
			return "login";
		}

		// 로그인 완료
		logger.debug("로그인 완료");
		session.setAttribute("User", registeredUser);

		// 회원가입 창에서 넘어 왔을 경우 Index 페이지로 이동.
		String referer = (String) session.getAttribute("referer");
		// 다시 생각해보기 책보고 다시 해보기.
		logger.debug("referer(/user/login): {}", referer);
		if (referer.equals("http://15.164.87.42:8080/sentence/register")) {
			return "redirect:/";
		}

		return "redirect:" + referer;
	}

	// 로그아웃 controller
	@RequestMapping("/user/logout")
	public String requestLogout(HttpSession session) {
		UserVo user = (UserVo) session.getAttribute("User");

		// 카카오 회원의 경우 -> 카카오 로그아웃 해줘야함
		if (user.getEmailStatus().equals("3")) {
			logger.debug("카카오로그아웃");
			logger.debug("!!!!!!! {}", session.getAttribute("access_token").toString());
			KakaoLoginController logout = new KakaoLoginController();
			logout.kakaoLogout(session.getAttribute("access_token").toString());
		}

		// 세션 종료.
		session.invalidate();
		logger.debug("로그아웃!");
		return "redirect:/";
	}

}
