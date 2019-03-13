package com.one.sentence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String getIndexPage() {
		
		System.out.println("getIndexPage method");
		
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLoginPage() {
		
		System.out.println("getLoginPage method");
		
		return "login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegisterPage() {
		
		System.out.println("getRegisterPage method");
		
		return "register";
	}
	
}
