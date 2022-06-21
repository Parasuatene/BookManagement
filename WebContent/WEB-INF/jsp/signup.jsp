<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>新規アカウント登録</title>
	</head>
	<body>
		<div class="signup">
			<h3 class="signup_header">新規アカウント登録</h3>
			<form class="signup_container" action="signup" method="post">
				<label class="required" for="full_name">名前（姓・名）</label><br>
				<p>
					<input type="text" class="last_name" name="last_name" required="required">
					<input type="text" class="first_name" name="first_name" required="required">
				</p>

				<label class="required" for="login_id">ログインID</label><br>
				<c:set var="errorLoginId" value="${errorMessages.errorLoginId}"/>
				<c:if test="${not empty errorLoginId}">
					<label for="error_message">${errorLoginId}</label>
				</c:if>
				<!-- ログインIDが既に存在した場合のエラーメッセージ -->
				<c:set var="errorDistinctLoginId" value="${errorMessages.errorDistinctLoginId}"/>
				<c:if test="${not empty errorDistinctLoginId}">
					<label for="error_message">${errorDistinctLoginId}</label>
				</c:if>

				<p><input type="text" name="login_id"></p>

				<label class="required" for="password">パスワード</label><br>
				<c:set var="errorPassword" value="${errorMessages.errorPassword}"/>
				<c:if test="${not empty errorPassword}">
					<label for="error_message">${errorPassword}</label>
				</c:if>

				<p><input type="password" name="password"></p>
				<p><input type="submit" value="登録"></p>
			</form>
		</div>
	</body>
</html>