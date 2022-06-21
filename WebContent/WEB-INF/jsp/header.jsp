<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<header>
	<h1 class="title">GeeBook</h1>
	<form class="search_container" action="" method="get">
		<input type="text" name="q" placeholder="検索キーワード（本のタイトル、著者名など）">
		<input type="submit" value="&#xf002">
	</form>
	<nav class="menu">
		<c:if test="${empty sessionScope.id}">
			<ul>
				<li><a href="login">ログイン</a></li>
			</ul>
		</c:if>
		<c:if test="${not empty sessionScope.id}">
			<ul>
				<li><a href="rental_books">借りている書籍</a></li>
			</ul>
		</c:if>
	</nav>
</header>
