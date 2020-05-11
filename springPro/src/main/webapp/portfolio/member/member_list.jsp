<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 3. 10.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set  var="hContext" value="${pageContext.request.contextPath }"></c:set>
<c:if test="${maxPageNo == null}"><c:set var="maxPageNo" value="1"></c:set></c:if>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Bombom</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/open-iconic-bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/animate.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/owl.carousel.min.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/owl.theme.default.min.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/magnific-popup.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/aos.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/ionicons.min.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/flaticon.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/icomoon.css">
  <link rel="stylesheet" type="text/css" href="${hContext}/resources/css/style.css">
</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar ftco-navbar-light site-navbar-target" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.jsp"><span>B</span>ombom</a>
	      <button class="navbar-toggler js-fh5co-nav-toggle fh5co-nav-toggle" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
         <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav nav ml-auto">
	          <li class="nav-item"><a href="#home-section" class="nav-link"><span>Home</span></a></li>
	          <li class="nav-item"><a href="#about-section" class="nav-link"><span>About</span></a></li>
	          <li class="nav-item"><a href="#License-section" class="nav-link"><span>License</span></a></li>
	          <li class="nav-item"><a href="#Skills-section" class="nav-link"><span>Skills</span></a></li>
	          <li class="nav-item"><a href="#Projects-section" class="nav-link"><span>Projects</span></a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
	  
	  <br/><br/><br/>
	  
  	<!-- div container -->
  	<div class="container">
  	    <!-- div title -->
  	    <div class="page-header">
  	    	<h1>Portfolio List</h1>
  	    </div>
    	<form action="${hContext}/portfolio/do_select_one.spring" id="selectOne_frm" name="selectOne_frm" method="post">
    		<input type="hidden" name="hiddenId" id="hiddenId">
    	</form>
    	<!-- Grid영역 -->
    	<div class="table-responsive">
    		<table class="table table-hover" id="memberTable">
    		    <!-- hidden-sm hidden-xs 숨기기 -->
    			<thead class="bg-primary">
    			</thead>
    			<tbody>
    				<!-- Data있는 경우 -->
    				<c:choose>
    					<c:when test="${list.size()>0 }">
    						<c:forEach var="i" begin="0" end="${list.size()-1}">
    							<tr>
			    					<td class="text-center"><img src="../resources/images/${fileList.get(i).saveNm}.${fileList.get(i).ext}" width="180" height="200" /></td>
			    					<td class="text-left" style="display:none;">${list.get(i).memberId}</td>
			    					<td class="text-left col-sm-12">
			    					<table>
			    						<tr>
			    							<td>
			    								<h6 class="mb-4"><b>Name</b></h6>
			    							</td>
			    							<td>
			    								<span>${list.get(i).name }</span>
			    							</td>
			    							<td>
			    								<h6><b>Birth</b></h6>
			    							</td>
			    							<td>
			    								${list.get(i).birth }
			    							</td>
			    						</tr>
			    						<tr>
			    							<td>
			    								<h6><b>Email</b></h6>
			    							</td>
			    							<td>
			    								${list.get(i).email }
			    							</td>
			    							<td>
			    								<h6><b>Phone</b></h6>
			    							</td>
			    							<td>
			    								${list.get(i).phone }
			    							</td>
			    						</tr>
			    					
			    					</table>
			    					</td>
		    					</tr>
	    					</c:forEach>
    					</c:when>
    					<c:otherwise>
    						<tr><td colspan="99">등록된 게시글이 없습니다.</td></tr>
    					</c:otherwise>
    				</c:choose>
    			</tbody>
    		</table>
    	</div>
    	<!--// Grid영역 -->    	
    </div>
    <!--// div container -->
    
    
    
    <footer class="ftco-footer ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">About</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Links</h2>
              <ul class="list-unstyled">
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Home</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>About</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Services</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Projects</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Contact</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Services</h2>
              <ul class="list-unstyled">
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Web Design</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Web Development</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Business Strategy</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Data Analysis</a></li>
                <li><a href="#"><span class="icon-long-arrow-right mr-2"></span>Graphic Design</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="${hContext}/resources/js/jquery.min.js"></script>
  <script src="${hContext}/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${hContext}/resources/js/popper.min.js"></script>
  <script src="${hContext}/resources/js/bootstrap.min.js"></script>
  <script src="${hContext}/resources/js/jquery.easing.1.3.js"></script>
  <script src="${hContext}/resources/js/jquery.waypoints.min.js"></script>
  <script src="${hContext}/resources/js/jquery.stellar.min.js"></script>
  <script src="${hContext}/resources/js/owl.carousel.min.js"></script>
  <script src="${hContext}/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${hContext}/resources/js/aos.js"></script>
  <script src="${hContext}/resources/js/jquery.animateNumber.min.js"></script>
  <script src="${hContext}/resources/js/scrollax.min.js"></script>
  <script src="${hContext}/resources/js/main.js"></script>


    <script type="text/javascript">
		
		//숫자만 입력:text numberOnly    
	    $("input:text[numberOnly]").on("keyup", function() {
	        $(this).val($(this).val().replace(/[^0-9]/g,""));
	    });

		//그리드 click: ID값을 서버로 ajax 전송:/member/do_select_one.do
		$("#memberTable>tbody").on("click","tr", function(){
			console.log("#memberTable>tbody"+ $(this));
			var tds = $(this).children();
			console.log("tds:"+ tds.text());
			var memberId = tds.eq(1).text();
			console.log("memberId:"+ memberId);

			var frm = document.selectOne_frm;
			frm.hiddenId.value = memberId;
			
			frm.submit();

			
		});

		function doRetrieve(){
			//console.log('doRetrieve');
			var frm = document.member_frm;
			frm.pageNum.value = 1;
			frm.action = "${hContext}/portfolio/do_retrieve.spring";
			frm.submit();
		}

		
		
		$("#searchWord").on("keydown",function(key) {
			console.log('searchWord keydown:'+key.keyCode);
			if(key.keyCode ==13){
				doRetrieve();
			}
		});
	
    </script>
  </body>
</html>