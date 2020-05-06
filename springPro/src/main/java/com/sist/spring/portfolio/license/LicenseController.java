package com.sist.spring.portfolio.license;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LicenseController {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public LicenseController() {	
	}
	
	@Autowired
	LicenseService licenseService;
	
	@RequestMapping(value="/portfolio/do_retrieve2.spring",method =RequestMethod.GET)
	public String doRetrieve(HttpServletRequest req,Model model) {

		LicenseVO inVO=new LicenseVO();
		inVO.setMemberId("sohyun1234");
		
		List<LicenseVO> list = (List<LicenseVO>) licenseService.doRetrieve(inVO);
		LOG.debug("1.3===========================");
		for(LicenseVO vo:list) {
			LOG.debug("1.3 vo = "+vo);
		}
		LOG.debug("1.3===========================");		
		model.addAttribute("list",list);
		
		//총글수
		int totalCnt = 0;
		if(list!=null && list.size()>0) {
			totalCnt =list.get(0).getTotalCnt();
		}
		model.addAttribute("totalCnt",totalCnt);


		return "portfolio/index2";
	}
	
}
