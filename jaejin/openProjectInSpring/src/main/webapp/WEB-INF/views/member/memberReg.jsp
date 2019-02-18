<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>memberReg</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main.jsp"></jsp:include>

	<div id="member_reg">
		<ul id="memberReg">
			<li>
				<h2>회원가입</h2><hr>
			</li>
			<li>회원가입 성공!</li>
			<li>${result}</li>
			<li><a href="<%=request.getContextPath() %>/member/memberLogin"><h3>로그인하러가기</h3></a></li>
		</ul>

	</div>
</body>
</html>