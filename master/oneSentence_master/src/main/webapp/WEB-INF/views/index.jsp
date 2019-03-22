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

<title>한문장 메인페이지</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/jaejin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<%-- <link href="${pageContext.request.contextPath}/resources/jaejin/vendor/bootstrap/css/bootstap.min.css" 
	rel="stylesheet"> --%>

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/jaejin/css/full-width-pics.css"
	rel="stylesheet">

<!-- Custom Styles by jaejin -->
<link
	href="${pageContext.request.contextPath}/resources/jaejin/css/custom.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
	
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

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
</style>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>

<body>

	<!-- 로그인시 이전 페이지로 redirect -->
	<%-- <c:if test="${referer ne null }">
		<c:redirect url="${referer}" />
	</c:if> --%>

	<%-- <%@include file="include/mainHeader.jsp"%> --%>

	<!-- Navigation -->
	<!-- 로그인 전 -->
	<c:if test="${User eq null}">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/">한문장</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<!-- 로그인, 회원가입 버튼. -->
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/login"><button
									class="btn navbar-btn">로그인</button></a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/register"><button
									class="btn btn-success navbar-btn">회원가입</button></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:if>

	<!-- 로그인 후 -->
	<c:if test="${User ne null}">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/">한문장</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/onesentence/list/all"><button
									class="btn navbar-btn">추천</button></a></li>&nbsp;&nbsp;&nbsp;
						<li class="nav-item">
							<a class="nav-link"
								href="${pageContext.request.contextPath}/userpage/${User.userIdx}"><button
									class="btn btn-success navbar-btn">마이페이지</button></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</c:if>


	<!-- Header - set the background image for the header in the line below -->
	<header class="py-5 bg-image-full"
		style="background-image: url('${pageContext.request.contextPath}/resources/jaejin/img/main.png'); min-height: 388px">
		<div id=test>
			<img class="img-fluid d-block mx-auto"
				src="${pageContext.request.contextPath}/resources/jaejin/img/logo.png"
				alt="">
		</div>
		<!-- <div class="py-5"></div> -->
	</header>

	<!-- Content section -->
	<section class="py-5">
		<!-- 검색 엔진 -->
		<div class="container" style="position: relative; top: -65px;">
			<div class="container2">
				<form class="form-signin"
					action="${pageContext.request.contextPath}/search"
					method="GET">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="query">
						<div class="input-group-btn">
							<button class="btn btn-default" style="background-color: #F6F5F4" type="submit" onclick="send(this.form)">
								<i class="fa fa-search icon" name="query"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="container" style="position: relative; top: -30px">
			<div class="container2">
				<h1>여러분의 한 문장을 등록해주세요.</h1>
				<br>
				<!-- <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, suscipit, rerum quos facilis repellat
          architecto commodi officia atque nemo facere eum non illo voluptatem quae delectus odit vel itaque amet.</p> -->
				<p>"자신이 생각하기에 이 한 권의 책의 주제를 가장 뚜렷하고 집약적으로 드러내는 구절을 뽑는 것이다. 이런
					일에는 정답이 있을 수 없으니 부담없이 뽑으면 된다. 어떤 구절을 뽑느냐는 자신이 이 책을 어떤 측면에서 읽었느냐를
					드러내는 것이 될 것이다. 또 2년 정도 후에 이 책을 다시 읽었을 때에는 지금 뽑은 구절과는 다른 것을 뽑을 수도 있을
					것이다. 그것이 자신이 책을 읽는 실력이 향상되었음을 의미할 수도 있고, 그 기간 동안 세상을 보는 자신의 눈이
					바뀌었음을 뜻할 수도 있을 것이다. 이런 과정을 거치면서 고전을 즐기는 것도 나름대로 재미있는 일이다."</p>
				<p>[서구 정치사상 고전읽기], p83~84, 강유원, 라티오출판사</p>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="py-5" style="background-color:#F6F5F4">
		<div class="container">
			<div class="container2">
				<p class="m-0 text-center text-black">
					You can join our project with
					https://github.com/kwonhoe1121/oneSentence <br> This is the
					final project in bitcamp
				</p>
			</div>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/jaejin/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/jaejin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	
		  <!-- 검색창에 입력안했을경우 -->
		<script type="text/javascript">

		function send(theform){ //form 을 받는다.

		if(theform.query.value==""){

		//받은 form 의 input text name인s search의 value 가 빈칸일때.

		alert("검색어를 입력 하세요.");

		theform.query.focus(); //text 창으로 커서

		return false;

		}

		theform.submit();

		}
	
	
	</script>
</body>

</html>

