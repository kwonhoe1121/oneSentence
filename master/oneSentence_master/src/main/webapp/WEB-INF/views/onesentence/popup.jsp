<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>한문장입력 폼</title>

<!-- <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/"> -->

<!-- Bootstrap core CSS -->
<!-- 
    <link href="../dist:css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous"> -->

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
#findAtPhoto{
	color:darkgrey;
	font-size:0.8rem;
	font-weight:bold;
	float:right;
	padding-right:1rem;
}
</style>
<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/jaejin/css/signin.css"
	rel="stylesheet">
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">	
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body class="text-center">
	<form class="form-signin"
		action="../update" method="POST">
		<img class="mb-4"
			src="${pageContext.request.contextPath}/resources/jaejin/img/logo.png"
			alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">한문장 수정</h1>
		<input class="hidden" type="text" id="isbn" name="isbn" value="${onesentence.isbn}">
		<input class="hidden" type="text" id="oneSentenceIdx" name="oneSentenceIdx" value="${onesentence.oneSentenceIdx}">
		
		<label for="page" class="sr-only">Page</label> 
		<input
			type="text" id="page" name="page" class="form-control"
			value="${onesentence.page}" ><br> 
		<label
			for="oneSentence" class="sr-only">OneSentence</label> <input
			type="text" id="oneSentence" name="oneSentence" class="form-control"
			 value="${onesentence.oneSentence}" required autofocus>
			<br><br>
		
		<button class="btn btn-lg btn-success btn-block" type="submit">수정완료</button>
	</form>

	<!-- bootstrap core JavaScript   -->
	<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script> -->
<script>
$().ready(function(){
	$('.hidden').hide();
});
</script>
</body>

</html>
