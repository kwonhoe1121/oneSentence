package com.one.sentence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/indexPage", method = RequestMethod.GET)
	public String getIndexPage() {

		System.out.println("getIndexPage method");

		return "index";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String getLoginPage() {

		System.out.println("getLoginPage method");

		return "login";
	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public String getRegisterPage() {

		System.out.println("getRegisterPage method");

		return "register";
	}

	@RequestMapping(value = "/contentsPage", method = RequestMethod.GET)
	public String getContentsPage() {

		System.out.println("getContentsPage method");

		return "contents";
	}

	@RequestMapping(value = "/preferencePage", method = RequestMethod.GET)
	public String getPreferencePage() {

		System.out.println("getPreferencePage method");

		return "preference";
	}

	@RequestMapping(value = "/sentenceListPage", method = RequestMethod.GET)
	public String getSentenceList() {

		System.out.println("getSentenceList mehotd");

		return "sentenceList";
	}

	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public String getUserPage() {

		System.out.println("getUserPage method");

		return "user";
	}

	@RequestMapping(value = "/mainHeaderPage", method = RequestMethod.GET)
	public String getMainHeader() {

		System.out.println("getMainHeader method");

		return "include/mainHeader";
	}

	@RequestMapping(value = "/searchPage", method = RequestMethod.GET)
	public String getSearchPage() {

		System.out.println("getSearchPage()");

		return "search";
	}

	@RequestMapping(value = "/searchMorePage", method = RequestMethod.GET)
	public String getSearchMorePage() {

		System.out.println("getSearchMorePage method");

		return "searchMore";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String getReviewPage() {

		System.out.println("getReviewPage method");

		return "review";
	}
}
