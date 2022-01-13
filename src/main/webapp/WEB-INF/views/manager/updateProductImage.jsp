<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta charset="UTF-8">
<title>제품수정</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<!-- ckeditor -->
<script src="resources/ckeditor/ckeditor.js"></script>	

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
     <div class="col-md-12 ftco-animate text-center">
      <p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>제품수정</span></p>
      <h1 class="mb-0 bread">제품수정</h1>    
     </div>
  </div>
</section>


<section class="ftco-section ftco-degree-bg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 ftco-animate">		                 
		     <div class="">		        
		        <b><font size="3" color="BLACK">제품이미지수정</font></b>   
		        <br><br>		                       
		        <form method="post" action="doUpdateImage" name="updateForm" id="updateForm" enctype="multipart/form-data">					
					<div class="col-md-12 ftco-animate">
			     		<div class="cart-list">
			  				<table class="table">
			  			    <thead class="thead-primary">
			  			      <tr class="text-center">
			  			        <th>이미지명</th>
			  			        <th>&nbsp;</th>
			  			        <th>순서</th>
			  			        <th>삭제</th>
			  			      </tr>			  			     
			  			    </thead>
			  			    <tbody>
			  			      <c:if test="${fn:length(imageDto)==0}">
			  			      <tr class="text-center">
			  			        <td colspan="4">등록된 이미지가 없습니다.</td>  			        
			  			      </tr>
			  			      </c:if>
			  			      <c:forEach items="${imageDto}" var="imageList" varStatus="status">
			  			      	  <input type="hidden" id="newFileName" name="newFileName" value="${imageList.newFileName}">
				  			      <tr class="text-center">			  			      
				  			        <td class="product-name"><h3 id="imageName">${imageList.oriFileName}</h3></td>  
				  			        <td class="image-prod"><div class="img" id="image" style="background-image:url(resources/photo/${imageList.newFileName});"></div></td>	
				  			        <td class="price"><input type="text" id="photo_num" name="photo_num" value="${status.index + 1}" placeholder="순서를 입력해주세요"></td>				  			        		        
				  			        <td class="product-remove"><a onClick="delImage('${imageList.photo_num}')"><span class="ion-ios-close"></span></a></td>			  			       
				  			      </tr>
			  				  </c:forEach>	
			  			    </tbody>
			  			  </table>
			  		  </div>
			     	</div>
					<br>				
					<br><br>
					<div style="text-align:center;">
					<button type="button" class="btn btn-primary" onclick="location.href='./'">취소</button>
		       		<button type="button" class="btn btn-primary" onclick="check_input()">완료</button>			
					</div>
				</form>	        		      	
		    </div>   		       
      </div> <!-- .col-md-8 -->
    </div>
  </div>
</section>

<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
  <div class="container py-4">
    <div class="row d-flex justify-content-center py-5">    
    </div>
  </div>
</section>


<jsp:include page="/WEB-INF/views/include/footer.jsp"/>


</body>



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


<script>

CKEDITOR.replace("content");


function check_input() {
	 
 	
   
    
    document.updateForm.submit();
    // 모두 확인 후 submit()
 }
 
 

</script>
</html>