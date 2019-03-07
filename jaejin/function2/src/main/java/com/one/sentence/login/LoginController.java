package com.one.sentence.login;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.sentence.vo.UserVo;

@Controller
public class LoginController {

	@Inject
	LoginService service;

	// 세션 유무체크 interceptor에서 처리
	// 로그인 안되어 있는 상태에서 아래 작업 수행
	@RequestMapping(value="/user/login", method = RequestMethod.POST)
	public String requestLogin(HttpSession session, Model model, @RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword) {
		System.out.println("로그인체크");
		// 이메일 체크
		if (!service.isUser(userEmail)) {
			model.addAttribute("isNotUser", "회원이 아닙니다.");
			System.out.println("등록된 이메일 없음.");
			return "home";
		}

		// 유저 정보 가져오기.
		UserVo user = service.selectUser(userEmail);

		// 비밀번호 체크
		if (!userPassword.equals(user.getUserPassword())) {
			model.addAttribute("isNotPassword", "비밀번호가 다릅니다.");
			System.out.println("비밀번호 불일치!");
			return "home";
		}

		// 로그인 완료
		session.setAttribute("User", user);
		System.out.println("로그인 완료");
		return "home";
	}

	// 로그아웃 controller
	@RequestMapping("user/logout")
	public String requestLogout(HttpSession session) {

		// 세션 종료.
		session.invalidate();
		System.out.println("로그아웃!");
		return "home";
	}

}
