<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>입력완료</title>


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
@font-face {
	font-family: 'BMHANNAAir_ttf';
	src:
		url('<%=request.getContextPath()%>/resources/naeun/sentenceList/font/BMHANNAAir_ttf.ttf');
}

@font-face {
	font-family: 'BMHANNAAir_otf';
	src:
		url('<%=request.getContextPath()%>/resources/naeun/sentenceList/font/BMHANNAAir_otf.otf');
}

* {
	font-family: 'BMHANNAAir_ttf', 'BMHANNAAir_otf';
}
</style>
<!-- Custom styles for this template -->
<link
	href="<%=request.getContextPath()%>/resources/jaejin/css/signin.css"
	rel="stylesheet">
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">	
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body class="text-center" style="display:block">
<img class="mb-4"
			src="<%=request.getContextPath()%>/resources/jaejin/img/logo.png"
			alt="" width="72" height="72"><br>
	<h1>한문장이 등록되었습니다.</h1><br>
	<a href="#" id="close" style="font-size:2rem">닫기</a>

</body>
<script>
	$('#close').on('click', function() {
		console.log("닫기");
		opener.parent.location.reload();
		window.close();
	});
</script>
</html>