<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
<style type="text/css">
h1 {
	text-align: center;
	padding-top: 80px;
}

p {
	text-align: center;
	padding: 100px
}

.home {
	text-align: center;
	padding: 70px;
}

.homeButton {
	color: black;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>エラーページ</h1>
	<p>入力されていない箇所があります。すべて入力してください</p>

	<%--ホームボタンを押すとホーム画面遷移、セッションスコープ内のインスタンスを破棄 --%>
	<form method="post" class="home">
		<a href="Home" class="homeButton">ホーム画面</a>
	</form>
</body>
</html>