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

<title>한문장 메인 헤더</title>

<link
	href="${pageContext.request.contextPath}/resources/jaejin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link
	href="${pageContext.request.contextPath}/resources/jaejin/css/custom.css"
	rel="stylesheet">
	
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
        @media(max-width:800px) {
           	.container3 {
                width: 150px;
                margin-left: 0px;
                margin-right: 0px;
            }
			
			.navbar-brand {
				/* margin-left: 0px; */
                margin-right: 0px;
			}

        }

</style>
</head>

<body>
	<!-- Navigation -->
	<!-- 로그인 전 nav -->
	<c:if test="${User eq null}">
		<nav class="navbar navbar-expand-lg navbar-light fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">한문장</a>
				<!-- <div class="container"> -->
				<div class="container3">

				<form class="navbar-form naver-right"  action="${pageContext.request.contextPath}/search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="query">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search icon"></i>
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
						<!-- 로그인, 회원가입 버튼. -->

						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/login"><button
									class="btn navbar-btn">로그인</button></a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/register"><button
									class="btn btn-primary navbar-btn">회원가입</button></a></li>
					</ul>

				</div>

			</div>
		</nav>
	</c:if>

	<!-- 로그인 완료 nav -->
	<c:if test="${User ne null}">
		<nav class="navbar navbar-expand-lg navbar-light fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">한문장</a>
				<!-- <div class="container"> -->
				<div class="container3">

				<form class="navbar-form naver-right" action="${pageContext.request.contextPath}/search">

					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="query">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search icon"></i>
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

						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/onesentence/list/all"><button
									class="btn navbar-btn">추천</button></a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/userpage/${User.userIdx}"><button
									class="btn btn-primary navbar-btn">마이페이지</button></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</c:if>
</body>
</html>