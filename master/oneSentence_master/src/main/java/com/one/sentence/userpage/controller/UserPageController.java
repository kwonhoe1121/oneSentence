package com.one.sentence.userpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.following.model.Following;
import com.one.sentence.following.service.FollowingService;
import com.one.sentence.userpage.service.UserPageService;


@Controller
public class UserPageController {

	@Autowired
	UserPageService uservice;
	
	@Autowired
	FollowingService service = new FollowingService();
	
	@RequestMapping("/userpage/{userIdx}")
	public String CheckFollowingState(Model model, @PathVariable("userIdx") int userIdx) {
		// userIdx=4의 userpage
		// loginid=3이 팔로우 하려고 할 때

		UserVo uservo = uservice.showUser_infoByuserIdx(userIdx);
		model.addAttribute("uservo", uservo);
			
		Following following = new Following();
		following.setUserIdx(3);
		following.setFollowingUserIdx(userIdx);
		
		Object followingstate = service.checkFollowingState(following);

		if(followingstate !=null) { // 이미 팔로잉 되어있음
			model.addAttribute("followingstate", "팔로잉");
		}else { // 아직 팔로잉 되어있지 않음
			model.addAttribute("followingstate", "팔로우");
		}
		return "user";
	}

}
