<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장 리스트</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<table border="1">
			<tr>
				<td>작성자번호</td> 
				<td>작성자이름</td>
				<td>한문장번호</td>
				<td>한문장</td>
				<td>페이지</td>
				<td>작성시간</td>
				<td>isbn</td>
				<td>책제목</td>
				<td>저자</td>
				<td>출판사</td>
				<td>수정,삭제</td>
			</tr>
				<tr>
					<td>${onesentence.userIdx}</td>
					<td>${onesentence.userName}</td>
					<td id="idx">${onesentence.oneSentenceIdx}</td>
					<td>${onesentence.oneSentence}</td>
					<td>${onesentence.page}</td>
					<td>${onesentence.oneSentenceRegisteredTime}</td>
					<td>${onesentence.isbn}</td>
					<td>${onesentence.bookTitle}</td>
					<td>${onesentence.author}</td>
					<td>${onesentence.publisher}</td>
					 <td><a href="#" id="updateBtn" onclick="updateClick(${list.oneSentenceIdx})">수정</a>
					 &nbsp;<a href="../../onesentence/delete/${list.oneSentenceIdx}" id="deleteBtn">삭제</a></td>
					 
				</tr>
		</table>

<script>
function updateClick(idx){
	console.log("수정Click");
	var url="../../onesentence/popup/"+idx;
	var popupOption="width=700,height=600";
	window.open(url,"한문장수정하기",popupOption);	
}

/* function pop_close(){
    opener.location.reload();
    window.close();
} */


</script>		
		
		
</body>
</html>