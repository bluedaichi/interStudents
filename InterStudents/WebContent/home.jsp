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
<link rel="stylesheet" href="slick-theme.css" type="text/css">
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
<title>Home画面</title>

<style type="text/css">
#photo img {
	margin: 0 auto;
}

#center {
	margin: auto;
	width: 70%;
}

#news {
	width: 95%;
	margin: 0 auto;
}

#tool {
	width: 95%;
	margin: 0 auto;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="center">
			<ul id="news">
				<s:iterator value="newsList">
					<li><table class="news">
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
						</table></li>
				</s:iterator>
			</ul>
			<s:if test='session.adminFlg == "A"'>
				<s:form action="NewsEditAction">
					<input id="btn-black" type="submit" value="NEWS編集" />
				</s:form>
				<br />
			</s:if>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>