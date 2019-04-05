<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@include file="/WEB-INF/views/include/mainHeader.jsp"%> 
<%-- <%@include file="/WEB-INF/views/testHeader.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>한문장-유저페이지</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/jaejin/img/favicon.ico">
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/naeun/user/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
	
<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<style>
@font-face {
	font-family: 'BMHANNAAir_ttf';
	src:
		url('${pageContext.request.contextPath}/resources/naeun/user/font/BMHANNAAir_ttf.ttf');
}

@font-face {
	font-family: 'BMHANNAAir_otf';
	src:
		url('${pageContext.request.contextPath}/resources/naeun/user/font/BMHANNAAir_otf.otf');
}

* {
	font-family: 'BMHANNAAir_ttf', 'BMHANNAAir_otf';
}
/* .container{
	margin-top:3.5rem; } */
</style>

</head>
<body>
	
	<div id="header">
		<%-- <a href="${pageContext.request.contextPath}/indexPage"><i class="fa fa-home fa-2x"
			aria-hidden="true"></i></a> --%>
	</div>

	<!-- Page Content -->
	<div class="container">

		<!-- Post Content Column -->
		<div class="col-lg-8">

			<!-- Comments Form -->
			<div class="card my-4">
				<div class="card-header" id="part1">
					<img id="img1"
						src="${pageContext.request.contextPath}/resources/naeun/user/img/9c7e52813cc7517492fb362d2f090d47.jpg">
					<a href="#" onclick="setting()"><i class="fa fa-cog fa-2x"
						aria-hidden="true"></i></a>
					<div id="settingDiv" aria-hidden="true">
						<c:set var="logout" value="logout" scope="session"/>
						
						<c:if test="${uservo.emailStatus} eq '3' ">
							<c:set var="logout" value="kakaologout" scope="session"/>
						</c:if>
						<a href="${pageContext.request.contextPath}/user/${logout}">로그아웃</a><br>
						<a href="${pageContext.request.contextPath}/user/withdraw">회원탈퇴</a>

					</div>
				</div>


				<div class="card-header" id="part2">
					<i class="fa fa-user-circle fa-4x" aria-hidden="true"></i>
					<h3 class="bold">${uservo.userName}</h3>
					<input type="submit" value="${followingstate}"
						class="btn btn-primary1" id="follow"> <input type="hidden"
						value="${flag}" id="flag"> <input type="hidden"
						value="${loginIdx}" id="loginIdx"> <input type="hidden"
						value="${uservo.userIdx}" id="userIdx">
					<h5>${uservo.userIntroduction}</h5>
					<input type="submit" value="수정" class="btn btn-primary1" id="update">
				</div>

				<h4 class="card-header" id="part3">
					<a href="${pageContext.request.contextPath}/userpage/preference/${uservo.userIdx }">취향분석(링크)</a>
				</h4>
				<div class="card-header" id="part4">
					<h4 class="bold">
						<a href="${pageContext.request.contextPath}/followingnews/news/${uservo.userIdx }">친구소식(링크)</a>
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
				지금까지 <i class="fa fa-star" aria-hidden="true"></i>
				${countAllSentences }개의 문장이 쌓였어요!
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
		src="${pageContext.request.contextPath}/resources/naeun/user/vendor/jquery/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/user/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/user/js/userpage.js"></script>
	<script>
		$('#settingDiv').hide();
		function setting() {
			$('#settingDiv').show();
		}
		$(document).mouseup(function(e) {
			console.log('ff');
			var container = $('#settingDiv');
			if (container.has(e.target).length === 0) {
				container.hide();
			}
		})
	</script>
</body>
</html>




