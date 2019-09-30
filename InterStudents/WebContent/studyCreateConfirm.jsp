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
		<title>StudyCreateConfirm画面</title>

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
						<p>StudyCreateConfirm</p>
				</div>
				<div>
						<h3>更新されました。</h3>
										<table>
												<s:iterator value="#session.studyDTOList">
														<tr>
															<s:if test='studyName=="HTML"'>
																<td>HTML</td>
															</s:if>
															<s:if test='studyName=="CSS"'>
																<td>CSS</td>
															</s:if>
															<s:if test='studyName=="JavaScript"'>
																<td>JavaScript</td>
															</s:if>
															<s:if test='studyName=="jQuery"'>
																<td>jQuery</td>
															</s:if>
															<s:if test='studyName=="XAMPP MySQL"'>
																<td>XAMPP MySQL</td>
															</s:if>
															<s:if test='studyName=="コマンドプロンプトMySQL"'>
																<td>コマンドプロンプトMySQL</td>
															</s:if>
															<s:if test='studyName=="PHP"'>
																<td>PHP</td>
															</s:if>
															<s:if test='studyName=="Git GitHub"'>
																<td>Git GitHub</td>
															</s:if>
															<s:if test='studyName=="Java"'>
																<td>Java</td>
															</s:if>
															<s:if test='studyName=="Javaオブジェクト指向"'>
																<td>Javaオブジェクト指向</td>
															</s:if>
															<s:if test='studyName=="Javaとデータベース接続"'>
																<td>Javaとデータベース接続</td>
															</s:if>
															<s:if test='studyName=="JSPとServletL"'>
																<td>JSPとServlet</td>
															</s:if>
															<s:if test='studyName=="ログイン認証"'>
																<td>ログイン認証</td>
															</s:if>
															<s:if test='studyName=="ECサイト初級"'>
																<td>ECサイト初級</td>
															</s:if>
															<s:if test='studyName=="ECサイト中級"'>
																<td>ECサイト中級</td>
															</s:if>
														</tr>
														<tr>
															<s:if test='studyHomework=="なし"'>
																<td>なし</td>
															</s:if>
															<s:if test='studyHomework=="動画/テキスト"'>
																<td>動画/テキスト</td>
															</s:if>
															<s:if test='studyHomework=="写経"'>
																<td>写経</td>
															</s:if>
															<s:if test='studyHomework=="2カラムレイアウト"'>
																<td>2カラムレイアウト</td>
															</s:if>
															<s:if test='studyHomework=="4eachblog"'>
																<td>4eachblog</td>
															</s:if>
															<s:if test='studyHomework=="★の出力"'>
																<td>★の出力</td>
															</s:if>
															<s:if test='studyHomework=="for文でプルダウンメニューを作る"'>
																<td>for文でプルダウンメニューを作る</td>
															</s:if>
															<s:if test='studyHomework=="関数"'>
																<td>関数</td>
															</s:if>
															<s:if test='studyHomework=="jQuert スライドショー"'>
																<td>jQuert スライドショー</td>
															</s:if>
															<s:if test='studyHomework=="コマンドプロント用 読書"'>
																<td>コマンドプロント用 読書</td>
															</s:if>
															<s:if test='studyHomework=="問い合わせフォーム"'>
																<td>問い合わせフォーム</td>
															</s:if>
															<s:if test='studyHomework=="掲示板"'>
																<td>掲示板</td>
															</s:if>
															<s:if test='studyHomework=="アカウント作成"'>
																<td>アカウント作成</td>
															</s:if>
															<s:if test='studyHomework=="初 git push 完了"'>
																<td>初 git push 完了</td>
															</s:if>
															<s:if test='studyHomework=="コレクションフレームワーク"'>
																<td>コレクションフレームワーク</td>
															</s:if>
															<s:if test='studyHomework=="インスタンス化"'>
																<td>インスタンス化</td>
															</s:if>
															<s:if test='studyHomework=="コンストラクタ"'>
																<td>コンストラクタ</td>
															</s:if>
															<s:if test='studyHomework=="カプセル化"'>
																<td>カプセル化</td>
															</s:if>
															<s:if test='studyHomework=="継承"'>
																<td>継承</td>
															</s:if>
															<s:if test='studyHomework=="実装"'>
																<td>実装</td>
															</s:if>
															<s:if test='studyHomework=="データベース作成"'>
																<td>データベース作成</td>
															</s:if>
															<s:if test='studyHomework=="Javaとデータベース接続"'>
																<td>Javaとデータベース接続</td>
															</s:if>
															<s:if test='studyHomework=="JSP HelloJSP"'>
																<td>JSP HelloJSP</td>
															</s:if>
															<s:if test='studyHomework=="Servret HelloServret"'>
																<td>Servret HelloServret</td>
															</s:if>
															<s:if test='studyHomework=="ログイン"'>
																<td>ログイン</td>
															</s:if>
															<s:if test='studyHomework=="フレームワーク演習５"'>
																<td>フレームワーク演習５</td>
															</s:if>
														</tr>
														<tr>
															<s:if test='studyPeriod=="なし"'>
																<td>なし</td>
															</s:if>
															<s:if test='studyPeriod=="1時間目"'>
																<td>1時間目</td>
															</s:if>
															<s:if test='studyPeriod=="2時間目"'>
																<td>2時間目</td>
															</s:if>
															<s:if test='studyPeriod=="3時間目"'>
																<td>3時間目</td>
															</s:if>
															<s:if test='studyPeriod=="4時間目"'>
																<td>4時間目</td>
															</s:if>
															<s:if test='studyPeriod=="5時間目"'>
																<td>6時間目</td>
															</s:if>
															<s:if test='studyPeriod=="7時間目"'>
																<td>7時間目</td>
															</s:if>
															<s:if test='studyPeriod=="8時間目"'>
																<td>8時間目</td>
															</s:if>
															<s:if test='studyPeriod=="9時間目"'>
																<td>9時間目</td>
															</s:if>
															<s:if test='studyPeriod=="10時間目"'>
																<td>10時間目</td>
															</s:if>
															<s:if test='studyPeriod=="11時間目"'>
																<td>11時間目</td>
															</s:if>
															<s:if test='studyPeriod=="12時間目"'>
																<td>12時間目</td>
															</s:if>
															<s:if test='studyPeriod=="13時間目"'>
																<td>13時間目</td>
															</s:if>
															<s:if test='studyPeriod=="14時間目"'>
																<td>14時間目</td>
															</s:if>
															<s:if test='studyPeriod=="15時間目"'>
																<td>15時間目</td>
															</s:if>
													</tr>
											</s:iterator>
								</table>
				<div>
								<a href='<s:url action="HomeAction" />'>ログインへ</a>
						</div>
				</div>
		</div>
		<div id="footer">
				<div id="pr">
				</div>
		</div>
</body>
</html>