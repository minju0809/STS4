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
		&emsp;<a href="/security.do">홈으로</a>

		&emsp;<a href="/admin/admin.do">관리자</a>
		&emsp;<a href="/manager/manager.do">매니저</a>

		&emsp;<a href="/member/member.do">맴버</a>
		&emsp;<a href="/member/member2.do">맴버2</a>
		&emsp;<a href="/member/memberBoard.do">맴버게시판</a>

		&emsp;<a href="/guest/guest.do">게스트</a>
		&emsp;<a href="/guest/guestBoard.do">게스트게시판</a>

		&emsp;<a href="/login.do">로그인</a>
		&emsp;<a href="/logout.do">로그아웃</a>
		
		<c:if test="${not empty session_id }">
			&emsp;아이디: <a href="sessionLogout.do">${session_id}</a>
		</c:if>
	</nav>