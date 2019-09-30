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

.bx-wrapper {
	margin: auto !important;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="center">
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