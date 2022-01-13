<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<title>채소</title>
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
	    	<p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>${type }</span></p>
	     	<h1 class="mb-0 bread">${type }</h1>
	      	<p class="breadcrumbs"><span>건강한 ${type } 상품을 마련했습니다.</span></p>
	    </div>
	</div>
</section>


<section class="ftco-section">
  <div class="container">
        
        <div class="row mb-5 text-center search-form">
		   <div class="col-md-4">
		     <div class="mb-4">
		       <select name="brandType" class="form-control">
		       		<option value="전체">전체</option>
					<option value="샤넬">샤넬</option>
					<option value="루이비통">루이비통</option>
					<option value="보테가">보테가</option>
			   </select>		
		     </div>
		   </div>
		   <div class="col-md-4">
		      <div class=" mb-4">
		    	<select name="productType" class="form-control">
		    		<option value="전체" <c:if test="${page.searchType eq 'subject'}">selected</c:if>>전체</option>
					<option value="백팩" <c:if test="${page.searchType eq 'subject'}">selected</c:if>>백팩</option>
					<option value="토트백" <c:if test="${page.searchType eq 'content'}">selected</c:if>>토트백</option>
					<option value="크로스백" <c:if test="${page.searchType eq 'subject_content'}">selected</c:if>>크로스백</option>
				</select>		
		     </div>
		   </div>
		   <div class="col-md-4">
		     <div class="mb-4">
		     	<div class="form-group">                
		             <a href="javascript:void(0);" id="searchBtn"><span class="icon ion-ios-search"></span></a>
		             <input type="text" class="form-control" id="keyword" name="keyword" placeholder="상품명을 입력해주세요">
		         </div>		
		   	</div>
		   </div>
		</div>  
        
		<div class="row" >			
		<c:forEach items="${list}" var="list">
		   <div class="col-md-6 col-lg-3 ftco-animate">
				<div class="product">					
					<a href="detail?idx=${list.idx}" class="img-prod"><img class="img-fluid" src="resources/photo/${list.newFileName}" alt="Colorlib Template">

					</a>
					<div class="text py-3 pb-4 px-3 text-center">
						<h3><a href="prudoutDtail?idx=${list.idx}">${list.subject}</a></h3>
						<div class="d-flex">
							<div class="pricing">
	    						<p class="price"><span class="mr-2 price-dc">${list.price}원</span><span class="price-sale">${list.salePrice}원</span></p>
	    					</div>
    					</div>
    					<div class="bottom-area d-flex px-3">
    						<div class="m-auto d-flex">    							
    							 							
							</div>
						</div>
					</div>
				</div>
			</div>	
		</c:forEach>								
	  </div>
	  <br>
	  <div class="row mt-5">
		  <div class="col text-center">
			<div class="block-27">
			   <ul>
			      <c:if test="${page.prev}">
			      <li><a href="productPageList?type=${type_num }&num=${page.startPageNum - 1}${page.searchTypeKeyword}">&lt;</a></li>
			      </c:if>
			      <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
			      <c:if test="${select == num}">
			      <li class="active"><span>${num}</span></li>
			      </c:if>
			      <c:if test="${select != num}">
			      <li><a href="productPageList?type=${type_num }&num=${num}${page.searchTypeKeyword}">${num}</a></li>			     
			      </c:if>    		
			      </c:forEach>
			      <c:if test="${page.next}">
			      <li><a href="productPageList?type=${type_num }&num=${page.endPageNum + 1}${page.searchTypeKeyword}">&gt;</a></li>
			      </c:if>
			   </ul>
			 </div>
		  </div>
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
	
	function enterkey() {	
	    if (window.event.keyCode == 13) {
	         // 엔터키가 눌렸을 때 실행할 내용
	         DoSearch();
	    }
	}
	
	function DoSearch() {
	    
		  let searchType = document.getElementsByName("searchType")[0].value;
		  let keyword =  document.getElementsByName("keyword")[0].value;
		  let type =  "${type_num}";  
		  
		  console.log(searchType);
		  console.log(keyword);	  
		  location.href = "productPageList?type="+ type + "&num=1" + "&searchType=" + searchType + "&keyword=" + keyword;
	
	};
	
	
</script>
</html>