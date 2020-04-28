<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.ProductContentDAO"%>
<%@ page import="beans.ProductBeans"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/stock.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<h1>商品在庫画面</h1>
	</header>

	<main>

		<div class="lineup">
			<%--リクエストスコープから全商品情報を取得 --%>
			<%
				List<ProductBeans> proList = (List<ProductBeans>) request.getAttribute("proList");
			%>

			<%
				for (ProductBeans productBeans : proList) {
			%>

			<%--商品ラインナップを表示 --%>
			<div class="menu">
				<div class="content">
					<%--商品番号--%>
					<%=productBeans.getId()%>番
				</div>

				<div class="content">
					<%--商品名--%>
					<%=productBeans.getName()%>
				</div>

				<div class="content">
					<%--商品在庫--%>
					(在庫数)<%=productBeans.getStock()%>個
				</div>
			</div>
			<br>

			<%
				}
			%>
		</div>
		<%--変更したい在庫数を入力するフォーム --%>
		<form action="StockController" method="post" class="formContent">

			<%--db内の商品番号を選択式で表示 --%>
			<label>商品番号</label>
			<select name="inputId">
				<%
					for (ProductBeans productBeans : proList) {
				%>
				<option value="<%=productBeans.getId()%>">
					<%=productBeans.getId()%>
				</option>
				<%
					}
				%>

			</select> <br>

			<br> <label>商品在庫</label><input type="number" name="inputStock"><br>

			<br> <input type="submit" value="変更する" class="submitButton">

		</form>
	</main>

	<footer>
		<%--ホームボタンを押すとホーム画面遷移 --%>
		<form method="post" class="home">
			<a href="Home" class="homeButton">ホーム画面</a>
		</form>
	</footer>

</body>
</html>