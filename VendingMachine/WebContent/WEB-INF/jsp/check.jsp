<%@page import="beans.ProductBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="dao.ProductContentDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<style type="text/css">
h1 {
	text-align: center;
	padding-top: 80px;
}

.confirm{
	text-align: center;
	padding: 40px;
}

.checkForm{
	text-align: center;
	padding: 20px;
}

.checkButton{
	text-align: center;

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
<body>

	<h1>購入確認画面</h1>

	<%--スコープに保存したProductBeansを取得 --%>
	<%
		ProductBeans productBeans = (ProductBeans) session.getAttribute("productBeans");
	%>

	<%--ProductBeansから商品番号、商品名、金額を表示 --%>
	<div class="confirm">
		<%=productBeans.getName()%>を購入しますか？ <br>
		<%=productBeans.getMoney()%>円です。 <br>
	</div>

	<form action="PurchaseCheck" method="post" class="checkForm">
		<input type="submit" value="購入確定" name="checkButton">
	</form>

	<%--ホームボタンを押すとホーム画面遷移 --%>
	<form method="post" class="home">
		<a href="Home" class="homeButton">ホーム画面</a>
	</form>



</body>
</html>