package com.one.sentence.userpage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.following.model.Following;
import com.one.sentence.following.service.FollowingService;


@Controller
public class UserPageController {

	@Autowired
	FollowingService service = new FollowingService();
	
	@RequestMapping("/userpage/{userIdx}")
	public String CheckFollowingState(Model model, @PathVariable("userIdx") String userIdx) {
		// userIdx=1의 userpage
		// loginid=3이 팔로우 하려고 할 때
			
		Following following = new Following();
		following.setUserIdx(3);
		following.setFollowingUserIdx(Integer.parseInt(userIdx));
		
		Object followingstate = service.checkFollowingState(following);

		if(followingstate !=null) { // 이미 팔로잉 되어있음
			model.addAttribute("followingstate", "팔로잉");
		}else { // 아직 팔로잉 되어있지 않음
			model.addAttribute("followingstate", "팔로우");
		}
		return "user";
	}

}
