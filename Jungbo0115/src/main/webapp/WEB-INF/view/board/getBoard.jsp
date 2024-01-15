<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false"%>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<section>
	<div align="center">
		<br>
		<h1>상세보기</h1>
		<form action="boardUpdate.do">
			<table border=1>
				<tr>
					<th>seq</th>
					<td><input type=text name=seq value="${m.seq}" readonly /></td>
				</tr>
				<tr>
					<th>title</th>
					<td><input type=text name=title value="${m.title}" /></td>
				</tr>
				<tr>
					<th>writer</th>
					<td><input type=text name=writer value="${m.writer}" /></td>
				</tr>
				<tr>
					<th>content</th>
					<td><input type=text name=content value="${m.content}" /></td>
				</tr>
				<tr>
					<th>regdate</th>
					<td><input type=text value="${m.regdate}" readonly /></td>
				</tr>
				<tr>
					<th>cnt</th>
					<td>${m.cnt}</td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="수정" /></td>
				</tr>
			</table>
		</form>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />