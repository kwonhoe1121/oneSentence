<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>user page</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/naeun/user/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<style>
@font-face {
	font-family: 'BMHANNAAir_ttf';
	src: url('<%=request.getContextPath()%>/resources/naeun/user/font/BMHANNAAir_ttf.ttf');
}

@font-face {
	font-family: 'BMHANNAAir_otf';
	src: url('<%=request.getContextPath()%>/resources/naeun/user/font/BMHANNAAir_otf.otf');
}

body {
	font-family: 'BMHANNAAir_ttf', 'BMHANNAAir_otf';
}
</style>

<script
		src="<%=request.getContextPath()%>/resources/naeun/user/js/userpage.js"></script>
</head>
<body>
<!-- userpage.js부분 가져오기 -->
<%
	String val="팔로잉";
%>

	<div id="search">검색창 들어갈 자리</div>

	<!-- Page Content -->
	<div class="container">

		<!-- Post Content Column -->
		<div class="col-lg-8">

			<!-- Comments Form -->
			<div class="card my-4">
				<div class="card-header" id="part1">
					<img id="img1" src="<%=request.getContextPath()%>/resources/naeun/user/img/9c7e52813cc7517492fb362d2f090d47.jpg">
					<i class="fa fa-cog fa-2x" aria-hidden="true"><a href="#"></a></i>
				</div>

				<div class="card-header" id="part2">
					<i class="fa fa-user-circle fa-4x" aria-hidden="true"></i>
					<h3 class="bold">김김김</h3>
					<input type="submit" value=<%=val %> class="btn btn-primary"
						id="follow">
					<h5>자기소개입니당(default="프로필이 없습니다.")</h5>
					<input type="submit" value="수정" class="btn btn-primary" id="update">
				</div>

				<h4 class="card-header" id="part3">
					<a href="#">취향분석(링크)</a>
				</h4>
				<div class="card-header" id="part4">
					<h4 class="bold">
						<a href="#">친구소식(링크)</a>
					</h4>
					<h5>팔로우 한 친구들의 소식을 받아볼 수 있습니다.</h5>
				</div>
			</div>
		</div>

	</div>

	<!-- Footer  -->
	<footer class="py-5 bg-dark">
		<div class="container">

			<p class="m-0 text-center" id="footer1">
				지금까지 <i class="fa fa-star" aria-hidden="true"></i> 100개의 문장이 쌓였어요!
			</p>
			<br>
			<p class="m-0 text-center">
				<a href="#">서비스 이용 약관</a> &nbsp; &nbsp; <a href="#">개인정보 처리방침</a>
			</p>
			<br>
			<div id="footer2">
				<p class="m-0 text-center">고객센터 onesentence@naver.com</p>
				<p class="m-0 text-center">One Sentence &copy; 2019 by One
					Sentence.Inc</p>
			</div>
		</div>
	</footer>


	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/naeun/user/vendor/jquery/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/naeun/user/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/naeun/user/js/userpage.js"></script>

</body>
</html>




