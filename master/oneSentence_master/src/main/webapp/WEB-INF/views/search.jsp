<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/include/mainHeader.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>search page</title>
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dahye/search/css/bootstrap.css"> --%>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/resources/jaejin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/naeun/sentenceList/css/sentenceList.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/naeun/sentenceList/css/sentenceList2.css"
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
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">	
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

	<%-- <%@include file="include/mainHeader.jsp"%> --%>
	<div style="height:60px"></div>
	
	<c:choose>
	<c:when test="${fn:length(items) > 0 }">

	<div class="all2">
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

							<div class="pad15" id="bookdiv" style="height:26rem;overflow:scroll">
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
						
							<div class="pad15" style="height:26rem;color:black;overflow:scroll;">
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
	<%-- <c:when test="${fn:length(hashtagitems) > 0 }"> --%>
	<c:when test="${fn:length(oneSentenceList) > 0 }">
	<!-- <div class="hashtagsearch">
		<h2 class="h2">
			<strong>한문장 검색결과</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2> -->
<div class="container">
		<!-- Post Content Column -->
		
	<h2 class="h2">
			<strong>한문장 검색결과</strong><a href=""><span class="more"><strong>더보기</strong></span></a>
		</h2>
	<c:forEach items="${oneSentenceList}" var="onesentence" begin="0" end="4" step="1">
				<div class="newdiv" style="background-color:#f6f5f4;border:1px solid lightgrey;font-size:1.5rem">
					<span style="color: darkgray; padding-right: 1rem"
						class="oneSentenceIdx">${onesentence.oneSentenceIdx}</span>
					<!--한문장번호-->
					<a href="#" ><i class="fa fa-user icon" style="color: black">
							${onesentence.userName}</i></a> <span class="eventA"><i
						class="fa fa-ellipsis-v icon"></i></span> <input type="text"
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
						style="padding-left: 2rem; font-size: 1rem; color: darkgray">${onesentence.oneSentenceRegisteredTime}</span><br>
					<span style="padding-left: 2rem; font-size: 2rem;">${onesentence.oneSentence}</span><br>
					<span
						style="float: right; padding-right: 2rem; font-size: 1.5rem; color: darkgray">${onesentence.bookTitle},
						${onesentence.author}, ${onesentence.publisher},
						${onesentence.page} 에서.. </i>
					</span><br>
					<hr>
					<span class="hashtag" style="font-size:1.2rem;padding-left:2rem">${onesentence.hashtag}</span> <span
						class="like"><i class="fa fa-heart-o" style="color:red;font-size:1.2rem">
							${onesentence.likeTotal}</i></span>
				</div>
			</c:forEach>
			</div>
	
	</c:when>
	<c:otherwise>
	<h3 class="onesentenfail">한문장 조회결과가 없습니다.</h3>
	</c:otherwise>
	</c:choose>
	
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/js/sentencelist2.js"></script>
	<script>
	
		showLikedSentenceStatus();
			  
	   
		
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
	    
		/* click like button  */
		$(".like").on("click", function (data){
			
			/* alert("like button click!!"); */
			console.log(data);
			/* var $this = $("this"); */
			/* oneSentenceIdx 값 가져오기. */
			var oneSentenceIdx = $(this).parent("div").find("span").html();
			//좋아요 카운트
			var likeCnt = $(this).find("i")[0].innerText;
			console.log(oneSentenceIdx);
		    //하트 아이콘 변경. & count 증가.
			console.log($(this).find("i")[0].innerText);
		   	
		    if($(this).find("i")[0].className === "fa fa-heart") {
				$(this).find("i")[0].className = "fa fa-heart-o";
				//하트 개수 감소.
				if(likeCnt !== "0") {				
					likeCnt = likeCnt - 1;
				}
				$(this).find("i")[0].innerText = likeCnt;
			} else {
				$(this).find("i")[0].className = "fa fa-heart";
				//하트 개수 증가.
				likeCnt = Number(likeCnt) + 1;
				console.log(likeCnt);
				$(this).find("i")[0].innerText = "";
				$(this).find("i")[0].innerText = likeCnt;
			}
			
			//ajax처리 해서 서버 요청.
			 $.ajax({
	        	type: "POST",
	       		url: "${pageContext.request.contextPath}/user/clickLike",
	       		data: JSON.stringify({
	            "oneSentenceIdx": oneSentenceIdx
		        }),
		        dataType: "text",
		        contentType: "application/json; charset=UTf-8",
		        success: function (data) {
		            console.log("좋아요 요청 성공!");
		            // alert("좋아요 클릭 반영 성공!!");
		            
		            //좋아요 아이콘 이미지 토글로 변경시킨다.
		        },
		        error: function () {
		            console.log("에러발생!!")
		            // alert("에러발생!!");
		        }
		    })
			
		});
		
		/* like status in oneSentence */
		function showLikedSentenceStatus() {
			console.log($(".newdiv").find(".oneSentenceIdx"));
			/* console.log($(".newdiv")); */
			
			//oneSentenceIdx 값 모두 가져오기.
			var oneSentenceIdx = [];
		 	for(var i = 0; i < $(".newdiv").find(".oneSentenceIdx").length; i += 1) {
				oneSentenceIdx[i] = $(".newdiv").find(".oneSentenceIdx")[i].innerText;
			}
			/* console.log(oneSentenceIdx); */
			
			var requestData = {"oneSentenceIdx" : oneSentenceIdx}
			
			//oneSentenceIdx값 모두 가져다가 서버로 넘긴다. (배열에 담아서)
		
			$.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/user/isLiked",
				data: requestData,
				dataType: "json",
				contentType: "application/json; charset=UTf-8",
				success: function(data) {
					console.log("좋아요 상태 확인 요청 성공!");
					/* console.log(data); */
					//div 객체 모두 가져온다.
					/* console.log(newdiv); */
					var newdiv = $(".newdiv"); 
				/* 	newdiv[0].childNodes[26].firstChild.className = "fa fa-heart"; */
					// 반복문 돌려서 oneSentenceIdx 값과 data의 값을 비교한다.
  					for(var i = 0; i < newdiv.length; i += 1) {
						/* console.log(newdiv[i].childNodes[1].innerText); */
					 	for(var j = 0; j < data.length; j += 1){
							//일치하면 하트 색깔 바꾼다.
							if(Number(newdiv[i].childNodes[1].innerText) === Number(data[j])) {
								newdiv[i].childNodes[26].firstChild.className = "fa fa-heart";
								/* break; */
							}			
						}
					} 
					
				},
				error: function(error) {
					console.log("에러발생: " + error);
				}
				
			})
			
			//controller에서 현재 로그인한 유저가 좋아요한 기록이 있는지 확인한다
		
			//좋아요 기록이 있는 oneSentenceIdx 값만 다시 view페이지로 넘긴다.
		
			//서버로 부터 받은 oneSentenceIdx 문장에다가 하트표시한다.(반복문)
			
			
		
 
	</script>	
	
</body>
</html>