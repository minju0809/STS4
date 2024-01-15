<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<style>
table {
	width: 800px;
}

.td1 {
	text-align: center;
}
</style>
<section>
	<div align="center">
		<br>
		&emsp;<button type=button onclick="location.href='boardForm.do'"> 글쓰기 </button>
		<table border=1>
			<tr align="center">
				<td>idx</td>
				<td>seq</td>
				<td>title</td>
				<td>writer</td>
				<td>regdate</td>
				<td>cnt</td>
			</tr>
			<c:forEach items="${li}" var="m" varStatus="status">

				<tr>
					<td>${status.count}</td>
					<td>${m.seq}</td>
					<td>${m.title}</td>
					<td>${m.writer}</td>
					<td>${m.regdate}</td>
					<td>${m.cnt}</td>
				</tr>

			</c:forEach>
		</table>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />