<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規アカウント登録</title>
	</head>
	<body>
		<div class="signup">
			<h3 class="signup_header">新規アカウント登録</h3>
			<c:forEach var="errorMessage" items="${errorMessages}">
				<span class="errorMsg"> <c:out value="${errorMessage}" /></span>
				<br>
			</c:forEach>
			<form class="signup_container" action="signup" method="post">
				<label class="required" for="full_name">名前（姓・名）</label><br>
				<p>
					<input type="text" class="last_name" name="last_name" required="required">
					<input type="text" class="first_name" name="first_name" required="required">
				</p>
				<label class="required" for="login_id">ログインID</label><br>
				<!-- TODO: エラー文の実装 -->
				<!-- <label for="error_message">※入力されたログインIDは既に存在します</label> -->
				<label for="error_message">※ログインIDは半角英数字、記号（@._-）などを用いて、5文字〜50文字で入力してください</label>
				<p><input type="text" name="login_id" required="required"></p>
				<label class="required" for="password">パスワード</label><br>
				<label for="error_message">※パスワードは5文字〜50文字で入力してください</label>
				<p><input type="password" name="password" required="required"></p>
				<p><input type="submit" value="登録"></p>
			</form>
		</div>
	</body>
</html>