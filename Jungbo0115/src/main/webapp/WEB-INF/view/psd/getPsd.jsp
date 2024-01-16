<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<section>
	<div align="center">
		<br>
		<h1>게시판 상세보기</h1>
		&emsp;<button type=button onclick="location.href='psdForm.do'"> 글쓰기 </button>
		<table border=1>
			<tr align="center">
				<th>idx</th>
				<th>title</th>
				<th>imgStr</th>
				<th>img</th>
			</tr>
			<tr>
				<td>${m.idx}</td>
				<td>${m.title}</td>
				<td>${m.imgStr}</td>
				<td><img src="/psd/img/${m.imgStr}" width=50></td>
			</tr>
		</table>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />