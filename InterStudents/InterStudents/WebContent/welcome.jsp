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
		<meta name="descriprion" content="" />
		<meta name="keywords" content="" />
		<title>Welcome画面</title>

		<style type="text/css">
		/*====== TAG LAOUT ======*/

				body {
					margin: 0;
					padding: 0;
					line-height: 1.6;
					letter-spacing: 1px;
					font-family: Verdana, Helvetica, sans-serif;
					font-size: 20px;
					color: #333;
					background: #fff;
				}

				table {
					text-align: center;
					margin: 0 auto;
				}

				/* ========ID LAYOUT======== */

				#top {
					width: 780px;
					margin: 30px auto;
					border: 3px solid #333;
				}

				#header {
					width: 100%;
					height: 80px;
					background-color:#00ffff;
				}

				#main {
					width: 100%;
					height: 600px;
					text-align: center;
				}

				#footer {
					width: 100%;
					height: 50px;
					background-color:#999999;
					clear: both;
				}

		</style>
</head>
<body>
		<div id="header">
				<div id="pr">
				</div>
		</div>
		<div id="main">
				<div id="top">
						<p>Welcome</p>
				</div>
				<div>
						<h3>生徒</h3>
						<table>
								<tr>
										<td>
												<s:form action="1Action">
												<p><input type="submit" value="６月生"/></p>
												</s:form>
										</td>
										<td>
												<s:form action="2Action">
												<input type="submit" value="7月生"/>
												</s:form>
										</td>
										<td>
												<s:form action="3Action">
												<input type="submit" value="8月生"/>
												</s:form>
										</td>
								</tr>
						</table>
						<div>
						<br/>
										<a href='<s:url action="StudyCreateAction"/>'>教材更新</a>
						</div>
				</div>
		</div>
		<div id="footer">
				<div id="pr">
				</div>
		</div>
</body>
</html>