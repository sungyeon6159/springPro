<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 4. 27.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Bombom</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <link rel="stylesheet" href="${hContext}/resources/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${hContext}/resources/css/animate.css">
    
    <link rel="stylesheet" href="${hContext}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${hContext}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${hContext}/resources/css/magnific-popup.css">

    <link rel="stylesheet" href="${hContext}/resources/css/aos.css">

    <link rel="stylesheet" href="${hContext}/resources/css/ionicons.min.css">
    
    <link rel="stylesheet" href="${hContext}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${hContext}/resources/css/icomoon.css">
    <link rel="stylesheet" href="${hContext}/resources/css/style.css">
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
	          <li class="nav-item"><a href="#about-section" class="nav-link"><span>About</span></a></li>
	          <li class="nav-item"><a href="#Projects-section" class="nav-link"><span>Projects</span></a></li>
	          <li class="nav-item"><a href="#Skills-section" class="nav-link"><span>Skills</span></a></li>
	          <li class="nav-item"><a href="#License-section" class="nav-link"><span>License</span></a></li>
	          <li class="nav-item"><a href="#Recommends-section" class="nav-link"><span>Recommends</span></a></li>
	          <li class="nav-item"><a href="${hContext}/portfolio/do_retrieve.spring" class="nav-link"><span>Portfolio List</span></a></li>
	        </ul>
	      </div>
	    </div>    
	      <div class="row" align="left"> 
	      	<ol>
	      		<li> phone: ${pageContext.request.contextPath }</li>
	      		<li> Email: abcdefg@naver.com</li>
	      	</ol>
	      </div>
	  </nav>
	  <section class="hero-wrap js-fullheight">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight justify-content-center align-items-center">
          <div class="col-lg-8 col-md-6 ftco-animate d-flex align-items-center">
          	<div class="text text-center">
          		<span class="subheading">Hey! I am</span>
		  			<h1>Bombom</h1>
			  			<h2> 
						  <span
						     class="txt-rotate"
						     data-period="1000"
						     data-rotate='[  "Now,", "Let me", "introduce myself"  ]'>
						  </span>
						</h2>
				</div>
            </div>
          </div>
        </div>
      </div>
      <div class="mouse">
				<a href="#" class="mouse-icon">
					<div class="mouse-wheel"><span class="ion-ios-arrow-round-down"></span></div>
				</a>
			</div>
    </section>
    <!-- About -->
  <!-- About -->
    <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="about-section">
    	<div class="container">
    		<div class="row d-flex no-gutters">
    			<div class="col-md-6 col-lg-6 d-flex">
    				<div class="img-about img d-flex align-items-stretch">
    					<div class="overlay"></div>
	    				<div class="img d-flex align-self-stretch align-items-center" style="background-image:url(${hContext}/resources/images/${fileVO.saveNm}.${fileVO.ext });">
	    				</div>
    				</div>
    			</div>
    			<div class="col-md-6 col-lg-6 pl-md-5 py-5">
    				<div class="row justify-content-start pb-3">
		          <div class="col-md-12 heading-section ftco-animate">
		            <h2 class="mb-4">About Me</h2>
		            <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
		            <ul class="about-info mt-4 px-md-0 px-2">
		            	<li class="d-flex"><span>Name:</span> <span>${memberVO.name }</span></li>
		            	<li class="d-flex"><span>Date of birth:</span> <span>${memberVO.birth }</span></li>
		            	<li class="d-flex"><span>Email:</span> <span>${memberVO.email }</span></li>
		            	<li class="d-flex"><span>Phone: </span> <span>${memberVO.phone }</span></li>
		            </ul>
		          </div>
		        </div>
	        </div>
        </div>
    	</div>
    </section>
	<!--// About -->
	
    <section class="ftco-section ftco-partner">
    	<div class="container">
    		<div class="row">
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="${hContext}/resources/images/partner-1.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="${hContext}/resources/images/partner-2.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="${hContext}/resources/images/partner-3.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="${hContext}/resources/images/partner-4.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="${hContext}/resources/images/partner-5.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    		</div>
    	</div>
    </section>
	
	<!-- Projects -->
    <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="Projects-section">
    	<div class="container-fluid px-md-5">
    		<div class="row justify-content-center py-5 mt-5">
          		<div class="col-md-12 heading-section text-center ftco-animate">
           			 <h2 class="mb-4">Projects</h2>
           			 <div align="center">
	           			 <table>
	                        <tbody>
	                        <tr>
	                        	<td colspan="3">
	                        		<small>이 곳에서는 그동안 배우고 적용한 프로젝트를 볼 수 있는 곳입니다. <br>해당하는 버튼을 클릭하면 소스와,시연영상을 보실 수 있습니다.</small>
	                        	</td>
	                        </tr>
	                        <tr>
	                        	<td><br/></td>
	                        </tr>
	                        <c:choose>
	                		<%-- data가 있는 경우 --%>
	                		<c:when test="${pjtList.size()>0}">
	                			<c:forEach var="vo" items="${pjtList}">
		                		<tr>
	                              <td><h5 class="text-primary" ><b>1차 프로젝트</b></h5></td>
	                           </tr>
	                           <tr>
	                              <td rowspan="4">
	                                  <a href="${vo.gitAddress }">
	                                 	<video src="${hContext}/resources/video/20200507151830_c66bf.avi" width="170" height="170" align="top"/>
	                                 </a>  
	                              </td>
	                              <td>
	                              	<p><b> subject:</b></p>
	                              </td>
	                              <td>
	                              	<p> ${vo.pjtName}</p>
	                              </td>
	                           </tr>
	                           <tr>
	                           	  <td>
	                           	  	<p><b> 설명:</b></p>
	                           	  </td>
	                           	  <td>
	                           	  	<p>${vo.pjtInfo}</p>
	                           	  </td>
	                           </tr>
	                           <tr>
	                           	  <td>
	                           	  	<p><b> 사용 툴:</b></p>
	                           	  </td>
	                           	  <td>
	                           	  	<p>${vo.pjtTool}</p>
	                           	  </td>
	                           </tr>
	                           
	                           <tr>
	                           	  <td>
	                           	  	<p><b>프로젝트 기간</b></p>
	                           	  </td>
	                           	  <td>
	                           	  	<p>${vo.pjtStart}-${vo.pjtEnd}</p>
	                           	  </td>
	                           </tr>
	                           <tr>
	                           	  <td colspan="2" align="center">
	                           	      <a href="${vo.gitAddress}">
	                           	      	<input type="button" class="btn btn-outline-primary" value="소스보기"/>
	                           	      </a> &nbsp;&nbsp;
	                           	  	  <input type="button" onclick="javascript:popup('${vo.gitAddress}');" class="btn btn-outline-primary" value="영상보기"/>  
	                           	  </td>
	                           </tr>
	                           <tr>
	                        	<td><br/></td>
	                        	</tr>
		                	    </c:forEach>
	                		</c:when>
	                		<%-- data가 없는 경우 --%>
	                		<c:otherwise>
	                			<tr>
	                				<td colspan="99">등록된 게시글이 없습니다</td>
	                			</tr>
	                		</c:otherwise>
	                	</c:choose>
	                        </tbody>
	                     </table>
           			 </div>
           		</div>
           	</div>
        </div>
    </section>
	<!--// Projects -->
	
    <!-- Skills -->
     <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="Skills-section">
		<div class="container-fluid px-md-5">
    		<div class="row justify-content-center py-5 mt-5">
          		<div class="col-md-12 heading-section text-center ftco-animate">
           			 <h2 class="mb-4">Skills</h2> 
           			  <div class="row progress-circle mb-5">
                                        
					  	      <c:choose>
						          <c:when test="${skillList.size()>0}">
						              <c:forEach var="i" begin="0" end="2">
						               <div class="col-lg-4 mb-4">
			                              <div class="bg-white rounded-lg shadow p-4">
                        
						                <h2 class="h5 font-weight-bold text-center mb-4">${skillList.get(i).sName}</h2>
		                                <!-- Progress bar 1 -->
		                                <div class="progress mx-auto" data-value='${skillList.get(i).sMarstery}'>
		                                    <span class="progress-left">
		                                         <span class="progress-bar border-primary"></span>
		                                    </span>
		                                    <span class="progress-right">
		                                        <span class="progress-bar border-primary"></span>
		                                    </span>
		                                    <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
		                                        <div class="h2 font-weight-bold">${skillList.get(i).sMarstery}<sup class="small">%</sup></div>
		                                    </div>
		                                </div>
		                                       <!-- Demo info -->
			                                <div class="row text-center mt-4">
			                                  <h4 class="h5 font-weight-bold text-center mb-4">${skillList.get(i).sContent}</h4>
			                                </div>
			                                <!-- END -->
			                              </div>
			                            </div>
		                               </c:forEach>
		                             
                                       
						          </c:when>
						          <c:otherwise>
                                   <h2 class="text-center">등록된 게시글이 없습니다</h2>
                                </c:otherwise>
                              </c:choose>
                              </div>
                              <c:choose><c:when test="${skillList.size()>0}">
						       <div class="row">
                                       <c:forEach var="i" begin="0" end="${skillList.size()-1 }">
                                       
                                                <div class="col-md-${skillList.size()} animate-box">
                                                        <div class="progress-wrap ftco-animate">
                                                            <h3>${skillList.get(i).sName}</h3>
                                                            <br/>
                                                            <div class="progress">
                                                                <div class="progress-bar color-1" role="progressbar" aria-valuenow="${skillList.get(i).sMarstery}"
                                                                aria-valuemin="0" aria-valuemax="100" style="width:${skillList.get(i).sMarstery}%">
                                                                <span>${skillList.get(i).sMarstery}%</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                       </c:forEach>
                                      </div>
						        <!-- END -->
                                </c:when> 
                           </c:choose>
						 </div>
						   						    
					  	</div>
					  	
           		  </div>
           	 </div>
         </div>    	
    </section>
    <!-- //Skills -->	
    
    <!-- License -->
     <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="License-section">
     	<form action="${hContext}/portfolio/do_retrieve_lic.spring"  name="license_frm" method="GET" class="form-inline">
			<div class="container-fluid px-md-3">
	    		<div class="row justify-content-center py-5 mt-5">
	          		<div class="col-md-10 heading-section text-center ftco-animate">
	           			 <h2 class="mb-4">License</h2>
						 <div class="row">
						 	<c:choose>
						 		<c:when test="${licList.size()>0 }">
						 			<c:forEach var="vo" items="${licList}" >
									 	<div class="col-md-4 text-center d-flex ftco-animate">
									 		<div class="services-1 shadow">
									 			<span class="icon">
									 				<i class="flaticon-analysis"></i>
									 			</span>
									 			<div class="desc">
									 				<input type="hidden" name="memberId" id="memberId" value="${vo.memberId}" />
									 				<table id="licFrm">
									 					<tbody>
															<tr>
									 						    <td rowspan="2"><input type="hidden" name="memberId" id="memberId" value="${vo.memberId}"/>
									 							</td> 
									 						</tr>
									 						<tr>
									 							<td name="lName" value="${vo.lName }"  style="width: 40"><c:out value="${vo.lName }" /><hr/></td>
									 						</tr>
									 						<tr>
									 							<td id="lGroup" value="${vo.lGroup}" >자격분류: </td>
									 							<td  name="lGroup"><c:out value="${vo.lGroup}" /></td>
									 						</tr>
									 						<tr>
									 							<td>자격등급: </td>
									 							<td id="lGrade" name="lGrade"><c:out value="${vo.lGrade}" /></td>
									 						</tr>
									 						<tr>
									 							<td>자격번호: </td>
									 							<td id="lNum" name="lNum"><c:out value="${vo.lNum }"  /></td>
									 						</tr>
									 						<tr>
									 							<td>취득일자: </td>
									 							<td id="lDate" name="lDate"><c:out value="${vo.lDate }" /></td>
									 						</tr>
									 						<tr>
									 							<td>발행기관: </td>
									 							<td id="lOrgan" name="lOrgan"><c:out value="${vo.lOrgan }" /></td>
									 						</tr>
									 						<tr>
									 							<td colspan="2">
  			 						 								<!-- <button type="button" onclick="javascript:doDel();" class="licDelBtn" id="licDel" name="licDel" >삭제</button> -->
  			 						 								<button type="button"  class="licDelBtn btn btn-primary" id="licDel" name="licDel" >삭제</button>
 																	<!-- <button type="button" class="licUpdate btn btn-primary" id="licUpdate" name="licUpdate" onclick="javascript:goUpdate();">수정</button>-->
									 							    <button type="button" class="licUpdate btn btn-primary" id="licUpdate" name="licUpdate" >수정</button> 
									 							</td>
									 						</tr>
									 					</tbody>
									 				</table>
									 			</div>
									 		</div>
									 	</div>
									 </c:forEach>
							 	</c:when>
						 	</c:choose>	
						 	<div>
						 		<button type="button" onclick="javascript:licRetrieve();"class="btn btn-primary btn-sm">조회</button>
						 	</div>
						 </div>
	           	    </div>
	           	</div>
	           	<!-- <button type="button" id="retrieveLic" onclick="javascript:licRetrieve();"class="btn btn-primary btn-sm">조회</button> -->
	        </div>  
        </form>
     </section>  
    <!-- //License -->

	<!-- Recommend -->
	<section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="Recommends-section">
    	<div class="container-fluid px-md-5">
    		<div class="row justify-content-center py-5 mt-5">
          		<div class="col-md-12 heading-section text-center ftco-animate">
           			 <h2 class="mb-4">Recommend</h2>
           			 <div align="center">
	           			 <table>
	                        <tbody>
	                        <tr>
	                        	<td><br/></td>
	                        </tr>
	                         <tr>
	                        	<td><hr/></td>
	                        </tr>
	                        <c:choose>
	                		<%-- data가 있는 경우 --%>
	                		<c:when test="${recommendList.size()>0}">
	                			<c:forEach var="i" begin="0" end="${recommendList.size()-1 }">
	                		
		                		<tr>
		                		  <td>
	                              	<h5 class="text-primary" >
	                              	<a href="${urlList.get(i)}">
	                              			<b>${companyList.get(i)}</b>
	                              	</a>
	                              	</h5>
	                              </td>
	                           </tr>

		                		<tr>
	                              <td><h6><b>${recommendList.get(i)}</b></h5></td>
	                           </tr>
	                           <tr>
	                              <td><hr/></td>
	                           </tr>
		                	    </c:forEach>
	                		</c:when>
	                		<%-- data가 없는 경우 --%>
	                		<c:otherwise>
	                			<tr>
	                				<td colspan="99">등록된 게시글이 없습니다</td>
	                			</tr>
	                		</c:otherwise>
	                	</c:choose>
	                        </tbody>
	                     </table>
           			 </div>
           		</div>
           	</div>
        </div>
    </section>
	
