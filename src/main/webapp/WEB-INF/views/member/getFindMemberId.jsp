<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style></style>
</head>
<body>
	<h3>아이디 찾기 결과</h3>
	<%-- <input type="text" value="${memberId }"/> --%>
	<p>아이디 : ${memberId }</p>
	<button id="login">로그인</button>
</body>
<script>
	$('#login').click(function () {
		location.href='toLogin';
	})
</script>
</html>