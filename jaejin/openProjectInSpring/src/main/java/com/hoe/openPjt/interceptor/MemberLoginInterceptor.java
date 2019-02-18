package com.hoe.openPjt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberLoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	//회원 로그인 여부 확인
	public boolean preHandle( //반환값이 true면 계속 인터셉터 진행하고 controller까지 이어감.
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		//session 받기.
		HttpSession session = request.getSession(false); // 세션 없더라도 exception 발생 막기위해서.
		
		if(session != null) { //세션 주소검사
			
			Object obj = session.getAttribute("member"); // 세션주소의 데이터 가져오기
				
			if(obj != null) { // 세션 주소의 데이터 검사.
				System.out.println("로그인상태");
				return true; //로그인상태.					
			}	
		}
	
		//메인 페이지로 이동.
		System.out.println("비로그인 상태");
		response.sendRedirect(request.getContextPath() + "/member/memberLogin");
		return false;
	}
	
}
