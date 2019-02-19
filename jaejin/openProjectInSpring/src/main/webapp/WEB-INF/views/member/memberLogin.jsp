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

	<div id="member_login">
		<ul id="memberLogin">
			<li>
				<h2>로그인</h2>
			</li>
			<!-- <div class="clear"></div>
			<hr><br> -->
			<li>로그인 성공!</li>
			<li>ID: ${member.email }, PW: ${member.password }</li>
			<li><a href="<%=request.getContextPath() %>/member/memberMypage"><h3>마이페이지보러가기</h3></a></li>
			<li><a href="<%=request.getContextPath() %>/member/memberDelete"</a>회원탈퇴</li>
			<li><a href="<%=request.getContextPath() %>/member/memberUpdate"</a>회원정보수정</li>
		</ul>

	</div>

</body>
</html>