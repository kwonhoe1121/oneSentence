<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/include/mainHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>한문장-도서 더보기 페이지</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/jaejin/img/favicon.ico">
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
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<header style="height:60px"></header>

	<i class="fa fa-book fa-2x" aria-hidden="true"></i>
	<h2 style="font-size : 1.5rem;">도서 더보기</h2>
	<hr>
	<div class="bookmore" id="bookscroll" >
	<c:forEach items="${items}" var="b">
		<div class="book_div" hideen="true">
			<a href="${pageContext.request.contextPath}/contentsPage/${b.isbn }" id="books">
			<img
				src="${b.cover}"
				alt="book_1" class="img-fluid img-rounded book_img">
			<p class="ptitle">
				<strong>${b.title }</strong>
			</p>
			<p class="ptext_01">${b.author }</p>
			<p class="ptext_01">${b.publisher }</p>
			<p class="ptext_01"><c:out value="${fn:substring(b.pubDate,5,16)}"/></p>
			</a>
			<hr>
		</div>
		</c:forEach>
	</div>
	<script>

	var book_div = document.getElementsByClassName('book_div');
	book_div[0].hidden = false;
	book_div[1].hidden = false;
	book_div[2].hidden = false;
	book_div[3].hidden = false;
	book_div[4].hidden = false;
	book_div[5].hidden = false;
	
	var b =5;
	$(window).scroll(function() {
		if ($(window).scrollTop() == $(document).height() - $(window).height()) {
			book_div[++b].hidden=false;
		}
		
		
	})
	
	</script>
	

</body>
</html>