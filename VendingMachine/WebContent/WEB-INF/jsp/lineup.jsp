<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.ProductContentDAO" %>
<%@ page import="beans.ProductBeans" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">

	h1{
		text-align: center;
	}

	.menu{
		height:40%;
		width: 100%;
		text-align: center;
		padding:0 20 0 20px;
	}

	table{
		height:180px;
		width:200px;
		border:solid 1px;
		text-align:center;
		float: left;

	}

	tr{
		height: 30px;
	}

	td{
		height: 30px;
	}

	form{
	clear: all;
	text-align: center;
	padding:50px;
	}


</style>

<title>Insert title here</title>
</head>
<body>
	<main>
	<h1>商品一覧</h1>

	 <%List<ProductBeans> proList = (List<ProductBeans>)request.getAttribute("proList"); %>
	 <% for(ProductBeans productBeans:proList){ %>
	 <div class="menu">
		 <table>
			 <tr>
			 	<%--商品番号--%>
			 	<td><%= productBeans.getId() %>番</td>
			 </tr>
			 <tr>
			 	<%--商品名--%>
				<td><%= productBeans.getName() %></td>
			 </tr>
			 <tr>
				<%--商品金額--%>
				<td><%= productBeans.getMoney() %>円</td>
			 </tr>
			 <tr>
				<%--商品在庫--%>
				<td>
					<% int stock = productBeans.getStock() ;%>
						<% if(stock == 0){%>
						<p>売り切れ</p>
						<% }%>
			    </td>
			 </tr>
		 </table>
	</div>
	<%} %>

	<div>
	<form action="ProductControll" method="post" >

		<div class="">
			商品番号:<input type="text" name="id" maxlength="1"><br>
			投入金額:<input type="text" name="inputMoney" max="4"><br>
			<input type="submit" value="送信">
		</div>
	</form>
	</div>

	</main>
</body>
</html>