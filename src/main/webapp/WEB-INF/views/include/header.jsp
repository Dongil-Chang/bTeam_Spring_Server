<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header style="padding:15px 0; text-align:left; border-bottom: 1px solid #ccc">
	<div class='category' style="margin-left: 100px;">
	<ul>
		<li><a href='<c:url value="/"/>'><img src="imgs/toolbarlogo.png"></a></li>
		<li><a href='list.cu' class='${category eq "cu" ? "active" : "" }'>예약하기</a></li>
		<li><a href='list.hr' class='${category eq "hr" ? "active" : "" }'>Q&A</a></li>
		<li><a href='list.no'class="${category eq 'no' ? 'active' : ''}">공지사항</a></li>
		<li><a href='list.bo'class="${category eq 'bo' ? 'active' : ''}">이용안내</a></li>
	</ul>
	</div>
   
   <div	style="position: absolute; right: 0; top: 20px; margin-right: 100px;">
   <ul>
  		<!-- 로그인 하지 않는 상태 -->
  		<c:if test="${empty loginInfo }">
		<li>
			<a class="main_login" href="login">로그인</a>
			<a class="main_sign" href="member">회원가입</a>
		</li>
		</c:if>
  		<!-- 로그인한 상태 -->
  		<c:if test="${!empty loginInfo }">
  		<li>
  			<strong>${loginInfo.name }</strong>님 <a href="logout" class="btn-fill">로그아웃</a>
  		</li>
  		</c:if>
   </ul>
   </div>
</header>
<style>
header ul, header ul li {
margin:0; padding:0; display:inline; 
}

header .category { 
font-size:18px;
}

header .category ul li:not(:first-child){
padding-left: 30px;
}

header .category ul li a:hover, header .category ul li a.active{
	font-weight: bold; color: #0000cd;
}

</style>
<link rel="stylesheet" type="text/css" href="css/common.css?v=<%=new java.util.Date().getTime()%>">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>