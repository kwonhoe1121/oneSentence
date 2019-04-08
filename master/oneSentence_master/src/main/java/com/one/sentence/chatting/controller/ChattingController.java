package com.one.sentence.chatting.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat/{isbn}")
public class ChattingController {

	public String getChattingRoom(HttpServletRequest request) {
		System.out.println("채팅접속");
		System.out.println(request.getAttribute("data").toString());
		return "/chatting/room";
	}
}
