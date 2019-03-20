<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page session="false"%>
<%-- <%@include file="include/mainHeader.jsp"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>search page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dahye/search/css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/resources/jaejin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dahye/search/css/search.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/dahye/search/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/dahye/search/js/util.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/dahye/search/js/search.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/dahye/search/js/bootstrap.js"></script>

<style>
	a:link { color: black; text-decoration: none;}
	a:visited { color: black; text-decoration: none;}
	a:hover { color: black; text-decoration: none;}
</style>

</head>
<body>

	<%-- <%@include file="include/mainHeader.jsp"%> --%>
	
	<c:choose>
	<c:when test="${fn:length(items) > 0 }">

	<div class="all">
		<h2 class="h2">
			<strong>통합 검색 결과</strong><a href="../search/searchMore?query=${param.query}"><span class="more"><strong>더보기</strong></span></a>
		</h2>

		<div class="container">
			<div class="row">
				<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1"
					id="MultiCarousel" data-interval="1000">
					<div class="MultiCarousel-inner">
					<c:forEach items="${items}" var="b">
					 
					 
						<div class="item">

							<div class="pad15" id="bookdiv" style="height:26rem;">
										 	<a href="../contentsPage/${b.isbn }" id="books">
											<input type="text" name="bookId" value="${b.isbn }" hidden="true">

						
	   										<img src="${b.cover}" 
	   										alt="book_1" class="img-fluid img-rounded book_img" name="books" style="width:8rem;height:12rem">
	   										
		   									<p class="ptitle" name="books">
											<strong>${b.title }</strong>
											</p>
											<p class="ptext_01" name="books">${b.author }</p>
											<p class="ptext_01" name="books">${b.publisher }</p>
											<p class="ptext_01" name="books"><c:out value="${fn:substring(b.pubDate,5,16)}"/></p>
					
	
							</div>
						</div>
						</a>
					</c:forEach>
					
					</div>

					<button class="btn btn-primary leftLst"><</button>
					<button class="btn btn-primary rightLst">></button>
				</div>
			</div>
		</div>
	</div>



	<hr>

	<div class="book_lank">
		<h2 class="h2">
			<strong>인기순</strong><a href="../search/searchMoreBest?query=${param.query}"><span class="more"><strong>더보기</strong></span></a>
		</h2>
		<div class="container">
			<div class="row">
				<div class="MultiCarousel" data-items="1,3,5,6" data-slide="1"
					id="MultiCarousel" data-interval="1000">
					<div class="MultiCarousel-inner">
					 <c:forEach items="${itemtwo}" var="b2">
			
						
					 	
					 <a href="../contentsPage/${b2.isbn }" id="books">
					 <input type="text" name="bookId" value="${b2.isbn }" hidden="true">
						<div class="item">
						
							<div class="pad15" style="height:26rem;">
								<img
									src="${b2.cover }"
									alt="book_1" class="img-fluid img-rounded book_img" style="width:8rem;height:12rem">
								<p class="ptitle">
									<strong>${b2.title }</strong>
								</p>
								<p class="ptext_01">${b2.author }</p>
								<p class="ptext_01">${b2.publisher }</p>
								<p class="ptext_01"><c:out value="${fn:substring(b2.pubDate,5,16)}"/></p>
								
							</div>
						</div>
						</a>
				
					</c:forEach>
					
					</div>

					<button class="btn btn-primary leftLst"><</button>
					<button class="btn btn-primary rightLst">></button>
				</div>
			</div>
		</div>
		<hr>
	</div>
	</c:when>
	<c:otherwise>
	<h3 class="booksearchfail">도서 조회결과가 없습니다.</h3>
	<hr>
	</c:otherwise>
	</c:choose>

	<c:choose>

	<c:when test="${fn:length(useritems) > 0 }">
	<div class="user_search">
		<h2 class="h2">
			<strong>사용자</strong><a href="../search/searchMoreUser?query=${param.query}"><span class="more"><strong>더보기</strong></span></a>
		</h2>
		
		<div class="line">
<%-- 		
		 	<c:forEach items="${useritems }" var="userSearch"></a>
<!-- 		 	<div class="userdiv" style="float: left;"> -->
			<img
				src="<%=request.getContextPath()%>/resources/dahye/search/img/userimgpng.png"
				alt="user_1"
				class="<%=request.getContextPath()%>/resources/dahye/search/img-circle user_img">
				
			<span class="usertext">${userSearch }</span>

			</div>
			 </c:forEach>
 --%>
			 
			 	<c:forEach items="${userInfo}" var="userSearch">
			<img
				src="${pageContext.request.contextPath}/resources/dahye/search/img/userimgpng.png"
				alt="user_1"
				class="${pageContext.request.contextPath}/resources/dahye/search/img-circle user_img">
				
			<span class="usertext"><a href="${pageContext.request.contextPath}/userpage/${userSearch.userIdx }">${userSearch.userName}</a></span>

			 </c:forEach>
			 </div>
			 </c:when>
			 <c:otherwise>
			 		<h3>사용자 조회된 결과가 없습니다.</h3>
			 </c:otherwise>
			</c:choose> 
		</div>
	</div>
	<hr>
	
	<c:choose>
	<c:when test="${fn:length(hashtagitems) > 0 }">
	<div class="hashtagsearch">

		<h2 class="h2">
			<strong>한문장 검색결과</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2>


	<c:forEach items="${hashtagitems }" var="hashtagitems">
		<table>
		
			<tr>
				<td>이름</td>
				<td>책이름</td>
				<td>저자</td>
				<td>출판사</td>
				<td>한문장</td>
				<td>페이지</td>
			</tr>
			
			<tr>
				<td>유다혜</td>
				<td>에어프라이어 만능 레시피북</td>
				<td>김영희</td>
				<td>한빛출판사</td>
				<td>어쩌구저쩌구</td>
				<td>128p</td>
			</tr>
		</table>
	</c:forEach>
	</c:when>
	<c:otherwise>
	<h3 class="onesentenfail">한문장 조회결과가 없습니다.</h3>
	</c:otherwise>
	</c:choose>
	</div>
	
	
</body>
</html>