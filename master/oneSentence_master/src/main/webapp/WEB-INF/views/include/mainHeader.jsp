<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>main_header page</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/jaejin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/resources/jaejin/css/full-width-pics.css"
	rel="stylesheet">

<!-- Custom Styles by jaejin -->
<link
	href="<%=request.getContextPath()%>/resources/jaejin/css/custom.css"
	rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<!-- 로그인 전 nav -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">한문장</a>
			<!-- <div class="container"> -->
			<!-- <div class="container2"> -->

			<form class="navbar-form naver-right">
				<!-- <div class="searchBox" class="form-group">
                            <label for="search" class="sr-only">검색:</label>
                            <input type="text" class="form-control" placeholder="검색어 입력" value="">
                            <button type="submit"></button>
                        </div> -->
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>

			<!-- </div> -->
			<!-- </div> -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<!-- 로그인, 회원가입 버튼. -->

					<li class="nav-item"><a class="nav-link" href="login"><button
								class="btn navbar-btn">로그인</button></a></li>
					<li class="nav-item"><a class="nav-link" href="register"><button
								class="btn btn-success navbar-btn">회원가입</button></a></li>
				</ul>

			</div>

		</div>
	</nav>

	<!-- 로그인 완료 nav -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		style="visibility: hidden;">
		<div class="container">
			<a class="navbar-brand" href="#">한문장</a>
			<!-- <div class="container"> -->
			<div class="container2">

				<form class="navbar-form naver-right">
					<!-- <div class="searchBox" class="form-group">
                                <label for="search" class="sr-only">검색:</label>
                                <input type="text" class="form-control" placeholder="검색어 입력" value="">
                                <button type="submit"></button>
                            </div> -->
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
			<!-- </div> -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<!-- 추천, 마이페이지. -->

					<li class="nav-item"><a class="nav-link" href="#"><button
								class="btn navbar-btn">추천</button></a></li>
					<li class="nav-item"><a class="nav-link" href="#"><button
								class="btn btn-success navbar-btn">마이페이지</button></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<br>
	<br>
	<hr>

	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/jaejin/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/jaejin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>



</html>