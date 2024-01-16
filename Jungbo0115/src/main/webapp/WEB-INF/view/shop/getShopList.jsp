<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<section>
	<div align="center">
		<br>
		<h1>상품 목록 보기</h1>
		<table border=1>
			<tr align="center">
				<th>idx</th>
				<th>상품이름</th>
				<th>상품가격</th>
				<th>상세설명</th>
				<th>등록일</th>
				<th>img</th>
			</tr>
			<c:forEach items="${li}" var="m" varStatus="status">

				<tr>
					<td>${m.product_id}</td>
					<td>${m.product_name}</td>
					<td>${m.product_price}</td>
					<td>${m.product_desc}</td>
					<td>${m.product_date}</td>
					<td><img src="/shop/img/${m.product_imgStr}" width=50></td>
				</tr>

			</c:forEach>
		</table>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />