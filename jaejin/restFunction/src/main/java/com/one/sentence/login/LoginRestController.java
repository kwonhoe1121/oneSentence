package com.one.sentence.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.one.sentence.vo.UserVo;

@RestController
public class LoginRestController {

	@Inject
	LoginService service;

	@PostMapping("/users/login")
	@ResponseBody
	public List<Map<String, String>> requestLogin(@RequestBody UserVo inputUser) {
		
		System.out.println("ajax 요청 시작!");
		System.out.println(inputUser);
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		//id 일치여부 확인
		if(!service.isUser(inputUser.getUserEmail())) {
			map.put("loginMessage", "아이디를 잘 못 입력하셨습니다.");
			list.add(map);
			return list;
		}
		//pwd 일치여부 확인
		if(!inputUser.getUserPassword().equals(service.selectUser(inputUser.getUserEmail()).getUserPassword())) {
			map.put("loginMessage", "비밀번호를 잘 못 입력하셨습니다.");
			list.add(map);
			return list;
		}
		
		map.put("loginMessage", "로그인 완료!");
		list.add(map);
		return list;
	}
	
}
