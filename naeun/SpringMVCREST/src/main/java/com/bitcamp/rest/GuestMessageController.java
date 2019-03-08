package com.bitcamp.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageController {
	
	
	@RequestMapping("/guest/messages/xml")
	@ResponseBody	//반환형 타입 앞쪽에 들어가도 됨
	public GuestMessageList getXml(){
	
		List<GuestMessage> list = new ArrayList<GuestMessage>();
		
		// id-message-creationTime
		list.add(new GuestMessage("1", "첫번째 메시지", new Date()));  
		list.add(new GuestMessage("2", "두번째 메시지", new Date())); 
		list.add(new GuestMessage("3", "세번째 메시지", new Date())); 
		
		// GuestMessageList클래스의 생성자 참고
		return new GuestMessageList(list);		
	}
	
	
	@RequestMapping("/guest/messages/json")
	@ResponseBody	//반환형 타입 앞쪽에 들어가도 됨
	public GuestMessageList2 getJSON(){
	
		List<GuestMessage2> list = new ArrayList<GuestMessage2>();
		
		// id-message-creationTime
		list.add(new GuestMessage2("1", "첫번째 메시지", new Date()));  
		list.add(new GuestMessage2("2", "두번째 메시지", new Date())); 
		list.add(new GuestMessage2("3", "세번째 메시지", new Date())); 
		
		// GuestMessageList클래스의 생성자 참고
		return new GuestMessageList2(list);		
	}
	
	// RestApiController에 넣으면 form.jsp로 넘어가지 않고 'form'이라는 String이 화면에 출력됨
	@RequestMapping("/guest/form")
	public String getForm() {
		return "form";
	}
	
	
}
