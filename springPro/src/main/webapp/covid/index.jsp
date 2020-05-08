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
	<form action="${hContext}/covid/do_retrieve.spring" name="addr_frm" method="get">
	
		<input type="text" id="address" name="address" size="50" disabled="disabled"/> 
		<input type="button" onclick="searchKakaoAddress();" value="주소검색" />
		<input type="button" onclick="javascript:doRetrieve();" class="btn btn-primary btn-sm" value="조회" size="30px" >
		<input type="hidden" id="lng" name="lng"/> 
		<input type="hidden" id="lat" name="lat"/> 
		
	</form>
	<input type="hidden" id="result" name="result"/>
	
	<form action="${hContext}/covid/do_insert.spring" name="search_frm" method="post">
		<input type="hidden" id="searchlng" name="searchlng"/>
		<input type="hidden" id="searchlat" name="searchlat"/>
	</form>
	<!-- 지도 -->
	<div id="map" style="width:90%;height:600px;"></div>
	

<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=639b35f7e3646b98692013b4830ce2da&libraries=services"></script>
<script>
	//카카오 주소 검색 (daum)
	function searchKakaoAddress(){
	   console.log("----- 주소 검색 시작 -----");
	   
	   new daum.Postcode({
	        oncomplete: function(data) {
	           console.log("searching result", data);
	           var address = data.address;
	           document.getElementById("address").value =address;	//위에 hidden input type에 저장됨
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
	        /*   console.log("map result", result);
		         console.log("y", result[0].y);
		         console.log("x", result[0].x);
		         console.log("status+", status); */
	         
	         document.getElementById("lng").value = result[0].x;
	         document.getElementById("lat").value = result[0].y;

	       } 
	   }); 
	}

	function doRetrieve(){
		//console.log("doRetrieve");
			
		var frm = document.addr_frm;
		frm.lng.value = $("#lng").val();
		frm.lat.value = $("#lat").val();
		frm.action = "${hContext}/covid/do_retrieve.spring";
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
	    title: '${vo.pName}', 
	    latlng: new kakao.maps.LatLng("${vo.pLat}", "${vo.pLng}"),
	    markImg: '${vo.pRemainStat}',
	    addr: '${vo.pAddr}'
	},  
	</c:forEach>
	]; 

	
	//마커 이미지의 이미지 주소입니다
	var imageSrc = ""; 
	
	for (var i = 0; i < positions.length; i ++) {

		// 마커 이미지의 이미지 크기 입니다
		var imageSize = new kakao.maps.Size(24, 35); 
	
		// 마커 이미지를 생성합니다    
		if(positions[i].markImg =='plenty'){
			imageSrc = "${hContext}/resources/images/markger_green.png"; 
		} else if(positions[i].markImg =='some'){
			imageSrc = "${hContext}/resources/images/markger_orange.png"; 
		} else if(positions[i].markImg =='few'){
			imageSrc = "${hContext}/resources/images/markger_red.png"; 
		} else if(positions[i].markImg =='empty'){
			imageSrc = "${hContext}/resources/images/markger_gray.png"; 
		} 
		
		var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
	
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    map: map, // 마커를 표시할 지도
		    position: positions[i].latlng, // 마커를 표시할 위치
		    title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		    image : markerImage // 마커 이미지 
		});
		
		kakao.maps.event.addListener(marker, 'click', makeOverListener(marker));
		
	}//for

	function makeOverListener(marker) {
	    return function() {
	       //console.log(marker.mc);
	       //마커의 위도경도와 api의 위도경도가 같으면 그 vo를 찾아서 db에 insert하면 됨
	       //console.log(marker);
	       //console.log(marker.mc);
		   //console.log(marker.getPosition());
		   //console.log(marker.getPosition().Ga.toFixed(7));
		   //console.log(marker.getPosition().Ha.toFixed(7));
		   
		   document.getElementById("searchlng").value = marker.getPosition().Ga.toFixed(7);
		   document.getElementById("searchlat").value = marker.getPosition().Ha.toFixed(7);


		 	//ajax
			$.ajax({
			   type:"POST",
			   url:"${hContext}/covid/do_insert.spring",
			   dataType:"html", 
			   data:{"searchlng": $("#searchlng").val(),
				     "searchlat": $("#searchlat").val()
			   },
			   success:function(data){ //성공
			   	   //console.log("data:" + data);
				   var parseData = $.parseJSON(data);
			   	   if(parseData.msgId =="1"){
						alert(parseData.msgMsg);
						
				   } else{
					    alert(parseData.msgMsg);
				   }
			   },
			   error:function(xhr,status,error){
			       alert("error:"+error);
			   },
			   complete:function(data){
			   
			   }   
			   
			  });//--ajax
		   
		   
	    };
	}
	
</script>	
</body>
</html>