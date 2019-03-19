package com.one.sentence.followingnews.controller;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.followingnews.service.FollowingNewsService;
import com.one.sentence.onesentence.model.ShowOnesentence;
import com.one.sentence.onesentence.service.OnesentenceService;

@Controller
@RequestMapping("/followingnews/news")
public class FollowingNewsController {

	@Autowired
	private FollowingNewsService FollowingNewsservice;
	
	@Inject
	private OnesentenceService oneService;
	
	
	@RequestMapping("/{userIdx}")
	public String selectOneSentenceListForFollowing(@PathVariable("userIdx") int userIdx, Model model){
		List<ShowOnesentence> oneSentenceList = FollowingNewsservice.selectOneSentenceListForFollowing(userIdx);
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash="";
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
		return "sentenceList";
	}
	
}
