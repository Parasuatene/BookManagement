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
		<!-- <c:if test="${empty sessionScope.id}">
			ログインするボタンを作る
		</c:if>

		<c:if test="${not empty sessionScope.id}">
			<form action="rentalList" method="get">
				<input type="submit" value="${sessionScope.id}さんの貸出中書籍リスト">
			</form>
		</c:if> -->

		<!-- TODO: 後ほど修正する -->
		<div class="body_container">
			<!-- <c:forEach var="book" items="${bookList}">
				<c:set var="start" value="${book.rentalControl.startDate}"/>
				<c:set var="schedule" value="${book.rentalControl.scheduleDate}"/>
				<c:set var="end" value="${book.rentalControl.endDate}"/> -->
				<div class="book_list">
					<figure class="image">
						<img src="https://img.ips.co.jp/ij/15/1115101068/1115101068-520x.jpg" alt="">
						<!-- https://img.ips.co.jp/ij/18/1118101036/1118101036-520x.jpg -->
					</figure>
					<div class="book_info">
						<h3>徹底攻略Java SE 11 Silver問題集［1Z0-815］対応</h3>
						<label for="author">志賀 澄人</label>
						<label for="publisher">株式会社ソキウス・ジャパン</label>
						<p class="discription">オラクル社の資格試験「Oracle Certified Java Programmer, Silver SE 11 認定資格（試験番号：1Z0-815-JPN）」に完全対応！新しい試験範囲を完全に網羅。教科書テキストがなくても、この問題集1冊でとても丁寧に解説しているので、ラムダ式やモジュールについてもすんなりと理解できます。巻末には、本番の試験と同じ構成・問題数の【総仕上げ問題】を2回分収録！試験直前の実力確認までバッチリサポートします！！これからJava SE 11 Silver試験を受験しようとしている人は、迷わず必携の1冊です！！</p>
						<!-- <a href="bookInfo?id=${book.id}"></a> -->
						<p>rental.id=${book.rentalControl.id}</p>
					</div>
				</div>
				
				<div class="book_list">
					<!-- <c:if test="${not empty start and empty end}">
						<p>貸出中: 返却予定日（${schedule}）</p>
					</c:if> -->
					<h3>いちばんやさしいGit&GitHubの教本 人気講師が教えるバージョン管理＆共有入門</h3>
					<p>横田 紋奈, 宇賀神 みずき</p>
					<p>株式会社ソキウス・ジャパン</p>
					<p>${book.imgPath}</p>
					<p>実際のワークフローをイメージしながら実践的なGit/GitHubの使い方が身につく「いちばんやさしい」入門書です。前半は、手元のパソコンでファイルを実際にバージョン管理しながら基本的な使い方を解説。後半では、実践的なワークフローに沿ってチームメンバーと一緒に開発を進めるための知識が身につきます。全体を通し、コマンドラインを使った操作が中心であることも大きな特徴です。概念や操作方法を丁寧に解説するのみならず、「なぜそうするのか」といった疑問に答えられるような説明も多く入れています。</p>
					<a href="bookInfo?id=${book.id}"></a>
					<p>rental.id=${book.rentalControl.id}</p>
				</div>
			<!-- </c:forEach> -->
		</div>
	</body>
</html>