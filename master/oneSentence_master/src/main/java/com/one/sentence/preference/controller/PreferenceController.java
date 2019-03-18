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
import com.one.sentence.countuser.service.CountUserService;
import com.one.sentence.preference.service.PreferenceService;
import com.one.sentence.userpage.service.UserPageService;

@Controller
public class PreferenceController {

	@Autowired
	PreferenceService service;
	
	@Autowired
	UserPageService uservice;
	
	@Autowired
	CountUserService cservice;
	
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
		
		
		return "preference";
		}
	
	}
