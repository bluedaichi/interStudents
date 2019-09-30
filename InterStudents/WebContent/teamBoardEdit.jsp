<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<link rel="stylesheet" href="./css/style.css" type="text/css">
<link rel="stylesheet" href="./css/table.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<title>TeamBoardEdit画面</title>
</head>
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
	function updateBoard(obj) {
		var targetTr = $(obj).parent().parent();
		var titleTd = $(targetTr).find('td.updateTitle');
		var title = $(titleTd).text();
		var commentTd = $(targetTr).find('td.updateComment');
		var comment = $(commentTd).text();
		var idTd = $(targetTr).find('td.updateId').find('input.hidden');
		var id = $(idTd).val();

		$('#updateTitle').val(title);
		$('#updateComment').val(comment);
		$('#commentId').val(id);
	}
</script>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>TeamBoardEdit</p>
		</div>
			<table class="list">
				<tbody>
					<tr>
						<th>タイトル</th>
						<th>コメント</th>
						<th>投稿日時</th>
					</tr>
				</tbody>
			</table>
			<table class="list">
				<tbody>
					<s:iterator value="boardList">
						<tr>
							<td><s:property value="title" /></td>
							<td><s:property value="comment" /></td>
							<td><s:property value="insertDate" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		<div class="content">
			<input class="js-modal-open" id="btn-black" type="submit" value="投稿" data-target="CONTRIBUTE" />
			<input class="js-modal-open" id="btn-black" type="submit" value="修正" data-target="UPDATE" />
			<input class="js-modal-open" id="btn-black" type="submit" value="削除" data-target="DELETE" />
		</div>
		<div id="CONTRIBUTE" class="modal js-modal">
			<div class="modal__bg js-modal-close"></div>
			<div class="modal__content">
				<div class="cp_form">
					<s:form action="TeamBoardContributeCompleteAction" class="cp_group">
						<div class="title">
							<h2>チーム掲示板 投稿</h2>
						</div>
						<div class="cp_tx">
							<label class="title">タイトル</label> <input class="large"
								type="text" name="title" />
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
				<a class="js-modal-close" href="">閉じる</a>
			</div>
		</div>

		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------------- -->

		<div id="UPDATE" class="modal js-modal">
			<div class="modal__bg js-modal-close"></div>
			<div class="modal__content">
				<table class="list">
					<tbody>
						<tr>
							<th>*</th>
							<th>タイトル</th>
							<th>コメント</th>
							<th>投稿日時</th>
						</tr>
					</tbody>
				</table>
				<table class="list">
					<tbody>
						<s:iterator value="boardList" status="st">
							<tr>
								<td><input type="radio" name="editUpdate" id="%{#st.index}"
									onChange="updateBoard(this)" /></td>
								<td class="updateTitle"><s:property value="title" /></td>
								<td class="updateComment"><s:property value="comment" /></td>
								<td class="updateId"><s:hidden value="%{id}" class="hidden" />
									<s:property value="insertDate" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<div class="cp_form">
					<s:form action="TeamBoardUpdateAction" class="cp_group">
						<div class="title">
							<h2>チーム掲示板 投稿</h2>
						</div>
						<div class="cp_tx">
							<label class="title">タイトル</label> <input class="large"
								type="text" name="title" id="updateTitle" />
						</div>
						<div class="cp_textarea">
							<label class="title">コメント</label>
							<textarea class="small" name="comment" cols="30" rows="5"
								id="updateComment"></textarea>
						</div>
						<input type="hidden" name="id" id="commentId">
						<div class="submit">
							<input type="submit" value="投稿" />
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
				<table class="list">
					<tbody>
						<tr>
							<th>*</th>
							<th>タイトル</th>
							<th>コメント</th>
							<th>投稿日時</th>
						</tr>
					</tbody>
				</table>
				<div class="cp_form">
					<s:form action="TeamBoardDeleteAction">
						<table class="list">
							<tbody>
								<s:iterator value="boardList">
									<tr>
										<td><input type="checkbox" name="checkList"
											value="<s:property value='id'/>" /></td>
										<td><s:property value="title" /></td>
										<td><s:property value="comment" /></td>
										<td><s:property value="insertDate" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						<div class="cp_group">
							<div class="submit">
								<input type="submit" value="削除" />
							</div>
						</div>
					</s:form>
				</div>
				<a class="js-modal-close" href="">閉じる</a>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>

</body>
</html>