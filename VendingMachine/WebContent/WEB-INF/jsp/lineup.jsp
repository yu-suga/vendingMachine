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

	<h1>商品一覧</h1>

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
 	}
 %>
					</td>
				</tr>
			</table>
		</div>
		<%
			}
		%>
	</div>
	<%--入力フォーム --%>
	<div class="formContent">

		<%--購入したい商品を入力しPOST通信でProductControllへ --%>
		<form action="ProductControll" method="post">
			<p>いらっしゃいませ、商品番号と投入金額を入力してください。</p>
			<div class="komoku">
				<label>商品番号</label><input type="number" name="inputId"><br>
			</div>
			<br>


			<div class="komoku">
				<input type="submit" value="購入する">
			</div>
		</form>
	</div>

	<%--ホームボタンを押すとホーム画面遷移 --%>
	<form method="post" class="home">
		<a href="Home" class="homeButton">ホーム画面</a>
	</form>

</body>
</html>