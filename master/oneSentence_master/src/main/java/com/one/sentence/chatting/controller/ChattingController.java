package com.one.sentence.chatting.controller;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.chatting.model.OldChatting;

@Controller
public class ChattingController {

	@RequestMapping("/getroom/{params}")
	public String getRoom(@PathVariable("params") String params, Model model) {
		String[] arr = params.split(":");
		model.addAttribute("isbn", arr[0]);
		model.addAttribute("bookTitle", arr[1]);
		model.addAttribute("userName", arr[2]);
		return "chatting/getRoom";
	}

	@RequestMapping("/getroom3/{params}")
	public String getRoom3(@PathVariable("params") String params, Model model) {
		System.out.println("getroom3");
		String[] arr = params.split(":");
		List<OldChatting> oldChatList = new ArrayList<OldChatting>();
		try {
			URL url = new URL("http://127.0.0.1:52273/chatRoom/" + arr[0]);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("GET");
			con.connect();

			InputStreamReader is = new InputStreamReader(url.openConnection().getInputStream(), "utf-8");
			JSONObject jsonObj = (JSONObject) JSONValue.parse(is);
			JSONArray jArr = (JSONArray) jsonObj.get("data");

			OldChatting oldChat;

			for (int i = 0; i < jArr.size(); i++) {
				JSONObject j = (JSONObject) jArr.get(i);
				oldChat = new OldChatting();
				oldChat.setIsbn((String) j.get("isbn").toString());
				oldChat.setUserName((String) j.get("userName").toString());
				oldChat.setMessage((String) j.get("message").toString());
				oldChat.setTime((String) j.get("time").toString());
				oldChatList.add(oldChat);

			}
			System.out.println("iterator-----------");
			Iterator<OldChatting> it = oldChatList.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("isbn", arr[0]);
		model.addAttribute("bookTitle", arr[1]);
		model.addAttribute("userName", arr[2]);
		model.addAttribute("oldChatList", oldChatList);

		return "chatting/room";
	}

}
