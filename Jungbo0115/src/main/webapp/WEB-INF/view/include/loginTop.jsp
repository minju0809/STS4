<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 게시판</title>
<link type="text/css" rel="stylesheet" href="/css/style.css" />
</head>

<body>
	<header>
 	  시큐리티 ver 1.0
	</header>
	<nav>
		&emsp;<a href="/">홈으로</a>
		
		<c:if test="${not empty session_id }">
			&emsp;아이디: <a href="sessionLogout.do">${session_id}</a>
		</c:if>
	</nav>