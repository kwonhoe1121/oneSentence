<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<jsp:include page="include/mainHeader.jsp"></jsp:include>

	<i class="fa fa-book fa-3x" aria-hidden="true"></i>
	<h1>도서 더보기</h1>
	<hr>
	<div class="bookmore">
		<div class="book_div">
			<img
				src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg"
				alt="book_1" class="img-fluid img-rounded book_img">
			<p class="ptitle">
				<strong>강아지와고양이</strong>
			</p>
			<p class="ptext_01">김철수</p>
			<p class="ptext_01">강아지출판사</p>
			<p class="ptext_01">2019</p>
			<hr>
		</div>
		<div class="book_div">
			<img
				src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg"
				alt="book_1" class="img-fluid img-rounded book_img">
			<p class="ptitle">
				<strong>강아지와고양이</strong>
			</p>
			<p class="ptext_01">김철수</p>
			<p class="ptext_01">강아지출판사</p>
			<p class="ptext_01">2019</p>
			<hr>
		</div>
		<div class="book_div">
			<img
				src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg"
				alt="book_1" class="img-fluid img-rounded book_img">
			<p class="ptitle">
				<strong>강아지와고양이</strong>
			</p>
			<p class="ptext_01">김철수</p>
			<p class="ptext_01">강아지출판사</p>
			<p class="ptext_01">2019</p>
			<hr>
		</div>
		<img
			src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg"
			alt="book_1" class="img-fluid img-rounded book_img">
		<p class="ptitle">
			<strong>강아지와고양이</strong>
		</p>
		<p class="ptext_01">김철수</p>
		<p class="ptext_01">강아지출판사</p>
		<p class="ptext_01">2019</p>
		<hr>
		<div class="book_div">
			<img
				src="<%=request.getContextPath()%>/resources/dahye/search/img/book1.jpg"
				alt="book_1" class="img-fluid img-rounded book_img">
			<p class="ptitle">
				<strong>강아지와고양이</strong>
			</p>
			<p class="ptext_01">김철수</p>
			<p class="ptext_01">강아지출판사</p>
			<p class="ptext_01">2019</p>
			<hr>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/dahye/searchMore/js/searchmore.js"></script>

</body>
</html>