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
			<h3 class="login_header">サインイン</h3>
			<form class="login_container" action="login" method="post">
				<c:if test="${not empty errorMessage}">
					<label for="error_message">${errorMessage}</label>
				</c:if>
				<label for="login_id">ログインID</label><br>
				<p><input type="text" name="login_id"></p>
				<label for="password">パスワード</label><br>
				<p><input type="password" name="password"></p>
				<p><input type="submit" value="ログイン"></p>
			</form>
			<div class="account_create">
				<a href="signup">新規アカウント作成</a>
			</div>
		</div>
	</body>
</html>