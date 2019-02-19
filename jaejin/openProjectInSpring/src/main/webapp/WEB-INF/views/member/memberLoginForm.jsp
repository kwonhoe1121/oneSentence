<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>memberRegForm</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet"> 
</head>

<body>
	<jsp:include page="../main.jsp"></jsp:include>

	<div id="member_login_form">
		<form method="post">
			<ul id="loginList">
				<li><h2>회원로그인</h2><hr></li>
				<li><label>아이디(이메일)</label><input type="text" class="regBox"
					name="email"></li>
				<li><label>비밀번호</label><input type="password" class="regBox"
					name="password"></li>
				<li><label></label><input type="submit" value="로그인"></li>
			</ul>
			<hr>
		</form>
	</div>

</body>

</html>
