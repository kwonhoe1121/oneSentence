//로그인 버튼 눌렀을 때
$("#login_btn").on("click", function() {
	// alert("로그인 버튼!!");
	// var $login_form = $("#login_form");
	$("#register_form").css("visibility", 'hidden');
	$("#login_form").css("visibility", 'visible');
});

// 로그인 등록 버튼이 눌렸을 때
$("#loginButton").on("click", function() {
	// alert("로그인 등록!!");
	console.log("로그인 등록!!");
	// 이메일, 비밀번호 값 가져오기!
	var userEmail = $("#userEmail").val();
	var userPassword = $("#userPassword").val();
	console.log(userEmail);
	console.log(userPassword);
	// ajax로 로그인 요청하기!
	$.ajax({
		type : "POST",
		url : "./users/login",
		data : JSON.stringify({
			"userEmail" : userEmail,
			"userPassword" : userPassword
		}),
		dataType : "json",
		contentType : "application/json; charset=UTf-8",
		success : function(data) {
			console.log("로그인 요청 성공!!");
			console.log(data);
			// alert("loginMessage");

		},
		error : function(request, status, error) {
			console.log("에러발생!!" + error);
			// console.log("code:" + request.status + "\n" + "message:"
			// + request.responseText + "\n" + "error:" + error);
		}

	});

});

// 회원가입 버튼 눌렀을 때
$("#register_btn").on("click", function() {
	// alert("회원가입 버튼!!");
	$("#login_form").css("visibility", 'hidden');
	$("#register_form").css("visibility", 'visible');
});

// 회원가입 등록 버튼 눌렀을떄
$("#registerButton").on("click", function() {
	console.log("회원가입 등록!!");
	var userName = $("#userName").val();
	var userPassword = $("#userPassword").val();
	var userEmail = $("#userEmail").val();

	console.log(userName + userPassword + userEmail + "");

	$.ajax({
		type : "POST",
		url : "./users/register",
		data : JSON.stringify({
			"userEmail" : userEmail,
			"userPassword" : userPassword,
			"userName" : userName
		}),
		dataType : "json",
		contentType : "application/json; charset=UTf-8",
		success : function(data) {
			console.log(data);

		},
		error : function() {
			console.log("error 발생!!");
		}

	});

});

// 중복확인 버튼 눌렀을 때
$("#check_email").on("click", function() {
	var checkEmail = 0;
	var userEmail = $("#userEmail").val();
	// alert("중복체크확인!")
	// console.log(userEmail);

});

// 로그아웃 버튼이 눌렸을 때
$("#logout_btn").on("click", function() {
	alert("로그아웃 버튼!!");

});