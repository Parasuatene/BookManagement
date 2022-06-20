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

		<c:if test="${empty sessionScope.id}">
			ログインするボタンを作る
		</c:if>

		<c:if test="${not empty sessionScope.id}">
			<form action="rentalList" method="get">
				<input type="submit" value="${sessionScope.id}さんの貸出中書籍リスト">
			</form>
		</c:if>

		<!-- TODO: 後ほど修正する -->
		<c:forEach var="book" items="${bookList}">
			<c:set var="start" value="${book.rentalControl.startDate}"/>
			<c:set var="schedule" value="${book.rentalControl.scheduleDate}"/>
			<c:set var="end" value="${book.rentalControl.endDate}"/>
			<div class="book_list">
				<c:if test="${not empty start and empty end}">
					<p>貸出中: 返却予定日（${schedule}）</p>
				</c:if>
				<h3>${book.title}</h3>
				<p>${book.author}</p>
				<p>${book.publisher}</p>
				<p>${book.imgPath}</p>
				<p>${book.discription}</p>
				<a href="bookInfo?id=${book.id}"></a>
				<p>rental.id=${book.rentalControl.id}</p>
			</div>
			<br>
		</c:forEach>
	</body>
</html>