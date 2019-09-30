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
	<s:form action="">
		<table class="seat">
			<tbody>
				<s:if test="grade==1">
					<s:iterator value="studentsList" status="st">
						<s:if test="#st.index%7 == 0">
							<tr>
						</s:if>
						<s:if test='userName=="　"'>
							<td><s:property value="userName" /></td>
						</s:if>
						<s:else>
							<td><select name="#st.index">
							<s:iterator value="studentsNameList"><option value='<s:property value="userName" />'><s:property value="userName" /></option></s:iterator>
							</select></td>
						</s:else>
						<s:if test="#st.index%7 == 6">
							</tr>
						</s:if>
					</s:iterator>
				</s:if>
			</tbody>
		</table>
	</s:form>

	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>