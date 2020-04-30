package com.sist.spring.portfolio.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.sist.spring.cmn.SearchVO;

@Controller
public class ProjectController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private final String UPLOAD_FILE="C:\\SPRING_SPRING\\pjtVideo";	

	public ProjectController() {	
	}
	
	@Autowired
	ProjectService pjtService;
	
	@RequestMapping(value="/portfolio/do_insert.spring"
			,method=RequestMethod.GET
			,produces ="application/json; charset=UTF-8")
	public String doInsert(HttpServletRequest req, Model model) {
		LOG.debug("doInsert");
		String pjtName=req.getParameter("pjtName");
		LOG.debug(pjtName);
		return null;
	}
	
	
	
	@RequestMapping(value="/portfolio/do_retrieve.spring"
					,method=RequestMethod.GET
					,produces ="application/json; charset=UTF-8")
	public String doRetrieve(HttpServletRequest req, ProjectVO search, Model model) {
		
		LOG.debug("==========================");
		LOG.debug("==ProjectService/doRetrieve");
		LOG.debug("==========================");
		
		search.setMemberId("iod1125");
		
		List<ProjectVO> list=(List<ProjectVO>)pjtService.doRetrieve(search);
		
		
		LOG.debug("==================================");
		LOG.debug("scrapping Method");
		LOG.debug("==================================");
			StringBuilder out=new StringBuilder();
        List<String> companyList=new ArrayList<String>();
		String url = "http://www.jobkorea.co.kr/Search/?stext=웹개발";    //크롤링할 url지정
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
 
    try {
 
            doc = Jsoup.connect(url).get();
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        }
    
        //select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
        //                               ==>원하는 값들이 들어있는 덩어리를 가져온다
        Elements element = doc.select("div.post-list-info"); 
      
 
        System.out.println("============================================================");
 
        //Iterator을 사용하여 하나씩 값 가져오기
        //덩어리안에서 필요한부분만 선택하여 가져올 수 있다.
        Iterator<Element> ie1 = element.select("a.title").iterator();
        
        
        while (ie1.hasNext()) {
 
            System.out.println(ie1.next().text());
            out.append(ie1.next().text()+",");
            companyList.add(ie1.next().text());
        }
        model.addAttribute("companyList",companyList);
        model.addAttribute("pjtList", list);
		

		return "portfolio/index";
	}
	
	@RequestMapping(value="/portfolio/recommend.spring", method=RequestMethod.GET
							,produces ="application/json; charset=UTF-8")
	public String scrappingMethod(HttpServletRequest req,Model model) {
		LOG.debug("==================================");
		LOG.debug("scrapping Method");
		LOG.debug("==================================");
			StringBuilder out=new StringBuilder();
        List<String> companyList=new ArrayList<String>();
		String url = "http://www.jobkorea.co.kr/Search/?stext=웹개발";    //크롤링할 url지정
        Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
 
    try {
 
            doc = Jsoup.connect(url).get();
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        }
    
        //select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
        //                               ==>원하는 값들이 들어있는 덩어리를 가져온다
        Elements element = doc.select("div.post-list-info"); 
      
 
        System.out.println("============================================================");
 
        //Iterator을 사용하여 하나씩 값 가져오기
        //덩어리안에서 필요한부분만 선택하여 가져올 수 있다.
        Iterator<Element> ie1 = element.select("a.title").iterator();
        
        
        while (ie1.hasNext()) {
 
            System.out.println(ie1.next().text());
            out.append(ie1.next().text()+",");
            companyList.add(ie1.next().text());
        }
        model.addAttribute("companyList",companyList);
 
        System.out.println("============================================================");
 
		return "portfolio/recommendJob/recommendJob";
	}

	
}
