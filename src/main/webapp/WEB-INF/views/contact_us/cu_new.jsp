<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='js/file_check.js'></script>	<!-- 태그보다 위 쪽에 선언된 경우   -->
</head>
<body>
	<h3>소소한 문의</h3>
	<form method="post" action="cu_insert.qa" enctype="multipart/form-data">
		<table class='w-pct70'>
			<tr>
				<th>문의종류</th>
				<td>
					<select name="type" class='w-px150'>
						<option value="customer" ${page.search eq 'customer' ? 'selected' : '' } >고객정보</option>
						<option value="product" ${page.search eq 'product' ? 'selected' : '' }>상품/상품평</option>
						<option value="booking" ${page.search eq 'booking' ? 'selected' : '' }>예약관련</option>
						<option value="service" ${page.search eq 'service' ? 'selected' : '' }>서비스/불편사항</option>
					</select>				
				</td>
				<th>문의제목</th>
				<td>
					<input type="text" name="board_title" class="chk" title="제목" />
				</td>
			</tr>
			<tr>
				<th>문의내용</th>
				<td colspan="3">
					<textarea class="p_textareaname" name="board_content" title="내용"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td class='left' colspan="3">
					<label>
						<a><img src="imgs/select.png" class='file-img' /></a>
						<input type="file" id='attach-file' name='file' />
					</label>
					<span id='file-name'></span>
					<a id='delete-file'><i class="font-img fas fa-minus-circle"></i></a>
				</td>
			</tr>
		</table>
	</form>
	<div class='btnSet'>
		<a class='btn-fill' onclick=" if( emptyCheck() ) $('form').submit() ">문의하기 등록</a>
		<a class='btn-empty' onclick='history.go(-1)'>입력취소</a>
	</div>
	<div class='btnSet'>
		<jsp:include page="/WEB-INF/views/contact_us/cu_list.jsp" />
	</div>
</body>
</html>

