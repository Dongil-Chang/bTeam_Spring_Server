<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>FAQ 1</title>

<style>
/* FAQ */
h3{
font-size: 30px;
}

.faq{
border-bottom:0px solid #ddd;margin:1em 0;
width: 100%;
height: 100%;
}

.faq .faqHeader{
position:relative;
/* zoom:1 */
}

.faq .faqHeader .showAll{
position:absolute;
bottom:0;
right:0;
border:0;
padding:0;
overflow:visible;
/* background: #00D4FF; */
cursor:pointer
}

.faq .faqBody{
margin:0;padding:0
}

.faq .faqBody .article{
list-style:none;
margin-top: 50px;
}

.faq .q{
/* margin:10px 0; */
padding : 10px 450px;
background: #caf0f8;
}

.faq .q .a{display:block;text-align:left; 
    background:url("faq1_icon_q.png") no-repeat 0 0;
    padding:0 0 0 35px;
    font-size:18px;
    color:#5e5e5e;
    font-weight:bold;
    line-height: 27px;
    cursor:pointer;
    margin: 10px 0; !important
}
    
.faq .q a:hover, .faq .q a:active, .faq .q a:focus{}
.faq .a{background:#f8f8f8 url("faq1_icon_a.png") no-repeat 40px 10px;padding: 10px 75px 10px 75px;
    font-size: 16px;
    color: #444444;
    line-height: 22px;
    padding : 10px 450px;
    border-top: 1px solid #bdbdbd;
    /* margin:-10px 0 0 0; */
}
.q{
	max-width : 2000px;
	text-align : left;
	font-size: 25px;
}

.a{
	max-width : 2000px;
	text-align : left;
	font-size: 18px;
}

</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>

</head>
<body>
<h3>소소한 FAQ</h3>
<div class="faq">
    <div class="faqHeader">
    <!--button type="button" class="showAll">답변 모두 여닫기</button-->
    	<ul>
			<!-- 관리자로 로그인된 경우만 글쓰기 가능 -->
			<!-- 로그인 시 정보를 담고 있는 session.setAttribute("loginInfo", vo)을 통해 admin 값을 가져와 비교함. -->			
			<c:if test="${loginInfo.subcode eq '3  '}">
				<li><a class='btn-fill' href='new.no'>글쓰기</a></li>
			</c:if>
		</ul>
    </div>
    <div>
    	<ul class="faqBody">
    		<c:forEach items="${faq}" var="vo">
    			<li class="article" id="a1">
	            	<p class="q">
	            		<a href="#a1">${vo.faq_title }<i class="fas fa-angle-double-down"></i></a>
	            	</p>
	        	    <p class="a">${vo.faq_content }</p>
       	 		</li>
    		</c:forEach>
    	
        	<!-- <li class="article" id="a1">
            	<p class="q">
            		<a href="#a1">소소한 스토리지는 어떤 서비스를 제공하고 있나요?<i class="fas fa-angle-double-down"></i></a>
            	</p>
        	    <p class="a">차츰 차츰 알려드리도록 하겠습니다. ^^</p>
       	 	</li>
        	<li class="article" id="a2">
           		<p class="q">
           	 		<a href="#a2">bteam은 어떤 컨셉을 가지고 프로젝트를 진행 중인가요?<i class="fas fa-angle-double-down"></i></a></p>
        	    <p class="a">bteam은 특별한 기능보단 기본에 충실한 결과를 만들기 위해 노력 중입니다.</p>
       	 	</li>
        	<li class="article" id="a3">
            	<p class="q">
            		<a href="#a3">이제부터 시작입니다.<i class="fas fa-angle-double-down"></i></a></p>
            	<p class="a">늦었다고 생각하지 않습니다. 좋은 결과를 위해 우리 함께 합시다.</p>
        	</li> -->
    	</ul>
    </div>
</div>
<script>
jQuery(function($){
    // Frequently Asked Question
    var article = $('.faq>.faqBody>.article');
    article.addClass('hide');
    article.find('.a').hide();
    article.eq(0).removeClass('show');
    article.eq(0).find('.a').hide();
/*     article.eq(0).find('.a').show(); */
    $('.faq>.faqBody>.article>.q>a').click(function(){
        var myArticle = $(this).parents('.article:first');
        if(myArticle.hasClass('hide')){
            article.addClass('hide').removeClass('show');
            article.find('.a').slideUp(100);
            myArticle.removeClass('hide').addClass('show');
            myArticle.find('.a').slideDown(100);
        } else {
            myArticle.removeClass('show').addClass('hide');
            myArticle.find('.a').slideUp(100);
        }
        return false;
    });
    /* $('.faq>.faqHeader>.showAll').click(function(){
        var hidden = $('.faq>.faqBody>.article.hide').length;
        if(hidden > 0){
            article.removeClass('hide').addClass('show');
            article.find('.a').slideDown(100);
        } else {
            article.removeClass('show').addClass('hide');
            article.find('.a').slideUp(100);
        }
    }); */
});
</script>

</body>
</html>
