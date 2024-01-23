<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:import url="${path}/WEB-INF/view/include/securityTop.jsp" />

<section>
	<div align="center">
		<br>
		<h1>회원등록</h1>
		<form action="/insert.do">
			<table border=1>
				<tr>
					<th>아이디</th>
					<td><input type=text name=username></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type=text name=password></td>
				</tr>
				<tr>
					<th>role</th>
					<!-- <td><input type=text name=role></td> -->
					<td>
						<select name="role">
							<option value="admin">관리자</option>
							<option value="manager">매니저</option>
							<option value="member">맴버</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type=text name=name></td>
				</tr>
				<tr>
					<th>등급</th>
					<td>
						<select name="grade">
							<option value="일반">일반</option>
							<option value="매니저">매니저</option>
							<option value="회원1">회원1</option>
						</select>
					</td>
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