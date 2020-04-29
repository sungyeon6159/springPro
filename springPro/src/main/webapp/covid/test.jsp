
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Map test</title>

</head>
<body>
 
   <h2>다음 주소 검색 API </h2>
   <button onclick="searchKakaoAddress()">주소 검색</button>
   <br>
   <h2>주소로 좌표 검색</h2>
   <p id="result"></p>




<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=639b35f7e3646b98692013b4830ce2da&libraries=services"></script>
<script type="text/javascript">

//카카오 주소 검색 
function searchKakaoAddress(){
   console.log("----- 주소 검색 시작 -----");
   
   new daum.Postcode({
        oncomplete: function(data) {
           console.log("searching result", data);
           var address = data.address;
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
         
         
         document.getElementById('result').innerHTML="위도 : " + result[0].y + ", 경도 : " + result[0].x;

      
         
         
       } 
   }); 
}






</script>

</body>
</html>