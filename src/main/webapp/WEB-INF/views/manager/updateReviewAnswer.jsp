<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta charset="UTF-8">
<title>Q&A상세</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script src="resources/css/bootstrap/bootstrap.min.js"></script>

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
    <div class="row block-9">
      <div class="login-form col-md-8 d-flex">
        <div class="bg-white p-5 contact-form">
	          <div class="login-heading">
		      	<span>리뷰상세</span>	                      
		      </div>	        
	          <div class="col-lg-12 pl-md-5 ftco-animate">
				 <h5>제품명</h5>	
				 <p>${product_name}</p>				 		
				 <h5>아이디</h5>	
				 <p>${review.userId }</p>	
				  <h5>제목</h5>	
				 <p>${review.subject }</p>					
				 <h5>내용</h5>
				 <p>${review.content }</p> 
				 <p style="float:right;">${review.regdate }</p>
			  </div>			 
			  <br><br>			 
	          
	          <div class="form-group text-center">
	            <form action="doUpdateReviewAnswer" id="doAnswer" name="doAnswer" method="post">
	              <input type="hidden" id="idx" name="idx" value="${review.idx}">
	          	  <input type="hidden" id="a_idx" name="a_idx" value="${answer.idx}">
	          	  <input type="hidden" id="product_name" name="product_name" value="${product_name}">
		          <div class="bg-light p-5 contact-form">
			          <div class="col-lg-12 pl-md-5 ftco-animate ">							 				
						 <h5>답변수정</h5>
						 <textarea class="form-textArea" rows="5" id="answer" name="answer">${answer.content}</textarea>						
					  </div>			 
					  <br><br>	
			          <div class="form-group text-center">
			            <input type="button" value="뒤로가기" class="btn btn-primary" onclick="location.href='toReviewPage?num=1&answer_flg=2'">
			            <input type="button" value="답변수정" class="btn btn-primary" onclick="doAnswerRegist()">        
			          </div>
		           </div>
	             </form>
	          </div>	         
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

function doAnswerRegist(){
	
	if (confirm('해당 답변을 수정하시겠습니까?')) {
		$('#doAnswer').submit();
	}
}



</script>


</html>

