package com.one.sentence.profile.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.common.vo.UserVo;
import com.one.sentence.profile.model.Profile;
import com.one.sentence.profile.service.ProfileService;

@Controller
public class profileController {

	@Inject
	ProfileService profileService;
	
	@RequestMapping("/profile/{idx}")
	public String selectProfileByuserIdx(@PathVariable("idx") int idx, Model model) {
		Profile profile = new Profile();
		UserVo user = profileService.showUser_infoByuserIdx(idx);
		profile.setUserIdx(user.getUserIdx());
		profile.setUserIntroduction(user.getUserIntroduction());
		profile.setUserName(user.getUserName());
		profile.setUserPoint(user.getUserPoint());
		
		model.addAttribute("profile", profile);
		
		return "profile/userPage";
	}
	@RequestMapping("/profile/popup/{idx}")
	public String getUpdateForm(@PathVariable("idx") int idx, Model model) {
		UserVo user = profileService.showUser_infoByuserIdx(idx);
		model.addAttribute("user_info",user);
		return "profile/popup";	
	}
	@RequestMapping("/profile/update")
	public String updateUser_infoByuserIdx(Model model,HttpServletRequest request) {
		System.out.println("userupdate Mapping 연결");
		String newPassword=(String)request.getParameter("newPassword");
		System.out.println("newPassword"+newPassword);
		
		String idx = (String)request.getParameter("userIdx");
		int userIdx = Integer.parseInt(idx);
		String originalPassword=(String)request.getParameter("originalPassword");
		String userName=(String)request.getParameter("userName");
		String userIntroduction = (String)request.getParameter("userIntroduction");
		
		if(!(newPassword==null||newPassword.equals(""))) {
			System.out.println("새로운 패스워드");
			profileService.changeUser_info(userIdx,newPassword, userName, userIntroduction);
		}else {
			System.out.println("원래 패스워드");
			profileService.changeUser_info(userIdx, originalPassword,userName, userIntroduction);
		}
		
		return "profile/popupfinish";
	}
	
}
