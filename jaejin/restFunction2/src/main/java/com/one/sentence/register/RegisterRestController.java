package com.one.sentence.register;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.one.sentence.vo.UserVo;

@RestController
public class RegisterRestController {

	@Inject
	RegisterService service;

	@PostMapping("/users/register")
	@ResponseBody
	public Map<String, String> requestRegister(@RequestBody UserVo inputUser) {

		Map<String, String> map = new HashMap<>();
		System.out.println(inputUser);
		// email 중복 체크
		if (!service.isUser(inputUser.getUserEmail())) {
	
			service.registerUser(inputUser);
			map.put("registerMessage", "회원가입 완료 되었습니다.");

			return map;
		}

		map.put("registerMessage", "이메일이 중복됩니다.");

		return map;
	}
	
	//로그인 focusing out 방식으로 행하는 것.
	@PostMapping("")
	@ResponseBody
	public Map<String, String> restEmailChek(@RequestBody UserVo inputUser) {
		
		Map<String, String> map = new HashMap<>();
		
		
		
		return map;
	}
}
