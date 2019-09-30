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
			speed : 20000
		});
	});
</script>
<title>Generatione画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>
				<s:property value="generation" />
			</p>
		</div>
		<div id="textbox">
			<ul id="news">
				<li><table class="news">
						<s:iterator value="newsList">
							<tr class="temImg">
								<th><img src='./img/<s:property value="templateImgPass"/>' /></th>
							</tr>
							<tr class="title">
								<td><s:property value="title" /></td>
							</tr>
							<tr class="comment">
								<td><s:property value="comment" /></td>
							</tr>
							<tr class="date">
								<td><s:property value="insertdate" /></td>
							</tr>
						</s:iterator>
					</table></li>
				<li><img src="./img/jQuery_image1.jpg"></li>
				<li><img src="./img/jQuery_image1.jpg"></li>
				<li><img src="./img/jQuery_image1.jpg"></li>
				<li><img src="./img/jQuery_image1.jpg"></li>
			</ul>
			<s:if test='session.adminFlg == "L" || session.adminFlg == "A"'>
				<s:form action="TeamNewsEditAction">
					<input id="btn-black" type="submit" value="NEWS編集" />
				</s:form>
				<br />
			</s:if>
			<div id="students-list">
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