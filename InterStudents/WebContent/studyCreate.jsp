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
<title>Studycreate画面</title>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>StudyCreate</p>
		</div>
		<h2>進捗チェック</h2>
		<div id="textbox">
			<s:form action="StudyCreateCompleteAction">
				<div id="select-study">
					<select name="studyName">
						<option value="" selected="selected">言語/教材名を選択してください</option>
						<option value="HTML">HTML</option>
						<option value="CSS">CSS</option>
						<option value="JavaScript">JavaScript</option>
						<option value="jQuery">jQuery</option>
						<option value="XAMPP">XAMPP MySQL</option>
						<option value="コマンドプロンプトMySQL">コマンドプロンプトMySQL</option>
						<option value="PHP">PHP</option>
						<option value="Git GitHub">Git GitHub</option>
						<option value="Java">Java</option>
						<option value="Javaオブジェクト指向">Javaオブジェクト指向</option>
						<option value="Javaとデータベース接続">Javaとデータベース接続</option>
						<option value="JSPとServlet">JSPとServlet</option>
						<option value="ログイン認証">ログイン認証</option>
						<option value="ECサイト初級">ECサイト初級</option>
						<option value="ECサイト中級">ECサイト中級</option>
					</select>
				</div>
				<div id="select-study">
					<select name="studyHomework">
						<option value="" selected="selected">演習を選択してください</option>
						<option value="動画/テキスト">動画/テキスト</option>
						<option value="写経">写経</option>
						<option value="2カラムレイアウト">2カラムレイアウト</option>
						<option value="4eachblog">4eachblog</option>
						<option value="★の出力">★の出力</option>
						<option value="for文でプルダウンメニューを作る">for文でプルダウンメニューを作る</option>
						<option value="関数">関数</option>
						<option value="jQuert スライドショー">jQuert スライドショー</option>
						<option value="コマンドプロント用 読書">コマンドプロント用 読書</option>
						<option value="問い合わせフォーム">問い合わせフォーム</option>
						<option value="掲示板">掲示板</option>
						<option value="アカウント作成">アカウント作成</option>
						<option value="初 git push 完了">初 git push 完了</option>
						<option value="コレクションフレームワーク">コレクションフレームワーク</option>
						<option value="インスタンス化">インスタンス化</option>
						<option value="コンストラクタ">コンストラクタ</option>
						<option value="カプセル化">カプセル化</option>
						<option value="継承">継承</option>
						<option value="実装">実装</option>
						<option value="データベース作成">データベース作成</option>
						<option value="Javaとデータベース接続">Javaとデータベース接続</option>
						<option value="JSP HelloJSP">JSP HelloJSP</option>
						<option value="Servret HelloServret</option>">Servret
							HelloServret</option>
						<option value="ログイン">ログイン認証</option>
						<option value="フレームワーク演習">フレームワーク演習５</option>
					</select>
				</div>
				<div id="select-study">
					<select name="studyPeriod">
						<option value="" selected="selected">時間を選択してください</option>
						<option value="1時間目">1時間目</option>
						<option value="2時間目">2時間目</option>
						<option value="3時間目">3時間目</option>
						<option value="4時間目">4時間目</option>
						<option value="5時間目">5時間目</option>
						<option value="6時間目">6時間目</option>
						<option value="7時間目">7時間目</option>
						<option value="8時間目">8時間目</option>
						<option value="9時間目">9時間目</option>
						<option value="10時間目">10時間目</option>
						<option value="11時間目">11時間目</option>
						<option value="12時間目">12時間目</option>
						<option value="13時間目">13時間目</option>
						<option value="14時間目">14時間目</option>
						<option value="15時間目">15時間目</option>
					</select>
				</div>
				<div id="btn-right">
					<input id="btn-blue" type="submit" value="登録" />
				</div>
			</s:form>
			<div id="btn-left">
				<s:form action="MyPageAction">
					<input id="btn-red" type="submit" value="戻る" />
				</s:form>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>