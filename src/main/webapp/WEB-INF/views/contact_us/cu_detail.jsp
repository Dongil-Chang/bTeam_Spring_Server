<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1:1 문의 상세 화면</h3>
	<table class='w-pct70'>
		<tr>
			<th class='w-px80'>문의종류</th>
			<td>
				<c:choose>	
					<c:when test="${vo.type eq 'customer'}">고객정보</c:when>
					<c:when test="${vo.type eq 'product'}">상품/상품평</c:when>
					<c:when test="${vo.type eq 'booking'}">예약관련</c:when>
					<c:when test="${vo.type eq 'service'}">서비스/불편사항</c:when>
				</c:choose>
			</td>
			<th class='w-px80'>문의일</th>
			<td>${vo.board_write_date }</td>
			<th class='w-px80'>답변일</th>
			<td>${vo.board_edit_date }</td>
		</tr>
		<tr>
			<th class='w-px80'>제목</th>
			<td colspan="5">${vo.board_title }</td>
		</tr>
		<tr>
			<th>내용</th>			
			<td colspan='5' class='left'>${fn:replace(vo.board_content, crlf, '<br>')}</td>
		</tr>
	</table>
	<div class='btnSet'>
		<a class='btn-fill' href='cu_modify.qa?board_num=${vo.board_num }'>수정</a>
		<a class='btn-fill' onclick=" if(confirm('정말 삭제하시겠습니까?')) { href='cu_delete.qa?id=${vo.board_num}' } ">삭제</a>
		<a class='btn-fill' href='cu_list.qa'>목록</a>
	</div>	
</body>
</html>