//package com.one.sentence.preference.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.one.sentence.following.model.Following;
//import com.one.sentence.preference.service.PreferenceService;
//
//@Controller
//public class PreferenceController {
//
//	@Autowired
//	PreferenceService service = new PreferenceService();
//	
//	@RequestMapping("/hashtagList")
//	public String getMemberlist(Model model, HttpServletRequest request) {
//		int userIdx = 2;
//		List<String> hashtaglist = service.genrePreference(userIdx);
//		model.addAttribute("hashtaglist", hashtaglist);
//		
//		return "preference/HashtagList";
//		}
//	}

package com.one.sentence.preference.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.countsentence.service.CountSentenceService;
import com.one.sentence.countuser.service.UserRankService;
import com.one.sentence.preference.service.PreferenceService;
import com.one.sentence.userpage.service.UserPageService;

@Controller
public class PreferenceController {

	@Autowired
	PreferenceService service;
	
	@Autowired
	UserPageService uservice;
	
	@Autowired
	UserRankService rservice;
	
	@Autowired
	CountSentenceService cservice;
	
	@RequestMapping("/userpage/preference/{userIdx}")
	public String GetHashtaglist(Model model, HttpServletRequest request, @PathVariable("userIdx") int userIdx) {

		List<String> hashtaglist = service.userPreference(userIdx);

		if(hashtaglist.size()==0) {
			hashtaglist.add("");
		}
		
		model.addAttribute("hashtaglist", hashtaglist);
		model.addAttribute("userIdx",userIdx);
		
		UserVo uservo = uservice.showUser_infoByuserIdx(userIdx);
		model.addAttribute("uservo", uservo);
		
		int countAllUsers = rservice.countAllUsers();
		int userRank = rservice.selectUserRank(userIdx);
		int percent = Math.round(((float)userRank/countAllUsers)*100);
		model.addAttribute("percent", percent);
		
		if(percent<=10) {
			model.addAttribute("grade", "5");
			model.addAttribute("comment", "최고의 경지에 도달한 한문장 유저군요. 당신은 진정한 한문장 매니아!");
		}
		else if(percent<=30) {
			model.addAttribute("grade", "4");
			model.addAttribute("comment", "한문장 등록 상위권 돌파! 대단합니다!");
		}
		else if(percent<=50) {
			model.addAttribute("grade", "3");
			model.addAttribute("comment", "한문장의 매력을 알게되셨군요! 축하합니다!");
		}
		else if(percent<=70) {
			model.addAttribute("grade", "2");
			model.addAttribute("comment", "프로 한문장 유저의 고지가 저 앞에 보입니다!");
		}
		else if(percent<=100) {
			model.addAttribute("grade", "1");
			model.addAttribute("comment", "한문장을 더 많이 등록해서 다른 유저들과 함께 감상하세요!");
		}
		
		int countMySentences = cservice.countSentenceByUserIdx(userIdx);
		model.addAttribute("countMySentences", countMySentences);
		
		return "preference";
		}
	
	}
