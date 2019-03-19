<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mail test</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/mail/send" method="POST">
		이메일: <input type="text" name="userEmail"><br>
		<input type="submit" value="메일전송">	
	</form>

</body>
</html>