<!--     <section class="ftco-section ftco-no-pb goto-here" id="resume-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-3">
				    <nav id="navi">
					    <ul>
					      <li><a href="#page-1">Education</a></li>
					      <li><a href="#page-2">Experience</a></li>
					      <li><a href="#page-3">Skills</a></li>
					      <li><a href="#page-4">Awards</a></li>
					    </ul>
					  </nav>
					</div>
					<div class="col-md-9">
					  <div id="page-1" class= "page one">
					  	<h2 class="heading">Education</h2>
					    <div class="resume-wrap d-flex ftco-animate">
					    	<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Bachelor of Science in Computer Science</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
	    					</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Computer Processing Systems/Computer Software</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Diploma in Computer</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Art &amp; Creative Director</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
					  </div>

					  <div id="page-2" class= "page two">
					  	<h2 class="heading">Experience</h2>
					    <div class="resume-wrap d-flex ftco-animate">
					    	<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Software Developer</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Web Designer</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Web Marketing</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Art &amp; Creative Director</h2>
		    					<span class="position">Side Tech</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Wordpress Developer</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2017-2018</span>
		    					<h2>UI/UX Designer</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
					  </div>
					  <div id="page-3" class= "page three">
					  	<h2 class="heading">Skills</h2>
					  	<div class="row progress-circle mb-5">
					  		<div class="col-lg-4 mb-4">
						      <div class="bg-white rounded-lg shadow p-4">
						        <h2 class="h5 font-weight-bold text-center mb-4">CSS</h2>

						        Progress bar 1
						        <div class="progress mx-auto" data-value='90'>
						          <span class="progress-left">
                        <span class="progress-bar border-primary"></span>
						          </span>
						          <span class="progress-right">
                        <span class="progress-bar border-primary"></span>
						          </span>
						          <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
						            <div class="h2 font-weight-bold">90<sup class="small">%</sup></div>
						          </div>
						        </div>
						        END

						        Demo info
						        <div class="row text-center mt-4">
						          <div class="col-6 border-right">
						            <div class="h4 font-weight-bold mb-0">28%</div><span class="small text-gray">Last week</span>
						          </div>
						          <div class="col-6">
						            <div class="h4 font-weight-bold mb-0">60%</div><span class="small text-gray">Last month</span>
						          </div>
						        </div>
						        END
						      </div>
						    </div>

						    <div class="col-lg-4 mb-4">
						      <div class="bg-white rounded-lg shadow p-4">
						        <h2 class="h5 font-weight-bold text-center mb-4">HTML</h2>

						        Progress bar 1
						        <div class="progress mx-auto" data-value='80'>
						          <span class="progress-left">
                        <span class="progress-bar border-primary"></span>
						          </span>
						          <span class="progress-right">
                        <span class="progress-bar border-primary"></span>
						          </span>
						          <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
						            <div class="h2 font-weight-bold">80<sup class="small">%</sup></div>
						          </div>
						        </div>
						        END

						        Demo info
						        <div class="row text-center mt-4">
						          <div class="col-6 border-right">
						            <div class="h4 font-weight-bold mb-0">28%</div><span class="small text-gray">Last week</span>
						          </div>
						          <div class="col-6">
						            <div class="h4 font-weight-bold mb-0">60%</div><span class="small text-gray">Last month</span>
						          </div>
						        </div>
						        END
						      </div>
						    </div>

						    <div class="col-lg-4 mb-4">
						      <div class="bg-white rounded-lg shadow p-4">
						        <h2 class="h5 font-weight-bold text-center mb-4">jQuery</h2>

						        Progress bar 1
						        <div class="progress mx-auto" data-value='75'>
						          <span class="progress-left">
                        <span class="progress-bar border-primary"></span>
						          </span>
						          <span class="progress-right">
                        <span class="progress-bar border-primary"></span>
						          </span>
						          <div class="progress-value w-100 h-100 rounded-circle d-flex align-items-center justify-content-center">
						            <div class="h2 font-weight-bold">75<sup class="small">%</sup></div>
						          </div>
						        </div>
						        END

						        Demo info
						        <div class="row text-center mt-4">
						          <div class="col-6 border-right">
						            <div class="h4 font-weight-bold mb-0">28%</div><span class="small text-gray">Last week</span>
						          </div>
						          <div class="col-6">
						            <div class="h4 font-weight-bold mb-0">60%</div><span class="small text-gray">Last month</span>
						          </div>
						        </div>
						        END
						      </div>
						    </div>
					  	</div>
					  	<div class="row">
					  		<div class="col-md-6 animate-box">
									<div class="progress-wrap ftco-animate">
										<h3>Photoshop</h3>
										<div class="progress">
										 	<div class="progress-bar color-1" role="progressbar" aria-valuenow="90"
										  	aria-valuemin="0" aria-valuemax="100" style="width:90%">
										    <span>90%</span>
										  	</div>
										</div>
									</div>
								</div>
								<div class="col-md-6 animate-box">
									<div class="progress-wrap ftco-animate">
										<h3>jQuery</h3>
										<div class="progress">
										 	<div class="progress-bar color-2" role="progressbar" aria-valuenow="85"
										  	aria-valuemin="0" aria-valuemax="100" style="width:85%">
										    <span>85%</span>
										  	</div>
										</div>
									</div>
								</div>
								<div class="col-md-6 animate-box">
									<div class="progress-wrap ftco-animate">
										<h3>HTML5</h3>
										<div class="progress">
										 	<div class="progress-bar color-3" role="progressbar" aria-valuenow="95"
										  	aria-valuemin="0" aria-valuemax="100" style="width:95%">
										    <span>95%</span>
										  	</div>
										</div>
									</div>
								</div>
								<div class="col-md-6 animate-box">
									<div class="progress-wrap ftco-animate">
										<h3>CSS3</h3>
										<div class="progress">
										 	<div class="progress-bar color-4" role="progressbar" aria-valuenow="90"
										  	aria-valuemin="0" aria-valuemax="100" style="width:90%">
										    <span>90%</span>
										  	</div>
										</div>
									</div>
								</div>
								<div class="col-md-6 animate-box">
									<div class="progress-wrap ftco-animate">
										<h3>WordPress</h3>
										<div class="progress">
										 	<div class="progress-bar color-5" role="progressbar" aria-valuenow="70"
										  	aria-valuemin="0" aria-valuemax="100" style="width:70%">
										    <span>70%</span>
										  	</div>
										</div>
									</div>
								</div>
								<div class="col-md-6 animate-box">
									<div class="progress-wrap ftco-animate">
										<h3>SEO</h3>
										<div class="progress">
										 	<div class="progress-bar color-6" role="progressbar" aria-valuenow="80"
										  	aria-valuemin="0" aria-valuemax="100" style="width:80%">
										    <span>80%</span>
										  	</div>
										</div>
									</div>
								</div>
					  	</div>
					  </div>
					  <div id="page-4" class= "page four">
					    <h2 class="heading">Awards</h2>
					    <div class="resume-wrap d-flex ftco-animate">
					    	<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Top 10 Web Developer</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
	    					</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Top 5 LeaderShip Exellence Winner</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Top 4 Web Tester</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
	    				<div class="resume-wrap d-flex ftco-animate">
	    					<div class="icon d-flex align-items-center justify-content-center">
					    		<span class="flaticon-ideas"></span>
					    	</div>
					    	<div class="text pl-3">
		    					<span class="date">2014-2015</span>
		    					<h2>Art &amp; Creative Director</h2>
		    					<span class="position">Cambridge University</span>
		    					<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
		    				</div>
	    				</div>
					  </div>
					</div>
			  </div>
    	</div>
    </section>
 -->	
	
