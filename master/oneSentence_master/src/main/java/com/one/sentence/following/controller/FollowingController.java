package com.one.sentence.following.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.one.sentence.following.model.Following;
import com.one.sentence.following.service.FollowingService;


@Controller
public class FollowingController {

	@Autowired
	FollowingService service;
	
	//userpage.js에서 ajax로 보냄
	@RequestMapping("/userpage/following")
	@ResponseBody
	public String ClickFollowingButton(Model model, HttpServletRequest request) {
		int userIdx = Integer.parseInt(request.getParameter("userIdx"));
		int loginIdx = Integer.parseInt(request.getParameter("loginIdx"));
		int follow = Integer.parseInt(request.getParameter("follow"));
		
		Following following = new Following();
		following.setUserIdx(loginIdx);
		following.setFollowingUserIdx(userIdx);
//		
//		if(follow==1)
//			service.startFollowing(following);
//		else
//			service.unfollowing(following);			
//		
		
		
		//프로시저로 구현
		Map<String, Object> followingMap = new HashMap<String, Object>();
		followingMap.put("p1",follow);
		followingMap.put("p2",loginIdx);
		followingMap.put("p3",userIdx);
		
		service.followingProc(followingMap);

		return "";
		}
	}
