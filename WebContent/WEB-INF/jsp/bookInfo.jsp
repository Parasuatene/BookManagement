<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>書籍情報</title>
	</head>
	<body>
		<!-- ヘッダーの読み込み -->
		<%@ include file="header.jsp" %>

		<c:set var="book" value="${book}"/>

		<c:if test="${empty book}">
			<div class="not_found">
				<!-- ページが見つからなかった時の処理 -->
			 	<h2>お探しのページは見つかりませんでした</h2>
			 	<a href="home">書籍一覧ページに戻る</a>
		 	</div>
		</c:if>

		<c:if test="${not empty book}">
			<!-- ページが見つかった時の処理 -->
			<div class="book_info_panel">
				<div class="book_info">
					<figure class="book_info_image">
						<img src="img/<c:out value="${book.imgPath}" />" alt="">
					</figure>
					<div class="book_info_text">
						<h3>${book.title}</h3>
						<label for="author">${book.author}</label>
						<label for="publisher">${book.publisher}</label>
						<p class="discription">${book.discription}</p>
					</div>
				</div>
				<div class="btn_page_transition">
					<a id="return" href="home">戻る</a>
					<a id="post_confirm" href="rentalRequest?id=${book.id}">貸出申請に移る</a>
				</div>
			</div>
		</c:if>
	</body>
</html>