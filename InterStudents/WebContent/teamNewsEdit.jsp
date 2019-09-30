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
<title>TeamNewsEdit画面</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#news').bxSlider({
			ticker : true,
			minSlides : 6,
			maxSlides : 6,
			slideWidth : 500,
			slideMargin : 50,
			speed : 20000
		});
	});
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

	function updateNews(obj) {
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

	function changeAttribute(){
		var checkBoxList = document.getElementsByClassName("checkBoxList");
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
		} else {
			document.getElementById('deleteButtonL').disabled="true";
		}

	};
</script>
<body>
	<header>
		<jsp:include page="/header.jsp" />
	</header>
	<div id="main">
		<div id="top">
			<p>TeamNewsEdit</p>
		</div>
		<ul id="news">
			<s:iterator value="newsList">
				<li><table class="news">
						<tr class="temImg">
							<th><img src='./img/<s:property value="templateImgPass"/>' /></th>
						</tr>
						<tr class="title">
							<td><s:property value="title" /></td>
						</tr>
						<tr class="comment">
							<td><s:property value="comment" /></td>
						</tr>
						<tr class="date">
							<td><s:property value="insertdate" /></td>
						</tr>
					</table></li>
			</s:iterator>
		</ul>
		<br />
		<div class="content">
			<input class="js-modal-open" id="btn-black" type="submit" value="投稿" data-target="CONTRIBUTE" />
			<input class="js-modal-open" id="btn-black" type="submit" value="修正" data-target="UPDATE" />
			<input class="js-modal-open" id="btn-black" type="submit" value="削除" data-target="DELETE" />
		</div>
		<div id="CONTRIBUTE" class="modal js-modal">
			<div class="modal__bg js-modal-close"></div>
			<div class="modal__content">
				<div class="cp_form">
					<s:form action="TeamNewsContributeAction" class="cp_group">
						<div class="title">
							<h2>チームニュース 投稿</h2>
						</div>
						<div class="cp_tx">
							<select name="templateImgPass">
								<option value='<s:property value="templateImgPass"/>'
									selected="selected">テンプレート画像</option>
								<option value="study.jpeg">教材</option>
								<option value="重要.jpg">重要</option>
								<option value="consult.jpg">面談</option>
								<option value="close.jpeg">休校</option>
							</select>
						</div>
						<div class="cp_tx">
							<input type="text" name="title" value="" placeholder="タイトル" />
						</div>
						<div class="cp_textarea">
							<s:textarea name="comment" value="" rows="7" cols="40"
								placeholder="コメントを書く" />
						</div>
						<div class="submit">
							<s:submit value="投稿" />
						</div>
					</s:form>
				</div>
				<a class="js-modal-close" href="">閉じる</a>
			</div>
		</div>

		<!-- ----------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------- -->

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
						<s:iterator value="newsList" status="st">
							<tr>
								<td><input type="radio" name="editUpdate" id="%{#st.index}"
									onChange="updateNews(this)" /></td>
								<td class="updateTitle"><s:property value="title" /></td>
								<td class="updateComment"><s:property value="comment" /></td>
								<td class="updateId"><s:property value="insertDate" /> <s:hidden
										value="%{id}" class="hidden" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<div class="cp_form">
					<s:form action="TeamNewsUpdateAction" class="cp_group">
						<div class="title">
							<h2>チームニュース 投稿</h2>
						</div>
						<div class="cp_tx">
							<select name="templateImgPass">
								<option value='<s:property value="templateImgPass"/>'
									selected="selected">テンプレート画像</option>
								<option value="study.jpeg">教材</option>
								<option value="importance.png">重要</option>
								<option value="consult.jpg">面談</option>
								<option value="close.jpeg">休校</option>
							</select>
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

		<!-- ----------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------- -->
		<!-- ----------------------------------------------------------------------------------------------- -->

		<div id="DELETE" class="modal js-modal">
			<div class="modal__bg js-modal-close"></div>
			<div class="modal__content">
				<s:form action="TeamNewsDeleteAction">
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
						<table class="list">
							<tbody>
								<s:iterator value="newsList">
									<tr>
										<td><input type="checkbox" name="checkList" class="checkBoxList"
											value="<s:property value='id'/>" onchange="changeAttribute()"/></td>
										<td><s:property value="title" /></td>
										<td><s:property value="comment" /></td>
										<td><s:property value="insertDate" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						</div>
						<div class="cp_group">
							<div class="submit">
								<s:submit value="削除" id="deleteButtonL" disabled="true" />
							</div>
					</div>
				</s:form>
				<a class="js-modal-close" href="">閉じる</a>
			</div>
		</div>
	</div>
	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>