<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/WEB-INF/views/include/mainHeader.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>한문장-한문장목록페이지</title>

<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/jaejin/img/favicon.ico">
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/bootstrap/css/bootstrap.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/naeun/sentenceList/css/sentenceList.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/naeun/sentenceList/css/sentenceList2.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet prefetch"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

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

.alink {
	float: right;
	padding-right: 2rem;
	font-size: 1rem;
	padding-top:2rem;
}

/* 추후 삭제. */
.btn-primary {
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}

</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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

	<header style="height:60px">

	<%-- <%@include file="include/mainHeader.jsp"%> --%>
	<a href="${pageContext.request.contextPath}/onesentence/liketo/${userIdx}" id="liketo" class="alink"
		style="color: #007bff"><i class="fa fa-search icon"> 좋아요한
			문장보러가기</i></a>
	<a href="${pageContext.request.contextPath}/onesentence/list/${userIdx}" id="list" class="alink"
		style="color: #007bff"><i class="fa fa-search icon"> 작성한
			문장보러가기</i></a>
	</header>

	<!-- Page Content -->
	<div class="container">
		<!-- Post Content Column -->
		<div class="col-lg-8" style="padding-top:3rem">
			<!-- Comments Form -->
			<input type="text" id="session" value="${User.userIdx}" hidden="true">
			
			<%-- <c:choose>
			<c:when test="${fn:length(oneSentenceList) > 0} "> --%>
			
			<c:forEach items="${oneSentenceList}" var="onesentence">
				<div class="newdiv" hidden="true">
					<span style="color: darkgray; padding-right: 1rem"
						class="oneSentenceIdx">${onesentence.oneSentenceIdx}</span>
					<!--한문장번호-->
					<a href="${pageContext.request.contextPath}/userpage/${onesentence.userIdx}" style="color: black"><i class="fa fa-user icon">
							${onesentence.userName}</i></a> <span class="eventA"><i
						class="fa fa-ellipsis-v icon"></i></span> <input type="text"
						class="userIdx" value="${onesentence.userIdx}" hidden="true">
					
						<div class="divmodal" style="text-align: center;">
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
								<a href="#" onclick="deleteClick(${onesentence.oneSentenceIdx})"
									><i class="fa fa-remove icon"></i></a>
							</div>
						</div>
					
					<span
						style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">${onesentence.oneSentenceRegisteredTime}</span><br>
					<span style="padding-left: 2rem; font-size: 1.5rem;">${onesentence.oneSentence}</span><br>
					<span
						style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray">${onesentence.bookTitle},
						${onesentence.author},	p.${onesentence.page} 에서.. 
					</span><br>
					<hr>
					<span class="hashtag">${onesentence.hashtag}</span> <span
						class="like"><i class="fa fa-heart-o">
							${onesentence.likeTotal}</i></span>
				</div>
			</c:forEach>
			<%-- </c:when>
			<c:otherwise>
				<h3 style="font-size: 1.2rem;padding-top:3rem">한문장 조회결과가 없습니다.</h3>
			</c:otherwise>
			</c:choose> --%>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/js/sentencelist2.js"></script>
	<script>
	
		<c:if test="${User ne null}">
			showLikedSentenceStatus();
		</c:if>
	
		var href = window.location.href;
		console.log(href);
		if((href.search('list'))!=-1){
			$('#list').hide();
		}else{
			$('#liketo').hide();
		}
	
		var newdiv = document.getElementsByClassName('newdiv');
		newdiv[0].hidden = false;
		newdiv[1].hidden = false;
		newdiv[2].hidden = false;
		newdiv[3].hidden = false;
		newdiv[4].hidden = false;
		newdiv[5].hidden = false;
		var k =5;
		$(window).scroll(function() {
	    	 if ($(window).scrollTop() == $(document).height() - $(window).height()) {
	    		 newdiv[++k].hidden=false;
	            
	        }
	    })   
	   
		
			function share(idx) {
				FB.ui({
				method : 'share_open_graph',
				action_type : 'og.shares',
				action_properties : JSON
						.stringify({
							object : {
								'og:url' : 'http://127.0.0.1/sentence/onesentence/one/'
										+ idx,
								'og:title' : '한문장',
								'og:description' : '한문장내용',
								'og:image' : 'C:\\Users\\jaeho\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\onesentence\\upload\\책.jpg'
							}
						})
				})
			}

			function updateClick(idx) {
				var url = "${pageContext.request.contextPath}/onesentence/popup/" + idx;
				var popupOption = "width=700,height=600";
				window.open(url, "한문장수정하기", popupOption);
			}
			
			
			function deleteClick(idx){
				var arr = {id: idx};
				$.ajax({
					url: '${pageContext.request.contextPath}/onesentence/'+idx,
					type:'DELETE',
					data : JSON.stringify(arr),
					contentType:'application/json;charset=utf-8',
					async:true,
					success: function(msg){
						window.location.reload();
					},error:function(){
						console.log('error');
						window.location.reload();
					}
				});
			}
			
			/* click like button  */
			<c:if test="${User ne null}">
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
			</c:if>
			
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
					contentType: "application/x-www-form-urlencoded; charset=UTF-8",
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
				
			}
	    
	
 
	</script>
</body>

</html>
