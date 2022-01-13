<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>채소</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script src="resources/js/jquery.twbsPagination.js"></script>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="resources/css/common.css"/>
<script src="resources/js/jquery.twbsPagination.js"></script>

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

<section class="ftco-section contact-section bg-light" style="text-align:center;">
	<h2 style="text-align: center;">${productList[0].brand_name }</h2>
		<select id="bagTypeList" style="margin-top: 50px; width: 200px; height: 35px; margin-right: 30px;">
			<c:forEach var="bagType" items="${bagTypeList }">
	         	<option value="${bagType.type_name }">${bagType.type_name }</option>			
			</c:forEach>
	   </select>
	   <input type="text" name="productName" id="productName" placeholder="상품명">
	   <button id="productSearchButton">검색</button>
</section>

<section id="searchProductList">
	<c:forEach var="productList" items="${productList }">
		<div id="productList" style="border: 1px solid red; width: 350px; height:450px; float: left; margin-left: 20px; margin-bottom: 20px;">
			<img src='resources/photo/${productList.newFileName }' style="width: 350px; height: 350px;"/>
			<p>${productList.product_name }</p>
			<p>${productList.price }</p>
		</div>
	</c:forEach>
</section>

<section id="searchProductList1">

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
	
	function productListCall(data) {
			console.log("productListCall 동작 확인");
		   var content = "";
		   for(var i = 0; i < data.length; i++){
		      content += '<div style="border: 1px solid red; width: 350px; height:450px; float: left; margin-left: 20px; margin-bottom: 20px;">';
		      content += '<img src="resources/photo/'+data[i].newFileName+'" style="width: 350px; height: 350px;"/>';
		      content += '<p>'+data[i].product_name+'</p>';
		      content += '<p>'+data[i].price+'</p>';
		      content += '</div>';
		   }
		   $("#searchProductList").append(content);
	}

	
	$("#productSearchButton").click(function () {
		$("#searchProductList").empty();
		console.log("productSearchButton 동작 확인");
		console.log($("#bagTypeList").val());
		console.log($("#productName").val());
		var bagType = $("#bagTypeList").val();
		var productName = $("#productName").val();
		$.ajax({
			type:'GET',
			url:'productSearch',
			data:{'bagType':bagType, 'productName':productName},
			dataType:'JSON',
			success:function(data){
				console.log(data);
				productListCall(data);
			},
			error:function(e){
				
			}
		})
	})
	
</script>
</html>























