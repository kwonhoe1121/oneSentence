package com.one.sentence.chatting.controller;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.one.sentence.chatting.model.OldChatting;

@Controller
public class ChattingController {
	
	@RequestMapping("/getroom/{params}")
	public String getRoom(@PathVariable("params") String params,
			Model model) {
		String[] arr = params.split(":");
		model.addAttribute("isbn", arr[0]);
		model.addAttribute("bookTitle", arr[1]);
		model.addAttribute("userName", arr[2]);
		return "chatting/getRoom";
	}
	
	@RequestMapping("/getroom3/{params}")
	public String getRoom3(@PathVariable("params") String params,
			Model model) {
		System.out.println("getroom3");
		String[] arr = params.split(":");
		List<OldChatting> oldChatList;
		OldChatting oldChat;
		
		
		try{
		URL url = new URL("http://127.0.0.1:52273/chatRoom/"+arr[0]);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("GET");
		
		for(Map.Entry<String, List<String>> header: con.getHeaderFields().entrySet()) {
			for(String value:header.getValue()) {
				System.out.println(header.getKey()+":"+value);
			}}
		
		
			InputStream in = con.getInputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			System.out.println("1");
			byte[] buf = new byte[1028];
			int length=0;
			
			System.out.println(in.read(buf));
			while((length=in.read(buf))!=-1) {
				out.write(buf,0,length);
			}
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject)parser.parse(out.toString());
			JSONArray arr2 = new JSONArray();
			arr2.add(jsonObject);
			
			System.out.println("+++++++++++++++");
			System.out.println(arr2);
			System.out.println(out.toString());
			
			System.out.println("+++++++++++++++");
			List<String> list = new ArrayList<String>();
			String[] sArr = {};
		    
		    sArr= (new String(out.toByteArray(),"utf-8")).replace("\":\"", "\",\"").replace("\"","").trim().split("[,={}]");
		   
		    for(int i=0;i<sArr.length;i++) {
		    	list.add(sArr[i]);
		    }
		    
			Iterator<String> it = list.iterator();
			
			/*System.out.println("!!!!!!!!!");
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			System.out.println("!!!!!!!!!");*/
			
			oldChatList = new ArrayList<OldChatting>();
			
			
			int i=-1;
			while (it.hasNext()) {
				oldChat=new OldChatting();
				i++;
				if(i==7) {
					System.out.println("7");
					
					oldChat.setIsbn(it.next());
					/*System.out.println(it.next());*/
				}else if(i==9) {
					System.out.println("9");
					oldChat.setUserName(it.next());
					/*System.out.println(it.next());*/
				}else if(i==11) {
					System.out.println("11");
					oldChat.setMessage(it.next());
					/*System.out.println(it.next());*/
				}else if(i==13) {
					System.out.println("13");
					oldChat.setTime(it.next());
					System.out.println(oldChat);
					oldChatList.add(oldChat);
					/*System.out.println(it.next());*/
					i=1;
				}else {
					System.out.println("기타");
					System.out.println(it.next());
				}
			}
			System.out.println("#######################");
			Iterator<OldChatting> it2 = oldChatList.iterator();
			while(it2.hasNext()) {
				System.out.println(it2.next());
			}
			System.out.println("#######################");
			model.addAttribute("oldChatList", oldChatList);
		con.disconnect();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		model.addAttribute("isbn", arr[0]);
		model.addAttribute("bookTitle", arr[1]);
		model.addAttribute("userName", arr[2]);
		
		
		return "chatting/room";
	}
	
	/*@RequestMapping("/chat/{isbn}")
	public String getChattingRoom(HttpServletRequest request,
			@PathVariable("isbn") String isbn,
			@RequestBody Chatting chatting,
			Model model) {

		System.out.println("채팅접속");
		System.out.println(chatting);
		
		System.out.println("----------");

		//HttpConnection
		
		Object[] arr = chatting.getData();
		String[] sArr = {};
		List<String> list = new ArrayList<String>();
		for(int k=0; k<arr.length;k++) {
			sArr =arr[k].toString().split("[,={}]");
			for(int j=0;j<sArr.length;j++) {
				list.add(sArr[j]);
			}	
		}
		Iterator<String> it = list.iterator();
		List<OldChatting> oldChatList = new ArrayList<OldChatting>();
		OldChatting oldChat=new OldChatting();
		
		int i=-1;
		while (it.hasNext()) {
			i++;
			if(i==4) {
				System.out.println("4");
				oldChat.setIsbn(it.next());
			}else if(i==6) {
				System.out.println("6");
				oldChat.setUserName(it.next());
			}else if(i==8) {
				System.out.println("8");
				oldChat.setMessage(it.next());
			}else if(i==10) {
				System.out.println("10");
				oldChat.setTime(it.next());
				oldChatList.add(oldChat);
				i=-1;
			}else {
				System.out.println("기타");
				System.out.println(it.next());
			}
		}
		
		System.out.println("#######################");
		Iterator<OldChatting> it2 = oldChatList.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println("#######################");
		
		model.addAttribute("isbn", chatting.getIsbn());
		model.addAttribute("bookTitle",chatting.getBookTitle());
		model.addAttribute("userName", chatting.getUserName());
		model.addAttribute("oldChatList", oldChatList);
		
		
		
		return "../chatting/room";
	}*/
	
	
}
