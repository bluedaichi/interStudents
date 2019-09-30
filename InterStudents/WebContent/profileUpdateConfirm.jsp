<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Conntent-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="./css/style.css" type="text/css">
<link rel="stylesheet" href="./css/table.css" type="text/css">
<title>ProfileUpdateConfirm画面</title>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>ProfileUpdateConfirm</p>
		</div>
		<h2>更新する内容は以下でよろしいでしょうか。</h2>
		<br>
		<table class="blue">
			<tr>
				<th>入学月</th>
				<td><s:property value="session.generation" escape="false" /></td>
			</tr>
			<tr>
				<th>名前</th>
				<td><s:property value="session.userName" escape="false" /></td>
			</tr>
			<tr>
				<th>ふりがな</th>
				<td><s:property value="session.furigana" escape="false" /></td>
			</tr>
			<tr>
				<th>出身地</th>
				<td><s:property value="session.birthplace" escape="false" /></td>
			</tr>
			<tr>
				<th>趣味</th>
				<td><s:property value="session.userHobby" escape="false" /></td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><s:property value="session.userComment" escape="false" /></td>
			</tr>
		</table>
		<br />
		<s:form action="ProfileUpdateCompleteAction">
			<input id="btn-blue" type="submit" value="完了" />
		</s:form>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>