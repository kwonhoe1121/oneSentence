//로그인 버튼 눌렀을 때
$("#login_btn").on("click", function () {
    // alert("로그인 버튼!!");
    // var $login_form = $("#login_form"); 
    $("#register_form").css("visibility", 'hidden');
    $("#login_form").css("visibility", 'visible');
});

//회원가입 버튼 눌렀을 때
$("#register_btn").on("click", function () {
//    alert("회원가입 버튼!!"); 
    $("#login_form").css("visibility", 'hidden');
    $("#register_form").css("visibility", 'visible');
});

// 중복확인 버튼 눌렀을 때
$("#check_email").on("click", function() {
    var checkEmail = 0;
    var userEmail = $("#userEmail").val();
    // alert("중복체크확인!")
    // console.log(userEmail);

    $.ajax()
});

//로그아웃 버튼이 눌렸을 때
$("#logout_btn").on("click", function() {
    alert("로그아웃 버튼!!");
    
});