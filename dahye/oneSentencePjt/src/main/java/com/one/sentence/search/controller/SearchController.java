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
import com.one.sentence.search.service.SearchUserService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchAladdinService service;

	@Autowired
	private SearchUserService serviceUser;

	@RequestMapping(method = RequestMethod.GET)
	public String getQuery(HttpServletRequest request, Model model) throws Exception {
		String query = (String) request.getParameter("search");

		Object search = service.getSearchModel(query);

		System.out.println("쿼리");
		if (search != null) {
<<<<<<< HEAD
		List<SearchModel> items = service.getSearchModel(query);
		List<String> userlist = serviceUser.selectUserList("%지민%");
		
		model.addAttribute("items", items);
		System.out.println("검색완료");
		System.out.println(userlist);
		return "search/searchresult";
=======
			List<SearchModel> items = service.getSearchModel(query);
			model.addAttribute("items", items);
			System.out.println("검색완료");
			return "search/searchresult";
>>>>>>> branch 'master' of https://github.com/kwonhoe1121/oneSentence.git
		} else {
			System.out.println("검색결과없음");
			return "search/searchfail";
		}
	}
<<<<<<< HEAD
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String getUserForm(HttpServletRequest request, Model model)  {
//		String userQuery = (String)request.getParameter("search");
//		System.out.println("찍힘");
//	
//		Object search = serviceUser.selectUserList();
//		
//		if (search != null) {
//			List<String> selectUser = serviceUser.selectUserList();
//			System.out.println("검색완료");
//			return "search/searchreuslt";
//		} else {
//			System.out.println("검색결과 없음");
//			return "search/searchfail";
//		}
//	}
	
=======

	@RequestMapping(method = RequestMethod.POST)
	public String getUserForm(HttpServletRequest request, Model model) {
		String userQuery = (String) request.getParameter("search");
		System.out.println("찍힘");

		Object search = serviceUser.selectUserList();

		if (search != null) {
			List<String> selectUser = serviceUser.selectUserList();
			System.out.println("검색완료");
			return "search/searchreuslt";
		} else {
			System.out.println("검색결과 없음");
			return "search/searchfail";
		}
	}

>>>>>>> branch 'master' of https://github.com/kwonhoe1121/oneSentence.git
}
