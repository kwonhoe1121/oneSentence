<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>mp3재생</h3>

<audio controls autoplay>
<source src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${oneSentenceIdx}.mp3" type="audio/mpeg">
<%-- 	<source src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${oneSentenceIdx}.mp3" type="audio/ogg">
	<source src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${oneSentenceIdx}.mp3" type="audio/wav"> --%>
</audio>
</body>
</html>