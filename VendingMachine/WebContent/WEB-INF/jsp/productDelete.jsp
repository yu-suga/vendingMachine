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
	<div class="lineup">
		<header>
			<h1>商品削除画面</h1>
		</header>
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

		<%--削除したい商品番号を入力するフォーム --%>
		<form action="ProductDelete" method="post">
			<div class="komoku">
				<label>商品番号</label><input type="number" name="inputId" max=""><br>
			</div>
			<div class="komoku">
				<input type="submit" value="削除する">
			</div>
		</form>
	</div>
	<form method="post" class="home">
		<a href="Home" class="homeButton">ホーム画面</a>
	</form>
</body>
</html>