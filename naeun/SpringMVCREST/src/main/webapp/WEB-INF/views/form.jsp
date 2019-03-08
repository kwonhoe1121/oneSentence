<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>메시지 작성</h1>
	
	<!-- <form action="../rest/message" method="post"> -->
		아이디 <input type="text" name="id" id="id"> <br>
		메시지 <input type="text" name="message" id="message"> <br>
		<input type="submit" value="전송" id="btn">
	<!-- </form> -->
	
	
	<script>
		$('#btn').click(function(){
			
			var arr = {
					id : $('#id').val(),
					message:$('#message').val()
					};
			
			$.ajax({
				url : '../rest/message',
				type : 'POST',
				data : JSON.stringify(arr),
				dataType : 'json',
				contentType : 'application/json; charset=utf-8',
				async : false,
				success : function(msg){
					alert(JSON.stringify(msg));
				}
				
			});
		});
	</script>
</body>
</html>