package com.one.sentence.kakaologin.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.kakaologin.service.KakaoLoginService;

@Controller
public class KakaoLoginController {

	@Autowired
	private KakaoLoginService service;	
	
	// 사용자 토큰은 얻은 code를 이용해서 POST 방식으로 요청해야한다 (cf.뷰에서 Ajax로 요청하거나 컨트롤러에서 요청하면 된다.)
	// 다음은 컨트롤러에서 요청하기 위한 함수
	@RequestMapping(value="/kakaologin", produces="application/json")
	public String kakaologin(@RequestParam("code") String code, Model model, HttpSession session) {
		JsonNode jsonToken = getAccessToken(code);

		String access_token = jsonToken.get("access_token").toString();
		session.setAttribute("access_token",access_token);
		
		JsonNode kakaoUserInfo = getKakaoUserInfo(access_token);
		
		String id = kakaoUserInfo.path("id").asText();

		JsonNode properties = kakaoUserInfo.path("properties");
		String nickname = properties.path("nickname").asText();
		
		// 이미 user_info 테이블에 등록 되어있나 확인
		if(service.checkKakaoUser(id) != null) {
			// 되어있으면 로그인 처리
			UserVo loginuser = service.checkKakaoUser(id);			
			session.setAttribute("User",loginuser);			
		}
		else {// 안되어있으면 등록 후 로그인 처리
			UserVo uservo = new UserVo();
			uservo.setUserEmail(id);
			uservo.setUserName(nickname);
			uservo.setEmailStatus("3");
			
			service.registerKakaoUser(uservo);
			UserVo loginuser = service.checkKakaoUser(id);			
			session.setAttribute("User",loginuser);		
		}

		return "redirect:/";
	}
	
	
	
	// 토큰 얻어오는 메서드
	public JsonNode getAccessToken(String autorize_code) {
		System.out.println("autorize_code="+autorize_code);
	        
	    final String RequestUrl = "https://kauth.kakao.com/oauth/token";	 
	    final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
	        
	    //포스트 파라미터의 grant_type이라는 명칭에 authorization_code를 추가한다 아래도 동일
        postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));	 
        postParams.add(new BasicNameValuePair("client_id", "ad0264e1ffef69d01b6778d82c031206"));	 
        postParams.add(new BasicNameValuePair("redirect_uri", "http://15.164.87.42/sentence/kakaologin")); //예 : http://아이피:포트/최상위폴더/리다이렉션경로	 
        postParams.add(new BasicNameValuePair("code", autorize_code));
	        
	
        final HttpClient client = HttpClientBuilder.create().build();
 
        final HttpPost post = new HttpPost(RequestUrl);
 
        JsonNode returnNode = null;
	 
        try {
            post.setEntity(new UrlEncodedFormEntity(postParams));
            final HttpResponse response = client.execute(post);	 
           
            //JSON 형태 반환값 처리
            ObjectMapper mapper = new ObjectMapper();	 
            returnNode = mapper.readTree(response.getEntity().getContent());
 
        } catch (UnsupportedEncodingException e) {	 
            e.printStackTrace();	 
        } catch (ClientProtocolException e) {	 
            e.printStackTrace();	 
        } catch (IOException e) {	 
            e.printStackTrace();	 
        } finally {}
        
        return returnNode;
	 
	}

	
	 // 토큰으로 사용자 정보 얻어오는 메서드
	 public static JsonNode getKakaoUserInfo(String autorize_code) {			

		 final String RequestUrl = "https://kapi.kakao.com/v1/user/me";
		 final HttpClient client = HttpClientBuilder.create().build();
		 final HttpPost post = new HttpPost(RequestUrl);	    

	    // add header
	    post.addHeader("Authorization", "Bearer " + autorize_code);
	    JsonNode returnNode = null;

	    try {

	      final HttpResponse response = client.execute(post);
	      final int responseCode = response.getStatusLine().getStatusCode();

	      System.out.println("\nSending 'POST' request to URL : " + RequestUrl);
	      System.out.println("Response Code : " + responseCode);


	      //JSON 형태 반환값 처리

	      ObjectMapper mapper = new ObjectMapper();
	      returnNode = mapper.readTree(response.getEntity().getContent());

	     
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	        // clear resources
	    }

	    return returnNode;
	    
	 }
	 
	 
	 // 토큰으로 로그아웃 시키는 메서드 -> 잘안됨..ㅠㅠ
	 public JsonNode kakaoLogout(String autorize_code) {

		 final String RequestUrl = "https://kapi.kakao.com/v1/user/logout";		 
	     final HttpClient client = HttpClientBuilder.create().build();
	     final HttpPost post = new HttpPost(RequestUrl);
	 
	     post.addHeader("Authorization", "Bearer " + autorize_code);	 
	     JsonNode returnNode = null;
	 
	     try {
	    	 final HttpResponse response = client.execute(post);
	    	 ObjectMapper mapper = new ObjectMapper();
	    	 returnNode = mapper.readTree(response.getEntity().getContent());
	    	 System.out.println("!!!!! ==> " + response.getHeaders("Status Code"));
	    } catch (UnsupportedEncodingException e) {
	    	e.printStackTrace();
	    } catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {}
	     
	     return returnNode;
	     
	 }
}
