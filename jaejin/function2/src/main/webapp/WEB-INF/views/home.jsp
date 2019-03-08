<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>main</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<!-- 로그인 회원가입 bar -->
	<div id="login">
		<ul>
			<li><button id="login_btn">로그인</button></li>
			<li><button id="register_btn">회원가입</button></li>
			<li><button id="logout_btn"><a href="<%=request.getContextPath()%>/user/logout">로그아웃</a></button></li>
			<li><button id="like_btn"><a href="<%=request.getContextPath()%>/user/like">좋아요</a></button>
		</ul>
	</div>

	<div class="clear"></div>

	<!-- 추천 마이페이지 bar hidden -->
	<div id="login_ok">
		<ul>
			<li><button id="review">추천도서</button></li>
			<li><button id="user_page">유저페이지</button></li>
		</ul>
	</div>

	<!-- 로그인 모달창. -->
	<div id="login_form">
		<form class="signUp" id="signupForm" action="<%=request.getContextPath()%>/user/login" method="POST">
			<h1 class="signUpTitle">로그인</h1>
			<input type="text" class="signUpInput" placeholder="이메일"
				name="userEmail" autofocus required> <input type="password"
				class="signUpInput" placeholder="비밀번호" name="userPassword" required>
			<input type="submit" value="로그인" class="signUpButton">
		</form>
	</div>

	<!-- 회원가입 모달창. -->
	<div id="register_form">
		<form class="signUp" id="signupForm" action="<%=request.getContextPath()%>/user/register" method="POST">
			<h1 class="signUpTitle">회원가입</h1>
			<input type="text" class="signUpInput" name="userName"
				placeholder="이름" autofocus required> <input type="text"
				class="signUpInput" name="userEmail" placeholder="이메일" required>
			<input type="password" class="signUpInput" name="userPassword"
				placeholder="비밀번호" required> <input type="submit"
				value="등록" class="signUpButton">
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
	<script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>