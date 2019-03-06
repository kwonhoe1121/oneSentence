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
        
        td{
        	padding:10px;
        }
    </style>
</head>
<body>
   <header>
       <h1><a href="../../sentence">One Sentence</a></h1>
   </header> 
    <ul>
        <li><a href="hashtagList">취향분석</a></li>
        <li><a href="following">팔로잉</a></li>    
    </ul>  
	<h1>도서 선호태그</h1>
	<table>
		<c:forEach items="${hashtaglist}" var="hashtag">
			<tr>
				<td>${hashtag}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
