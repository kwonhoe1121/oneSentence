package com.one.sentence.following.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.one.sentence.following.model.Following;
import com.one.sentence.following.service.FollowingService;


@Controller
@RequestMapping("/following")
public class FollowingController {

	@Autowired
	FollowingService service = new FollowingService();
	
	@RequestMapping(method=RequestMethod.GET)
	public String GetFollowingForm() {
		return "following/FollowingForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String ClickFollowingButton(Model model, HttpServletRequest request, 
								Following following) {
		
		//하드코딩
		//Following following = new Following();
		//following.setUserIdx(2);
		//following.setFollowingUserIdx(8);

		
		Object result = service.checkFollowingState(following);
		

		if(result !=null) { // 이미 팔로잉 되어있음 -> 팔로잉 해지
			service.unfollowing(following);
			return "following/Unfollowing";
		}

		else { // 팔로잉 시작
			service.startFollowing(following);			
			return "following/StartFollowing";
		}

		
		// 실제로는 로그인, 본인계정 여부에 따라 팔로잉 버튼 보여지는 형태 달라짐
		// 1. 로그인x : 기본 형태의 팔로잉 버튼 -> 클릭하면 로그인 모달창
		// 2. 로그인o, 본인 계정 : 팔로잉 버튼 x
		// 3-1. 로그인o, 본인 계정x, 현재 팔로잉o : 이미 팔로잉 된 형태의 팔로잉 버튼
		// 3-2. 로그인o, 본인 계정x, 현재 팔로잉x : 기본 형태의 팔로잉 버튼 -> 클릭하면 변함

		}
	}
