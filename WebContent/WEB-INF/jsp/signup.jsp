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
		<div align="center">
			<h1>新規アカウント登録</h1>
			<c:forEach var="errorMessage" items="${errorMessages}">
				<span class="errorMsg"> <c:out value="${errorMessage}" /></span>
				<br>
			</c:forEach>
			<div>
				<form action="signup" method="post">
					<p>名前</p>
					<input type="text" name="last_name" placeholder="姓" value=<c:out value="${lastName}"/>>
					<input type="text" name="first_name" placeholder="名" value=<c:out value="${firstName}"/>>
					<p>ログインID</p>
					<input type="text" name="login_id" value=<c:out value="${loginId}"/>>
					<p>パスワード</p>
					<input type="password" name="password">
					<br>
					<input type="submit" value="登録">
				</form>
			</div>
		</div>
	</body>
</html>