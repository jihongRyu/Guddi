<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>


 
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"rel="stylesheet">
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

	<jsp:include page="/WEB-INF/views/include/header.jsp" />

	<section class="ftco-section contact-section bg-light">
		<div class="container">
			<div class="col-md-12 ftco-animate text-center bg-light">
				<h1 class="mb-0 bread">주문하기</h1>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-degree-bg" id="qnaList">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 ftco-animate">
					<div class="myPage-table table-striped">
						<table>
							<tr style="background-color: #212529; color: white;">
								<th>제품 이미지</th>
								<th>제품명</th>
								<th>가격</th>
								<th>수량</th>
								<th>총가격</th>
							</tr>
							<c:forEach items="${orderList}" var="orderInfo">
								<tr>
									<th><img src='resources/photo/${orderInfo.newFileName }'style="width: 350px; height: 350px;" /></th>
									<th>${orderInfo.product_name}</th>
									<th>${orderInfo.price }</th>
									<th>${orderInfo.quantity }</th>
									<th class="totalPrice">${orderInfo.price *orderInfo.quantity }</th>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="col-lg-6" style="border: 1px solid black; margin-top: 70px;  float: left;">
						<h2>결제 하기</h2>
						<div class="form-group" style="text-align: left;">
							<label for="inputtelNO">성함</label>
							<input type="text"value="${orderList[0].username }" readonly class="form-control"id="userName" name="userName"> <br>
							<div class="form-group" style="text-align: left;">
								<label for="inputtelNO">우편번호</label>
								<input type="text"value="${orderList[0].zipcode }" readonly class="form-control"id="inputZipcode" name="zipcode" placeholder="우편번호 찾기를 해주세요.">
							</div>
							<div class="form-group" style="text-align: left;">
								<label for="inputtelNO">주소</label>
								<input type="text"value="${orderList[0].address }" class="form-control" readonly id="inputAddress" name="address" placeholder="주소를 입력해 주세요">
							</div>
							<div class="form-group" style="text-align: left;">
								<label for="inputtelNO">상세 주소</label>
								<input type="text"value="${orderList[0].address_detail }" class="form-control"id="inputAddress_detail" name="address_detail"placeholder="상세주소를 입력해 주세요">
							</div>
							<div class="form-group" style="text-align: left;">
								<label for="InputEmail">이메일 주소</label>
								<input type="email"value="${orderList[0].email }" class="form-control"id="inputEmail" name="email" placeholder="이메일 주소를 입력해주세요">
							</div>
							<div class="form-group" style="text-align: left;">
								<label for="inputMobile">휴대폰번호</label>
								<input type="tel"value="${orderList[0].phone }" class="form-control"id="inputMobile" name="phone" placeholder="ex)01012345678">
							</div>
						</div>
						<div class="text-center">
							<input type="button" id="btnZipcode"class="btn btn-primary py-3 px-5" onclick="goPostcode()"value="우편번호 검색" />
						</div>
					</div>
					<div class="col-lg-5" style="border: 1px solid red; height: 700px; width: 500px; margin-left: 645px; margin-top: 70px;">
						<h2>카트</h2>
						<div class="form-group" style="text-align: left;">
								<label for="inputMobile">가격</label>
								<input type="tel"value="${orderList[0].phone }" class="form-control"id="inputMobile" name="phone" placeholder="ex)01012345678">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="/WEB-INF/views/include/footer.jsp" />

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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="resources/js/google-map.js"></script>
	<script src="resources/js/main.js"></script>

	<!-- 우편번호 찾기 라이브러리 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

</body>
<script>
	
	//우편번호 찾기
	function goPostcode() {
		console.log("우편번호 검색");
		$("#inputAddress_detail").val(null);
		$("#inputAddress").val(null);
		$("#inputZipcode").val(null);

		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

				// 각 주소의 노출 규칙에 따라 주소를 조합한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				if (data.userSelectedType === 'R') {
					// 법정동명이 있을 경우 추가한다. (법정리는 제외)
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					// 건물명이 있고, 공동주택일 경우 추가한다.
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', '
								+ data.buildingName : data.buildingName);
					}
					// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					if (extraAddr !== '') {
						extraAddr = ' (' + extraAddr + ')';
					}
					// 조합된 참고항목을 해당 필드에 넣는다.
					document.getElementById("inputAddress").value = extraAddr;

				} else {
					document.getElementById("inputAddress").value = '';
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('inputZipcode').value = data.zonecode;
				document.getElementById("inputAddress").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				document.getElementById("inputAddress_detail").focus();
			}
		}).open();
	};
</script>
</html>







































































