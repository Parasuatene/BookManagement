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
			<!-- TODO: エラーメッセージを下のpタグに差し込む -->
			<c:forEach var="errorMessage" items="${errorMessages}">
				<span class="errorMsg"> <c:out value="${errorMessage}" /></span>
				<br>
			</c:forEach>
			<form class="login_container" action="login" method="post">
				<!-- <label for="error_message">＊ログイン、またはパスワードに誤りがあります</label> -->
				<label for="login_id">ログインID</label><br>
				<p><input type="text" name="login_id"></p>
				<label for="password">パスワード</label><br>
				<p><input type="password" name="password"></p>
				<p><input type="submit" value="ログイン"></p>
			</form>
			<div class="account_create">
				<a href="signup">新規アカウント作成</a>
			</div>
	</body>
</html>