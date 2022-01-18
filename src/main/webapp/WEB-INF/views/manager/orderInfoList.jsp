<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>제품 내역</title>
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
	    <div class="col-md-12 ftco-animate text-center">	    	
	    	<p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>주문정보내역</span></p>
	     	<h1 class="mb-0 bread">주문정보내역</h1>      
	    </div>
	</div>
</section>
 <table>	         
	<tr style="background-color:#212529;color:white;">
	 	<th>주문번호</th>	             	
	 	<th>제품번호</th>	
	 	<th>제품이름</th>           	
	 	<th>브랜드</th>	             	
	 	<th>제품종류</th>	             	
	 	<th>주문날짜</th>	             	
	 	<th>주문수량</th>	             	
	 	<th>가격</th>	             	
	 	<th>이름</th>	             	
	 	<th>전화번호</th>	             	           	         		     
	</tr>
	<c:if test="">   
		<tr>
		 	<td colspan="12">등록된 제품이 없습니다.</td>	             	             	           		     
		</tr>
	</c:if>
	<c:forEach items="${listpagedto}" var="listpagedto">		       	  
		<tr>		       
			<th>${listpagedto.order_num}</th>	             	
		 	<th>${listpagedto.product_code}</th>
		 	<th>${listpagedto.product_name}</th>	             	
		 	<th>${listpagedto.brand_name}</th>	             	
		 	<th>${listpagedto.bag_type}</th>	             	
		 	<th>${listpagedto.regdate}</th>	             	
		 	<th>${listpagedto.quantity}</th>	             	
		 	<th>${listpagedto.totalPrice}</th>	             	
		 	<th>${listpagedto.username}</th>	             	
		 	<th>${listpagedto.phone}</th>      		           		     
		</tr>			    
	</c:forEach>             
</table>

<c:forEach begin="1" end="${endPage}" var="num">



  		
</c:forEach>








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




</script>


</html>