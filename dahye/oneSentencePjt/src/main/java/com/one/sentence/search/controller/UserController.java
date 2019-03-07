package com.one.sentence.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.sentence.search.service.SearchUserService;

@Controller
@RequestMapping("/search/{query}")
public class UserController {

	@Autowired 
	private SearchUserService Userservice;
	
	@RequestMapping(method=RequestMethod.GET)
	public String GetUserForm() {
		return "search/searchreuslt";
	}
	
}