<!-- 
    <section class="ftco-section ftco-no-pt ftco-no-pb ftco-counter img" id="section-counter">
    	<div class="container-fluid px-md-5">
				<div class="row d-md-flex align-items-center">
          <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
            <div class="block-18 shadow">
              <div class="text">
                <strong class="number" data-number="100">0</strong>
                <span>Awards</span>
              </div>
            </div>
          </div>
          <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
            <div class="block-18 shadow">
              <div class="text">
                <strong class="number" data-number="1200">0</strong>
                <span>Complete Projects</span>
              </div>
            </div>
          </div>
          <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
            <div class="block-18 shadow">
              <div class="text">
                <strong class="number" data-number="1200">0</strong>
                <span>Happy Customers</span>
              </div>
            </div>
          </div>
          <div class="col-md d-flex justify-content-center counter-wrap ftco-animate">
            <div class="block-18 shadow">
              <div class="text">
                <strong class="number" data-number="500">0</strong>
                <span>Cups of coffee</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
 -->
<!-- 
    <section class="ftco-section" id="blog-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h1 class="big big-2">Blog</h1>
            <h2 class="mb-4">Our Blog</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
          </div>
        </div>
        <div class="row d-flex">
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <a href="single.html" class="block-20" style="background-image: url('images/image_1.jpg');">
              </a>
              <div class="text mt-3 float-right d-block">
                <h3 class="heading"><a href="single.html">Why Lead Generation is Key for Business Growth</a></h3>
                <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2">Sept. 12, 2019</span>
	                	<a href="#" class="mr-2">Admin</a>
	                	<a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a>
	                </p>
                </div>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry justify-content-end">
              <a href="single.html" class="block-20" style="background-image: url('images/image_2.jpg');">
              </a>
              <div class="text mt-3 float-right d-block">
                <h3 class="heading"><a href="single.html">Why Lead Generation is Key for Business Growth</a></h3>
                <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2">Sept. 12, 2019</span>
	                	<a href="#" class="mr-2">Admin</a>
	                	<a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a>
	                </p>
                </div>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
          	<div class="blog-entry">
              <a href="single.html" class="block-20" style="background-image: url('images/image_3.jpg');">
              </a>
              <div class="text mt-3 float-right d-block">
                <h3 class="heading"><a href="single.html">Why Lead Generation is Key for Business Growth</a></h3>
                <div class="d-flex align-items-center mb-3 meta">
	                <p class="mb-0">
	                	<span class="mr-2">Sept. 12, 2019</span>
	                	<a href="#" class="mr-2">Admin</a>
	                	<a href="#" class="meta-chat"><span class="icon-chat"></span> 3</a>
	                </p>
                </div>
                <p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section ftco-hireme img" style="background-image: url(images/bg_1.jpg)">
    	<div class="overlay"></div>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-7 ftco-animate text-center">
						<h2>I'm <span>Available</span> for freelancing</h2>
						<p>A small river named Duden flows by their place and supplies it with the necessary regelialia.</p>
						<p class="mb-0"><a href="#" class="btn btn-primary py-3 px-5">Hire me</a></p>
					</div>
				</div>
			</div>
		</section>
 -->
    <section class="ftco-section contact-section ftco-no-pb" id="contact-section">
      <div class="container">
      	<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h1 class="big big-2">Contact</h1>
            <h2 class="mb-4">Contact Me</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia</p>
          </div>
        </div>

        <div class="row d-flex contact-info mb-5">
          <div class="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div class="align-self-stretch box text-center p-4 shadow">
          		<div class="icon d-flex align-items-center justify-content-center">
          			<span class="icon-map-signs"></span>
          		</div>
          		<div>
	          		<h3 class="mb-4">Address</h3>
		            <p>198 West 21th Street, Suite 721 New York NY 10016</p>
		          </div>
	          </div>
          </div>
          <div class="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div class="align-self-stretch box text-center p-4 shadow">
          		<div class="icon d-flex align-items-center justify-content-center">
          			<span class="icon-phone2"></span>
          		</div>
          		<div>
	          		<h3 class="mb-4">Contact Number</h3>
		            <p><a href="tel://1234567920">+ 1235 2355 98</a></p>
	            </div>
	          </div>
          </div>
          <div class="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div class="align-self-stretch box text-center p-4 shadow">
          		<div class="icon d-flex align-items-center justify-content-center">
          			<span class="icon-paper-plane"></span>
          		</div>
          		<div>
	          		<h3 class="mb-4">Email Address</h3>
		            <p><a href="mailto:info@yoursite.com">info@yoursite.com</a></p>
		          </div>
	          </div>
          </div>
          <div class="col-md-6 col-lg-3 d-flex ftco-animate">
          	<div class="align-self-stretch box text-center p-4 shadow">
          		<div class="icon d-flex align-items-center justify-content-center">
          			<span class="icon-globe"></span>
          		</div>
          		<div>
	          		<h3 class="mb-4">Website</h3>
		            <p><a href="#">yoursite.com</a></p>
	            </div>
	          </div>
          </div>
        </div>

        <div class="row no-gutters block-9">
          <div class="col-md-6 order-md-last d-flex">
            <form action="#" class="bg-light p-4 p-md-5 contact-form">
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Your Name">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Your Email">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Subject">
              </div>
              <div class="form-group">
                <textarea name="" id="" cols="30" rows="7" class="form-control" placeholder="Message"></textarea>
              </div>
              <div class="form-group">
                <input type="submit" value="Send Message" class="btn btn-primary py-3 px-5">
              </div>
            </form>
          
          </div>

          <div class="col-md-6 d-flex">
          	<div class="img" style="background-image: url(${hContext}/resources/images/about.jpg);"></div>
          </div>
        </div>
      </div>
    </section>
		

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
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="index.jsp" target="_blank">Bombom</a>
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

  //조회버튼 클릭 시
  function licRetrieve() {
      var frm = document.license_frm;
      frm.action="${hContext}/portfolio/total_retrieve.spring";
      frm.submit();
   }

  function popup(gitAddress){
	  
      var url = "${hContext}/portfolio/videoPopup.jsp";
      var name = "popup test";
      var option = "width = 500, height = 500, top = 200, left = 200, location = no"
      window.open(url, name, option);
  }
  
