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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>
	$(document).ready(function() {
		$('#news').bxSlider({
			ticker : true,
			minSlides : 6,
			maxSlides : 6,
			slideWidth : 500,
			slideMargin : 50,
			speed : 15000
		});
	});
</script>

<style type="text/css">
.bx-wrapper {
	margin: auto !important;
}
</style>

<title>TeamHome画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>
				<s:property value="team" />
			</p>
		</div>
		<div id="center">
			<div id="textbox">
			<h1><s:property value="newsList.size"/>件のお知らせ</h1>
				<ul id="news">
					<s:iterator value="newsList" status="st">
						<li><table class="news">
						<tr class="comment">
									<td><h3><s:property value="#st.index+1"/>件目</h3></td>
								</tr>
								<tr class="temImg">
									<th><a
										href='<s:url action="NewsDetailsAction"><s:param name="id" value="%{id}"/></s:url>'>
											<img src='./img/<s:property value="templateImgPass"/>' />
									</a></th>
								</tr>
								<tr class="title">
									<td><s:property value="title" /></td>
								</tr>
							</table></li>
					</s:iterator>
				</ul>
			</div>
			<s:if test='session.adminFlg == "L" || session.adminFlg == "A"'>
				<s:form action="TeamNewsEditAction">
					<input id="btn-black" type="submit" value="NEWS編集" />
				</s:form>
				<br />
			</s:if>
			<div id="borad-list">
				<table class="list">
					<tbody>
						<tr>
							<th>投稿者</th>
							<th>タイトル</th>
							<th>コメント</th>
							<th>投稿日時</th>
						</tr>
					</tbody>
				</table>
				<table class="list">
					<tbody>
						<s:iterator value="boardList">
							<tr>
								<td><s:property value="contributorName" /></td>
								<td><s:property value="title" /></td>
								<td><s:property value="comment" /></td>
								<td><s:property value="insertDate" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<br />
				<s:if test='session.adminFlg == "L" || session.adminFlg == "A"'>
					<s:form action="TeamBoardEditAction">
						<input id="btn-black" type="submit" value="掲示板編集" />
					</s:form>
				</s:if>
				<s:else>
					<s:form action="TeamBoardContributeAction">
						<input id="btn-black" type="submit" value="掲示板投稿" />
					</s:form>
				</s:else>
			</div>
			<br />
			<div id="students-list">
				<p>
					<s:property value="team" />
					座席表
				</p>
				<table class="seat">
					<tbody>
						<s:iterator value="studentsList" status="st">
							<s:if test="#st.index%2 == 0">
								<tr>
							</s:if>
							<s:if test='userName=="　"'>
								<td><s:property value="userName" /></td>
							</s:if>
							<s:else>
								<td><a
									href='<s:url action="ProfileAction"><s:param name="userName" value="userName"/></s:url>'><s:property
											value="userName" /></a></td>
							</s:else>
							<s:if test="#st.index%2 == 1">
								</tr>
							</s:if>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>