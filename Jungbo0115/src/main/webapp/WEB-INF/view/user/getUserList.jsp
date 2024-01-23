<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="${path}/WEB-INF/view/include/securityTop.jsp" />

<section>
	<div align="center">
		<br>
		<h1>회원 목록 보기</h1>
		<table border=1>
			<tr align="center">
				<th>idx</th>
				<th>아이디</th>
				<th>암호</th>
				<th>role</th>
				<th>이름</th>
				<th>등급</th>
			</tr>
			<c:forEach items="${li}" var="m" varStatus="status">

				<tr>
					<td>${m.idx}</td>
					<td>${m.username}</td>
					<td>${m.password.substring(0,9)}..</td>
					<td>${m.role}</td>
					<td>${m.name}</td>
					<td>${m.grade}</td>
				</tr>

			</c:forEach>
		</table>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />