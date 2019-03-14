package com.one.sentence.following.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.following.service.FollowingService;


@Controller
public class FollowingController {

	@Autowired
	FollowingService service = new FollowingService();
	
	@RequestMapping("/following")
	public String ClickFollowingButton(Model model, HttpServletRequest request) {
		
		System.out.println("userIdx="+request.getParameter("userIdx"));
			//service.unfollowing(following);


			//service.startFollowing(following);			

		return "preference";
		}
	}
