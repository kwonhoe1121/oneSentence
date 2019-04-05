<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>한문장-취향분석페이지</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/jaejin/img/favicon.ico">
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/naeun/preference/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/naeun/preference/css/preference.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<style>
@font-face {
	font-family: 'BMHANNAAir_ttf';
	src:
		url("${pageContext.request.contextPath}/resources/naeun/preference/font/BMHANNAAir_ttf.ttf");
}

@font-face {
	font-family: 'BMHANNAAir_otf';
	src:
		url("${pageContext.request.contextPath}/resources/naeun/preference/font/BMHANNAAir_otf.otf");
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
				<div class="backgroundimg"
					style="background-image: url('${pageContext.request.contextPath}/resources/naeun/preference/img/6d0a9dce557e7f6e96b0456ff3994329.jpg')">
					<h3 class="logo">One Sentence</h3>
					<h6 class="logo">취향분석</h6>
					<br> <i class="fa fa-user-circle fa-3x" aria-hidden="true"></i>
					<h5 class="logo">${uservo.userName}</h5>
				</div>
			</div>
			<div class="card my-4">
				<h4 class="card-header">등록한 한 문장 수</h4>
				<input type="hidden" value="${grade}" id="usergrade"> <input
					type="hidden" value="${percent}" id="percent"> <input
					type="hidden" value="${countMySentences}" id="countMySentences">
				<div id="grade"></div>
				<h5 class="card-body" id="comment">${comment}</h5>
			</div>
			<div class="card my-4">
				<h4 class="card-header">
					<a href="${pageContext.request.contextPath}/onesentence/list/${userIdx}">나의 히스토리(링크)</a>
				</h4>
				<div class="card-body"></div>
			</div>
			<div class="card my-4">
				<h4 class="card-header">한문장 선호태그</h4>
				<div id="hashtag" class="card-body"
					style="width: 24rem; height: 15rem;">
					<span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(40px, 0px) rotate(0deg);">#${hashtaglist[0]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 96px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(230px, 13px) rotate(0deg);">#${hashtaglist[2]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(120px, 25px) rotate(0deg);">#${hashtaglist[1]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(5px, 50px) rotate(0deg);">#${hashtaglist[3]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(190px, 58px) rotate(0deg);">#${hashtaglist[4]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 128px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(40px, 88px) rotate(0deg);">#${hashtaglist[5]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(230px, 99px) rotate(0deg);">#${hashtaglist[7]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(100px, 130px) rotate(0deg);">#${hashtaglist[6]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(255px, 144px) rotate(0deg);">#${hashtaglist[8]}
					</span> <span
						style="position: absolute; font-size: 17px; font-weight: bold; line-height: 23px; color: crimson; width: 64px; text-align: center; white-space: nowrap; transform-origin: center bottom; transform: translate(60px, 175px) rotate(0deg);">#${hashtaglist[9]}
					</span>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/naeun/preference/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/preference/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/preference/js/grade.js"></script>
</body>

</html>
