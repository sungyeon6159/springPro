/**
 *<pre>
 * com.sist.spring.covid
 * Class Name : CovidController.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-04-26           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-04-26 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.sist.spring.covid;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 82104
 *
 */
@Controller
public class CovidController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CovidService covidService;
	
	@RequestMapping(value = "covid/do_retrieve",method = RequestMethod.GET)
	public String doRetrieve(HttpServletRequest req, RxJoinVO rxJoinVO, Model model) {
		String url = "covid/index";
		
		//임의로 한명 회원아아디 setting
		rxJoinVO.setUserId("abcd");
		
		List<RxJoinVO> list = (List<RxJoinVO>) covidService.doRetrieve(rxJoinVO);
		
		model.addAttribute("list", list);		
		
		return url;
	}
	
	
}
