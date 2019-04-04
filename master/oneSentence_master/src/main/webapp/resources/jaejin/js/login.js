	//email focusout
		$("#inputEmail").on("focusout",function() {
							/* alert("userEmail focusout"); */
							var userEmail = $("#inputEmail").val();
							console.log(userEmail);

							$.ajax({
										type : "POST",
										url : "${pageContext.request.contextPath}/users/emailCheck",
										data : JSON.stringify({
											"userEmail" : userEmail
										}),
										dataType : "json",
										contentType : "application/json; charset=UTf-8",
										success : function(data) {
											console.log(data);
											console.log(data.emailCheck);
											console.log($("#inputEmail"));
											if (data.emailCheck === "이메일이 틀렸습니다.") {
												$("#inputEmail")
														.after(
																"<div id='emailCheck'>"
																		+ data.emailCheck
																		+ "</div>");
											}
										},
										error : function(error) {
											console.log("에러발생: " + error);
										}

									});
						});
		//다시 focusin시 삭제.
		$("#inputEmail").on("focusin", function() {
			$("#emailCheck").remove();
		});

		//password focusout
		$("#inputPassword").on("focusout",function() {
							/* alert("userPassword focusout"); */
							console.log("userPassword focusout");

							var userPassword = $("#inputPassword").val();
							var userEmail = $("#inputEmail").val();
							console.log(userEmail);
							console.log(userPassword);

							$.ajax({
										type : "POST",
										url : "${pageContext.request.contextPath}/users/pwdCheck",
										data : JSON.stringify({
											"userEmail" : userEmail,
											"userPassword" : userPassword
										}),
										dataType : "json",
										contentType : "application/json; charset=UTF-8",
										success : function(data) {
											console.log(data);
											if (data.passwordCheck === "비밀번호가 틀립니다.") {
												$("#inputPassword")
														.after(
																"<div id='passwordCheck'>"
																		+ data.passwordCheck
																		+ "</div>");
											}
										},
										error : function(error) {
											console.log("에러발생 : " + error);
										}

									});
							//다시 focusin시 삭제.
							$("#inputPassword").on("focusin", function() {
								$("#passwordCheck").remove();
							});
						});
		
		//search Password popup!
		$('#searchPwd').click(function(){
			/* alert("click!") */
			var url="${pageContext.request.contextPath}/serachPassword";
			var popupOption="width=700,height=600";
			window.open(url,"send Email",popupOption);
		});