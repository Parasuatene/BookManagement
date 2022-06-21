<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="css/style.css" rel="stylesheet">
		<meta charset="UTF-8">
		<title>書籍貸出画面</title>
	</head>
	<body>
		<!-- ヘッダーの読み込み -->
		<%@ include file="header.jsp" %>

		<c:set var="book" value="${book}"/>

		<c:if test="${empty book}">
		 	<h1>お探しのページは見つかりませんでした</h1>
		 	<a href="home">書籍一覧ページに戻る</a>
		</c:if>

		<c:if test="${not empty book}">
			<form action="rentalComplete" method="post">
				<div class="book_info_panel">
					<div class="book_info">
						<figure class="book_info_image">
							<img src="${book.imgPath}" alt="">
						</figure>
						<div class="book_info_text">
							<h3>${book.title}</h3>
							<label for="author">${book.author}</label>
							<label for="publisher">${book.publisher}</label>
							<p class="discription">${book.discription}</p>
							<div class="input_date_container">
								<p>貸出開始日　<input type="date" name="start_date" required="required"></p>
								<p class="shedule_date">返却予定日　<input type="date" name="schedule_date" required="required"></p>
							</div>
		                </div>
		            </div>
					<div class="btn_page_transition">
						<a id="return" href="bookInfo?id=${book.id}">戻る</a>
						<!-- <a id="confirm" href="rentalComplete">申請</a> -->
						<input id="post_confirm" type="submit" value="申請">
					</div>
				</div>
			</form>
		</c:if>
	</body>
</html>
