package com.one.sentence.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter2 extends HandlerInterceptorAdapter {
	// 로그인 상태에서 
	private static final Logger logger = LoggerFactory.getLogger(LoginIntercepter2.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);

		if (session != null) {
			Object obj = session.getAttribute("User");
			if (obj != null) {
				logger.debug("로그인 상태");
				return true;
			}
		}

		logger.debug("비로그인 상태");
		response.sendRedirect(request.getContextPath() + "/login");
		logger.debug("redirect: /login");
		return false;
	}
}
