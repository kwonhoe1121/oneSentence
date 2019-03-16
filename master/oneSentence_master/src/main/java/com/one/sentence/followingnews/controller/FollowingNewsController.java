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
	private FollowingNewsService FollowingNewsservice;
	
	@RequestMapping(method=RequestMethod.GET)
	public String GetFollowingNewsForm() {
		return "followingnews/followingnewshome";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String getFollowingNewsList(HttpServletRequest request, Model model) {
		String followingNewsquery = request.getParameter("userIdx");
		
		List<SearchModel> followingNewsitems = FollowingNewsservice.selectFollowingNewsList(followingNewsquery);
		
		if (followingNewsitems.size() !=0) {
			model.addAttribute("followingNewsitems", followingNewsitems);
			System.out.println("친구 한문장 : " + followingNewsitems);
			
			return "followingnews/followingnewslist";
		}
		
		return "followingnews/followingnewsfail";
		
	}
	
	
}
