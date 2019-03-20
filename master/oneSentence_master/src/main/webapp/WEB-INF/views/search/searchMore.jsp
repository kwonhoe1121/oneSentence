<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<style>
	a:link { color: black; text-decoration: none;}
	a:visited { color: black; text-decoration: none;}
	a:hover { color: black; text-decoration: none;}
</style>

</head>
<body>


	<i class="fa fa-book fa-3x" aria-hidden="true"></i>
	<h1>도서 더보기</h1>
	<hr>
	<div class="bookmore" id="bookscroll" hidden="true">
	<c:forEach items="${items}" var="b">
		<div class="book_div">
			<a href="../contentsPage/${b.isbn }" id="books">
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

	var bookmore = document.getElementsByClassName('bookmore');
	bookmore[0].hidden = false;
	bookmore[1].hidden = false;
	bookmore[2].hidden = false;
	bookmore[3].hidden = false;
	bookmore[4].hidden = false;
	bookmore[5].hidden = false;
	
	var b =5;
	$(window).scroll(function(){
		if ($(window).scrollTop() == $(document).height() - $(window).height()) {
			bookmore[++b].hidden=false;
		}
		
		
	})
	
	</script>
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/dahye/searchMore/js/searchmore.js"></script>

</body>
</html>