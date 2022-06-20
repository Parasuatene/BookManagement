<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>書籍登録</title>
	</head>
	<body>
		<form action="registrationComplete" method="post">
			書籍名
			<input type="text" name="title" required="required">
			<br>
			著者名
			<input type="text" name="author">
			<br>
			出版社名
			<input type="text" name="publisher">
			<br>
			<textarea name="discription" rows="4" cols="40"></textarea>
			<br>
			<input type="submit" value="登録">
		</form>
	</body>
</html>