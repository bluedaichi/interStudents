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
<body>

	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
	<h2>
		<s:property value="generation" />
	</h2>
	<table class="list">
		<tr>
			<th>生徒名</th>
			<th>教材名</th>
			<th>演習</th>
			<th>時間</th>
			<th>チーム名</th>
			<th>更新日</th>
		</tr>
		<s:iterator value="studentsList">
			<tr>
				<td><a
					href='<s:url action="ProfileAction"><s:param name="userName" value="%{userName}"/></s:url>'><s:property
							value="userName" /></a></td>
				<td><s:property value="studyName" /></td>
				<td><s:property value="studyHomework" /></td>
				<td><s:property value="studyPeriod" /></td>
				<td><s:property value="teamName" /></td>
				<td><s:property value="updateDate" /></td>
			</tr>
		</s:iterator>
	</table>
	</div>

	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>