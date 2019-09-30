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
			minSlides : 3,
			maxSlides : 3,
			slideWidth : 2000,
			slideMargin : 30 ,
			speed : 40000
		});
	});
</script>
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
		<div id="textbox">
			<ul id="news">
				<s:iterator value="newsList">
					<li><a href='<s:url action="NewsDetailsAction"><s:param name="id" value="%{id}"/></s:url>'> <img
							src='./img/<s:property value="templateImgPass" />'width="250" height="150" /></a> <s:property
							value="title" /></li>
				</s:iterator>
			</ul>
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