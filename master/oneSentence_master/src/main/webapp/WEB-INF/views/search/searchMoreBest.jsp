<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>searchMore</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/dahye/searchMore/css/searchmore.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">


</head>
<body>


	<i class="fa fa-book fa-3x" aria-hidden="true"></i>
	<h1>도서 더보기</h1>
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
			<p class="ptext_01">${b2.pubDate }</p>
		
			<hr>
		</div>
		</c:forEach>
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/dahye/searchMore/js/searchmore.js"></script>

</body>
</html>