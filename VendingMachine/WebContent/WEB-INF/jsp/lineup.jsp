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
<link href="${pageContext.request.contextPath}/css/productLineup.css"
	rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>

	<header>
		<h1>商品一覧</h1>
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
			<table>
				<tr>
					<%--商品番号--%>
					<td><%=productBeans.getId()%>番</td>
				</tr>
				<tr>
					<%--商品名--%>
					<td><%=productBeans.getName()%></td>
				</tr>
				<tr>
					<%--商品金額--%>
					<td><%=productBeans.getMoney()%>円</td>
				</tr>
				<tr>
					<%--商品在庫--%>
					<td>
						<%
							int stock = productBeans.getStock();
						%> <%
 	if (stock == 0) {
 %>
						<p>売り切れ</p> <%
 	int outstock = stock;
 %> <%
 	}
 %>
					</td>
				</tr>
			</table>
			<%
				}
			%>

		</div>
		<%--入力フォーム --%>


		<%--購入したい商品を入力しPOST通信でProductControllへ --%>
		<form action="ProductControll" method="post" class="formContent">
			<p>いらっしゃいませ、商品番号と投入金額を入力してください。</p>


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

			<label>投入金額</label><input type="number" name="clientMoney"
				min="100" max="1000" step="10" list="number" maxlength="4">
			<datalist id="number">
				<option value="200">
				<option value="500">
				<option value="700">
				<option value="1000">
			</datalist>

			<br> <br> <input type="submit" value="購入する"
				class="parchaseButton">

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