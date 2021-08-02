<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src='js/file_check.js'></script>	<!-- 태그보다 위 쪽에 선언된 경우   -->
</head>
<body>
	<h3>답글 작성</h3>
	<!-- 파일 첨부하여 submit 하는 경우
		1. method 는 post 로 지정
		2. form 에는 반드시 enctype='multipart/form-data' 지정
	 -->
	<form action="reply_insert.no" method="post" enctype="multipart/form-data">
		<input type="hidden" name='root' value = '${vo.root }'/>
		<input type="hidden" name='step' value = '${vo.step }'/>
		<input type="hidden" name='indent' value = '${vo.indent }'/>
		<table>
			<tr>
				<th class='w-px120'>제목</th>
				<td>
					<input type='text' name='title' class='chk' title='제목' />
				</td>			
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content" class='chk' title='내용' ></textarea>
				</td>			
			</tr>
			<tr>
				<th>첨부파일</th>
				<td class='left'>
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
		<a class='btn-fill' onclick= "if ( emptyCheck() ) $('form').submit()">저장하기</a>
		<a class='btn-empty' href='list.no'>취소</a>
	</div>
<!-- <script type="text/javascript" src='js/file_check.js'></script> -->
</body>
</html>