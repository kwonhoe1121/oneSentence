<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/include/mainHeader.jsp"%>
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


</head>
<body>
	<header style="height:60px"></header>

	<i class="fa fa-book fa-2x" aria-hidden="true"></i>
	<h2 style="font-size : 1.5rem;">도서 더보기</h2>
	<hr>
	<div class="bookmore">
	<c:forEach items="${itemstwo}" var="b2">
		<div class="book_div">
		
			<img
				src="${b2.cover}"
				alt="book_1" class="img-fluid img-rounded book_img">
			<p class="ptitle">
				<strong>${b2.title }</strong>
			</p>
			<p class="ptext_01">${b2.author }</p>
			<p class="ptext_01">${b2.publisher }</p>
			<p class="ptext_01"><c:out value="${fn:substring(b2.pubDate,5,16)}"/></p>
		
			<hr>
		</div>
		</c:forEach>
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/dahye/searchMore/js/searchmore.js"></script>

</body>
</html>