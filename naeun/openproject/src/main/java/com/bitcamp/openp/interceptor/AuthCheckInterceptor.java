package com.bitcamp.openp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession(false);
		String from = request.getRequestURI();
		request.setAttribute("referer", from.substring(6));

		
		if(session != null) {
			Object authObj = session.getAttribute("loginInfo");
			if(authObj != null) { // 세션 있고, 로그인 되어있을 경우			
				return true;				
			}
		}
		
		response.sendRedirect(request.getContextPath()+"/memberLogin");		
		return false;
	}

}
