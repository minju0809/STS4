<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<section>
	<div align="center">
		<br>
		<h1>장바구니 목록 보기</h1>
		<table border=1>
			<tr align="center">
				<th>카트번호</th>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>수량</th>
				<th>상품가격</th>
				<th>아이디</th>
			</tr>
			<c:forEach items="${li}" var="m" varStatus="status">

				<tr>
					<td>${m.cart_id}</td>
					<td>${m.product_id}</td>
					<td>${m.product_name}</td>
					<td>${m.product_amount}</td>
					<td>${m.product_price}</td>
					<td>${m.session_id}</td>
				</tr>

			</c:forEach>
		</table>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />