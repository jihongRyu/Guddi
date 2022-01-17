<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<meta charset="UTF-8">
	<title>GUDDI</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<link rel="icon" type="image/png" href="resources/photo/로고2.png">

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



<style>
	.product-quantity{
		text-align: center;
	}
</style>

</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

<section>
<c:forEach items="${productimage}" var="productimage">
	<img src="resources/photo/${productimage.newFileName}" width="250px"/>
</c:forEach>
</section>

<section>
<form action="cartupdate" method="post" class="formcart">
<input type="hidden" name="userId" Id="userId" class="userId" value="${SessionScope.userId}"/>
<input type="hidden" class="brand_name" value="${detail[0].brand_name}"/>
<input type="hidden" class="product_name" value="${detail[0].product_name}"/>
<input type="hidden" class="product_code" value="${detail[0].product_code}"/>
<input type="hidden" class="price" value="${detail[0].price}"/>


<h3 class="brand_name">${detail[0].brand_name}</h3>
<div class="product_name">${detail[0].product_name}</div>
<div class="product_code">${detail[0].product_code}</div>
<div class="price">${detail[0].price}원</div>
<div class="product_content">${detail[0].product_content}</div>

<div>
	<button class="btn-minus" data-type="minus" data-field=""></button>
	<input class="product-quantity" type="number" value="1" min="1" max="100"/>
	<button class="btn-plus" data-type="plus" data-field=""></button>
</div>

<br/>

<input type="button" class="cart-btn" value="장바구니"/>
</form>
</section>
	<div class="reviewupdateForm">
		<div>제목<input type="text" class="reviewsubject"></div>
		<div>내용<input type="text" class="reviewcontent"></div>
		<input type="button" class="reviewupdatebutton"value="저장">
	</div> 
	<c:if test="${reviewlist eq null||size == 0 }">
		<div>등록된 글이 없습니다.</div>
	</c:if>
	<c:forEach items="${reviewlist}" var="review">
		<div>${review.userId}</div>
		<div>${review.regdate}</div>
		<div>${review.subject}</div>
		<div>${review.content}</div>
		<input type="button" class="reviewdelete" value="삭제">
	</c:forEach>

<section>
</section>



<jsp:include page="/WEB-INF/views/include/footer.jsp"/>


</body>

<script>



$(".btn-minus").click(function(){
	var num = $(".product-quantity").val();
	if (num==1) {
		alert("1개이상부터 구매 가능합니다.");
		
	}
	num--;
});
$(".btn-plus").click(function(){
	var num = $(".product-quantity").val();
	
	num++;
});

$(".cart-btn").click(function(){
		
		if(confirm("제품을 카트에 담으시겠습니까?")){
			var userId = $(".userId").val();
			var product_name = $(".product_name").val();
			var product_code = $(".product_code").val();
			var quantity = $(".product-quantity").val();
			var price = $(".price").val();
			
			console.log(userId,product_name,product_code,price,quantity);
			$.ajax({
				url:"doCartUpdate",
				data:{
					'userId':userId,
					'product_name':product_name,
					'product_code':product_code,
					'price':price,
					'quantity':quantity
				},
				method: "POST",
				dataType: "JSON",
				success: function(data){
					console.log(data);
					if (data.result>0) {

					}
				
				},
				error:function(e){
					console.log("장바구니 실패");
				}
			});
		}	
});
</script>
</html>