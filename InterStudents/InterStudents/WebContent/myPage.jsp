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
<title>MyPage画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>Mypage</p>
		</div>
		<div>
			<s:if test="#session.studyInfo.isEmpty()">
				<h2>教材進捗がありません。</h2>
			</s:if>
			<s:iterator value="#session.studyInfo">
				<h2>
					<s:property value="userName" />
					さん ようこそ!!
				</h2><br/>
			</s:iterator>
			<h2>【進捗状況】</h2>
			<br />
			<table class="blue">
				<s:iterator value="#session.studyInfo">
					<tr>
						<th>教材名</th>
						<td><s:property value="studyName" /></td>
					</tr>
					<tr>
						<th>演習</th>
						<td><s:property value="studyHomework" /></td>
					</tr>
					<tr>
						<th>時間</th>
						<td><s:property value="studyPeriod" /></td>
					</tr>
					<tr>
						<th>更新日</th>
						<td><s:property value="updateDate" /></td>
					</tr>
				</s:iterator>
			</table>
			<br/>
			<s:form action="StudyCreateAction">
				<input id="btn-blue" type="submit" value="教材更新" />
			</s:form>
			<br>
			<h2>【プロフィール】</h2>
			<br />
			<table class="blue">
				<s:iterator value="#session.studyInfo">
					<tr>
						<th>入学月</th>
						<td><s:property value="generation" /></td>
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
						<th>チーム名</th>
						<td><s:property value="teamName" /></td>
					</tr>
					<tr>
						<th>コメント</th>
						<td><s:property value="userComment" /></td>
					</tr>
				</s:iterator>
			</table>
			<br/>
			<s:form action="ProfileUpdateAction">
				<input id="btn-blue" type="submit" value="プロフィール更新" />
			</s:form>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>