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
<link rel="stylesheet" href="./css/table.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<title>StudentsList画面</title>

<script type="text/javascript">
	$(function() {
		$('.js-modal-open').each(function() {
			$(this).on('click', function() {
				var target = $(this).data('target');
				var modal = document.getElementById(target);
				$(modal).fadeIn();
				return false;
			});
		});
		$('.js-modal-close').on('click', function() {
			$('.js-modal').fadeOut();
			return false;
		});
	});

	function checkedAction() {
		var cList = $('.checks:checked');
		var checkedList = [];
		for (i = 0; i < cList.length; i++) {
			checkedList.push($(cList[i]).val())
		};
		if (checkedList != null && checkedList.length > 0) {
			$('#checkedAccount').val(checkedList);
		};
	};

	function checkedAction2() {
		var cList2 = $('.checks:checked');
		var checkedList2 = [];
		for (i = 0; i < cList2.length; i++) {
			checkedList2.push($(cList2[i]).val())
		};

		if (checkedList2 != null && checkedList2.length > 0) {
			$('#checkedAccount2').val(checkedList2);
		};
	};

	function changeAttribute(){
		var checkBoxList = document.getElementsByClassName("checks");
		var checkFlag = 0;
		for (  var i = 0;  i < checkBoxList.length;  i++  ) {
			if(checkFlag == 0){
				if(checkBoxList[i].checked) {
					checkFlag = 1;
					break;
				};
			};
		};
		if (checkFlag == 1) {
			document.getElementById('deleteButtonL').disabled="";
			document.getElementById('deleteMessage').textContent="チェックを入れたユーザーを削除します。よろしいですか？";
		} else {
			document.getElementById('deleteButtonL').disabled="true";
			document.getElementById('deleteMessage').textContent="チェックを入れてください。";
		}

	};
</script>
</head>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>StudentsList</p>
		</div>
		<div id="textbox">
			<s:form action="StudentsListAction">
				<div id="select">
					<s:select name="generation" list="generationArray" />
				</div>
				<input type="text" name="search" placeholder="ひらながで生徒を検索" />
				<br />
				<br />
				<input id="btn-blue" type="submit" value="検索">
				<br />
			</s:form>
			<br />
		</div>

		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->

		<h2>
			<s:property value="generation" />
		</h2>
		<table class="list">
			<tr>
				<th>*</th>
				<th>生徒名</th>
				<th>教材名</th>
				<th>演習</th>
				<th>時間</th>
				<th>チーム名</th>
				<th>更新日</th>
			</tr>
			<s:iterator value="#session.studentsList">
				<tr>
					<td><input type="checkbox" name="checkList" class="checks"
						value="<s:property value='id' />" onchange="changeAttribute()"/></td>
					<td><a
						href='<s:url action="ProfileAction"><s:param name="userName" value="%{userName}"/></s:url>'><s:property
								value="userName" /></a></td>
					<td><s:property value="studyName" /></td>
					<td><s:property value="studyHomework" /></td>
					<td><s:property value="studyPeriod" /></td>
					<td><s:property value="teamName" /></td>
					<td><s:property value="updateDate" /></td>
				</tr>
			</s:iterator>
		</table>

		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->

		<div class="content">
			<input class="js-modal-open" id="btn-black" type="submit" value="編成"
				data-target="organization" onclick="checkedAction2()" /><input
				class="js-modal-open" id="btn-black" type="submit" value="削除"
				data-target="DELETE" onclick="checkedAction()" />
		</div>
		<div id="organization" class="modal js-modal">
			<div class="modal__bg js-modal-close"></div>
			<div class="modal__content">
				<div class="cp_form">
					<h2>チェックを入れたユーザーを以下で選択したチームに所属させます。</h2>
					<s:form action="StudentsSetTeamAction" class="cp_group">
						<table class="list">
							<tr>
								<th>*</th>
								<th>チーム名</th>
							</tr>
							<s:iterator value="teamList" status="st">
								<tr>
									<td><input type="radio" name="selectName"
										id="%{#st.index}" value='<s:property value="teamName" />' /></td>
									<td><s:property value="teamName" /></td>
								</tr>
							</s:iterator>
						</table>
						<input type="hidden" id="checkedAccount2" name="checked" value="">
						<div class="submit">
							<input type="submit" value="編成" />
						</div>
					</s:form>
				</div>
				<a class="js-modal-close" href="">閉じる</a>
			</div>
		</div>

		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->

		<div id="DELETE" class="modal js-modal">
			<div class="modal__bg js-modal-close"></div>
			<div class="modal__content">
				<div id="btn-right">
					<div id="deleteMessage">チェックを入れてください。</div>
					<s:form action="StudentsDeleteAction">
						<input type="hidden" id="checkedAccount" name="checked" value="">
						<s:submit  id="deleteButtonL" value="了承" disabled="true"/>
					</s:form>
					<br /> <a class="js-modal-close" href="">閉じる</a>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>