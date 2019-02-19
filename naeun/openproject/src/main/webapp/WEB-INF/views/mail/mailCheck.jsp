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
        ul{
            list-style: none;
            border-top:1px solid silver;
            border-bottom:1px solid silver;
            padding:10px;
        }
        ul>li{
            display: inline-block;
            margin-right: 50px;
        }
        a{
        	text-decoration: none;
        	color : black;
        }
        a:visited{
        	color:black;
        }
        div>h3{
        	margin-left : 30px;
        }
        
        h4{
        	text-decoration: underline; 
        }
    </style>
</head>
<body>
   <header>
       <h1><a href="../../openp">Open Project</a></h1>
   </header> 
    <ul>
    	<li><a href="memberReg">회원가입</a></li>
        <li><a href="memberLogin">로그인</a></li>
        <li><a href="memberLogout">로그아웃</a></li>
        <li><a href="memberList">회원리스트</a></li>
        <li><a href="Board">방명록작성</a></li>
        <li><a href="BoardList">방명록리스트</a></li>
        <li><a href="mypage">마이페이지</a></li>      
        <li><a href="#">사원관리</a></li> 
    </ul>  
	<h1> 메일 인증 완료</h1>
	<h4><a href="../../openp"> 메인으로 이동</a></h4>
</body>
</html>
