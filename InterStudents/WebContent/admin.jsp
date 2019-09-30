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
<meta name="description" content="" />
<link rel="stylesheet" href="./css/style.css" type="text/css">
<link rel="stylesheet" href="./css/table.css" type="text/css">
<title>AdminPage画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>AdmiPage</p>
		</div>
		<table class="blue">
				<tr>
					<th>HOMEスライダー</th>
					<td><a href='<s:url action="HomeAction"/>'>Home画面</a></td>
				</tr>
				<tr>
					<th>生徒メッセージ</th>
					<td><a href='<s:url action="ProfileAction"/>'>Profile画面</a></td>
				</tr>
				<tr>
					<th>生徒削除/生徒チーム追加</th>
					<td><a href='<s:url action="StudentsListAction"/>'>StudentsList画面</a></td>
				</tr>
				<tr>
					<th>チーム名追加/削除</th>
					<td><a href='<s:url action="GoTeamAddAction"/>'>TeamEdit画面</a></td>
				</tr>
				<tr>
					<th>NEWSスライダー</th>
					<td><a href='<s:url action="TeamHomeAction"/>'>TeamHome画面</a></td>
				</tr>
				<tr>
					<th>掲示板スライダー</th>
					<td><a href='<s:url action="TeamHomeAction"/>'>TeamHome画面</a></td>
				</tr>
		</table>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>