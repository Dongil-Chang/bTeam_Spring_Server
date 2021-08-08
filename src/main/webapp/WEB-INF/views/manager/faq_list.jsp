<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>FAQ 목록</h3>
	<div id='list-top'>
		<form method="post" action="faq_list.ma">
			<input type="hidden" name='id' />	<!-- detail 에 보내질 id -->
			<div>
				<ul>
					<li><a class='btn-fill' href='faq_new.ma'>글쓰기</a></li>
				</ul>
			</div>
		</form>
	</div>
	<table>
		<thead>
			<tr>
				<th class='w-px120'>번호</th>
				<th>제목</th>
				<th class='w-px180'>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty faq }">
				<tr>
					<td colspan='3'>FAQ 정보가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${faq}" var="vo">
				<tr>
					<td>${vo.faq_code }</td>
					<td class='left'><a onclick='go_detail(${vo.faq_code})'>${vo.faq_title }</a></td>
					<td>${vo.faq_regist_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<script type="text/javascript">
	function go_detail(faq_code){
		$('[name = id]').val( faq_code );
		$('form').attr('action', 'faq_detail.ma');
		$('form').submit();
	}
</script>
	
</body>
</html>