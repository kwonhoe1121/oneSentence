<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/member.css" />" rel="stylesheet">
</head>
<body>

	<jsp:include page="../main.jsp"></jsp:include>

	<div id="member_memberList">
		<h2>회원 리스트</h2>
		<hr>
		<table>
			<thead id="label">
				<tr>
					<th>altKey</th>
					<th>아이디(이메일)</th>
					<th>이름</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody id="memberInfo">

			</tbody>

		</table>

				<div id="modifyDiv">
			<h2>회원정보수정</h2>
			<hr>
			<form method="post">
				<form method="post" enctype="multipart/form-data">

				<ul id="updateList">
					<li><label>아이디(이메일)</label><input type="text" class="regBox"
						name="email"></li>
					<li><label>비밀번호</label><input type="password" class="regBox"
						name="password"></li>
					<li><label>이름</label><input type="text" class="regBox"
						name="name"></li>
					<li><label>사진</label><input type="file" name="photo"></li>
					<li><label></label><input type="submit" value="수정">&nbsp;&nbsp;<input type="submit" value="삭제"></li>
				</ul>
			</form>
		</div>
	</div>

	<script>
		//멤버 생성자 등록
		function Member(altKey, email, name) {
			this.altKey = altKey;
			this.email = email;
			this.name = name;
		}
		//배열 생성.
		var member = new Array();
		var i = 0;
		<c:forEach items="${memberList }" var="mem">
			member[i++] = new Member("${mem.altKey}", "${mem.email}", "${mem.name}");
		</c:forEach>

		console.log(member);

		//멤버 리스트 뿌려주기.

		for (var i = 0; i < member.length; i++) {

			document.getElementById("memberInfo").innerHTML += "<tr><td>"
					+ member[i].altKey
					+ "</td><td>"
					+ member[i].email
					+ "</td><td>"
					+ member[i].name
					+ "</td><td><button onclick=\"modify()\">수정</button><button onclick=\"remove()\">삭제</button></td></tr>"
		}

		//수정
		function modify() {

			console.dir(document.getElementById("modifyDiv"));
			console.log(document.getElementById("modifyDiv"));
			document.getElementById("modifyDiv").style.visibility = "visible";
		}

		//삭제
		function remove() {
			alert("remove!!");
		}
	</script>
</body>
</html>