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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.sentence.preference.service.PreferenceService;

@Controller
@RequestMapping("/hashtagList")
public class PreferenceController {

	@Autowired
	PreferenceService service = new PreferenceService();
	
	@RequestMapping(method=RequestMethod.GET)
	public String GetFollowingForm() {
		return "preference/PreferenceForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String GetHashtaglist(Model model, HttpServletRequest request) {
		int userIdx = Integer.parseInt(request.getParameter("userIdx"));
		//int userIdx = 2;
		
		List<String> hashtaglist = service.genrePreference(userIdx);
		
		//System.out.println(hashtaglist.size());
		
		String returnpage="";
		if(hashtaglist.size()==0) {
			hashtaglist.add("아직 등록한 문장, 좋아요 한 문장이 없습니다~");
			returnpage = "preference/NoHashtagList";
		}
		else	
			returnpage = "preference/HashtagList";
		
		model.addAttribute("hashtaglist", hashtaglist);
		
		return returnpage;
		}
	
	}
