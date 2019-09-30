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
<title>UserCreate画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
		<s:if
			test="generationErrorMessageList !=null && generationErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="generationErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="loginUserIdErrorMessageList !=null && loginUserIdErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="loginUserIdErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="loginPasswordErrorMessageList !=null && loginPasswordErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="loginPasswordErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="userNameErrorMessageList !=null && userNameErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="userNameErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="furiganaErrorMessageList !=null && furiganaErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="furiganaErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="birthplaceErrorMessageList !=null && birthplaceErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="birthplaceErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="userHobbyErrorMessageList !=null && userHobbyErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="userHobbyErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="userCommentErrorMessageList !=null && userCommentErrorMessageList.size()>0">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="userCommentErrorMessageList">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:if
			test="checkExistsUserErrorMessage !=null">
			<div class="error">
				<div class="error-messege">
					<s:iterator value="checkExistsUserErrorMessage">
						<s:property />
						<br />
					</s:iterator>
				</div>
			</div>
		</s:if>
		<s:form action="UserCreateConfirmAction">
			<div id="textbox">
				<div id="select">
					<select name="generation">
						<option value="" selected="selected">入学月を選択して下さい</option>
						<option value="1月生">1月生</option>
						<option value="2月生">2月生</option>
						<option value="3月生">3月生</option>
						<option value="4月生">4月生</option>
						<option value="5月生">5月生</option>
						<option value="6月生">6月生</option>
						<option value="7月生">7月生</option>
						<option value="8月生">8月生</option>
						<option value="9月生">9月生</option>
						<option value="10月生">10月生</option>
						<option value="11月生">11月生</option>
						<option value="12月生">12月生</option>
					</select><br />
				</div>
				<label id="text"> <input type="text" name="loginUserId"
					value="" placeholder="ユーザーID" /><br /> <br /> <input
					type="password" name="loginPassword" value=""
					placeholder="ユーザーパスワード" /><br /> <br /> <input type="text"
					name="userName" value="" placeholder="名前(漢字)" /><br /> <br /> <input
					type="text" name="furigana" value="" placeholder="ふりがな" /><br />
					<br /> <input type="text" name="birthplace" value=""
					placeholder="出身地" /><br /> <br /> <input type="text"
					name="userHobby" value="" placeholder="趣味" /><br /> <br /> <input
					type="text" name="userComment" value="" placeholder="一言コメント" /><br />
					<br />
				</label>
			</div>
			<div id="btn-right">
				<input id="btn-blue" type="submit" value="登録" />
			</div>
		</s:form>
		<div id="btn-left">
			<s:form action="HomeAction">
				<input id="btn-red" type="submit" value="戻る" />
			</s:form>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>