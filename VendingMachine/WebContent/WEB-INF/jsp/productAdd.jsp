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
<link href="${pageContext.request.contextPath}/css/lineup.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<header>
		<h1>商品追加画面</h1>
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
					<%--商品金額--%>
					<%=productBeans.getMoney()%>円
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
		<%--追加したい商品情報を入力するフォーム --%>
		<form action="ProductAdd" method="post" class="formContent">
		<div class="labelContent">

			<label>商品名</label><input type="text" name="inputName"><br>

			<br> <label>商品金額</label><input type="number" name="inputMoney" min="100" max="200" step="10"><br>

			<br> <label>商品在庫数</label><input type="number" name="inputStock" max="50"><br>

			<br> <input type="submit" value="追加する" class="submitButton">
		</div>
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