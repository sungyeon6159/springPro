<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 4. 23.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2020.04.23
  *]
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="hContext" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공적마스크 약국 검색 하기</h1>
	<form action="${hContext}/covid/do_retrieve" name="addr_frm" method="get">
	
		<input type="text" id="address" name="address" size="50" disabled="disabled"/> 
		<input type="button" onclick="searchKakaoAddress();" value="주소검색" />
		<input type="button" onclick="javascript:doRetrieve();" class="btn btn-primary btn-sm" value="조회" size="30px" >
		<input type="hidden" id="lng" name="lng"/> 
		<input type="hidden" id="lat" name="lat"/> 
		<!-- 디버깅용 -->
	</form>
	<input type="hidden" id="result" name="result"/>
	
	<div id="map" style="width:50%;height:600px;"></div>
	

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=639b35f7e3646b98692013b4830ce2da&libraries=services"></script>
<script>
	//카카오 주소 검색 
	function searchKakaoAddress(){
	   console.log("----- 주소 검색 시작 -----");
	   
	   new daum.Postcode({
	        oncomplete: function(data) {
	           console.log("searching result", data);
	           var address = data.address;
	           document.getElementById("address").value =address;
	           getLatLng(data.address);
	        }
	    }).open();
	   
	}

	
	//주소로 좌표 구하기		address에 도로명 주소들어감 
	function getLatLng(address){
	   //주소-좌표 변환 객체를 생성합니다
	   var geocoder = new kakao.maps.services.Geocoder();
	      
	   // 주소로 좌표를 검색합니다
	   geocoder.addressSearch(address, function(result, status) {
	       // 정상적으로 검색이 완료됐으면 
	        if (status === kakao.maps.services.Status.OK) {
	         console.log("map result", result);
	         console.log("y", result[0].y);
	         console.log("x", result[0].x);
	         console.log("status+", status);
	         
	         document.getElementById("lng").value = result[0].x;
	         document.getElementById("lat").value = result[0].y;

	      
	         
	         
	       } 
	   }); 
	}

	function doRetrieve(){
	console.log("doRetrieve");
		
	var frm = document.addr_frm;
	frm.lng.value = $("#lng").val();
	frm.lat.value = $("#lat").val();
	frm.action = "${hContext}/covid/do_retrieve";
	frm.submit();
	
	}
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	mapOption = { 
	    center: new kakao.maps.LatLng("${currentLat}", "${currentLng}"), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


	var positions = [
	<c:forEach var="vo" items="${list}">
	{
	    title: '${vo.name}', 
	    latlng: new kakao.maps.LatLng("${vo.lat}", "${vo.lng}")
	},  
	</c:forEach>
	];



	//마커 이미지의 이미지 주소입니다
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 

	for (var i = 0; i < positions.length; i ++) {

		// 마커 이미지의 이미지 크기 입니다
		var imageSize = new kakao.maps.Size(24, 35); 
	
		// 마커 이미지를 생성합니다    
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    map: map, // 마커를 표시할 지도
		    position: positions[i].latlng, // 마커를 표시할 위치
		    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		    image : markerImage // 마커 이미지 
		});
	
	}
	
	
</script>	
</body>
</html>