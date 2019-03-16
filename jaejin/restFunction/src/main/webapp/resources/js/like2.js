$(".like_btn").on("click", function () {
    alert("버튼 눌림!!");
    var oneSentenceIdx = $("#oneSentenceIdx").text();
    console.log(oneSentenceIdx);

    //ajax처리 해서 서버 요청.
    $.ajax({
        type: "POST",
        url: "../user/clickLike",
        data: JSON.stringify({
            "oneSentenceIdx": oneSentenceIdx
        }),
        dataType: "text",
        contentType: "application/json; charset=UTf-8",
        success: function (data) {
            console.log("좋아요 요청 성공!");
            // alert("좋아요 클릭 반영 성공!!");
        },
        error: function () {
            console.log("에러발생!!")
            // alert("에러발생!!");
        }
    })
})