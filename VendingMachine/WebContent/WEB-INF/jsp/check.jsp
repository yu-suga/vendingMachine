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
<body>

	<h1>購入確認画面</h1>

	<%--スコープに保存したProductBeansを取得 --%>
	<%
		ProductBeans productBeans = (ProductBeans) request.getAttribute("productBeans");
	%>

	<%--ProductBeansから商品番号、商品名、金額を表示 --%>
	<%=productBeans.getId()%>番
	<%=productBeans.getName()%>を購入しますか？
	<br>
	<%=productBeans.getMoney()%>円です。
	<br>




</body>
</html>