<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>신상여부 카테고리 제어</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">    
<link rel="stylesheet" href="resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<link rel="stylesheet" href="resources/css/aos.css">
<link rel="stylesheet" href="resources/css/ionicons.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="resources/css/jquery.timepicker.css">    
<link rel="stylesheet" href="resources/css/flaticon.css">
<link rel="stylesheet" href="resources/css/icomoon.css">
<link rel="stylesheet" href="resources/css/style.css">

</head>
<body>

<jsp:include page="/WEB-INF/views/include/header.jsp"/>

<section class="ftco-section contact-section bg-light">
	<div class="container">    
	      <div class="col-md-12 ftco-animate text-center bg-light">
	      	<p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>사용여부카테고리관리</span></p>
	        <h1 class="mb-0 bread">사용여부카테고리관리</h1>
	      </div>    
	</div>
</section>

<section class="ftco-section ftco-degree-bg" id="qnaList">
  <div class="container" >
    <div class="row">      
      <div class="col-lg-12 ftco-animate" >    
		 <div class="myPage-table table-striped" >		 
		   <button class="btn btn-primary mb-4" style="float:right;" onclick="registQna()">추가하기</button>		  
		   <table>
		        <tr style="background-color:#212529;color:white;">
		        	<th>번호</th>
		        	<th>사용여부 (1:사용, 0:미사용)</th>
		        	<th>사용명</th>
		        	<th>등록일</th>
		        	<th>미사용처리</th>		
		        	<th>사용처리</th>      	           		     
		       </tr>
		       <c:if test="${newFlgList.size() == 0 }">           
		       <tr>
		        	<td colspan="6">해당하는 신상flg가 없습니다.</td>		             	             	           		     
		       </tr>
		       </c:if>
		       <c:forEach items="${newFlgList}" var="list">		       	  
			       <tr>		       
			        	<th>${list.idx}</th>
			        	<th>${list.use_flg}</th>
			        	<th>${list.newname}</th>
			        	<th>${list.regdate}</th>	
			        	<th>미사용처리</th>
			        	<th>사용처리</th>	             		           		     
			       </tr>			    
		       </c:forEach>      
		   </table>    	   				
		 </div>   		     
      </div>
	</div>
  </div>
</section>


<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery-migrate-3.0.1.min.js"></script>
<script src="resources/js/popper.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.easing.1.3.js"></script>
<script src="resources/js/jquery.waypoints.min.js"></script>
<script src="resources/js/jquery.stellar.min.js"></script>
<script src="resources/js/owl.carousel.min.js"></script>
<script src="resources/js/jquery.magnific-popup.min.js"></script>
<script src="resources/js/aos.js"></script>
<script src="resources/js/jquery.animateNumber.min.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
<script src="resources/js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="resources/js/google-map.js"></script>
<script src="resources/js/main.js"></script>

</body>
<script>


var msg = "${msg}";

if(msg != ""){
	alert(msg);
}	


function delReview(idx) {
	
	if (confirm("해당 리뷰를 삭제하시겠습니까?")) {
		location.href='delReview?idx='+idx;
	}
	
};

function changeQnAListByCategory(qnaType){	
	
	var qnaType = qnaType;
	var answer_flg = '${qnaAnswer_flg}';
	var keyword = '${qnaKeyword}';
	
	location.href="qnaPage?qnaNum=1&answer_flg="+answer_flg+"&qnaType="+qnaType+"&keyword="+keyword+"#qnaList";	
	
};


function changeQnAListByFlg(answer_flg){	
	
	var qnaType = '${qnaType}';
	var answer_flg = answer_flg;
	var keyword = '${qnaKeyword}';
	
	location.href="qnaPage?qnaNum=1&answer_flg="+answer_flg+"&qnaType="+qnaType+"&keyword="+keyword+"#qnaList";	
	
};


function changeQnAListById(){
	
	var qnaType = '${qnaType}';
	var answer_flg = '${qnaAnswer_flg}';
	var keyword = $('#keyword').val();	
	
	location.href="qnaPage?qnaNum=1&answer_flg="+answer_flg+"&qnaType="+qnaType+"&keyword="+keyword+"#qnaList";	
	
};

function registQna(){	
	
	if (confirm("Q&A를 작성하시겠습니까?")) {
		
		location.href="registQna";
		
	}
	
	
};

function toDetail(idx, writer) {
	
	var userId = "${sessionScope.userId}";		
	var mem_flg = "${sessionScope.mem_flg}";

	
	if (userId!=writer) {	
		if (mem_flg==1) {
			alert("타인의 문의내용을 볼 수 없습니다!");
			return;
		}				
	}
	
	location.href="qnaDetail?idx="+idx;
	
}






</script>
</html>