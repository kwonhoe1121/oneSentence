package com.one.sentence.register;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.one.sentence.vo.UserVo;

@Controller
@SessionAttributes("UserVo")
public class RegisterController {

	@Inject
	RegisterService service;

	@RequestMapping(value="/user/register", method = RequestMethod.POST)
	public String requestRegistration(UserVo user, Model model, HttpSession session) {
		System.out.println(user + "등록 전");
		
		if (service.registerUser(user) != -1) {
			service.registerUser(user);
			session.setAttribute("User", user);

		}
		System.out.println(user + "return 전");
		return "home";
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String tempMethod() {
//		return "/main";
//	}

	//이메일 중복 체크 확인.
	@RequestMapping("/emailCheck")
	@ResponseBody
	public Map<Object, Object> checkOverrapedEmail(@RequestBody String email) {

		Map<Object, Object> map = new HashMap<>();
		boolean chekUser = service.isUser(email);
		map.put("chekUser", chekUser);

		return map;
	}
	
	//회원탈퇴
//	@RequestMapping("/user")
//	public String 

}
