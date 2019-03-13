package com.one.sentence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndexPage() {

		System.out.println("getIndexPage method");

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {

		System.out.println("getLoginPage method");

		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage() {

		System.out.println("getRegisterPage method");

		return "register";
	}

	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public String getContentsPage() {

		System.out.println("getContentsPage method");

		return "contents";
	}

	@RequestMapping(value = "/preference", method = RequestMethod.GET)
	public String getPreferencePage() {

		System.out.println("getPreferencePage method");

		return "preference";
	}

	@RequestMapping(value = "/sentenceList", method = RequestMethod.GET)
	public String getSentenceList() {

		System.out.println("getSentenceList mehotd");

		return "sentenceList";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUserPage() {

		System.out.println("getUserPage method");

		return "user";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getMainHeader() {
		
		System.out.println("getMainHeader method");
		
		return "include/mainHeader";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getSearchPage() {
		
		System.out.println("getSearchPage()");
		
		return "search";
	}
	
	@RequestMapping(value = "/searchMore", method = RequestMethod.GET)
	public String getSearchMorePage() {
		
		System.out.println("getSearchMorePage method");
		
		return "searchMore";
	}
}
