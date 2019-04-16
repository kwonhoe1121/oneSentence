<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
	* {
		margin-top: 1rem;
	}
	body{
	    background-color: #F6F5F4;
	    }
	h3 {
		text-align: center;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h3>
		<i class="fa fa-volume-up icon" id="player"> OneSentence Player</i>
	</h3>
	<center>
	<c:forEach items="${oneSentenceIdxList}" var="list">
		<audio controls class="play" onended="next()">
			<source
				src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${list}.mp3"
				type="audio/mpeg">
		</audio>
		<br>
	</c:forEach>
	</center>
	<script>
		var play = document.getElementsByClassName('play');

		play[0].oncanplaythrough = function() {
			play[0].play();
		}

		var k = 0;
		function next() {
			++k;
			if (k < play.length) {
				play[k].play();
			}
		}
	</script>
</body>
</html>