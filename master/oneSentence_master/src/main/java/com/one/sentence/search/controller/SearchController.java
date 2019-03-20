package com.one.sentence.search.controller;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.onesentence.model.ShowOnesentence;
import com.one.sentence.onesentence.service.OnesentenceService;
import com.one.sentence.search.model.SearchModel;
import com.one.sentence.search.service.SearchAladdinService;
import com.one.sentence.search.service.SearchAladdinService2;
import com.one.sentence.search.service.SearchHashtagService;
import com.one.sentence.search.service.SearchUserService;

@Controller
//@RequestMapping("/search")
public class SearchController {

	@Autowired
	private SearchAladdinService service;

	@Autowired
	private SearchUserService serviceUser;

	@Autowired
	private SearchHashtagService serviceHashtag;

	@Autowired
	private SearchAladdinService2 servicetwo;

	@Inject
	private OnesentenceService oneService;
	
	@RequestMapping(value = "/search/query", method = RequestMethod.GET)
	public String getQuery(HttpServletRequest request, Model model, @RequestParam String query) throws Exception {
		System.out.println("query: " + query);
		List<SearchModel> items = service.getSearchModel(query);
		List<SearchModel> itemstwo = servicetwo.getSearchModel(query);
		List<String> useritems = serviceUser.selectUserList('%' + request.getParameter("query") + '%');
		List<UserVo> userInfo = serviceUser.selectUserByUserName('%' + request.getParameter("query") + '%');
		//List<String> hashtagitems = serviceHashtag.selectHashsearchList('%' + request.getParameter("query") + '%');
		List<ShowOnesentence> oneSentenceList = oneService.showOnesentenceListByHashtag('%' + request.getParameter("query") + '%');
		
		if (items.size() != 0 ||oneSentenceList.size()!=0|| useritems.size() != 0 || userInfo.size() != 0) {
			model.addAttribute("items", items);
			model.addAttribute("itemtwo", itemstwo);
			model.addAttribute("useritems", useritems);
			model.addAttribute("userInfo", userInfo);
			//model.addAttribute("hashtagitems", hashtagitems);
			System.out.println("검색완료");
			System.out.println("items" + items);
			System.out.println("items" + itemstwo);
			System.out.println("useritems" + useritems);
			//System.out.println("hashtagitems" + hashtagitems);
			
			Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
			ShowOnesentence showOneSentence;
			String hash = "";
			while (it2.hasNext()) {
				showOneSentence = it2.next();
				showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

				List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
				Iterator<String> it = hList.iterator();
				while (it.hasNext()) {
					hash += "#" + it.next() + " ";
				}
				showOneSentence.setHashtag(hash);
				hash = "";
			}
			model.addAttribute("oneSentenceList", oneSentenceList);
			
			return "/search";
		} else { // 검색결과가 하나도 존재하지 않을경우
			System.out.println("검색결과없음");
			return "/search/searchFail";
		}
	}

	@RequestMapping(value="/search/searchMore")
	public String getSearchMore(HttpServletRequest request, Model model, @RequestParam String query) throws Exception {
		
		List<SearchModel> items = service.getSearchModel(query);
		
		model.addAttribute("items", items);
		return "/search/searchMore";
	}
	
	@RequestMapping(value="/search/searchMoreBest")
	public String getSearchMoreBest(HttpServletRequest request, Model model, @RequestParam String query) throws Exception {
		
		List<SearchModel> itemstwo = servicetwo.getSearchModel(query);
		
		model.addAttribute("itemstwo", itemstwo);
		return "/search/searchMoreBest";
	}
	
	@RequestMapping(value="/search/searchMoreUser")
	public String getSearchMoreUser(HttpServletRequest request, Model model, @RequestParam String query) throws Exception {
		List<UserVo> userInfo = serviceUser.selectUserByUserName('%' + request.getParameter("query") + '%');
		model.addAttribute("userInfo", userInfo);
		
		List<String> useritems = serviceUser.selectUserList('%' + request.getParameter("query") + '%');

		model.addAttribute("useritems", useritems);
		return "/search/searchMoreUser";
	}
	
	
	@RequestMapping(value="/contentsPage/{isbn}")
	public String getContentsBook(HttpServletRequest request, Model model,@PathVariable("isbn") String isbn) throws Exception {
		
		List<SearchModel> items = service.getSearchModel(isbn);
		List<SearchModel> itemstwo = servicetwo.getSearchModel(isbn);

		if (items.size() != 0 || itemstwo.size() != 0)
			model.addAttribute("items", items);
			model.addAttribute("itemtwo", itemstwo);
		return "/contents";
	}
	
	
}
