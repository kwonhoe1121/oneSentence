<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
    <style>          
      
    </style>
</head>
<body>

     <header>
        <h1>한문장 검색결과페이지</h1>
    </header>
    <form name="search" method="get">
    <div class="div1">
    <input type="search" class="search"  placeholder="도서제목,저자,출판사,사용자를 검색하세요." id="searchbox" name="search">
    <input type="submit" calss="search" id="searchbtn" value="검색">
    </div>
    
    <table>
    <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    </tr>
    
    </table>

</body>
</html>
