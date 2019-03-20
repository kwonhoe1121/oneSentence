<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/mainHeader2.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>searchMore</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dahye/searchMore/css/searchmore.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<style>
	a:link { color: black; text-decoration: none;}
	a:visited { color: black; text-decoration: none;}
	a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
	
	<header style="height:60px"></header>
	
	<h1>사용자</h1>
	<hr>
	
<%-- 	<c:forEach items="${useritems }" var="userSearch">
	<div class="user_search">
		<div class="line">
		 	<div class="imgline">
			<img
				src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png"
				alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img">
			</div>
			<span class="usertext">${userSearch }</span>
			 
			 
		</div>
	</div>
	<hr>
	</c:forEach> --%>

	
	 	<c:forEach items="${userInfo }" var="userSearch">
	<div class="user_search">
		<div class="line">
		 	<div class="imgline">
			<img
				src="${pageContext.request.contextPath}/resources/dahye/search/img/userimgpng.png"
				alt="user_1"
				class="${pageContext.request.contextPath}/resources/dahye/search/img-circle user_img">
			</div>
			<span class="usertext"><a href="${pageContext.request.contextPath}/userpage/${userSearch.userIdx }">${userSearch.userName}</a></span>
				 
		</div>
	</div>
	<hr>
	</c:forEach>

	 
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/dahye/searchMore/js/searchmore.js"></script>

</body>
</html>