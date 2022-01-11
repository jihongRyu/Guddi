<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta charset="UTF-8">
<title>카트</title>
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

<div class="hero-wrap hero-bread" style="background-image: url('resources/images/bg_1.jpg');">
  <div class="container">
    <div class="row no-gutters slider-text align-items-center justify-content-center">
      <div class="col-md-9 ftco-animate text-center">
      	<p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>카트</span></p>
        <h1 class="mb-0 bread">장바구니</h1>
      </div>
    </div>
  </div>
</div>

<!-- 로그인 userCart-->

<c:if test="${sessionScope.userId eq null}">
	<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
		<div class="container py-4">
	        <div class="row d-flex justify-content-center py-5">
	          <div class="row justify-content-end">     
     			<div class="col-lg-12 mt-5 cart-wrap ftco-animate">     	
     				<div class="text-center">
     					<h1>로그인을 해주세요.</h1><br><br>
     					<a href="login" class="btn btn-primary py-3 px-4">로그인</a>
     				</div>
     			</div>
    		  </div>
	        </div>
		</div>
	</section>
</c:if>

<c:if test="${sessionScope.userId ne null}">
<section class="ftco-section ftco-cart">
  <div class="container">
  	<div class="row">
     	<div class="col-md-12 ftco-animate">
     		<div class="cart-list">
  				<table class="table">
  			    <thead class="thead-primary">
  			    
  			      <tr class="text-center">
  			        <th>삭제</th>
  			        <th>이미지</th>
  			        <th>제품명</th>
  			        <th>수량</th>
  			        <th>제품가격</th>
  			        <!-- <th>총 가격</th> -->
  			      </tr>
  			     
  			    </thead>
  			    <tbody>
  			      <c:if test="${fn:length(list)==0}">
  			      <tr class="text-center">
  			        <td colspan="6">장바구니에 담긴 제품이 없습니다.</td>  			        
  			      </tr>
  			      </c:if>
  			      
  			      
  			      <c:forEach items="${list}" var="list" varStatus="status">
  			      <tr class="text-center">
  			        <%-- <td class="product-remove"><a onClick="delCart('${list.u_idx}')"><span class="ion-ios-close"></span></a></td>
  			         --%>
  			        <td class="image-prod"><div class="img" style="background-image:url(resources/photo/${list.newFileName});"></div></td>
  			        
  			        <td class="product-name">
  			        	<h3>${list.product_name}</h3>
  			        	<p>상품코드 : ${list.product_code}</p>
  			        </td>
  			        
  			        <td class="price">${list.price}</td>
  			        
  			        <td class="quantity">
  			        
  			        	<div class="input-group mb-3">
  			        	<span class="input-group-btn mr-2">
				             <button type="button" class="quantity-left-minus btn" onClick="minus(${status.index},${list.price})" data-field="">
				                <i class="ion-ios-remove"></i>
				             </button>
				         </span>
  		             	<input type="text" name="quantity${status.index}" id="quantity${status.index}"class="form-control input-number" 
  		             		value="${list.quantity }" min="1" max="100" >
  		          		<span class="input-group-btn ml-2">
				             <button type="button" class="quantity-right-plus btn" onClick="plus(${status.index},${list.price})" data-field="">
				                 <i class="ion-ios-add"></i>
				              </button>
				          </span>
  		          		</div>
  		          	</td>
  			        
  			        <td class="total"><span id="price${status.index}">${list.quantity*list.price }</span> 원</td>
  			        <c:set var= "total" value="${total + list.quantity*list.price}"/>
  			      </tr>
  				  </c:forEach>
  			    
  			    
  			    
  			    
  			    
  			    </tbody>
  			  </table>
  		  </div>
     	</div>
     </div>
     <div class="row justify-content-end">
     	<c:if test="${fn:length(list)>0}"> 			      
     	<div class="col-lg-12 mt-5 cart-wrap ftco-animate">
     		<div class="cart-total mb-3">
     			<h3></h3>
     			<p class="d-flex">
     				<span>구매가격</span>     				
					<span id="totalPrice1">${total}</span>원
     			</p>
     			<p class="d-flex">
     				<span>배송료</span>
     				<span>언제나 0원!</span>
     			</p>     			
     			<hr>
     			<p class="d-flex total-price">
     				<span>최종구매가격</span>
     				<span id="totalPrice2">${total}</span>원
     			</p>
     		</div>
     		<div class="text-center">
     		<form action="checkout" method="post" id="toCheckout" name="toCheckout">
     		<input type="hidden" value="${total}" name="checkoutPrice" id="checkoutPrice">
     		<input type="hidden" value="${sessionScope.userId}" name="userId" id="userId">
     		<a href="./" class="btn btn-primary py-3 px-4">계속쇼핑하기</a>     		     		
     		<a href="#" id="toCheckoutButton" class="btn btn-primary py-3 px-4">구매하기</a>
     		</form>
     		</div>
     	</div>
     	</c:if> 
     	<div class="text-center col-lg-12 ftco-animate">
	  		<c:if test="${fn:length(list)==0}"><br>
	     		<a href="./" class="btn btn-primary py-3 px-4">돌아가기</a>  
	     	</c:if>
     	</div> 
     </div>
  </div>
</section>
</c:if>


<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
	<div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
          
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

$("#toCheckoutButton").click(function(){
	
	if (confirm("결제화면으로 넘어가시겠습니까?")) {
		
		document.toCheckout.submit();
		
	}
});

function minus(index, price){
	
	var num = $("#quantity"+index).val();
	var totalPrice = $("#totalPrice1").html();
	
	var totalPriceMinusChangedPrice = totalPrice-(price*num);	
	num--;
	var newTotalPrice = totalPriceMinusChangedPrice + (num*price);
	
	if (num<1) {
		alert("최소 구매수량은 1개입니다!");
	}else{
		$("#quantity"+index).val(num);
		$("#price"+index).html(num*price);
		$("#totalPrice1").html(newTotalPrice);
		$("#totalPrice2").html(newTotalPrice);
		$("#checkoutPrice").val(newTotalPrice);
	}
	
	
}

function plus(index, price){	
	
	var num= $("#quantity"+index).val();
	var totalPrice = $("#totalPrice1").html();	
	
	var totalPriceMinusChangedPrice = totalPrice-(price*num);	
	num++;
	var newTotalPrice = totalPriceMinusChangedPrice + (num*price);
	
	$("#quantity"+index).val(num);
	$("#price"+index).html(num*price);
	$("#totalPrice1").html(newTotalPrice);
	$("#totalPrice2").html(newTotalPrice);
	$("#checkoutPrice").val(newTotalPrice);
	
}

function delCart(product_num){
	
	if (confirm("해당 제품을 카트에서 제외하시겠습니까?")) {
		
		var product_num = product_num;
		
		$.ajax({
			url: "delCart", //호출할 파일명			
			method: "POST",
			dataType: "json", //내가 받아야할 결과 형태가 text, html, xml, json
			data : {"product_num":product_num},
			success: function(data){
				console.log(data);
				
				if(data.result>0) {
				
					alert("상품을 제외하였습니다.");
					location.href = "cart";
				} else {
					alert("삭제를 실패하였습니다. 관리자에게 문의해주세요.");
				}
				
			},
			error:function(){
				alert("상품번호 생성실패! 관리자에게 문의해주세요.");
			}
		});
		
	}
	
}

</script>
</html>