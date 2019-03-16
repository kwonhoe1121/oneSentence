<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>like</title>
<link href="<c:url value="/resources/css/like2.css" />" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
</head>
<body>

	<div id="like_div">
		<ul>
			<li id="oneSentenceIdx">3</li>
			<li><p>"밤과도 같은 낮에서 진짜 낮으로 향하는 '혼의 전환'이며 이것이야 말로 우리가 진정한
					철학이라고 말하게 될 실재로 향한 등정일것 같으이"</p></li>
			<li><p>플라톤, [국가], p256
				<p></li>
			<li><button class="like_btn">좋아요</button></li>
		</ul>
	</div>

	<script src="<c:url value="/resources/js/like2.js" />"></script>
</body>
</html>