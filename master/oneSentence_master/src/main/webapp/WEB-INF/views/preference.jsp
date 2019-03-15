<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>prference page</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/naeun/preference/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/resources/naeun/preference/css/preference.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<style>
@font-face {
	font-family: 'BMHANNAAir_ttf';
	src: url("<%=request.getContextPath()%>/resources/naeun/preference/font/BMHANNAAir_ttf.ttf");
}

@font-face {
	font-family: 'BMHANNAAir_otf';
	src: url("<%=request.getContextPath()%>/resources/naeun/preference/font/BMHANNAAir_otf.otf");
}

* {
	font-family: 'BMHANNAAir_ttf', 'BMHANNAAir_otf';
}
</style>

</head>
<body>
	<!-- Page Content -->
	<div class="container">
		<!-- Post Content Column -->
		<div class="col-lg-8">
			<!-- Comments Form -->
			<div class="card1 my-4">
				<div class="backgroundimg" style="background-image: url('<%=request.getContextPath()%>/resources/naeun/preference/img/6d0a9dce557e7f6e96b0456ff3994329.jpg')">
					<h3 class="logo">One Sentence</h3>
					<h6 class="logo">취향분석</h6>
					<br> <i class="fa fa-user-circle fa-3x" aria-hidden="true"></i>
					<h5 class="logo">이름</h5>
				</div>
			</div>
			<div class="card my-4">
				<h4 class="card-header">등록한 한 문장 수</h4>
				<div id="grade">
					<i class="fa fa-book fa-3x" aria-hidden="true"></i> &nbsp; <i
						class="fa fa-book fa-3x" aria-hidden="true"></i> &nbsp; <i
						class="fa fa-book fa-3x" aria-hidden="true"></i> &nbsp; <i
						class="fa fa-book fa-3x" aria-hidden="true"></i> &nbsp; <i
						class="fa fa-book fa-3x" aria-hidden="true"></i><br> <br>
					<h6>한문장 상위 10%! (총 @@개의 문장)</h6>
				</div>
				<h5 class="card-body" id="comment">한문장 등록을 정말 많이 하셨군요! 당신은 한문장
					그 자체!</h5>
			</div>
			<div class="card my-4">
				<h4 class="card-header">
					<a href="#">나의 히스토리(링크)</a>
				</h4>
				<div class="card-body"></div>
			</div>
			<div class="card my-4">
				<h4 class="card-header">도서 선호태그</h4>
				<div id="hashtag" class="card-body"
					style="width: 20rem; height: 13rem;">
					<span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(40px, 0px) rotate(0deg);">남주혁
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(120px, 25px) rotate(0deg);">한감자
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 96px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(205px, 15px) rotate(0deg);">감자처리기사
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(5px, 50px) rotate(0deg);">오이디은선
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(180px, 55px) rotate(0deg);">부트스트랩
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 128px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(45px, 75px) rotate(0deg);">감자
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(30px, 105px) rotate(0deg);">인생책
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(210px, 88px) rotate(0deg);">다혜의스펀지화법
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(130px, 120px) rotate(0deg);">감자의조퇴
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(160px, 148px) rotate(0deg);">css시러
					</span>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/naeun/preference/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/naeun/preference/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
