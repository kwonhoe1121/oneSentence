package com.one.sentence.search.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
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
import com.one.sentence.search.model.TestModel;
import com.one.sentence.search.service.SearchAladdinService;
import com.one.sentence.search.service.SearchAladdinService2;
import com.one.sentence.search.service.SearchBookPageService;
import com.one.sentence.search.service.SearchUserService;

@Controller

public class SearchController {

	@Autowired
	private SearchAladdinService service;

	@Autowired
	private SearchUserService serviceUser;


	@Autowired
	private SearchAladdinService2 servicetwo;

	@Inject
	private OnesentenceService oneService;
	
	
	@Autowired
	private SearchBookPageService service3;

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getQuery(HttpServletRequest request, Model model, @RequestParam String query) throws Exception {
		System.out.println("query: " + query);
		List<SearchModel> items = service.getSearchModel(query);
		List<SearchModel> itemstwo = servicetwo.getSearchModel(query);
		
		if(query.equals(" ") || query.equals("")) return "/search/searchFail";
	
		List<String> useritems = serviceUser.selectUserList('%' + request.getParameter("query") + '%');
		List<UserVo> userInfo = serviceUser.selectUserByUserName('%' + request.getParameter("query") + '%');
		List<ShowOnesentence> oneSentenceList = oneService.showOnesentenceListByHashtag('%' + request.getParameter("query") + '%');
		
		if (items.size() != 0 ||oneSentenceList.size()!=0|| useritems.size() != 0 || userInfo.size() != 0 || query == null || query.length() == 0) {
			model.addAttribute("items", items);
			model.addAttribute("itemtwo", itemstwo);
			model.addAttribute("useritems", useritems);
			model.addAttribute("userInfo", userInfo);
			System.out.println("검색완료");
			System.out.println("items" + items);
			System.out.println("items" + itemstwo);
			System.out.println("useritems" + useritems);
			System.out.println("넘기는값 : " + query);
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

	@RequestMapping(value="/search/searchMoreSentenceList")
	public String getSearchMoreSentenceList(HttpServletRequest request, Model model, @RequestParam String query) throws Exception {
		
		List<ShowOnesentence> oneSentenceList = oneService.showOnesentenceListByHashtag('%' + request.getParameter("query") + '%');
		
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
		
		return "/search/searchMoreSentenceList";

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
	public String getContentsBook(HttpSession session,HttpServletRequest request, Model model,@PathVariable("isbn") String isbn) throws Exception {
		if(isbn!=null) {
		List<SearchModel> items = service.getSearchModel(isbn);
		List<SearchModel> itemstwo = servicetwo.getSearchModel(isbn);
		List<ShowOnesentence> oneSentenceList = new ArrayList<ShowOnesentence>();
		
		List<TestModel> items3 = service3.getTestModel(isbn);
		
		UserVo user = (UserVo) session.getAttribute("User");
		ShowOnesentence sentence= new ShowOnesentence();
		if(user!=null) {
			sentence=oneService.selectOnesentenceByoneSentenceIdxAndIsbnMy(user.getUserIdx(), isbn);
			if(sentence!=null) {
			oneSentenceList.add(sentence);}
			
			sentence = oneService.selectOnesentenceByoneSentenceIdxAndIsbnFollowing(user.getUserIdx(), isbn);
			if(sentence!=null) {
			int user2 = sentence.getUserIdx();
			oneSentenceList.add(sentence);			
			oneSentenceList.addAll(oneService.selectOnesentenceListByoneSentenceIdxAndIsbnOther(user.getUserIdx(), user2, isbn));
			}else {
				oneSentenceList.addAll(oneService.selectOnesentenceListByoneSentenceIdxAndIsbnOtherNoFollwing(user.getUserIdx(), isbn));
			}
		}else {
			oneSentenceList = oneService.showOneSentenceListByIsbn(isbn);
		}
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		String hash="";
		while (it2.hasNext()) {
			sentence = it2.next();
			sentence.setLikeTotal(oneService.showLikeTotal(sentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(sentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			sentence.setHashtag(hash);
			hash = "";
		}
		if (items.size() != 0 || itemstwo.size() != 0||oneSentenceList.size()!=0 || items3.size() != 0) {
			model.addAttribute("items", items);
			model.addAttribute("itemtwo", itemstwo);
			model.addAttribute("oneSentenceList", oneSentenceList);
			model.addAttribute("items3", items3);
		}System.out.println("items3"+items3);}
		
		return "/contents";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	 public void AutoTest(HttpServletRequest request, Model model, 
	 HttpServletResponse resp, ShowOnesentence dto) throws IOException {
	 
	 String result = request.getParameter("query");
	 
	 List<ShowOnesentence> oneSentenceList = oneService.showOnesentenceListByHashtag(result); //result값이 포함되어 있는 emp테이블의 네임을 리턴
	 
	 JSONArray ja = new JSONArray();
	 for (int i = 0; i < oneSentenceList.size(); i++) {
	 ja.add(oneSentenceList.get(i).getHashtag());
	 }
	 
	 PrintWriter out = resp.getWriter();
	 
	 out.print(ja.toString());
	 
	 }
	
}
