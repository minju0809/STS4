<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath }" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 게시판</title>
<link type="text/css" rel="stylesheet" href="${path}/css/style.css" />
</head>

<body>
	<header>
 		게시판 ver 1.0
	</header>
	<nav>
		&emsp;<a href="index.do">홈으로</a>
		&emsp;<a href="getBoardList.do"> 목록보기 </a>
		&emsp;<a href="boardForm.do"> 글쓰기 </a>
		&emsp;<a href="getPsdList.do"> 자료실목록 </a>
		&emsp;<a href="psdForm.do"> 자료실저장 </a>
		&emsp;<a href="getShopList.do"> 상품목록 </a>
		&emsp;<a href="shopForm.do"> 상품등록 </a>
	</nav>