<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:import url="${path}/WEB-INF/view/include/securityTop.jsp" />

<section>
  <br>
  <div align="center">
    <h2>로그인 화면</h2>
    <form method="post">
      <table border="1">
        <tr>
          <th>아이디</th>
          <th><input type="text" name="username"></th>
        </tr>
        <tr>
          <th>암호</th>
          <th><input type="text" name="password"></th>
        </tr>
        <tr>
          <th colspan="2" align="center"><input type="submit" value="로그인"></th>
        </tr>
      </table>      
    </form>
  </div>
</section>

<c:import url="${path}/WEB-INF/view/include/bottom.jsp" />