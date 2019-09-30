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
<title>Header</title>

<style type="text/css">
header {
	width: 100%;
	height: 80px;
	padding-top: 0;
	background-color: white;
	position: relative;
	top: 0;
}

#menu img {
	float: left;
	height: 40px;
	padding-left: 40px;
	padding-top: 10px;
	display: flex;
}

#menu li {
	float: right;
	list-style: none;
	line-height: 80px;
	padding-right: 20px;
	color: #258;
	font-size: 10px;
	display: flex;
}
</style>
</head>
<body>
	<header>
		<div id="menu">
			<a href="https://www.internous.co.jp" target="_blank"><img
				src="./img/hd_logo_01.png" alt="インターノウス"></a>
			<ul>
				<s:if test='session.adminFlg == "A"'>
				<li><a href='<s:url action="AdminAction"/>'>ADMIN ></a></li>
				<li><a href='<s:url action="StudentsListAction"/>'>STUDENTS LIST ></a></li>
				</s:if>
				<s:if test="#session.login_user_id == null">
				<li><a href='<s:url action="UserCreateAction"/>'>USER CREATE ></a></li>
				</s:if>
				<s:if test="#session.login_user_id != null">
				<li><a href='<s:url action="StudentsListForGeneralAction"/>'><s:property value="#session.nowGrade"/>></a></li>
				<li><a href='<s:url action="LogoutAction"/>'>LOGOUT ></a></li>
				<li><a href='<s:url action="MyPageAction"/>'>MYPAGE ></a></li>
				</s:if>
				<s:else>
				<li><a href='<s:url action="HomeAction"/>'>LOGIN ></a></li>
				</s:else>
				<s:if test="#session.login_user_id != null && #session.team_name != null">
				<li><a href='<s:url action="TeamHomeAction"/>'>TEAM ></a></li>
				</s:if>
				<li><a href='<s:url action="GoHomeAction"/>'>HOME ></a></li>
			</ul>
		</div>
	</header>
</body>
</html>