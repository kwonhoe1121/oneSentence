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
<title>한문장 선택하기</title>

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
li{
	font-size:1rem;
	padding-right:4rem;
	list-style:none;
	float:left;
}
#choose{
	width:60%;display:initial;
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
</head>

<body class="text-center" style="display:block">
	
		
		<img class="mb-4"
			src="<%=request.getContextPath()%>/resources/jaejin/img/logo.png"
			alt="" width="72" height="72"><br>
		<h4>한문장을 선택하세요</h4><br>
		<ul>
		<c:forTokens var="OneSentence" items ="${OneSentenceList}" delims="." >
		<li><input type="radio" name="sentence" value="${OneSentence}">${OneSentence}</li>
		</c:forTokens>	
		</ul><br><br>
		<button class="btn btn-lg btn-success btn-block" type="submit" id="choose"><i class="fa fa-check icon"></i></button>

<script>
$('#choose').on('click',function(){
	opener.document.getElementById("oneSentence").value=$('input:checked').val();
	window.close();
});
</script>
</body>

</html>
