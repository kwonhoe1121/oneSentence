<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Document</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet">
</head>

<body>
	<jsp:include page="../main.jsp"></jsp:include>

	<div id="member_mypage">
		<ul id="memberMypage">
			<li>
				<h2>회원 마이페이지</h2>
				<hr>
			</li>
			<li>사진</li>
			<li>회원번호 : ${member.altKey}</li>
			<li>회원아이디(이메일) : ${member.email}</li>
			<li>회원이름 : ${member.name}</li>
		</ul>
	</div>
</body>

</html>
