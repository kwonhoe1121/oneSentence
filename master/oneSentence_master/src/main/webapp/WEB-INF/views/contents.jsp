<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/include/mainHeader.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Contents page</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/eunseon/contents/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/eunseon/contents/css/contents.css"
	rel="stylesheet">
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/eunseon/contents/js/contents.js"></script>
<style>
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


</style>
<script>
$().ready(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0&appId=302606807116615";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

</script>
</head>

<body>
	<%-- <jsp:include page="include/mainHeader.jsp"></jsp:include> --%>
	<%-- <%@include file="include/mainHeader.jsp"%> --%>
	<!-- Header -->
	
		
<c:forEach items="${items}" var="items">
<header class="bg-white">
			<img
				src="${items.cover}" width="100%" height="300rem" style="filter: blur(2px)">
		
		<div id="d2" class="container">

			<img id="photo"
				src="${items.cover}"
				width="150rem" height="200rem">
			<div id="d" class="bg-white">
			
				<ul>
					<li><b style="font-size: 1.2rem">${items.title}</b></li>
					<li>${items.author}</li>
					<li>${items.publisher}</li>
					<hr>
					<li>
					<form action="./onesentence/insertForm" method="POST">
						<input type="text" name="isbn" value="${items.isbn}">
						<input type="text" name="author" value="${items.author}">
						<input type="text" name="publisher" value="${items.publisher}">
						<input type="text" name="bookTitle" value="${items.title}">
						<input type="text" name="bookGenre" value="${items.categoryName}">
					<button id="btn1" type="submit">
							<b style="color: white"> + 코멘트작성&nbsp;&nabla;</b>
					</button>
					</form>
					</li>
				</ul>

			</div>
		</div>
	</header>

	<!-- Page Content -->
	<div class="container" style="padding-bottom: 1.5rem;">

		<div class="row"
			style="border-top-left-radius: 10px; border-top-right-radius: 10px;" id="basicData">
			<div class="col-md-12 mb-5" >
				<br> &nbsp;&nbsp;&nbsp; <b style="font-size: 1.2rem">기본정보</b> <a
					href="#" class="a1"><b>더보기</b></a>
				<hr>
				<ul>
					<li>${items.title}</li>
					<li>${items.author}</li>
					<li>${items.pubDate}/ ${items.itemPage}p</li>
					<br>
					<li>
						<p id="description">${items.description}...</p>
					</li>
				</ul>
								
				<hr>
				&nbsp;&nbsp;&nbsp;<span style="font-size: 1rem">목차</span><a href="#"
					class="a1"><b>더보기</b></a>
				<hr>
				&nbsp;&nbsp;&nbsp;<b style="font-size: 1.2rem">코멘트</b> 
				<a href="../onesentence/list/contents/${items.isbn}"
					class="a1"><b>더보기</b></a>
			</div>
			
		</div>
		
		<div class="row"
			style=" padding-top: 0px">
			<div class="col-md-11 mb-5" style="padding-left: 5rem">
				<div class="card h-100" style="border:none;">
				
				<c:forEach items="${oneSentenceList}" var="onesentence" begin="0" end="4" step="1">
					<div class="card-body" style="margin-bottom:2rem;border-radius: 10px;border:1px solid lightgray;">
						<input type="text" id="session" value="${User.userIdx}" hidden="true">
						&nbsp;<span style="color: darkgray"  class="oneSentenceIdx">${onesentence.oneSentenceIdx}</span>&nbsp;&nbsp;
						<!--한문장번호-->
						<a href="#" style="color: black"><i class="fa fa-user icon">
								${onesentence.userName}</i></a> <span class="eventA"
							style="float: right; padding-right: 1rem; color: darkgray"><i
							class="fa fa-ellipsis-v icon"></i></span><input type="text"
						class="userIdx" value="${onesentence.userIdx}" hidden="true">
						<center>
							<div class="divmodal">
								<div class="all">
								<a href="#" onclick="share(${onesentence.oneSentenceIdx})"
									id="share"><i class="fa fa-send-o icon"></i></a>
							</div>
							<div class="my">
								<a href="#" id="updateBtn"
									onclick="updateClick(${onesentence.oneSentenceIdx})"><i
									class="fa fa-reply icon"></i></a>
							</div>
							<div class="my">
								<a href="../../onesentence/delete/${onesentence.oneSentenceIdx}"
									id="deleteBtn"><i class="fa fa-remove icon"></i></a>
							</div>
							</div>
						</center>
						<span
							style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">${onesentence.oneSentenceRegisteredTime}</span><br> <span
							style="padding-left: 2rem; font-size: 1.5rem;">${onesentence.oneSentence}</span><br> <span
							style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>${onesentence.bookTitle},
								${onesentence.author}, ${onesentence.publisher},
						${onesentence.page} 에서..  </i></span><br>
						<hr>
						<span
							style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">${onesentence.hashtag}</span> <span
							style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"><i
							class="fa fa-heart-o"> ${onesentence.likeTotal}</i></span>
					</div>
				</c:forEach>
				</div>
			</div>
			
			</div>
		</div>
		<!-- /.row -->


	<!-- /.container -->
</c:forEach>
	<!-- Footer -->
	<footer class="py-5 bg-white" style="padding: 1rem">
		<div class="container">
			<br>
			<p class="m-0 text-center" style="color: #458534">데이터 출처서비스
				이용약관개인정보 처리방침</p>
			<p class="m-0 text-center text-black">사업자 등록 번호
				(211-88-66013)고객센터support@watcha.com © 2011–2019 by Watcha. Inc</p>
			<br>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/eunseon/contents/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/eunseon/contents/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/js/sentencelist2.js"></script>
	<script>
		$('#description img').hide();
		var $html = $('#description').html();
		var indexOfbr = $html.indexOf('<br>');
		var substring =$html.substring(indexOfbr+4);
		$('#description').html(substring);	
		
		function share(idx) {
			FB.ui({
			method : 'share_open_graph',
			action_type : 'og.shares',
			action_properties : JSON.stringify({
						object : {
							'og:url' : 'http://127.0.0.1/sentence/onesentence/one/'
									+ idx,
							'og:title' : '한문장',
							'og:description' : '한문장내용',
							'og:image' : 'http://image.kmib.co.kr/online_image/2018/0906/611211110012661971_2.jpg'
						}
					})
			})
		}

		function updateClick(idx) {
			var url = "../../onesentence/popup/" + idx;
			var popupOption = "width=700,height=600";
			window.open(url, "한문장수정하기", popupOption);
		}
	</script>
</body>

</html>
