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
				<form action="rentalComplete" method="post">
					貸出開始日
					<input type="date" name="start_date" required="required">
					返却予定日
					<input type="date" name="schedule_date" required="required">
					<br>
					<button onclick="location.href='bookInfo?id=${book.id}'">戻る</button>
					<input type="hidden" name="book_id" value="${book.id}">
					<input type="submit" value="申請">
				</form>
			</div>
		</c:if>
	</body>
</html>

<div class="book_panel">
	<figure class="image">
	   <img src="${book.imgPath}" alt="">
	</figure>
	<div class="book_info">
		<h3>徹底攻略Java SE 11 Silver問題集［1Z0-815］対応</h3>
		<label for="author">志賀 澄人</label>
		<label for="publisher">株式会社ソキウス・ジャパン</label>
		<p>オラクル社の資格試験「Oracle Certified Java Programmer, Silver SE 11 認定資格（試験番号：1Z0-815-JPN）」に完全対応！新しい試験範囲を完全に網羅。教科書テキストがなくても、この問題集1冊でとても丁寧に解説しているので、ラムダ式やモジュールについてもすんなりと理解できます。巻末には、本番の試験と同じ構成・問題数の【総仕上げ問題】を2回分収録！試験直前の実力確認までバッチリサポートします！！これからJava SE 11 Silver試験を受験しようとしている人は、迷わず必携の1冊です！！</p>
		<div class="input_date_container">
			<p>貸出開始日　<input type="date" name="start_date" required="required"></p>
			<p class="shedule_date">返却予定日　<input type="date" name="schedule_date" required="required"></p>
		</div>
	</div>
	<div class="btn_rental_request">
		<a href="rentalRequest?id=${book.id}">貸出申請を行う</a>
	</div>
</div>