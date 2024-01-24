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
					<ul class="menu-list">
						<li class="menu0">
							<a href="/security.do">홈으로</a>
						</li>
						<li class="menu1">
							<span>관리자</span>
							<ul class="menu">
								<li>
									<a href="/admin/admin.do" class="menu1-1">
										<span>관리자</span>
									</a>
									<a href="/admin/userForm.do" class="menu1-2">
										<span>회원등록</span>
									</a>
								</li>
							</ul>
						</li>
						<li class="menu2">
							<span>매니저</span>
							<ul class="menu">
								<li>
									<a href="/manager/manager.do" class="menu2-1">
										<span>매니저</span>
									</a>
								</li>
							</ul>
						</li>
						<li class="menu3">
							<span>맴버</span>
							<ul class="menu">
								<li>
									<a href="/member/member.do" class="menu3-1">
										<span>맴버</span>
									</a>
									<a href="/member/member2.do" class="menu3-2">
										<span>맴버2</span>
									</a>
									<a href="/member/memberBoard.do" class="menu3-3">
										<span>맴버게시판</span>
									</a>
								</li>
							</ul>
						</li>
						<li class="menu3">
							<span>게스트</span>
							<ul class="menu">
								<li>
									<a href="/guest/guest.do" class="menu3-1">
										<span>게스트</span>
									</a>
									<a href="/guest/guestBoard.do" class="menu3-2">
										<span>게스트게시판</span>
									</a>
								</li>
							</ul>
						</li>
						<li class="menu4">
							<a href="/getUserList.do">
								<span>회원목록</span>
							</a>
						</li>
						<li class="menu5">
							<a href="/login.do">
								<span>로그인</span>
							</a>
						</li>
						<li class="menu6">
							<a href="/logout">
								<span>로그아웃</span>
							</a>
						</li>
						${session.username}${session.name}
					</ul>
				</nav>
			</div>