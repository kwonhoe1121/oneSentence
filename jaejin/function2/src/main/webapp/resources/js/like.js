$(".like_btn").on(
		"click",
		function() {
			alert("버튼 눌림!!");
			var oneSentenceIdx = $("#oneSentenceIdx").text();

			console.log(oneSentenceIdx);
			// ajax처리 해서 서버 요청.
			$.ajax({
				type : "POST",
				url : "../user/clickLike",
				data : JSON.stringify({
					"oneSentenceIdx" : oneSentenceIdx
				}),
				// data : {
				// "oneSentenceIdx" : oneSentenceIdx
				// },
				dataType : "json",
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					// alert("좋아요 클릭 반영 성공!!");
					console.log("좋아요 클릭 반영!!")
				},
				error : function(request, status, error) {
					// alert("에러발생!!");
					console.log("에러발생!!" + error);
					console.log("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);

				}
			});

		});