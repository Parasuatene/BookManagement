<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>新規アカウント登録</title>
	</head>
	<body>
		<div align="center">
			<h1>新規アカウント登録</h1>
			<div>
				<form action="signup" method="post">
					<p>名前</p>
					<input type="text" name="last_name">
					<input type="text" name="first_name">
					<p>ログインID</p>
					<input type="text" name="login_id">
					<p>パスワード</p>
					<input type="text" name="password">
					<br>
					<input type="submit" value="登録">
				</form>
			</div>
		</div>
	</body>
</html>