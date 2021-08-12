<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1:1 문의 목록</h3>
	<form method="post" action="cu_list.qa">
		<input type="hidden" name='curPage' value="1" />
		<input type="hidden" name='id' />
	</form>
	<table class='w-pct70'>
		<thead>
			<tr>
				<th>NO</th>
				<th>문의종류</th>
				<th>문의제목</th>
				<th>문의일</th>
				<th>답변일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list }">
				<tr>
					<td colspan='5'>문의 내역이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${list }" var="vo">
				<tr>
					<td>${vo.no }</td>
					<td>
						<c:choose>	
							<c:when test="${vo.type eq 'customer'}">고객정보</c:when>
							<c:when test="${vo.type eq 'product'}">상품/상품평</c:when>
							<c:when test="${vo.type eq 'booking'}">예약관련</c:when>
							<c:when test="${vo.type eq 'service'}">서비스/불편사항</c:when>
						</c:choose>
					</td>
					<%-- <td>${vo.board_title }</td> --%>
					<td class='left'><a onclick='go_detail(${vo.board_num})'>${vo.board_title }</a></td>
					<td>${vo.board_write_date }</td>
					<td>${vo.board_edit_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script type="text/javascript">
	function go_detail(board_num){
		$('[name = id]').val( board_num );
		$('form').attr('action', 'cu_detail.qa');
		$('form').submit();
	}
</script>
	
</body>
</html>