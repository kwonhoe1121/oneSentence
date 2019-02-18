<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet">
</head>
<body>

	<jsp:include page="../main.jsp"></jsp:include>

	<div id="member_memberList">
		<h2>회원 리스트</h2>
		<hr>
		
		<c:forEach items="${memberList }" var="mem">
			이름: ${mem.name } , 아이디(email) : ${mem.email } 
			<br>	
		</c:forEach>
		
		
	<!-- 	<ul id="memberList">
						멤버리스트 동적으로 채워야 하나? List로 가져와서 foreach문 돌리기.jstl, el 태그 사용	
		</ul> -->
	</div>

</body>
</html>