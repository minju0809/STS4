<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false"%>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<section>
	<div align="center">
		<br>
		<h1>게시판 글 등록</h1>
		<form action="psdInsert.do" method=post enctype=multipart/form-data>
			<table border=1>
				<tr>
					<th>제목</th>
					<td><input type=text name=title></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><input type=file name=img></td>
				</tr>
				<tr>
					<td align=center colspan=2><input type=submit value="저장"></td>
				</tr>
			</table>
		</form>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />