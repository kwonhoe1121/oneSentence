<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/login/naver/finish" method="POST">
	<input id="email" name="email" type="text" hidden="true"  value="">
	<input id="name" name="name" type="text" hidden="true"  value="">
	<input style="border: none;background-color: white;font-size: xx-large;text-decoration: underline;" type="submit" value="로그인하시겠습니까?">
</form>
<script type="text/javascript">
  var naver_id_login = new naver_id_login("cPTP4WjJyJpuaIOiZ61K", "http://localhost/sentence/login/naver/callback");
  // 접근 토큰 값 출력
  /* alert(naver_id_login.oauthParams.access_token); */
  
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    $('#email').val(naver_id_login.getProfileData('email'));
    $('#name').val(naver_id_login.getProfileData('name'));
  }
</script>
</body>
</html>