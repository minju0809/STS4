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
	<span>서버  </span>: 
<%=application.getServerInfo() %><br>
<span>서블릿  </span>: 
<%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
<span>JSP  </span>: 
<%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
		<br>
		<div align=left>
			&emsp;<a href="boardForm.do"> 글쓰기 </a>
			&emsp;<input type=button href="boardForm.do"> 글쓰기 </a>
		</div>
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