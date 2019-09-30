<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="./css/style.css" type="text/css">
<link rel="stylesheet" href="./css/table.css" type="text/css">
<title>NewsDetails画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>NewsDetails</p>
		</div>
		<table class="blue">
			<s:iterator value="#session.newsDTO">
				<tr>
					<th>タイトル</th>
					<td><s:property value="title" /></td>
				</tr>
				<tr>
					<th>コメント</th>
					<td><s:property value="comment" /></td>
				</tr>
				<tr>
					<th>登録時間</th>
					<td><s:property value="insertDate" /></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>