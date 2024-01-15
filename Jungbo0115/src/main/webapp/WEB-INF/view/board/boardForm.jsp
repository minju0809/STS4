<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false"%>

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
		<h1>게시판 글 등록</h1>
		<form action="boardInsert.do">
			<table border=1>
				<tr>
					<td>제목</td>
					<td><input type=text name=title></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type=text name=writer></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type=text name=content></td>
				</tr>
				<tr>
					<td colspan=2><input type=submit value="저장"></td>
				</tr>
			</table>
		</form>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />