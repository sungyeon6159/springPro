<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 6.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="hContext" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bombom</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">
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
    
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
 
    
    <title>My page</title>
    
    
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
             <li class="nav-item"><a href="#skills-section" class="nav-link"><span>Skills</span></a></li>
             <li class="nav-item"><a href="#license-section" class="nav-link"><span>License</span></a></li>
             <li class="nav-item"><a href="#Projects-section" class="nav-link"><span>Projects</span></a></li>
           </ul>
         </div>
       </div>
     </nav>
     
   <div>
      <br/>
      <br/>
      <br/>
      <br/>
   </div>  

   <!-- Skills -->
    <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="skills-section">
       <div class="container-fluid px-md-5">
          <div class="row justify-content-center py-5 mt-5">
                <div class="col-md-12 heading-section text-center ftco-animate">
                     <h2 class="mb-4">Add Skills</h2>
                     <div align="center">
                        <form action="${hContext}/skill/do_insert.spring" name="skillInsertForm" id="skillInsertForm" method="post">
                        <!-- SkillController 할때 인서트 부분을 이렇게 하셨으면 좋겠는데 볼수있을까여 민지양이ㅋㅋ-->
                        <table id="skillForm">
                        	<tr>
                        		<td>
                        			<table>
                        			
                        				<tr>
				                           <td>
				                              <img alt="추가입력폼" width="20" height="20" src="${hContext}/resources/images/plus.png" id="skillPlusInsert">
				                           </td>
				                        </tr>
				                              <tr>
				                           <td>
				                              <p>Programming Language</p>
				                           </td>
				                           <td>
				                              <select id="sName" name="skillList[0].sName">
				                                 <option value="Java">Java</option>
				                                 <option value="C">C</option>
				                                 <option value="Python">Python</option>
				                                 <option value="C++">C++</option>
				                                 <option value="C#">C#</option>
				                                 <option value="Visual Basic.NET">Visual Basic.NET</option>
				                                 <option value="JavaScript">JavaScript</option>
				                                 <option value="PHP">PHP</option>
				                                 <option value="SQL">SQL</option>
				                                 <option value="R">R</option>
				                                 <option value="Swift">Swift</option>
				                                 <option value="Go">Go</option>
				                                 <option value="Ruby">Ruby</option>
				                                 <option value="Assmbler">Assmbler</option>
				                                 <option value="PL/SQL">PL/SQL</option>
				                                 <option value="Perl">Perl</option>
				                                 <option value="Objective-C">Objective-C</option>
				                                 <option value="MATLAB">MATLAB</option>
				                                 <option value="Visual Basic">Visual Basic</option>
				                                 <option value="Scratch">Scratch</option>
				                              </select>
				                           </td>
				                        </tr>
				                        <tr>   
				                           <td>
				                              <p>Mastership Level</p>
				                           </td>
				                           <td>
				                           	 <input type="range" id="sMarstery" name="skillList[0].sMarstery" name="points" step="1" value="0" oninput="document.getElementById('checkMastery0').innerHTML=this.value;">
        								   	 &nbsp&nbsp<b><span id="checkMastery0"></span>%</b>
        								   </td>
				                        </tr>
				                        <tr>   
				                           <td>
				                              <p>Activity content</p>
				                           </td>
				                           <td>
				                              <p><textarea rows="10" cols="50" name="skillList[0].sContent" id="sContent"></textarea></p>
				                           </td>
				                        </tr>
                        			
                        			
                        			</table>
                        		</td>
                        	</tr>
                        
                        
	                        <tbody id="skillbody">
	                        </tbody>
                        </table>
                        <table>
                     		<tr>
                        		<td colspan=2>
                           			<button type="button" onclick="javascript:skillInsert();" class="btn btn-primary btn-sm">Submit</button>
                        		</td>
                     		</tr>
                  		</table>
                        </form>
                     </div>
                 </div>
              </div>
        </div>
    </section>
   <!--// Skills -->
   
   <!-- license -->
      <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="license-section">
         <div class="container-fluid px-md-5">
             <div class="row justify-content-center py-5 mt-5">
                   <div class="col-md-12 heading-section text-center ftco-animate">
                        <h2 class="mb-4">Add License</h2>
                        <div align="center">
                     <form action="${hContext}/portfolio/do_insert_license.spring" name="licenseInsertForm" id="licenseInsertForm" method="post">
                     <table id="licenseForm">
                     	<tr>
                        	<td>
                        		<table>
                        		
				                     <tr>
				                     	<td>
				                        <img alt="추가입력폼" width="20" height="20" src="${hContext}/resources/images/plus.png" id="licensePlusInsert">
				                        </td>
				                     </tr>
				                           <tr>
				                              <td>
				                               <input  type="text" class="form-control lName" name="licenseList[0].lName" id="lName" placeholder="Qualification Name" >
				                              </td>
				                           </tr>
				                           <tr>
				                              <td>
				                                 <label for="Qualification classification">Qualification classification</label>
				                                  <select id="lGroup" name="licenseList[0].lGroup">
				                                    <option value="국가기술자격">National Technical qualification</option>
				                                    <option value="국가전문자격">National Professional qualification</option>
				                                    <option value="민간자격">Private qualification</option>
				                                    <option value="해외자격">Overseas qualification</option>
				                                  </select>
				                             </td>
				                              </tr>
				                              <tr>
				                                 <td>
				                                    <label for="TypeOfLicense">Type of license</label>
				                                  <select id="lGrade" name="licenseList[0].lGrade">
				                                    <option value="기사">기사</option>
				                                    <option value="기능사">기능사</option>
				                                    <option value="1급">1급</option>
				                                    <option value="2급">2급</option>
				                                    <option value="기타">기타</option>
				                                  </select>
				                             </td>
				                              </tr>
				                              <tr>
				                                 <td>
				                                  <input type="text" class="form-control lNum" name="licenseList[0].lNum" id="lNum" placeholder="License Number" >
				                                 </td>
				                              </tr>
				                              <tr>
				                                 <td>
				                                    <input type="text" class="form-control lDate" name="licenseList[0].lDate" id="lDate" placeholder="Date of Acquisition(yyyymmdd)" >
				                                 </td>
				                              </tr>
				                              <tr>
				                                 <td>
				                                    <input type="text" class="form-control lOrgan" name="licenseList[0].lOrgan" id="lOrgan" placeholder="Issuing Agency"  >
				                                 </td>
				                              </tr>
				                              
				                              
				                              		</table>
				                  				</td>
                        					</tr>
                        					
                        					
				                  			<tbody id="licensebody">
					                       </tbody>
								         <table>
							             	<tr>
							             		<td colspan=2>
							             			<button type="button" onclick="javascript:licenseInsert();" class="btn btn-primary btn-sm">Submit</button>
							             		</td>
							             	</tr>
							             </table>
				         </table>         			
                      </form>
                  </div>
               </div>
            </div>
         </div>
      </section>
   <!--// license -->
   
    <!-- Project -->
    <section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb" id="Projects-section">
       <div class="container-fluid px-md-5">
          <div class="row justify-content-center py-5 mt-5">
                <div class="col-md-12 heading-section text-center ftco-animate">
                  <h2 class="mb-4">Add Project</h2>
                    <div align="center">
                      <form action="${hContext}/portfoilo/upload.spring" method="post" enctype="multipart/form-data" name="projectInsetForm" id="projectInsetForm">
                      <input type="hidden" id="hiddenCnt" name="hiddenCnt">
                       <table id="pjtForm">
                        <tr>
                        	<td>
                        		<table>
                        		
			                        <tr>
			                           <td>
			                              <img alt="추가입력폼" width="20" height="20" src="${hContext}/resources/images/plus.png" id="pjtPlusInsert">
			                           </td>
			                        </tr>
			                        <tr>
			                           <td>
			                              Project Name
			                           </td>
			                           <td>
			                              <input type="text" id="pjtName" name="projectList[0].pjtName">
			                           </td>
			                        </tr>
			                        <tr>   
			                           <td>
			                              <p>Project Description<p>
			                           </td>
			                           <td>
			                              <textarea cols="50" rows="3" id="pjtInfo" name="projectList[0].pjtInfo"></textarea>
			                           </td>
			                        </tr>
			                        <tr>   
			                           <td>
			                              <p>Project Period<p>
			                           </td>
			                           <td>
			                              <input type="date" id="pjtStart" name="projectList[0].pjtStart"> - <input type="date" id="pjtEnd" name="projectList[0].pjtEnd">
			                           </td>
			                        </tr>
			                        <tr>   
			                           <td>
			                              <p>Github Address<p>
			                           </td>
			                           <td>
			                              <input type="text" id="gitAddress" name="projectList[0].gitAddress">
			                           </td>
			                        </tr>
			                        <tr>   
			                           <td>
			                              <p>Project DemonstrationVideo<p>
			                           </td>
			                           <td>
			                              <input type="file" id="videoFile" name="file01">
			                           </td>
			                        </tr>
			                        
			                        
			                      </table>
			                     </td>
                        	   </tr>
                        	
			                     <tbody id="projectbody">
					             </tbody>
					             
		                     <table>
		                     <tr>
		                        <td colspan=2>
		                           <button type="button" onclick="javascript:pjtInsert();" class="btn btn-primary btn-sm">Submit</button>
		                        </td>
		                     </tr>
		                  </table>
                     </table>
                    </form>
                   </div>
                 </div>
              </div>
        </div>
    </section>
   <!--// Project -->


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





<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-migrate-3.0.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.easing.1.3.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.waypoints.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.stellar.min.js"/>"></script>
<script src="<c:url value="/resources/js/owl.carousel.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.magnific-popup.min.js"/>"></script>
<script src="<c:url value="/resources/js/aos.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.animateNumber.min.js"/>"></script>
<script src="<c:url value="/resources/js/scrollax.min.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>
   
   
    <script type="text/javascript">

        var skillCnt = 0;
		var html='';
       
       $("#skillPlusInsert").on("click" , function(){
		console.log('this is plus button');
		var frm = document.uploadFrm;
		html = '';
		skillCnt+=1;
		console.log(skillCnt);

		html+='<tr id="tr_1'+skillCnt+'">';
		html+='<td>';
		html+='<table>';

		
		html+='<tr ><td colspan="2"><hr/><br/></td></tr>                                                                                             ';
		html+='          <tr>                                                                                                         ';
		html+='       <td>                                                                                                                          ';
		html+='          <p>Programming Language</p>                                                                                                ';
		html+='       </td>                                                                                                                         ';
		html+='       <td>                                                                                                                          ';
		html+='          <select id="sName'+skillCnt+'" name="skillList['+skillCnt+'].sName">                                                       ';
		html+='             <option value="Java">Java</option>                                                                                      ';
		html+='             <option value="C">C</option>                                                                                            ';
		html+='             <option value="Python">Python</option>                                                                                  ';
		html+='             <option value="C++">C++</option>                                                                                        ';
		html+='             <option value="C#">C#</option>                                                                                          ';
		html+='             <option value="Visual Basic.NET">Visual Basic.NET</option>                                                              ';
		html+='             <option value="JavaScript">JavaScript</option>                                                                          ';
		html+='             <option value="PHP">PHP</option>                                                                                        ';
		html+='             <option value="SQL">SQL</option>                                                                                        ';
		html+='             <option value="R">R</option>                                                                                            ';
		html+='             <option value="Swift">Swift</option>                                                                                    ';
		html+='             <option value="Go">Go</option>                                                                                          ';
		html+='             <option value="Ruby">Ruby</option>                                                                                      ';
		html+='             <option value="Assmbler">Assmbler</option>                                                                              ';
		html+='             <option value="PL/SQL">PL/SQL</option>                                                                                  ';
		html+='             <option value="Perl">Perl</option>                                                                                      ';
		html+='             <option value="Objective-C">Objective-C</option>                                                                        ';
		html+='             <option value="MATLAB">MATLAB</option>                                                                                  ';
		html+='             <option value="Visual Basic">Visual Basic</option>                                                                      ';
		html+='             <option value="Scratch">Scratch</option>                                                                                ';
		html+='          </select>                                                                                                                  ';
		html+='       </td>                                                                                                                         ';
		html+='    </tr>                                                                                                                            ';
		html+='    <tr>                                                                                                               ';
		html+='       <td>                                                                                                                          ';
		html+='          <p>Mastership Level</p>                                                                                                    ';
		html+='       </td>                                                                                                                         ';
		html+='       <td>                                                                                                                          ';
		html+='			<input type="range" id="sMarstery'+skillCnt+'" name="skillList['+skillCnt+'].sMarstery" step="1" value="0" oninput="document.getElementById(\'checkMastery'+skillCnt+'\').innerHTML=this.value;">     ';
		html+='			&nbsp&nbsp<b><span id="checkMastery'+skillCnt+'"></span>%</b>																													';
		html+='       </td>                                                                                                                         ';
		html+='    </tr>                                                                                                                            ';
		html+='    <tr>                                                                                                               ';
		html+='       <td>                                                                                                                          ';
		html+='          <p>Activity content</p>                                                                                                    ';
		html+='       </td>                                                                                                                         ';
		html+='       <td>                                                                                                                          ';
		html+='          <p><textarea rows="10" cols="50" name="skillList['+skillCnt+'].sContent" id="sContent'+skillCnt+'"></textarea></p>         ';
		html+='       </td>                                                                                                                         ';
		html+='    </tr>                                                                                                                            ';
		html+='      <tr >                                                                                                             ';
		html+='         <td>                                                                                                                        ';
		html+='				<img alt="삭제입력폼" align="left" width="20" height="20" src="${hContext}/resources/images/minus.png" onClick="skillbtnMinus(\'tr_1'+skillCnt+'\');">		';		
		html+='         </td>                                                                                                                       ';
		html+='      </tr>                                                                                                                          ';

		html+='</tr>';
		html+='</td>';
		html+='</table>';
		
		$("#skillbody").append(html);

           });

       function skillbtnMinus(btnId){
    	   console.log('this is minus button');
           $("#"+btnId).empty();
       }
           

       var licenseCnt = 0;
       $("#licensePlusInsert").on("click" , function(){
		console.log('this is plus button');
		var frm = document.uploadFrm;
		var html = '';
		licenseCnt+=1;
		console.log(licenseCnt);

		html+='<tr id="tr_2'+licenseCnt+'">';
		html+='<td>';
		html+='<table>';
                                                                                                                                                                                                                       
		html+='  <tr><td colspan="2"><hr/><br/></td></tr>                                                                                                                                                              ';
		html+='  <tr>                                                                                                                                                                                                  ';
		html+='      <td>                                                                                                                                                                                              ';
		html+='       <input  type="text" class="form-control lName" name="licenseList['+licenseCnt+'].lName" id="lName'+licenseCnt+'" placeholder="Qualification Name"   autofocus>                                   ';
		html+='      </td>                                                                                                                                                                                             ';
		html+='   </tr>                                                                                                                                                                                                ';
		html+='   <tr>                                                                                                                                                                                                 ';
		html+='      <td>                                                                                                                                                                                              ';
		html+='         <label for="Qualification classification">Qualification classification</label>                                                                                                                 ';
		html+='          <select id="lGroup'+licenseCnt+'" name="licenseList['+licenseCnt+'].lGroup">                                                                                                                  ';
		html+='            <option value="국가기술자격">National Technical qualification</option>                                                                                                                         ';
		html+='            <option value="국가전문자격">National Professional qualification</option>                                                                                                                      ';
		html+='            <option value="민간자격">Private qualification</option>                                                                                                                                       ';
		html+='            <option value="해외자격">Overseas qualification</option>                                                                                                                                      ';
		html+='          </select>                                                                                                                                                                                     ';
		html+='     </td>                                                                                                                                                                                              ';
		html+='      </tr>                                                                                                                                                                                             ';
		html+='      <tr>                                                                                                                                                                                              ';
		html+='         <td>                                                                                                                                                                                           ';
		html+='            <label for="TypeOfLicense">Type of license</label>                                                                                                                                          ';
		html+='          <select id="lGrade'+licenseCnt+'" name="licenseList['+licenseCnt+'].lGrade">                                                                                                                  ';
		html+='            <option value="기사">기사</option>                                                                                                                                                            ';
		html+='            <option value="기능사">기능사</option>                                                                                                                                                         ';
		html+='            <option value="1급">1급</option>                                                                                                                                                             ';
		html+='            <option value="2급">2급</option>                                                                                                                                                             ';
		html+='            <option value="기타">기타</option>                                                                                                                                                            ';
		html+='          </select>                                                                                                                                                                                     ';
		html+='     </td>                                                                                                                                                                                              ';
		html+='      </tr>                                                                                                                                                                                             ';
		html+='      <tr>                                                                                                                                                                                              ';
		html+='         <td>                                                                                                                                                                                           ';
		html+='          <input type="text" class="form-control lNum" name="licenseList['+licenseCnt+'].lNum" id="lNum'+licenseCnt+'" placeholder="License Number"  autofocus>                                         ';
		html+='         </td>                                                                                                                                                                                          ';
		html+='      </tr>                                                                                                                                                                                             ';
		html+='      <tr>                                                                                                                                                                                              ';
		html+='         <td>                                                                                                                                                                                           ';
		html+='            <input type="text" class="form-control lDate" name="licenseList['+licenseCnt+'].lDate" id="lDate'+licenseCnt+'" placeholder="Date of Acquisition(yyyymmdd)"  autofocus>                     ';
		html+='         </td>                                                                                                                                                                                          ';
		html+='      </tr>                                                                                                                                                                                             ';
		html+='      <tr>                                                                                                                                                                                              ';
		html+='         <td>                                                                                                                                                                                           ';
		html+='            <input type="text" class="form-control lOrgan" name="licenseList['+licenseCnt+'].lOrgan" id="lOrgan'+licenseCnt+'" placeholder="Issuing Agency"  autofocus>                                 ';
		html+='         </td>                                                                                                                                                                                          ';
		html+='      </tr>                                                                                                                                                                                       	   ';
		html+='    </tr>                                                                                                                                                                                               ';
		html+='      <tr >                                                                                                                                                                                             ';
		html+='         <td>                                                                                                                                                                                           ';
		html+='				<img alt="삭제입력폼" align="left" width="20" height="20" src="${hContext}/resources/images/minus.png" onClick="licensebtnMinus(\'tr_2'+licenseCnt+'\');">		                               ';		
		html+='         </td>                                                                                                                                                                                          ';
		html+='      </tr>                                                                                                                                                                                             ';
		
		
		html+='</tr>';
		html+='</td>';
		html+='</table>';
		
		$("#licensebody").append(html);

       });

       function licensebtnMinus(btnId){
    	   console.log('this is minus button');
           $("#"+btnId).empty();
       }

      var projectCnt = 0;
       $("#pjtPlusInsert").on("click", function(){
       console.log('This is plus button');
       var frm=document.uploadFrm;
       var html = '';
       projectCnt+=1;
       console.log(projectCnt);

       html+='<tr id="tr_3'+projectCnt+'">';
 	   html+='<td>';
 	   html+='<table>';

        html+='<tr><td colspan="2"><hr/><br/></td></tr>                                                                                                                                                                  ';
        html+='<tr>                                                                                                                                                                                                      ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      Project Name                                                                                                                                                                                        ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <input type="text" id="pjtName'+projectCnt+'" name="projectList['+projectCnt+'].pjtName">                                                                                                           ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='</tr>                                                                                                                                                                                                     ';
        html+='<tr>                                                                                                                                                                                                      ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <p>Project Description<p>                                                                                                                                                                           ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <textarea cols="50" rows="3" id="pjtInfo'+projectCnt+'" name="projectList['+projectCnt+'].pjtInfo"></textarea>                                                                                      ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='</tr>                                                                                                                                                                                                     ';
        html+='<tr>                                                                                                                                                                                                      ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <p>Project Period<p>                                                                                                                                                                                ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <input type="date" id="pjtStart'+projectCnt+'" name="projectList['+projectCnt+'].pjtStart"> - <input type="date" id="pjtEnd'+projectCnt+'" name="projectList['+projectCnt+'].pjtEnd">               ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='</tr>                                                                                                                                                                                                     ';
        html+='<tr>                                                                                                                                                                                                      ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <p>Github Address<p>                                                                                                                                                                                ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <input type="text" id="gitAddress'+projectCnt+'" name="projectList['+projectCnt+'].gitAddress">                                                                                                     ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='</tr>                                                                                                                                                                                                     ';
        html+='<tr>                                                                                                                                                                                                      ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <p>Project DemonstrationVideo<p>                                                                                                                                                                    ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='   <td>                                                                                                                                                                                                   ';
        html+='      <input type="file" id="videoFile'+projectCnt+'" name="projectList['+projectCnt+'].videoFile">                                                                                                       ';
        html+='   </td>                                                                                                                                                                                                  ';
        html+='</tr>                                                                                                                                                                                                     ';
        html+='      <tr >                                                                                                                                                                                               ';
 		html+='         <td>                                                                                                                                                                                             ';
 		html+='				<img alt="삭제입력폼" align="left" width="20" height="20" src="${hContext}/resources/images/minus.png" onClick="licensebtnMinus(\'tr_3'+projectCnt+'\');">	                      	             ';		
 		html+='         </td>                                                                                                                                                                                            ';
 		html+='      </tr>                                                                                                                                                                                               ';
 		
		
        html+='</tr>';
 		html+='</td>';
 		html+='</table>';  
 		                                                                                                                                                         
        $("#projectbody").append(html);

      	});
       function projectbtnMinus(btnId){
    	   console.log('this is minus button');
           $("#"+btnId).empty();
       }






       
      function skillInsert() {
           console.log("skillInsert");
           var frm = document.skillInsertForm;
           frm.action = "${hContext}/skill/do_insert.spring";
           frm.method="POST";
           frm.submit(); 
           
      }

      function licenseInsert() {
         console.log("licenseInsert");
         var frm = document.licenseInsertForm;
         frm.action = "${hContext}/portfolio/license_insert.spring";
         frm.method="POST";
         frm.submit(); 
         
     }
       
      function pjtInsert() {

    	  console.log("licenseInsert");
          var licFrm = document.licenseInsertForm;
          licFrm.action = "${hContext}/portfolio/license_insert.spring";
          licFrm.method="POST";
          licFrm.submit(); 

          console.log("skillInsert");
         var skillFrm = document.skillInsertForm;
         skillFrm.action = "${hContext}/skill/do_insert.spring";
         skillFrm.method="POST";
         skillFrm.submit(); 
          
         console.log("pjtInsert");
         var pjtFrm = document.projectInsetForm;
         pjtFrm.action = "${hContext}/project/do_insert.spring";
         pjtFrm.hiddenCnt.value=projectCnt;
         pjtFrm.method="POST";
         pjtFrm.submit(); 
         
      }

      $("#uploadBtn").on("click", function(){
         console.log("uploadTest");
         var frm=document.uploadFrm;
         frm.hiddenCnt.value=cnt;
         frm.file01.value=$("#videoFile").value;
         frm.action = "${hContext}/portfoilo/upload.spring";
         frm.method="POST"
         frm.submit();
         
         });

           
     </script>
    
</body>
</html>