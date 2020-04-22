<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="beans.ProductBeans"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
p{
	text-align: center;
	padding-top: 20px;
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

	<%--スコープに保存したProductBeansを取得 --%>
	<%
		ProductBeans productBeans = (ProductBeans) session.getAttribute("productBeans");
	%>

	<%--ProductBeansから商品番号、商品名、金額を表示 --%>

	<p>
		お釣りは<%=productBeans.getChange()%>円です。
	</p>

	<p>ありがとうございました。</p>

	<%--ホームボタンを押すとホーム画面遷移、セッションスコープ内のインスタンスを破棄 --%>
	<form method="post" class="home">
		<a href="Home" class="homeButton">ホーム画面</a>
	</form>

</body>
</html>