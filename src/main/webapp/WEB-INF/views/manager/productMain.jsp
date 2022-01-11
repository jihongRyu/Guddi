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
	    	<p class="breadcrumbs"><span class="mr-2"><a href="./">홈</a></span>/<span>관리메인페이지</span></p>
	     	<h1 class="mb-0 bread">관리메인페이지</h1>      
	    </div>
	</div>
</section>


<section class="ftco-section">
  <div class="container"> 
      <div class="form-group text-center">      	
	     	
	  </div>	 
  </div>
  <div class="col-lg-10 ftco-animate myPage-table table-striped">
  	      	
	  <form name = "mform" id = "mform" method="post">	                
	      <div>		        
	        <h3>제품 내역</h3>
	        <br><br>		                       
	        <table>
	          <colgroup>
 			    <col width="7%" />			   
			    <col width="15%"/>
			    <col width="15%"/>
			    <col width="23%"/>
			    <col width="20%"/>
			    <col width="10%"/>
			    <col width="10%"/>
			  </colgroup>
	             <tr>
	             	<th>번호</th>	             	
	             	<th>브랜드</th>
	             	<th>종류</th>
	             	<th>제품명</th>
	             	<th>제품번호</th>
	             	<th>수정하기</th>
	             	<th>삭제하기</th>	             	           		     
	            </tr>
	             <tr>
	             	<td colspan="7">등록된 제품이 없습니다.</td>	             	             	           		     
	            </tr>         
	        </table>			
	    </div>
 	</form>
 	
 	<div class="row mt-5">
        <div class="col text-center">
          <div class="block-27">
            <ul>
              <li><a href="#">&lt;</a></li>
              <li class="active"><span>1</span></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li><a href="#">&gt;</a></li>
            </ul>
          </div>
        </div>
      </div>    
      <br>
      <input type="button" value="제품등록하기" class="btn btn-primary py-3 px-5" onclick="location.href='registProduct'">	 
           
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