//License------------------------------
	//수정
	 $(".licUpdate").on("click",function(event){
		 console.log("수정");
		 var licUpdate = $(this);
	     var tdArr = new Array();
	
	     licUpdate.each(function(i){
				 var tr = licUpdate.parent().parent().parent().eq(i);
		         var td = tr.children().children();
		         var lName = td.eq(1).text();
			     var lGroup = td.eq(3).text();
			     var lGrade = td.eq(5).text();
			     var lNum = td.eq(7).text();
			     var lDate = td.eq(9).text();
			     var lOrgan=td.eq(11).text();
	
			     tdArr.push(lName);
			     tdArr.push(lGroup);
			     tdArr.push(lGrade);
			     tdArr.push(lNum);
			     tdArr.push(lDate);
			     tdArr.push(lOrgan);
	      }); //--raio.each
	
	     var lName = tdArr[0];
	     var lGroup = tdArr[1]; 
	     var lGrade = tdArr[2]; 
	     var lNum = tdArr[3];
	     var lDate = tdArr[4];
	     var lOrgan= tdArr[5];
		
     //ajax
     $.ajax({
      type:"GET",
      url:"${hContext}/portfolio/go_update.spring",
      dataType:"html", 
      data:{ //"memberId":"sohyun1234"
             "memberId":$("#memberId").val(),
             "lName" : lName.trim(),
             "lGroup": lGroup.trim(),
             "lGrade": lGrade.trim(),
             "lNum": lNum.trim(),
             "lDate": lDate.trim(),
             "lOrgan": lOrgan.trim() 
      },
      success:function(data){ //성공
	          console.log("data:"+data);  
	          var html = "";
	          var tr = licUpdate.parent().parent().parent();
		      var td = tr.children().children();

		      var removeTr01 = tr.eq(0);
	          var removeTr02 = tr.eq(1);
	          var removeTr03 = tr.eq(2);
	          var removeTr04 = tr.eq(3);
	          var removeTr05 = tr.eq(4);
	          var removeTr06 = tr.eq(5);
	          var removeTr07 = tr.eq(6);
	          event.preventDefault(); 
	
	          removeTr01.remove();
	          removeTr02.remove();
	          removeTr03.remove();
	          removeTr04.remove();
	          removeTr05.remove();
	          removeTr06.remove();
	          removeTr07.remove();  
	          
	          html +='<tr>                                                                                                '  ;
	       	  html +='    <td rowspan="2"><input type="hidden" name="memberId" id="memberId" value="${vo.memberId}"/></td>'  ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td name="lName" value="${vo.lName }"  style="width: 40"><c:out value="${vo.lName }" /><hr/></td>'   ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td id="lGroup" value="${vo.lGroup}" >자격분류: </td>                                               ';
	       	  html +='	<td  name="lGroup"><c:out value="${vo.lGroup}" /></td>                                           '   ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td>자격등급: </td>                                                                                 ';
	       	  html +='	<td id="lGrade" name="lGrade"><c:out value="${vo.lGrade}" /></td>                                '   ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td>자격번호: </td>                                                                                 ';
	       	  html +='	<td id="lNum" name="lNum"><c:out value="${vo.lNum }"  /></td>                                    '   ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td>취득일자: </td>                                                                                 ';
	       	  html +='	<td id="lDate" name="lDate"><c:out value="${vo.lDate }" /></td>                                  '   ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td>발행기관: </td>                                                                                 ';
	       	  html +='	<td id="lOrgan" name="lOrgan"><c:out value="${vo.lOrgan }" /></td>                               '   ;
	       	  html +='</tr>                                                                                               '  ;
	       	  html +='<tr>                                                                                                '  ;
	       	  html +='	<td colspan="2">                                                                                 '   ;
	       	  html +='   		<button type="button"  class="licDelBtn btn btn-primary">수정완료</button>                  ';
	       	  html +='	 <button type="button" class="licUpdate btn btn-primary">수정취소</button>                          ';
	       	  html +='	</td>                                                                                            '   ;
	       	  html +='</tr>                                                                                               '  ;
	          
   		  	  //tr.parent().append(html); 																							
      },
      error:function(xhr,status,error){
        alert("error:"+error);
      },
      complete:function(data){
      
      }   
      
     });//--ajax 

     
	  });//--수정 


 	//삭제
	 $(".licDelBtn").on("click",function(){
		 console.log("삭제");
		 var rowData = new Array();	 
		 var tdArr = new Array();	// 배열 선언
		 var licDelBtn = $(this);

		 var tr = licDelBtn.parent().parent().parent();
      	 var td = tr.children().children();
     	 rowData.push(tr.text());

	      var lName = td.eq(1).text();
	      console.log("lName="+lName);
	      tdArr.push(lName);

		  //confirm
     	  if(confirm(lName+"을(를) 삭제 하시겠습니까?")==false) return;
	       
		   //ajax
		   $.ajax({
		    type:"POST",
		    url:"${hContext}/portfolio/do_delete_license.spring",
		    dataType:"html", 
		    data:{ //"memberId":"sohyun1234"
		           "memberId":$("#memberId").val()
		          ,"lName" : lName.trim()
		    },
		    success:function(data){ //성공
		     //console.log("data:"+data);  
		     var parseData = $.parseJSON(data);
					 if(parseData.msgId=="1"){
							alert(parseData.msgMsg);
							//licRetrieve();
							history.go(0);
						 }else{
							alert(parseData.msgMsg);
							 }
		
		    },
		    error:function(xhr,status,error){
		      alert("error:"+error);
		    },
		    complete:function(data){
		    
		    }   
		    
		   });//--ajax 
		    

		 });	
	
//--License----------------------------

  </script> 
  </body>
</html>