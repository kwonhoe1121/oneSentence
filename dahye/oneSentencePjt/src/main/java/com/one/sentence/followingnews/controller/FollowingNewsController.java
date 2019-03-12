package com.one.sentence.followingnews.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.sentence.followingnews.service.FollowingNewsService;
import com.one.sentence.search.model.SearchModel;

@Controller
@RequestMapping("followingnews")
public class FollowingNewsController {

	@Autowired
	private FollowingNewsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String GetFollowingNewsForm() {
		return "followingnews/followingnewshome";
	}
	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String getFollowingNewsList(HttpServletRequest request, Model model) {
//	
//		
//		List<SearchModel> followingNewsitems = service.selectFollowingNewsList();
//		return "followingnews/followingnewslist";
//		
//	}
	
	
}
