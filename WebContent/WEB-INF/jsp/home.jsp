<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>TODO:サービス名</title>
	</head>
	<body>
		<!-- ヘッダーの読み込み -->
		<%@ include file="header.jsp" %>
		<c:out value="${id}" />
		<c:out value="${authority}" />

		<!-- TODO: 後ほど修正する -->
		<c:forEach var="book" items="${bookList}">
				<div class="book_list">
					<h3>${book.title}</h3>
					<p>${book.author}</p>
					<p>${book.publisher}</p>
					<p>${book.imgPath}</p>
					<p>${book.discription}</p>
					<a href="bookInfo?id=${book.id}"></a>
				</div>
				<br>
		</c:forEach>
	</body>
</html>