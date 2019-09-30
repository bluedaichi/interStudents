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
<link rel="stylesheet" href="./css/error.css" type="text/css">
<title>Login画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>LOGIN</p>
		</div>
		<s:form action="LoginAction">
			<s:if test="errorMessage != null">
				<div class="error">
					<div class="error-message">
						<s:property value="errorMessage" />
						<br>
					</div>
				</div>
			</s:if>
			<s:elseif
				test="!loginUserIdErrorMessageList.isEmpty()||!passwordErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="loginUserIdErrorMessageList"
							var="userIdErrorMessage">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
				<div class="error">
					<div class="error-message">
						<s:iterator value="passwordErrorMessageList"
							var="passwordErrorMessage">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:elseif>
			<s:else>
			</s:else>
			<div id="textbox">
				<label id="text"> <input type="text" name="loginUserId"
					placeholder="ユーザーID" /><br />
				<br /> <input type="password" name="loginPassword"
					placeholder="ユーザーパスワード" /><br />
				<br />
				</label> <input id="btn-blue" type="submit" value="ログイン" />
			</div>
		</s:form>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>