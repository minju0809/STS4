<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false" %>

<c:import url="${path}/WEB-INF/view/include/top.jsp" />

<section>
	<div align="center">
		<br>
		<h1>상품 상세보기</h1>
		<form action="getCartAdd.do">
			<table border=1>
				<tr>
					<th>id</th>
					<td><input type=text name="product_id" value="${m.product_id}" readonly></td>
				</tr>
				<tr align="center">
					<td colspan=2><img src="/shop/img/${m.product_imgStr}"></td>
				</tr>
				<tr>
					<th>img</th>
					<td><input type=text name="product_imgStr" value="${m.product_imgStr}" readonly></td>
				</tr>
				<tr>
					<th>name</th>
					<td><input type=text name="product_name" value="${m.product_name}"></td>
				</tr>
				<tr>
					<th>date</th>
					<td><input type=text name="product_date" value="${m.product_date}" readonly></td>
				</tr>
				<tr>
					<th>desc</th>	
					<td><textarea cols=25 rows=5 name="product_desc">${m.product_desc}</textarea></td>
				</tr>
				<tr>
					<th>개수</th>	
					<td><input type=text name="product_amount" value="2"></td>
				</tr>
				<tr>
					<th>가격</th>	
					<td><input type=text name="product_price" value="${m.product_price}"></td>
				</tr>
				<tr>
					<td align=center colspan=2>
						<input type=button value="목록" onclick="location.href='getShopList.do'">
						<input type=submit value="장바구니로">
					</td>
				</tr>
			</table>
		</form>

	</div>
	<br />
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />