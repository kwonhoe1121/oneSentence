package com.one.sentence.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.sentence.search.model.SearchModel;
import com.one.sentence.search.service.SearchAladdinService;
import com.one.sentence.search.service.SearchAladdinService2;
import com.one.sentence.search.service.SearchHashtagService;
import com.one.sentence.search.service.SearchUserService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchAladdinService service;

	@Autowired
	private SearchUserService serviceUser;

	@Autowired
	private SearchHashtagService serviceHashtag;
	
	@Autowired
	private SearchAladdinService2 servicetwo;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getQuery(HttpServletRequest request, Model model) throws Exception {
		String query = (String) request.getParameter("search");

		List<SearchModel> items = service.getSearchModel(query);
		List<SearchModel> itemstwo = servicetwo.getSearchModel(query);
		List<String> useritems = serviceUser.selectUserList( '%'+request.getParameter("search")+'%');
		List<String> hashtagitems = serviceHashtag.selectHashsearchList('%'+request.getParameter("search")+'%');

	
		if (items.size()!=0 || useritems.size()!=0 || hashtagitems.size()!=0) {
			model.addAttribute("items", items);
			model.addAttribute("itemtwo", itemstwo);
			model.addAttribute("useritems", useritems);
			model.addAttribute("hashtagitems", hashtagitems);
			System.out.println("검색완료");
			System.out.println("items" + items);
			System.out.println("items" + itemstwo);
			System.out.println("useritems" + useritems);
			System.out.println("hashtagitems" + hashtagitems);
			
			return "/searchPage";
		} else { // 검색결과가 하나도 존재하지 않을경우
			System.out.println("검색결과없음");
			return "search/searchfail";
		}
	}



}
