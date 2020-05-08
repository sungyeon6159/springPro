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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.spring.cmn.MessageVO;
import com.sist.spring.portfolio.skill.SkillVO;

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


		return "portfolio/index";
	}
	
	//삭제
	@RequestMapping(value = "portfolio/do_delete_license.spring",method=RequestMethod.GET
					,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doDeleteLicense(LicenseVO user) {
		LOG.debug("1===========================");
		LOG.debug("1 user = "+user);
		LOG.debug("1===========================");		
		
		int flag = 0;
		flag = licenseService.doDeleteLicense(user);
		LOG.debug("1.2===========================");
		LOG.debug("1.2 flag = "+flag);
		LOG.debug("1.2===========================");
		
		MessageVO message = new MessageVO();
		message.setMsgId(String.valueOf(flag));
		//성공
		if(flag==1) {
			message.setMsgMsg(user.getMemberId()+"님이 삭제 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(user.getMemberId()+"님, 삭제 실패했습니다.");			
		}
		
		//JSON
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("1.3===========================");
		LOG.debug("1.3 json = "+json);
		LOG.debug("1.3===========================");	
		
		return json;
	}	
	
	//등록
	@RequestMapping(value = "portfolio/do_insert_license.spring",method=RequestMethod.POST
				,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(LicenseVO user) {
	LOG.debug("1===========================");
	LOG.debug("1 user = "+user);
	LOG.debug("1===========================");		
	
	int flag = 0;
	flag = licenseService.doInsert(user);
	LOG.debug("1.2===========================");
	LOG.debug("1.2 flag = "+flag);
	LOG.debug("1.2===========================");
	
	MessageVO message = new MessageVO();
	message.setMsgId(String.valueOf(flag));
	//성공
	if(flag==1) {
		message.setMsgMsg(user.getMemberId()+"님이 삭제 되었습니다.");
	//실패	
	}else {
		message.setMsgMsg(user.getMemberId()+"님, 삭제 실패했습니다.");			
	}
	
	//JSON
	Gson gson = new Gson();
	String json = gson.toJson(message);
	
	LOG.debug("1.3===========================");
	LOG.debug("1.3 json = "+json);
	LOG.debug("1.3===========================");	
	
	return json;
	}	
	
}
