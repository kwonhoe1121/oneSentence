package com.one.sentence.profile.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.common.service.SecurityService;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.profile.model.Profile;
import com.one.sentence.profile.service.ProfileService;

@Controller
public class profileController {

	private static final Logger logger = LoggerFactory.getLogger(profileController.class);
	
	@Inject
	ProfileService profileService;

	@Inject
	SecurityService securityService;

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
		model.addAttribute("user_info", user);
		return "profile/popup";
	}

	@RequestMapping("/profile/update")
	public String updateUser_infoByuserIdx(Model model, HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		logger.debug("userupdate Mapping 연결");
		String newPassword = request.getParameter("newPassword");
		logger.debug("newPassword: {}", newPassword);
		logger.debug("newPassword" + newPassword);

		String idx = request.getParameter("userIdx");
		int userIdx = Integer.parseInt(idx);
		String originalPassword = request.getParameter("originalPassword");
		String userName = request.getParameter("userName");
		String userIntroduction = request.getParameter("userIntroduction");

		if (!(newPassword == null || newPassword.equals(""))) {
			logger.debug("새로운 패스워드");
			profileService.changeUser_info(userIdx, securityService.encryptUserPassword(newPassword), userName,
					userIntroduction);
		} else {
			logger.debug("원래 패스워드");
			profileService.changeUser_info(userIdx, originalPassword, userName, userIntroduction);
		}

		return "profile/popupfinish";
	}

}
