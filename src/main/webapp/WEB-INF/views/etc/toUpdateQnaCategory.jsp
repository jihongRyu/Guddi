<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A</title>
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
	<input class="form-control" type="hidden" style="width: 300px; margin-right: 50px;"name="userIdx" value="${userIdx}"/>
	<div class="container">    
	      <div class="col-md-12 ftco-animate text-center bg-light">
	      	<h3>문의 카테고리</h3>
	      </div>    
	</div>
</section>


<section class="ftco-section">
   <div class="container" style="margin-bottom: -100px;">
      <input class="form-control" type="text" style=" float:left; width: 300px; margin-right: 50px;"name="keyword" placeholder="카테고리명을 입력해주세요.">
      <input type="button"value="카테고리 추가하기" class="btn btn-primary py-3 px-4" id="addQna" style="height: 50px; margin-left: -40px;"/>
   </div>
</section>


<section class="ftco-section ftco-degree-bg" id="qnaList" style="margin-top: -40px;">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 ftco-animate">
				<div class="myPage-table table-striped">
					<table>
						<tr style="background-color: #212529; color: white;">
							<th>카테고리 번호</th>
							<th>카테고리명</th>
							<th>사용여부</th>
						</tr>
						<c:forEach items="${qnaList}" var="qnaList">
						<tr class="qnaTr">
							<td>${qnaList.idx}</td>
							<td>${qnaList.typename }</td>
							<td>
								<c:if test="${qnaList.use_flg eq 1}">
								<select class="form-control" style="text-align: center;" onchange="updateUseFlg('${qnaList.typename }')">
									<option value="${qnaList.use_flg }">사용</option>
									<option value="0">미사용</option>
								</select>								
								</c:if>
								<c:if test="${qnaList.use_flg eq 0}">
								<select class="form-control" style="text-align: center;">
									<option value="${qnaList.use_flg }">미사용</option>
									<option value="1">사용</option>
								</select>								
								</c:if>
							</td>
						</tr>
						</c:forEach>
						</table>
				</div>
			</div>
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
	 /* function qnaTypeCall(data) {
	   var content = "";
	   for(var i = 0; i < data.length; i++){
	      console.log(data[i]);
	      content += '<tr>';
	      content += '<td>'+${data[i].idx}+'</td>';
	      content += '<td>';
	      content += '<c:if test='+${data[i].use_flg eq 1}+'>';
	      content += '<select class="form-control" style="text-align: center;">';
	      content += '<option value='+${data[i].use_flg}+'>사용</option>';
	      content += '<option value="0">미사용</option>';
	      content += '</select>';
	      content += '</c:if>';
	      content += '<c:if test='+${data[i].use_flg eq 0}+'>';
	      content += '<select class="form-control" style="text-align: center;">';
	      content += '<option value='+${data[i].use_flg}+'>미사용</option>';
	      content += '<option value="0">사용</option>';
	      content += '</select>';
	      content += '</c:if>';
	      content += '</tr>';
	   }
	   $(".qnaTr").empty();
	   $(".qnaTr").append(content);
	}  */
	var varTypename;
	$("#addQna").click(function () {
		var keyword = $('input[name=keyword]').val();
		var userIdx = $('input[name=userIdx]').val();
		console.log(keyword);
		console.log(userIdx);
		if(keyword == ''){
			alert('카테고리명을 입력해 주세요');
		} else{
			$.ajax({
				type:'get',
				url:'addQna',
				data:{'userIdx':userIdx, 'keyword':keyword},
				dataType:'JSON',
				success:function(data){
					console.log(data);
					location.href="toUpdateQnaCategory?userIdx="+userIdx;
				},
				error:function(e){
					
				}
			})			
		}
	})
	
	$("select").change(function () {
		var changUseFlg = $(this).val();
		var typename = varTypename;
		console.log(changUseFlg);
		console.log(varTypename);
		$.ajax({
			type:'get',
			url:'changUseFlg',
			data:{'changUseFlg':changUseFlg, 'typename':typename},
			dataType:'JSON',
			success:function(data){
				console.log(data);
				location.href="toUpdateQnaCategory?userIdx="+userIdx;
			},
			error:function(e){
				
			}
		})
	})
	
	
	function updateUseFlg(typename) {
		//var changUseFlg = $(this).val(); 
		var typename =typename;
		//console.log(typename);
		varTypename = typename;
	}
</script>
</html>



















































