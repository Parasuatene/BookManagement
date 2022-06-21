<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>GeeBook</title>
	</head>
	<body>
		<!-- ヘッダーの読み込み -->
		<%@ include file="header.jsp" %>

		<div class="body_container">
			<c:forEach var="book" items="${bookList}">
				<div class="book_list">
					<figure class="image">
						<a href="bookInfo?id=${book.id}">
							<img src="https://img.ips.co.jp/ij/15/1115101068/1115101068-520x.jpg" alt="">
						</a>
					</figure>
					<div class="book_info">
						<c:set var="startDate" value="${book.rentalControl.startDate}"/>
						<c:set var="scheduleDate" value="${book.rentalControl.scheduleDate}"/>
						<c:set var="endDate" value="${book.rentalControl.endDate}"/>
						<c:if test="${not empty startDate and empty endDate}">
							<p class="rental_status">貸出中（返却予定日:${scheduleDate}）</p>
						</c:if>
						<h3><a href="bookInfo?id=${book.id}">${book.title}</a></h3>
						<label for="author">${book.author}</label>
						<label for="publisher">${book.publisher}</label>
						<p class="discription">${book.discription}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</body>
</html>