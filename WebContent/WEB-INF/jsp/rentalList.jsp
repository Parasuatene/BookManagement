<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>貸出中の書籍リスト</title>
	</head>
	<body>
		<!-- ヘッダーの読み込み -->
		<%@ include file="header.jsp" %>

		<c:if test="${empty requestScope.rentalBookList}">
			現在、"${sessionScope.id}"さんに貸出中の書籍はございません。
			<button onclick="location.href='home'">書籍一覧に戻る</button>
		</c:if>

		<c:if test="${not empty requestScope.rentalBookList}">
			<h3>"${sessionScope.id}"さんに貸出中の書籍一覧</h3>
			<c:forEach var="book" items="${rentalBookList}">
				<c:set var="start" value="${book.rentalControl.startDate}"/>
				<c:set var="schedule" value="${book.rentalControl.scheduleDate}"/>
				<c:set var="end" value="${book.rentalControl.endDate}"/>
				<div class="book_list">
					<p>返却予定日（${schedule}）</p>
					<h3>${book.title}</h3>
					<p>${book.author}</p>
					<p>${book.publisher}</p>
					<p>${book.imgPath}</p>
					<p>${book.discription}</p>
					<a href="returnRequest?id=${book.rentalControl.id}"></a>
				</div>
				<br>
			</c:forEach>
		</c:if>
	</body>
</html>