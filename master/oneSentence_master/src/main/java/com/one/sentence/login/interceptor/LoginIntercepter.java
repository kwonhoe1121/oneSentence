package com.one.sentence.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	//로그인이 필요한 요청url 생각해서 막기.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);

		if (session != null) {
			Object obj = session.getAttribute("User");
			if (obj != null) {
				System.out.println("로그인 상태");
				return true;
			}
		}
		
		//login창으로
		System.out.println("비로그인 상태");
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
	
}
