<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

		<c:set var="path" value="${pageContext.request.contextPath }" scope="session" />

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>스프링 게시판</title>
			<link type="text/css" rel="stylesheet" href="/css/style.css" />
			<script>
				// 햄버거 버튼을 클릭할 때 네비게이션 메뉴를 토글하는 함수
				function toggleNav() {
					const nav = document.querySelector('.nav-container nav');
					nav.classList.toggle('nav-visible');
				}
			</script>
		</head>

		<body>
			<header>
				시큐리티 ver 1.0
			</header>

			<div class="burger-menu" onclick="toggleNav()">☰</div>
			<div class="nav-container">
        <nav>
            <c:set var="user" value="${sessionScope.session}" />
            <a href="/security.do">홈으로</a>

            <a href="/admin/userForm.do">회원등록</a>
            <a href="/getUserList.do">회원목록</a>

            <a href="/admin/admin.do">관리자</a>
            <a href="/manager/manager.do">매니저</a>

            <a href="/member/member.do">맴버</a>
            <a href="/member/member2.do">맴버2</a>
            <a href="/member/memberBoard.do">맴버게시판</a>

            <a href="/guest/guest.do">게스트</a>
            <a href="/guest/guestBoard.do">게스트게시판</a>

            <a href="/login.do">로그인</a>
            <a href="/logout">로그아웃</a>
            ${session.username}${session.name}
        </nav>
    </div>