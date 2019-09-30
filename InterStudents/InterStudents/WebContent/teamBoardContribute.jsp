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
<title>TeamBoardContribute画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>TeamBoardContribute</p>
		</div>
		<div class="cp_form">
			<s:form action="TeamBoardContributeCompleteAction" class="cp_group">
				<div class="title">
					<h2>チーム掲示板 投稿</h2>
				</div>
				<div class="cp_tx">
					<label class="title">タイトル</label> <input class="large" type="text"
						name="title" />
				</div>
				<div class="cp_textarea">
					<label class="title">コメント</label>
					<textarea class="small" name="comment" cols="30" rows="5"></textarea>
				</div>
				<div class="submit">
					<input type="submit" value="投稿" />
				</div>
			</s:form>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>