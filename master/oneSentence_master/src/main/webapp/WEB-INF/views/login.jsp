<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>로그인 폼</title>

<!-- <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/"> -->

<!-- Bootstrap core CSS -->

<!-- <link href="../dist:css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous"> -->

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- Custom styles for this template, 폰트관련 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
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
/* 폰트관련. */
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
<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/jaejin/css/signin.css"
	rel="stylesheet">
</head>

<body class="text-center">

	<!-- 로그인 완료 후 이전 페이지로 이동 -->
	<c:if test="${User ne null}">
		<c:redirect url="${referer}" />
	</c:if>

	<form class="form-signin"
		action="${pageContext.request.contextPath}/user/login" method="POST">
		<a href="${pageContext.request.contextPath}/"><img class="mb-4"
			src="${pageContext.request.contextPath}/resources/jaejin/img/logo.png"
			alt="" width="72" height="72"></a>
		<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
		<label for="inputEmail" class="sr-only">Email address</label> <input
			type="email" id="inputEmail" name="userEmail" class="form-control"
			placeholder="이메일" required autofocus><br> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" name="userPassword"
			class="form-control" placeholder="비밀번호" required><br>
		<!-- <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div> -->
		<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
		<p class="mt-5 mb-3 text-muted">
			<a href="${pageContext.request.contextPath}/mailPage">비밀번호를
				잃어버리셨나요?</a> <br> <br> 계정이 없으신가요? <a
				href="${pageContext.request.contextPath}/register">회원가입</a>
		</p>
	</form>
	<!-- bootstrap core JavaScript   -->
	<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script> -->
	<script src="https://code.jquery.com/jquery-1.10.0.js"></script>

	<script type="text/javascript">
		//email focusout
		$("#inputEmail")
				.on(
						"focusout",
						function() {
							/* alert("userEmail focusout"); */
							var userEmail = $("#inputEmail").val();
							console.log(userEmail);

							$
									.ajax({
										type : "POST",
										url : "${pageContext.request.contextPath}/users/emailCheck",
										data : JSON.stringify({
											"userEmail" : userEmail
										}),
										dataType : "json",
										contentType : "application/json; charset=UTf-8",
										success : function(data) {
											console.log(data);
											console.log(data.emailCheck);
											console.log($("#inputEmail"));
											if (data.emailCheck === "이메일이 틀렸습니다.") {
												$("#inputEmail")
														.after(
																"<div id='emailCheck'>"
																		+ data.emailCheck
																		+ "</div>");
											}
										},
										error : function(error) {
											console.log("에러발생: " + error);
										}

									});
						});
		//다시 focusin시 삭제.
		$("#inputEmail").on("focusin", function() {
			$("#emailCheck").remove();
		});

		//password focusout
		$("#inputPassword")
				.on(
						"focusout",
						function() {
							/* alert("userPassword focusout"); */
							console.log("userPassword focusout");

							var userPassword = $("#inputPassword").val();
							var userEmail = $("#inputEmail").val();
							console.log(userEmail);
							console.log(userPassword);

							$
									.ajax({
										type : "POST",
										url : "${pageContext.request.contextPath}/users/pwdCheck",
										data : JSON.stringify({
											"userEmail" : userEmail,
											"userPassword" : userPassword
										}),
										dataType : "json",
										contentType : "application/json; charset=UTF-8",
										success : function(data) {
											console.log(data);
											if (data.passwordCheck === "비밀번호가 틀립니다.") {
												$("#inputPassword")
														.after(
																"<div id='passwordCheck'>"
																		+ data.passwordCheck
																		+ "</div>");
											}
										},
										error : function(error) {
											console.log("에러발생 : " + error);
										}

									});
							//다시 focusin시 삭제.
							$("#inputPassword").on("focusin", function() {
								$("#passwordCheck").remove();
							});
						});
	</script>

</body>

</html>
