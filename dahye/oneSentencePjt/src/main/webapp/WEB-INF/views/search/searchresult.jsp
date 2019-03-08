<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장</title>
    <style>         

        .search {  float: left; 
                    
                 }
        #searchbox {width: 500px; height: 30px;}
        #searchbtn {width: 60px; height: 30px;}
      hr {margin-top: 70px; margin-bottom: 50px;}
      .table {magin-top : 30px;}
      td {float: left; }
      td {width : 200px;}
    </style>
</head>
<body>

     <header>
        <h1>한문장 검색결과페이지</h1>
    </header>
    <form method="get">
    <input type="search" class="search"  placeholder="도서제목,저자,출판사,사용자를 검색하세요." id="searchbox" name="search">
    <input type="submit" class="search" id="searchbtn" value="검색">
    </form>
    
	<hr>
    
    <div class="table">
    <table>
    <c:forEach items="${items}" var="b">
    <tr>
    <td><img src="${b.cover }"></td>
    <td>${b.title }</td>
    <td>${b.author }</td>
    <td>${b.publisher }</td>
    </tr>
    </c:forEach>
    </table>
    
    <table>
    <c:forEach items="${selectUser}" var="user">
    <tr>
    <td>${user }</td>
    </tr>
    </c:forEach>
    </table>
  
    </div>

</body>
</html>
