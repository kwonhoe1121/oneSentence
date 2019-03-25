<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>mp3재생</h3>
<c:forEach items="${oneSentenceIdxList}" var="list">
<audio controls>

<source class="play" src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${list}.mp3" type="audio/mpeg">
<%-- 	<source src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${oneSentenceIdx}.mp3" type="audio/ogg">
	<source src="${pageContext.request.contextPath}/resources/eunseon/mp3Folder/${oneSentenceIdx}.mp3" type="audio/wav"> --%>

</audio><br>
</c:forEach>
</body>
</html>