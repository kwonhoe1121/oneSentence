<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>한문장-한문장페이지</title>
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

	<%-- <%@include file="include/mainHeader.jsp"%> --%>

	<!-- Page Content -->
	<div class="container">
		<!-- Post Content Column -->
		<div class="col-lg-8">
			<!-- Comments Form -->

		
			<div class="newdiv">
				<span style="color: darkgray; padding-right: 1rem"  class="oneSentenceIdx">${onesentence.oneSentenceIdx}</span>
				<!--한문장번호-->
				<a href="#" style="color: black"><i class="fa fa-user icon">
						${onesentence.userName}</i></a> <span class="eventA"><i class="fa fa-ellipsis-v icon"></i></span>
				
					<div class="divmodal" style="text-align: center;">
						<div class="all">
							<a href="#" onclick="share(${onesentence.oneSentenceIdx})" id="share"><i class="fa fa-send-o icon"></i></a>
						</div>
						<div class="my">
							<a href="#" id="updateBtn" onclick="updateClick(${onesentence.oneSentenceIdx})"><i class="fa fa-reply icon"></i></a>
						</div>
						<div class="my">
							<a href="#"  onclick="deleteClick(${onesentence.oneSentenceIdx})"
							><i class="fa fa-remove icon"></i></a>
						</div>
						
					</div>
				
				<span style="padding-left: 2rem; font-size: 0.8rem; color: darkgray">${onesentence.oneSentenceRegisteredTime}</span><br>
				 <span style="padding-left: 2rem; font-size: 1.5rem;">${onesentence.oneSentence}.</span><br> <span
					style="float: right; padding-right: 2rem; font-size: 1rem; color: darkgray">${onesentence.bookTitle},
						${onesentence.author}, p.${onesentence.page} 에서.. </i></span><br>
				<hr>
				<span class="hashtag">${onesentence.hashtag}</span> <span class="like"><i
					class="fa fa-heart-o"> ${onesentence.likeTotal}</i></span>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/js/sentencelist.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/naeun/sentenceList/js/sentencelist2.js"></script>
	<script>
	    function share(idx){
	    	FB.ui({
	    		method : 'share_open_graph',
	    		action_type: 'og.shares',
	    		action_properties: JSON.stringify({
	    			object:{ 
	    				'og:url': 'http://127.0.0.1/sentence/onesentence/one/'+idx,
	    				'og:title' : '한문장',
	    				'og:description' : '한문장내용',
	    				'og:image': 'C:\\Users\\jaeho\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\onesentence\\upload\\책.jpg'
	    			}
	    		})
	    	})
	    };
	    function updateClick(idx){
	    	var url="${pageContext.request.contextPath}/onesentence/popup/"+idx;
	    	var popupOption="width=700,height=600";
	    	window.open(url,"한문장수정하기",popupOption);	
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
	
	</script>
</body>

</html>
