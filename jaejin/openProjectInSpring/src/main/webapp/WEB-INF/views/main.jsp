<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<div id="top_banner">
		<h1>Open Project</h1>
	</div>

	<div id="menu_list">
		<hr>
		<ul id="menuList">
			<li><a href="<%=request.getContextPath()%>/member/memberReg">회원가입</a></li>
			<li><a href="<%=request.getContextPath()%>/member/memberLogin">로그인</a></li>
			<li><a href="<%=request.getContextPath()%>/member/memberLogout">로그아웃</a></li>
			<li><a href="<%=request.getContextPath()%>/member/memberMypage">마이페이지</a>(회원)</li>
			<li><a href="<%=request.getContextPath()%>/member/memberList">회원리스트(회원)</a></li>
		</ul>
		<div class="clear"></div>
		<hr>
	</div>
</body>
</html>