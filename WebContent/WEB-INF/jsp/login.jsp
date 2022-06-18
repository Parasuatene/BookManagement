<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<div align="center">
			<h1>サインイン</h1>
			<c:forEach var="errorMessage" items="${errorMessages}">
				<span class="errorMsg"> <c:out value="${errorMessage}" /></span>
				<br>
			</c:forEach>
			<div>
				<form action="login" method="post">
					<p>ログインID</p>
					<input type="text" name="login_id">
					<p>パスワード</p>
					<input type="password" name="password">
					<br>
					<input type="submit" value="ログイン">
				</form>
			</div>
			アカウント作成は<a href="signup">こちら</a>
		</div>
	</body>
</html>