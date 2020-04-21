<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/css/main.css"
	rel="stylesheet" type="text/css">

</head>

<body>

	<header>
		<h1>ホーム画面</h1>
	</header>

	<%-- 管理者ページか商品ページを選択 --%>
	<form action="get" class="menu">
		<a href="Management" class="button">管理者ページ</a><br> <a
			href="ProductControll" class="button">購入ページ</a>
	</form>


</body>
</html>
