<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>書籍貸出画面</title>
	</head>
	<body>
		<h1>貸出管理画面</h1>

		<c:set var="book" value="${book}"/>

		<c:if test="${empty book}">
			<!-- ページが見つからなかった時の処理 -->
		 	<h1>お探しのページは見つかりませんでした</h1>
		 	<a href="home">書籍一覧ページに戻る</a>
		</c:if>

		<c:if test="${not empty book}">
			<!-- ページが見つかった時の処理 -->
			<div class="book_info">
				<h3>${book.title}</h3>
				<p>${book.author}</p>
				<p>${book.publisher}</p>
				<p>${book.imgPath}</p>
				<p>${book.discription}</p>
				<button onclick="location.href='bookInfo?id=${book.id}'">戻る</button>
				<!-- TODO: 申請する際は申請情報をPOSTするようにする -->
				<!-- <button onclick="location.href='rentalComplete'">申請</button> -->
				<form action="rentalComplete" method="post">
					<input type="hidden" name="rental_request" value="${book}">
					<input type="submit" value="申請">
				</form>
			</div>
		</c:if>
	</body>
</html>