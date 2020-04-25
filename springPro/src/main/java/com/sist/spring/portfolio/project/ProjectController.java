package com.sist.spring.portfolio.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	public ProjectController() {	
	}
	
	@Autowired
	ProjectService pjtService;
	
	
	@RequestMapping(value="/portfolio/do_retrieve.spring"
					,method=RequestMethod.GET
					,produces ="application/json; charset=UTF-8")
	public String doRetrieve(HttpServletRequest req, ProjectVO search, Model model) {
		
		LOG.debug("==========================");
		LOG.debug("==ProjectService/doRetrieve");
		LOG.debug("==========================");
		
		search.setMemberId("iod1124");
		
		List<ProjectVO> list=(List<ProjectVO>)pjtService.doRetrieve(search);
		
		model.addAttribute("pjtList", list);
		
		
		return "portfolio/index";
	}
	
}
