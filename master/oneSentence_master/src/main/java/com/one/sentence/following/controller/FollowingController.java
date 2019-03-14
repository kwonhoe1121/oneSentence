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
public class FollowingController {

	@Autowired
	FollowingService service = new FollowingService();
	
	@RequestMapping("/userpage")
	public String CheckFollowingState(Model model) {
		// userIdx=2의 userpage
		// loginid=3이 팔로우 하려고 할 때
		Following following = new Following();
		following.setUserIdx(3);
		following.setFollowingUserIdx(2);
		
		Object followingstate = service.checkFollowingState(following);
		
		if(followingstate !=null) { // 이미 팔로잉 되어있음
			model.addAttribute("followingstate", "팔로잉");
		}else { // 아직 팔로잉 되어있지 않음
			model.addAttribute("followingstate", "팔로우");
		}
		
		return "user";
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String ClickFollowingButton(Model model, HttpServletRequest request) {
		

			//service.unfollowing(following);


			//service.startFollowing(following);			

		
		// 실제로는 로그인, 본인계정 여부에 따라 팔로잉 버튼 보여지는 형태 달라짐
		// 1. 로그인x : 기본 형태의 팔로잉 버튼 -> 클릭하면 로그인 모달창
		// 2. 로그인o, 본인 계정 : 팔로잉 버튼 x
		// 3-1. 로그인o, 본인 계정x, 현재 팔로잉o : 이미 팔로잉 된 형태의 팔로잉 버튼
		// 3-2. 로그인o, 본인 계정x, 현재 팔로잉x : 기본 형태의 팔로잉 버튼 -> 클릭하면 변함
return null;
		}
	}
