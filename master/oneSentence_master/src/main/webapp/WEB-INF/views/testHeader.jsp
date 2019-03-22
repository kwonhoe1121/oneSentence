<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>한문장 메인 헤더</title>
   
    <style>
        header{
            width:100%;
			position:fixed;
			z-index:1;
			top:0.5rem;
        }
        table{
        	width:100%;
        	margin: 0 auto;
        }

        td{
        	width:20%;
        }
        #a{
        	width:60%;
            text-align:center;
        }            
        #b{
            text-align:right;
        }
        span{
        	margin-right:1rem;
        	color:lightgray;
        	font-weight:bold;
        }
        #text{
        	width:60%;
        }
        .fa-search{
        	color:lightgray;
        }
        a{
        	font-weight:bold;
        }
        #logo{
        	margin-right:2rem;
        }
        .fa-user-circle{
        	margin-bottom:0rem;
        	margin-top:0.5rem;
        }
        #sidebtn{
        	margin-bottom:0.9rem;
        	font-weight:bold;
        }
    </style>
</head>
<body>
	<c:if test="${User eq null}">
	<header>
    <table>
        <tr>
            <td></td>          
            <td id="a">
            <form action="${pageContext.request.contextPath}/search">
            <a href="${pageContext.request.contextPath}/" id="logo">한문장</a>
            <input type="text" id="text" placeholder="Search" name="query">
            <button class="btn btn-default" type="submit">
				<i class="fa fa-search icon"></i>
			</button>	
			</form>	
			</td>
			
            <td id="b">
            <a class="nav-link" href="${pageContext.request.contextPath}/login">
            <button class="btn navbar-btn">로그인</button></a>
            <a class="nav-link" href="${pageContext.request.contextPath}/register">
            <button class="btn btn-success navbar-btn">회원가입</button></a>
            </td>
        </tr>
    </table>
    </header>
   	</c:if>
   	
   	<c:if test="${User ne null}">
   	<header>
    <table>
        <tr>
            <td></td>
            <form action="${pageContext.request.contextPath}/search">
            <td id="a">
            <a href="${pageContext.request.contextPath}/" id="logo">한문장</a>
            <input type="text" id="text" placeholder="Search" name="query">
            <button class="btn btn-default" type="submit">
				<i class="fa fa-search icon"></i>
			</button>		
			</td>
			</form>
            <td id="b">
             <a class="nav-link" href="${pageContext.request.contextPath}/onesentence/list/all">
            <button class="btn navbar-btn" id="sidebtn">추천</button></a>
            <a class="nav-link" href="${pageContext.request.contextPath}/userpage/${User.userIdx}">
            <i class="fa fa-user-circle fa-2x" aria-hidden="true"></i></a>
 			</td>
        </tr>
    </table>
    </header>
    </c:if>
</body>
</html>