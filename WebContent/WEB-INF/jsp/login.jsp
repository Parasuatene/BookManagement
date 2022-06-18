<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<div align="center">
			<h1>サインイン</h1>
			<div>
				<form action="login" method="post">
					<p>ログインID</p>
					<input type="text" name="login_id">
					<p>パスワード</p>
					<input type="text" name="password">
					<br>
					<input type="submit" value="ログイン">
				</form>
			</div>
			アカウント作成は<a href="signup">こちら</a>
		</div>
	</body>
</html>