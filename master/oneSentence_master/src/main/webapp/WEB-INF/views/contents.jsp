<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/WEB-INF/views/include/mainHeader.jsp"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>한문장-목록페이지</title>
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/jaejin/img/favicon.ico">
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
<%-- <script
	src="${pageContext.request.contextPath}/resources/eunseon/contents/js/contents.js"></script> --%>
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

/* 재진 */
.like {
	
}
</style>
<script>
$().ready(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0&appId=418736628946277";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
</script>
</head>

<body>
	<%-- <jsp:include page="include/mainHeader.jsp"></jsp:include> --%>
	<%-- <%@include file="include/mainHeader.jsp"%> --%>
	<!-- Header -->

	
		
<c:forEach items="${items}" var="items">
<header class="bg-white" style="height:37rem">
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
					<li><i class="fa fa-volume-up icon" id="player">한문장 듣기</i></li>
					<li><i class="fa fa-commenting-o icon" id="chat">채팅방1</i></li>
					<li><i class="fa fa-commenting-o icon" id="chat2">채팅방2</i></li>
					<li><i class="fa fa-commenting-o icon" id="chat3">채팅방3</i></li>
					<li><input type="text"  id="userName" hidden="true" value="${User.userName}"></li>
					<hr>
				</ul>
				<form action="${pageContext.request.contextPath}/onesentence/insertForm" method="POST" style="display:inline-block;margin-top:-1rem">
						<ul>
						<li><input type="text" id="isbn" name="isbn" value="${items.isbn}" hidden="true">
						<li><input type="text" name="author" value="${items.author}" hidden="true">
						<li><input type="text" name="publisher" value="${items.publisher}" hidden="true">
						<li><input type="text" id="bookTitle" name="bookTitle" value="${items.title}" hidden="true">
						<li><input type="text" name="bookGenre" value="${items.categoryName}" hidden="true">
					<li><input type="submit" id="btn1" value="+ 코멘트작성" style="color:white;">
					</ul>
				</form>
			</div>
		</div>
	</header>
	<div style="background-color:white;height:3rem;display:inline-block;"></div>
	<!-- Page Content -->
	<div class="container" style="padding-bottom: 1.5rem;margin-top:-5rem;">

				</div>
			</div>
		</header>

		<!-- Page Content -->
		<div class="container" style="padding-bottom: 1.5rem;">

			<div class="row"
				style="border-top-left-radius: 10px; border-top-right-radius: 10px;"
				id="basicData">
				<div class="col-md-12 mb-5">
					<br> &nbsp;&nbsp;&nbsp; <b style="font-size: 1.2rem">기본정보</b>
					<hr>
					<ul>
						<li>${items.title}</li>
						<li>${items.author}</li>
						<li><c:out value="${fn:substring(items.pubDate,5,16)}" />/ <c:forEach
								items="${items3}" var="items3">${items3.itemPage}</c:forEach>p</li>
						<br>
						<li>
							<p id="description">${items.description}...</p>
						</li>
					</ul>

					<hr>
					&nbsp;&nbsp;&nbsp;<span
						style="cursor: pointer; font-size: 1.2rem; font-weight: bold;"
						id="toc">목차</span>
					<div class="tocul" style="display: none;">
						<hr>
						<ul>
							<li><c:forEach items="${items3}" var="items3">${items3.toc}</c:forEach></li>
						</ul>
					</div>
					<hr>
					&nbsp;&nbsp;&nbsp;<b style="font-size: 1.2rem">코멘트</b> <a
						href="${pageContext.request.contextPath}/onesentence/list/contents/${items.isbn}"
						class="a1"><b>더보기</b></a>
				</div>

			</div>

			<div class="row" style="padding-top: 0px">
				<div class="col-md-11 mb-5" style="padding-left: 5rem">
					<div class="card h-100" style="border: none;">

						<c:forEach items="${oneSentenceList}" var="onesentence" begin="0"
							end="4" step="1">
							<div class="card-body"
								style="margin-bottom: 2rem; border-radius: 10px; border: 1px solid lightgray;">
								<input type="text" id="session" value="${User.userIdx}"
									hidden="true"> &nbsp;<span style="color: darkgray"
									class="oneSentenceIdx">${onesentence.oneSentenceIdx}</span>&nbsp;&nbsp;
								<!--한문장번호-->
								<a href="#" style="color: black"><i class="fa fa-user icon">
										${onesentence.userName}</i></a> <span class="eventA"
									style="float: right; padding-right: 1rem; color: darkgray"><i
									class="fa fa-ellipsis-v icon"></i></span><input type="text"
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
										<a href="#"
											onclick="deleteClick(${onesentence.oneSentenceIdx})"><i
											class="fa fa-remove icon"></i></a>
									</div>
								</div>

								<span
									style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">${onesentence.oneSentenceRegisteredTime}</span><br>
								<span style="padding-left: 2rem; font-size: 1.5rem;">${onesentence.oneSentence}</span><br>
								<span
									style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray"><i>${onesentence.bookTitle},
										${onesentence.author}, p.${onesentence.page} 에서.. </i></span><br>
								<hr>
								<span
									style="color: cadetblue; font-size: 0.9rem; padding-left: 1.5rem">${onesentence.hashtag}</span>
								<span
									style="float: right; padding-right: 1rem; font-size: 0.8rem; color: red"
									class="like"><i class="fa fa-heart-o">
										${onesentence.likeTotal}</i></span>
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
	
	<c:if test="${User ne null}">
		showLikedSentenceStatus();
	</c:if>

	$('#toc').click(function () {  
	    if($(".tocul").css("display") == "none"){   
	        $('.tocul').show();  
	    } else {  
	        $('.tocul').hide();  
	    }  
	})
	$('#player').click(function(){
		var isbn = $('#isbn').val();
		var url = "${pageContext.request.contextPath}/onesentence/playlist/contents/" + isbn;
		var popupOption="width=600,height=860,scrollbars=1";
		window.open(url, "한문장플레이어", popupOption);
	});
	$('#chat').click(function(){
		var userName = $('#userName').val();
		
		if(userName!=null&&userName!=''){
		
		var arr = {isbn:$('#isbn').val(), bookTitle:$('#bookTitle').val()
				,userName: $('#userName').val() };
		alert(JSON.stringify(arr));
		var url = 'http://127.0.0.1:52273/chat/';
		var popupOption = "width=600,height=860,scrollbars=1";
		$.ajax({
			url: 'http://127.0.0.1:52273/chat/'+$('#isbn').val(),
			type:'POST',
			data:JSON.stringify(arr),
			dataType:'json',
			contentType:'application/json; charset=utf-8',
			async: true,
			success: function(data){
				alert(JSON.stringify(data));
				window.open(url+JSON.stringify(data),'채팅방',popupOption);
			},
			error:function(error){
				console.error();
			}
		});
		}else{
			alert("로그인 이후 사용가능합니다.");
		}
	});
	
	$('#chat2').click(function(){
		var userName = $('#userName').val();		
		if(userName!=null&&userName!=''){
		var params =$('#isbn').val()+':'+$('#bookTitle').val()+':'+userName;
		var url = "${pageContext.request.contextPath}/getroom/" + params;
		var popupOption="width=600,height=860,scrollbars=1";
		window.open(url, "채팅페이지", popupOption);
		}else{
			alert("로그인 이후 사용가능합니다.");
		}
	});
	
	$('#chat3').click(function(){
		var userName = $('#userName').val();		
		if(userName!=null&&userName!=''){
		var params =$('#isbn').val()+':'+$('#bookTitle').val()+':'+userName;
		var url = "${pageContext.request.contextPath}/getroom3/" + params;
		var popupOption="width=600,height=860,scrollbars=1";
		window.open(url, "채팅페이지", popupOption);
		}else{
			alert("로그인 이후 사용가능합니다.");
		}
	});
	

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
							'og:url' : '${pageContext.request.contextPath}/sentence/onesentence/one/'
									+ idx,
							'og:title' : '한문장',
							'og:description' : '한문장내용',
							'og:image' : 'http://image.kmib.co.kr/online_image/2018/0906/611211110012661971_2.jpg'
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

			console.log($(".card-body").find(".oneSentenceIdx"));
			console.log($(".card-body"));
			
			//oneSentenceIdx 값 모두 가져오기.
			var oneSentenceIdx = [];
		 	for(var i = 0; i < $(".card-body").find(".oneSentenceIdx").length; i += 1) {
				oneSentenceIdx[i] = $(".card-body").find(".oneSentenceIdx")[i].innerText;
			}
			console.log(oneSentenceIdx);
			
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
					var cardDiv = $(".card-body"); 
				/* 	newdiv[0].childNodes[26].firstChild.className = "fa fa-heart"; */
					// 반복문 돌려서 oneSentenceIdx 값과 data의 값을 비교한다.
  					for(var i = 0; i < cardDiv.length; i += 1) {
						/* console.log(newdiv[i].childNodes[1].innerText); */
					 	for(var j = 0; j < data.length; j += 1){
							//일치하면 하트 색깔 바꾼다.
							if(Number(cardDiv[i].childNodes[3].innerText) === Number(data[j])) {
								cardDiv[i].childNodes[27].firstChild.className = "fa fa-heart";
								/* break; */
							}			
						}
					} 
					
				},
				error: function(request,status,error) {
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
				
			})
			
			//controller에서 현재 로그인한 유저가 좋아요한 기록이 있는지 확인한다
		
			//좋아요 기록이 있는 oneSentenceIdx 값만 다시 view페이지로 넘긴다.
		
			//서버로 부터 받은 oneSentenceIdx 문장에다가 하트표시한다.(반복문)
			
		}

	</script>
</body>

</html>