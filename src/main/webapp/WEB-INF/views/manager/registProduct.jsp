<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록</title>
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
      <p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>제품등록</span></p>
      <h1 class="mb-0 bread">제품등록</h1>    
     </div>
  </div>
</section>


<section class="ftco-section ftco-degree-bg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12 ftco-animate">		                 
		      <div class="">		        
		        <b><font size="3" color="BLACK">제품등록</font></b>   
		        <br><br>		                       
		        <form method="post" action="doRegistProduct" name="registForm" id="registForm" enctype="multipart/form-data">
					<label>제품명</label><br/>
					<input class="form-control" type="text" name="subject" id="subject" placeholder="제품을 입력해주세요."/><br/>
					
					<label>브랜드</label><br/>
					<select name="brand_type" id="brand_type" class="form-control" >
						<option value="0" >브랜드를 선택해주세요.</option>
				   		  <c:forEach items="${sessionScope.brandcategory}" var="list">
				   		  	<c:if test="${list.brand_idx ne 0}">
								<option value="${list.brand_idx }" >${list.brand_name }</option>
							</c:if>
						  </c:forEach>
			   		</select><br/>					
					
					<label>종류</label><br/>
					<select name="bag_type" id="bag_type" class="form-control" >
						<option value="" >제품타입을 선택해주세요.</option>
				   		<c:forEach items="${sessionScope.bagtype}" var="list">
				   		  	<c:if test="${list.type_idx ne 0}">
								<option value="${list.type_idx }" >${list.type_name }</option>
							</c:if>
						</c:forEach>
			   		</select><br/>
			   		
			   		<label>신상품 체크</label><br/>
					<select name="new_flg" id="new_flg" class="form-control" >
						<option value="" >신상품여부를 선택하세요.</option>	
						<c:forEach items="${sessionScope.newflg}" var="list">
							<option value="${list.idx}" >${list.newname}</option>
						</c:forEach>			   					   	
			   		</select><br/>
		
					<label>판매여부</label><br/>
					<select name="sell_flg" id="sell_flg" class="form-control" >
						<option value="" >판매여부를 선택하세요.</option>
						<c:forEach items="${sessionScope.sellflg}" var="list">				   		  
							<option value="${list.idx }" >${list.sellname}</option>
						</c:forEach>				   	
			   		</select><br/>
			   		
					<label>가격 : 단위 원, 원제외 등록</label><br/>
					<input type="text" class="form-control" name="price" id="price" placeholder="정가를 입력해주세요."/><br/>
										
					<label>제품번호</label>
					<button type="button" class="btn btn-primary" onclick="makeProductNum()">제품번호발행</button>					
					<br/>
					<input type="text" class="form-control" name="product_num" id="product_num" readonly placeholder="상품번호를 생성해주세요."/><br/>
						
					<label>제품 상세설명</label><br/>
					<textarea class="form-control" name="content" id="content" rows="10" placeholder="상세설명을 입력해주세요."></textarea><br/>
					
					<label>이미지 등록</label>
					<input class="form-control" type="file" name="files" id="files" style="border:none;"  multiple="multiple"/>	
					
					
					<br><br>
					<div style="text-align:center;">
					<button type="button" class="btn btn-primary" onclick="location.href='./'">취소</button>
		       		<button type="button" class="btn btn-primary" onclick="check_input()">등록</button>			
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

//상품번호 생성 함수
function makeProductNum(){
	
	if ($("#brand_type").val()=='0') {
		alert("브랜드를 선택해주세요");
		return;
	}
	
	if ($("#product_type").val()=='0') {
		alert("제품타입을 선택해주세요");
		return;
	}
	
	if (confirm("상품번호를 생성하시겠습니까?")) {

		$.ajax({
			url: "makeProductNum", //호출할 파일명			
			method: "POST",
			dataType: "json", //내가 받아야할 결과 형태가 text, html, xml, json
			
			success: function(data){
				console.log(data);
				
				if(data.result!=null) {
					let today = new Date();  
					let brandType;
					let productType;
					
					if ($("#product_type").val()=='크로스백') {
						productType = 'PC';
					}else if ($("#product_type").val()=='백팩') {
						productType = 'PB';
					}else if ($("#product_type").val()=='핸드백') {
						productType = 'PH';
					}else if ($("#product_type").val()=='토트백') {
						productType = 'PT';
					}else if ($("#product_type").val()=='숄더백') {
						productType = 'PS';
					}else if ($("#product_type").val()=='기타') {
						productType = 'PE';
					}
					
					if ($("#brand_type").val()=='샤넬') {
						brandType = 'S';
					}else if ($("#brand_type").val()=='루이비통') {
						brandType = 'L';
					}else if ($("#brand_type").val()=='에르메스') {
						brandType = 'H';
					}else if ($("#brand_type").val()=='보테가베네타') {
						brandType = 'B';
					}else if ($("#brand_type").val()=='기타') {
						brandType = 'E';
					}					
					
					var idx = data.result;
					var month = today.getMonth() + 1;  // 월
					var date = today.getDate();  // 날짜					
					
					var product_num = brandType + productType + month + date + idx;							
					
					$("#product_num").val(product_num);				
					
					alert("상품번호 생성 성공!");
					
				} 	
				
			},
			error:function(){
				alert("상품번호 생성실패! 관리자에게 문의해주세요.");
			}
		});
		
	}
	
}

function check_input() {
	 
 	
    if (!document.registForm.subject.value){// login_form 이름을 가진 form 안의 id_val 의 value가 없으면
        alert("상품명 입력하세요!");
        document.registForm.subject.focus();
        // 화면 커서 이동
        return;
    }  	
    if (document.registForm.product_type.value=='0'){
        alert("상품타입을 선택하세요!");
        // 화면 커서 이동
        return;
    } 
    if (!document.registForm.unit.value){
        alert("상품단위를 입력해주세요!");
        // 화면 커서 이동
        return;
    }
    if (!document.registForm.price.value){
        alert("정가를 입력하세요!");
        // 화면 커서 이동
        return;
    }   
    if (!document.registForm.salePrice.value){
        alert("할인가를 입력하세요!");
        // 화면 커서 이동
        return;
    }
    if (!document.registForm.product_num.value){
        alert("상품코드를 만들어주세요!");
        // 화면 커서 이동
        return;
    }
    
    document.registForm.submit();
    // 모두 확인 후 submit()
 }

</script>
</html>