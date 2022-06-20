<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<div class="login">
			<h1 class="login_header">サインイン</h1>
			<c:forEach var="errorMessage" items="${errorMessages}">
				<span class="errorMsg"> <c:out value="${errorMessage}" /></span>
				<br>
			</c:forEach>
			<div>
				<form action="login" method="post" class="login_container">
					<p><input type="text" name="login_id" placeholder="ログインID"></p>
					<p><input type="password" name="password" placeholder="パスワード"></p>
					<p><input type="submit" value="ログイン"></p>
				</form>
			</div>
			アカウント作成は<a href="signup">こちら</a>
		</div>
	</body>
</html>