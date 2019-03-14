<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Contents page</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/resources/eunseon/contents/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/resources/eunseon/contents/css/contents.css"
	rel="stylesheet">
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/eunseon/contents/js/contents.js"></script>
</head>

<body>

	<jsp:include page="include/mainHeader.jsp"></jsp:include>

	<!-- Navigation -->
	<!-- 	<nav class="navbar navbar-expand-lg navbar-dark bg-white fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#"><b>One Sentence</b></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Services</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>
				</ul>
			</div>
		</div>
	</nav> -->
	<!-- Header -->
	<header class="bg-white py-5 mb-5">
		<div>
			<img
				src="<%=request.getContextPath()%>/resources/eunseon/contents/img/contents.jpg"
				width="100%" height="300rem" style="filter: blur(5px)">
		</div>
		<div id="d2" class="container">
			<img id="photo"
				src="<%=request.getContextPath()%>/resources/eunseon/contents/img/contents.jpg"
				width="150rem" height="200rem">
			<div id="d" class="bg-white">
				<ul>
					<li><b style="font-size: 1.2rem">채식주의자</b></li>
					<li>한강 / 소설</li>
					<hr>
					<li><button id="btn1">
							<b style="color: white"> + 코멘트작성&nbsp;&nabla;</b>
						</button></li>
				</ul>
			</div>
		</div>
	</header>

	<!-- Page Content -->
	<div class="container" style="padding-bottom: 1.5rem;">

		<div class="row"
			style="border-top-left-radius: 10px; border-top-right-radius: 10px;">
			<div class="col-md-12 mb-5">
				<br> &nbsp;&nbsp;&nbsp; <b style="font-size: 1.2rem">기본정보</b> <a
					href="#" class="a1"><b>더보기</b></a>
				<hr>
				<ul>
					<li>채식주의자</li>
					<li>한강 / 소설</li>
					<li>2007/ 대한민국/ 247p</li>
					<br>
					<li>
						<p>2016년 맨부커상(Man Booker International Prize) 수상작. 10년 전 작가
							한강은 '내 여자의 열매'라는 단편소설을 썼다. 한 여자가 아파트 베란다에서 식물이 되고, 함께 살던 남자는 그녀를
							화분에 심는 이야기였다. '채식주의자'는 언젠가 그 변주를 쓰고 싶다는 바람에서...</p>
					</li>
				</ul>
				<hr>
				&nbsp;&nbsp;&nbsp;<span style="font-size: 1rem">목차</span><a href="#"
					class="a1"><b>더보기</b></a>
				<hr>
				&nbsp;&nbsp;&nbsp;<b style="font-size: 1.2rem">코멘트</b> <a href="#"
					class="a1"><b>더보기</b></a>
			</div>
		</div>
		<div class="row"
			style="border-bottom-left-radius: 10px; border-bottom-right-radius: 10px; padding-top: 0px">
			<div class="col-md-11 mb-5" style="padding-left: 5rem">
				<div class="card h-100">
					<div class="card-body">
						&nbsp;<span style="color: darkgray">1</span>&nbsp;&nbsp;
						<!--한문장번호-->
						<a href="#" style="color: black"><i class="fa fa-user icon">
								신짱구1</i></a> <span class="eventA"
							style="float: right; padding-right: 1rem; color: darkgray"><i
							class="fa fa-ellipsis-v icon"></i></span>
						<center>
							<div class="divmodal">
								<!--#modal>에 아이콘누른 누른 유저에 따라 <a>태그 붙이는 이벤트 필요함-->
								<div class="all" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-send-o icon"></i></a>
								</div>
							</div>
						</center>
						<span
							style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">2019.3.12
							23:10</span><br> <span
							style="padding-left: 2rem; font-size: 1.5rem;">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit.</span><br> <span
							style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>채식주의자,
								한강, 창비, p128 에서.. </i></span><br>
						<hr>
						<span
							style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">#봉미선
							#흰둥이</span> <span
							style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"><i
							class="fa fa-heart"> 11</i></span>
					</div>
				</div>
			</div>
			<div class="col-md-11 mb-5" style="padding-left: 5rem">
				<div class="card h-100">
					<div class="card-body">
						&nbsp;<span style="color: darkgray">1</span>&nbsp;&nbsp;
						<!--한문장번호-->
						<a href="#" style="color: black"><i class="fa fa-user icon">
								신짱구2</i></a> <span
							style="float: right; padding-right: 1rem; color: darkgray"
							class="eventA"><i class="fa fa-ellipsis-v icon"></i></span>
						<center>
							<div class="divmodal">
								<div class="my" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-reply icon"></i></a>
								</div>
								<!--수정-->
								<div class="my" style="background-color: #3b5998;">
									<a href=""><i class="fa fa-remove icon"></i></a>
								</div>
								<!--삭제-->
								<div class="all" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-send-o icon"></i></a>
								</div>
							</div>
						</center>
						<span
							style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">2019.3.12
							23:10</span><br> <span
							style="padding-left: 2rem; font-size: 1.5rem;">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit.</span><br> <span
							style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>채식주의자,
								한강, 창비, p128 에서.. </i></span><br>
						<hr>
						<span
							style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">#봉미선
							#흰둥이</span> <span
							style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"><i
							class="fa fa-heart"> 11</i></span>
					</div>
				</div>
			</div>
			<div class="col-md-11 mb-5" style="padding-left: 5rem">
				<div class="card h-100">
					<div class="card-body">
						&nbsp;<span style="color: darkgray">1</span>&nbsp;&nbsp;
						<!--한문장번호-->
						<a href="#" style="color: black"><i class="fa fa-user icon">
								신짱구2</i></a> <span
							style="float: right; padding-right: 1rem; color: darkgray"
							class="eventA"><i class="fa fa-ellipsis-v icon"></i></span>
						<center>
							<div class="divmodal">
								<div class="my" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-reply icon"></i></a>
								</div>
								<!--수정-->
								<div class="my" style="background-color: #3b5998;">
									<a href=""><i class="fa fa-remove icon"></i></a>
								</div>
								<!--삭제-->
								<div class="all" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-send-o icon"></i></a>
								</div>
							</div>
						</center>
						<span
							style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">2019.3.12
							23:10</span><br> <span
							style="padding-left: 2rem; font-size: 1.5rem;">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit.</span><br> <span
							style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>채식주의자,
								한강, 창비, p128 에서.. </i></span><br>
						<hr>
						<span
							style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">#봉미선
							#흰둥이</span> <span
							style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"><i
							class="fa fa-heart"> 11</i></span>
					</div>
				</div>
			</div>
			<div class="col-md-11 mb-5" style="padding-left: 5rem">
				<div class="card h-100">
					<div class="card-body">
						&nbsp;<span style="color: darkgray">1</span>&nbsp;&nbsp;
						<!--한문장번호-->
						<a href="#" style="color: black"><i class="fa fa-user icon">
								신짱구2</i></a> <span
							style="float: right; padding-right: 1rem; color: darkgray"
							class="eventA"><i class="fa fa-ellipsis-v icon"></i></span>
						<center>
							<div class="divmodal">
								<div class="my" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-reply icon"></i></a>
								</div>
								<!--수정-->
								<div class="my" style="background-color: #3b5998;">
									<a href=""><i class="fa fa-remove icon"></i></a>
								</div>
								<!--삭제-->
								<div class="all" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-send-o icon"></i></a>
								</div>
							</div>
						</center>
						<span
							style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">2019.3.12
							23:10</span><br> <span
							style="padding-left: 2rem; font-size: 1.5rem;">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit.</span><br> <span
							style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>채식주의자,
								한강, 창비, p128 에서.. </i></span><br>
						<hr>
						<span
							style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">#봉미선
							#흰둥이</span> <span
							style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"><i
							class="fa fa-heart"> 11</i></span>
					</div>
				</div>
			</div>
			<div class="col-md-11 mb-5" style="padding-left: 5rem">
				<div class="card h-100">
					<div class="card-body">
						&nbsp;<span style="color: darkgray">1</span>&nbsp;&nbsp;
						<!--한문장번호-->
						<a href="#" style="color: black"><i class="fa fa-user icon">
								신짱구2</i></a> <span
							style="float: right; padding-right: 1rem; color: darkgray"
							class="eventA"><i class="fa fa-ellipsis-v icon"></i></span>
						<center>
							<div class="divmodal">
								<div class="my" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-reply icon"></i></a>
								</div>
								<!--수정-->
								<div class="my" style="background-color: #3b5998;">
									<a href=""><i class="fa fa-remove icon"></i></a>
								</div>
								<!--삭제-->
								<div class="all" style="background-color: #3b5998;">
									<a href="#"><i class="fa fa-send-o icon"></i></a>
								</div>
							</div>
						</center>
						<span
							style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">2019.3.12
							23:10</span><br> <span
							style="padding-left: 2rem; font-size: 1.5rem;">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit.</span><br> <span
							style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>채식주의자,
								한강, 창비, p128 에서.. </i></span><br>
						<hr>
						<span
							style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">#봉미선
							#흰둥이</span> <span
							style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"><i
							class="fa fa-heart"> 11</i></span>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-white" style="padding: 1rem">
		<div class="container">
			<br>
			<p class="m-0 text-center" style="color: #458534">데이터 출처서비스
				이용약관개인정보 처리방침</p>
			<p class="m-0 text-center text-black">사업자 등록 번호
				(211-88-66013)고객센터support@watcha.com © 2011–2019 by Watcha. Inc</p>
			<br>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script
		src="<%=request.getContextPath()%>/resources/eunseon/contents/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/eunseon/contents/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>