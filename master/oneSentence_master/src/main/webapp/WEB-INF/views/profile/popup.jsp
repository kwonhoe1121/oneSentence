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
<title>회원정보수정</title>

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
		action="${pageContext.request.contextPath}/profile/update" method="POST">
		<img class="mb-4"
			src="${pageContext.request.contextPath}/resources/jaejin/img/logo.png"
			alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">회원정보 수정</h1>
		<input class="hidden" type="text" id="userIdx" name="userIdx" value="${user_info.userIdx}">
		
		<label for="userName" class="sr-only">userName</label> 
		<input
			type="text" id="userName" name="userName" class="form-control"
			value="${user_info.userName}" required autofocus><br>
		
		<label for="originalPassword" class="sr-only">originalPassword</label> 
		<input
			type="password" id="originalPassword" name="originalPassword" class="form-control"
			value="${user_info.userPassword}" ><br>
		
		<label for="newPassword" class="sr-only">newPassword</label> 
		<input
			type="password" id="newPassword" name="newPassword" class="form-control" placeholder="새로운 비밀번호"><br>
		
		<label for="checkNewPassword" class="sr-only">checkNewPassword</label> 
		<input
			type="password" id="checkNewPassword" name="checkNewPassword" class="form-control" placeholder="비밀번호 확인"><br>
			
		<label for="userIntroduction" class="sr-only">userIntroduction</label> 
		<input
			type="text" id="userIntroduction" name="userIntroduction" class="form-control"
			value="${user_info.userIntroduction}" ><br>	
			<br><br>
		
		<button class="btn btn-lg btn-success btn-block" id="btn">수정완료</button>
	</form>

	<!-- bootstrap core JavaScript   -->
	<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script> -->
<script>
$().ready(function(){
	$('.hidden').hide();
	var btn = document.getElementById('btn');
	
	btn.onclick=function(){
		var newPassword = $('#newPassword').val();
		var checkNewPassword = $('#checkNewPassword').val();
		var userName = $('#userName').val();
		console.log(newPassword);
		console.log(checkNewPassword);
		console.log(checkNewPassword===newPassword);
		

		if(!(checkNewPassword!==newPassword||userName==null||userName==="")){
			var result = confirm("수정하시겠습니까?");
			if(result){
			$('form').prop('action','${pageContext.request.contextPath}/profile/update');
			}
		}else{
			alert("올바르지 않은 입력입니다.");
		}		
	}
});
</script>
</body>

</html>
