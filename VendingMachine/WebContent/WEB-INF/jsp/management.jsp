<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<header>
		<h1>管理者画面</h1>
	</header>

	<form method="get" class="menu">
		<a href="StockController" class="button">在庫情報を変更</a><br> <a
			href="ProductAdd" class="button">商品を追加</a><br> <a
			href="ProductDelete" class="button">商品情報を削除 </a><br>
	</form>

	<form method="post" class="home">
		<a href="Home" class="homeButton">ホーム画面</a>
	</form>

</body>
</html>