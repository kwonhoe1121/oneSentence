package com.one.sentence.userpage.controller;

import javax.servlet.http.HttpSession;

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
	public String CheckFollowingState(Model model, @PathVariable("userIdx") int userIdx, HttpSession session) {

		//유저페이지 계정 정보 가져옴
		UserVo uservo = uservice.showUser_infoByuserIdx(userIdx);
		model.addAttribute("uservo", uservo);

		//loginInfo
		UserVo user = (UserVo) session.getAttribute("User");
		if(user==null) {
			model.addAttribute("loginIdx", "로그인필요");
			return "user";
		}
		else {
			model.addAttribute("loginIdx", user);			
			int loginUserIdx = user.getUserIdx();

		// 1. 본인의 유저페이지에 들어갈 경우 (userIdx와 loginId가 같은 경우)
		// 팔로잉 상태 알아보는 과정(아래의 과정) 필요 없음 (지금은 user.js로만 구현)
		if (loginUserIdx == userIdx) {
			model.addAttribute("flag", "same");
			model.addAttribute("followingstate", "");
			return "user";
		} else {
			model.addAttribute("flag", "different");

			// 2. 타인의 유저페이지에 들어갈 경우
			// (ex. loginid=3이고 userIdx=4번의 유저페이지에 들어갈 때)
			// 둘의 팔로잉 상태에 따라 팔로잉 버튼의 value와 css가 달라짐

			Following following = new Following();
			following.setUserIdx(loginUserIdx);
			following.setFollowingUserIdx(userIdx);

			Object followingstate = service.checkFollowingState(following);

			if (followingstate != null) { // 이미 팔로잉 되어있음
				model.addAttribute("followingstate", "팔로잉");
			} else { // 아직 팔로잉 되어있지 않음
				model.addAttribute("followingstate", "팔로우");
			}

			return "user";
		}
		}
	}
}
