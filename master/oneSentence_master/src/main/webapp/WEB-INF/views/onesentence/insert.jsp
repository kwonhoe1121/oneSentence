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
@font-face {
	font-family: 'BMHANNAAir_ttf';
	src:
		url('${pageContext.request.contextPath}/resources/naeun/sentenceList/font/BMHANNAAir_ttf.ttf');
}

@font-face {
	font-family: 'BMHANNAAir_otf';
	src:
		url('${pageContext.request.contextPath}/resources/naeun/sentenceList/font/BMHANNAAir_otf.otf');
}

* {

font-family: 'BMHANNAAir_ttf', 'BMHANNAAir_otf';
	}
	
#findAtPhoto{
	color:darkgrey;
	font-size:0.8rem;
	font-weight:bold;
	float:right;
	padding-right:1rem;
}


@font-face { font-family: 'Handon3gyeopsal600g'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_seven@1.2/Handon3gyeopsal600g.woff') format('woff'); font-weight: normal; font-style: normal; }

.logotest{
	font-family: 'Handon3gyeopsal600g';
	font-size:2.5rem;
	text-align:center;
	color:green;
	font-weight:bold;
	margin-bottom:2rem;
}

a:hover{
	text-decoration:none;
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
		action="${pageContext.request.contextPath}/onesentence/insert" method="POST">
<%-- 		<img class="mb-4"
			src="${pageContext.request.contextPath}/resources/jaejin/img/logo.png"
			alt="" width="72" height="72"> --%>					
			<a href="${pageContext.request.contextPath}/">
				<div  class="logotest">One Sentence</div>
			</a>
		<h1 class="h3 mb-3 font-weight-normal">한문장 작성</h1>
		<input class="hidden" type="text" id="isbn" name="isbn" value="<%=request.getParameter("isbn") %>">
		<input class="hidden" type="text" id="author" name="author" value="<%=request.getParameter("author") %>">
		<input class="hidden" type="text" id="publisher" name="publisher" value="<%=request.getParameter("publisher") %>">
		<input class="hidden" type="text" id="bookTitle" name="bookTitle" value="<%=request.getParameter("bookTitle") %>">
		<input class="hidden" type="text" id="bookGenre" name="bookGenre" value="<%=request.getParameter("bookGenre") %>">
		<input class="hidden" type="text" id="userIdx" name="userIdx" value="${User.userIdx}"><!-- 세션받아오기 -->
		
		<label for="page" class="sr-only">Page</label> 
		
		<input
			type="text" id="page" name="page" class="form-control"
			placeholder="페이지" required autofocus><br> 
		<label
			for="oneSentence" class="sr-only">OneSentence</label> <input
			type="text" id="oneSentence" name="oneSentence" class="form-control"
			placeholder="한문장을 입력해주세요" required autofocus>
			<a href="#" onclick="photo()" id="findAtPhoto"><i class="fa fa-camera icon">
							    사진에서 찾기</i></a><br><br>
		<label for="hashtag1" class="sr-only">Hashtag</label> 
		<input
			type="text" id="hashtag1" name="hashtag1" class="form-control"
			placeholder="#해시태그" ><br>
		<input
			type="text" id="hashtag2" name="hashtag2" class="form-control"
			placeholder="#해시태그"><br>
		<input
			type="text" id="hashtag3" name="hashtag3" class="form-control"
			placeholder="#해시태그"><br>	
		<label for="gender" style="font-weight:bolder;margin-left:2rem;float:left;">목소리 선택</label>
		<input
			type="radio" name="gender" value="male" style="margin-left:-3rem;" checked="checked">male
		<input
			type="radio" name="gender" value="female">female<br><br>		
		<button class="btn btn-lg btn-success btn-block" type="submit">작성완료</button>
	</form>

	<!-- bootstrap core JavaScript   -->
	<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script> -->
<script>
$().ready(function(){
 $('.hidden').hide();
	
	
$('#findAtPhoto').on('click',function(){
	console.log("insert By photo Click");
	var url="${pageContext.request.contextPath}/onesentence/popupForPhoto";
	var popupOption="width=600,height=600";
	window.open(url,"사진으로 한문장찾기",popupOption);
});


});
</script>
</body>

</html>
