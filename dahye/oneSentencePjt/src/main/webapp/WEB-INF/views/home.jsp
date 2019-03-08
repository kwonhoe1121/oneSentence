<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장</title>
<style>
.search {
	float: left;
	margin-left: auto;
	margin-right: auto;
}

#searchbox {
	width: 500px;
	height: 30px;
}

#searchbtn {
	width: 60px;
	height: 30px;
}
</style>
</head>
<body>

	<header>
		<h1>한문장 메인화면</h1>
	</header>
	<form action="<%request.getContextPath()%>/search" method="get">
		<div class="div1">
			<input type="search" class="search"
				placeholder="도서제목,저자,출판사,사용자를 검색하세요." id="searchbox" name="search">
			<input type="submit" class="search" id="searchbtn" value="검색">
		</div>
	</form>


</body>
</html>