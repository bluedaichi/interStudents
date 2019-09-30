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
<title>UserCreateConfirm画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h2>登録する内容は以下でよろしいでしょうか。</h2>
			<br />
			<div id="textbox">
				<table class="blue">
					<tr>
						<th>入学月</th>
						<td><s:property value="generation" /></td>
					</tr>
					<tr>
						<th>ユーザーID</th>
						<td><s:property value="loginUserId" /></td>
					</tr>
					<tr>
						<th>ユーザーパスワード</th>
						<td><s:property value="loginPassword" /></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><s:property value="userName" /></td>
					</tr>
					<tr>
						<th>ふりがな</th>
						<td><s:property value="furigana" /></td>
					</tr>
					<tr>
						<th>出身地</th>
						<td><s:property value="birthplace" /></td>
					</tr>
					<tr>
						<th>趣味</th>
						<td><s:property value="userHobby" /></td>
					</tr>
					<tr>
						<th>コメント</th>
						<td><s:property value="userComment" /></td>
					</tr>
				</table>
				<br />
				<div id="btn-left">
					<s:form action="UserCreateAction">
						<input id="btn-red" type="submit" value="戻る" />
					</s:form>
				</div>
				<div id="btn-right">
					<s:form action="UserCreateCompleteAction">
						<input id="btn-blue" type="submit" value="完了" />
					</s:form>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>