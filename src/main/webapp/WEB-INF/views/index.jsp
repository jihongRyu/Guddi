<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" href="resources/photo/로고2.png">
<title>GUddI Shop</title>
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

<body class="goto-here">
    
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

<section id="home-section" class="hero">
	  <div class="home-slider owl-carousel">
      <div class="slider-item" style="background-image: url(resources/images/bg_1.jpg);">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

            <div class="col-md-12 ftco-animate text-center">
              <h1 class="mb-2">We deliver Fresh Vegestables &amp; Fruits</h1>
              <h2 class="subheading mb-4">저희는 신선한 채소 &amp; 과일만을 배달합니다.</h2>
              <p><a href="#" class="btn btn-primary">상세보기</a></p>
            </div>

          </div>
        </div>
      </div>

      <div class="slider-item" style="background-image: url(resources/images/bg_2.jpg);">
      	<div class="overlay"></div>
        <div class="container">
          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

            <div class="col-sm-12 ftco-animate text-center">
              <h1 class="mb-2">We serve Fresh Vegestables &amp; Fruits</h1>
              <h2 class="subheading mb-4">저희는 신선한 채소 &amp; 과일만을 제공합니다.</h2>
              <p><a href="#" class="btn btn-primary">상세보기</a></p>
            </div>

          </div>
        </div>
      </div>
    </div>
</section>

<section class="ftco-section">
<div class="container">
	<div class="row no-gutters ftco-services text-center" >
      <div class="col-md-4 text-center align-self-stretch ftco-animate">
        <div class="media block-6 services mb-md-0 mb-4">
          <div class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
        		<span class="flaticon-shipped"></span>
          </div>
          <div class="media-body">
            <h3 class="heading">Free Shipping</h3>
            <span>한개만 구매하셔도, 모든 제품이 무료배송!</span>
          </div>
        </div>      
      </div>
      <div class="col-md-4 text-center align-self-stretch ftco-animate">
        <div class="media block-6 services mb-md-0 mb-4">
          <div class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
        		<span class="flaticon-award"></span>
          </div>
          <div class="media-body">
            <h3 class="heading">Superior Quality</h3>
            <span>구디숍은 품질을 꼼꼼히 관리합니다.</span>
          </div>
        </div>      
      </div>
      <div class="col-md-4 text-center align-self-stretch ftco-animate">
        <div class="media block-6 services mb-md-0 mb-4">
          <div class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
        		<span class="flaticon-customer-service"></span>
          </div>
          <div class="media-body">
            <h3 class="heading">Support</h3>
            <span>24시간 고객만족센터를 운영합니다</span>
          </div>
        </div>      
      </div>
    </div>
		</div>
	</section>

	<section class="ftco-section ftco-category ftco-no-pt">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-6 order-md-last align-items-stretch d-flex">
							<div class="category-wrap-2 ftco-animate img align-self-stretch d-flex" style="background-image: url(resources/images/category.jpg);">
								<div class="text text-center">
									<h2>GudeeShop</h2>
									<p>고객님들의 건강한 삶을 위해서</p>
									<p><a href="productPageList?type=1&num=1" class="btn btn-primary">구매하기</a></p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(resources/images/category-1.jpg);">
								<div class="text px-3 py-1">
									<h2 class="mb-0"><a href="javascript:void(0);">채소</a></h2>
								</div>
							</div>
							<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(resources/images/category-2.jpg);">
								<div class="text px-3 py-1">
									<h2 class="mb-0"><a href="javascript:void(0);">과일</a></h2>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="category-wrap ftco-animate img mb-4 d-flex align-items-end" style="background-image: url(resources/images/category-3.jpg);">
						<div class="text px-3 py-1">
							<h2 class="mb-0"><a href="javascript:void(0);">영양주스</a></h2>
						</div>		
					</div>
					<div class="category-wrap ftco-animate img d-flex align-items-end" style="background-image: url(resources/images/category-4.jpg);">
						<div class="text px-3 py-1">
							<h2 class="mb-0"><a href="javascript:void(0);">건조식품</a></h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>




<jsp:include page="/WEB-INF/views/include/footer.jsp"/>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

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
  
  
<script type="text/javascript"></script>
  
  
</html>