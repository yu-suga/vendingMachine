<%@page import="beans.ProductBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.ProductBeans" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>購入確認画面</h1>

<% ProductBeans productBeans =(ProductBeans) session.getAttribute("productBeans"); %>


<%= productBeans.getId()%>
<%= productBeans.getName() %>を購入しますか？<br>
<%= productBeans.getInputMoney() %>円です。<br>
お釣りは


</body>
</html>