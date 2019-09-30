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
<link rel="stylesheet" href="./css/table.css" type="text/css">

<style type="text/css">
.newbutton {
	width:68%;
	text-align: right;
	margin:0 auto;
}
</style>

<title>TeamEdit画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>TeamEdit</p>
		</div>
		<h1>---作成済みのチームを選び削除---</h1>
		<s:form action="TeamDeleteAction">
			<table class="list">
				<tr>
					<th>*</th>
					<th>チーム名</th>
					<th>何月生</th>
				</tr>
				<s:iterator value="teamList">
					<tr>
						<td><input type="checkbox" name="checkList" class="checks"
							value="<s:property value='id' />" /></td>
						<td><s:property value="teamName" /></td>
						<td><s:property value="generation" /></td>
					</tr>
				</s:iterator>
			</table>
			<div class="newbutton">
				<s:submit id="btn-red" value="削除" />
			</div>
		</s:form>
		<br>
		<br>
		<br>
		<h1>---新たにチームを作成---</h1>
		<s:form action="TeamAddAction">
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
				<label id="text"> <input type="text" name="teamName1"
					value="" placeholder="チーム名1" /><br />
				</label> <label id="text"> <input type="text" name="teamName2"
					value="" placeholder="チーム名2" /><br />
				</label> <label id="text"> <input type="text" name="teamName3"
					value="" placeholder="チーム名3" /><br />
				</label>
			</div>
			<div class="newbutton">
				<input id="btn-blue" type="submit" value="登録" />
			</div>
		</s:form>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>