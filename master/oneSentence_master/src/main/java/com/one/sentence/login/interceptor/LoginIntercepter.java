package com.one.sentence.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	//로그인 상태에서 로그인 요청 들어오면 막기위한 인터셉터.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);

		if (session != null) {
			Object obj = session.getAttribute("User");
			if (obj != null) {
				System.out.println("로그인 상태");
				response.sendRedirect(request.getContextPath() + "/");
				return false;
			}
		}
		
		System.out.println("비로그인 상태");
//		response.sendRedirect(request.getContextPath() + "/login");
		return true;
	}
	
}
