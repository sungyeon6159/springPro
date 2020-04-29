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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author 82104
 *
 */
@Controller
public class CovidController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CovidService covidService;
	
	
	/**
	 * email 보내기전 약국 검색기능
	 * @param req
	 * @param vo
	 * @param model
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value = "covid/do_retrieve",method = RequestMethod.GET)
	public String doRetrieve(HttpServletRequest req, CovidParmVO vo, Model model) throws JSONException, IOException {
		String url = "covid/index";
		String currentLng = req.getParameter("lng");
		String currentLat = req.getParameter("lat");
	
//		String currentLat="37.544169";	//나중에 주소 api검색시 값을 받아 저장 default=쌍용 
//		String currentLng="127.049948";
		JSONObject json1 = covidService.readJsonFromUrl("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByGeo/json?lat="+currentLat+"&lng="+currentLng+"&m=300");
		System.out.println("aaaaaa"+json1);
		JsonParser parser=new JsonParser();
        JsonObject jsonObj=(JsonObject)parser.parse(json1.toString());
        JsonArray memberArray=(JsonArray)jsonObj.get("stores");
        //model.addAttribute("memberArray",memberArray);
        
        List<CovidParmVO> list = new ArrayList<CovidParmVO>();
        for(int i=0; i<memberArray.size(); i++) {
        	vo = new CovidParmVO();
        	JsonObject object=(JsonObject)memberArray.get(i);
        	int codeEndpoint= object.get("code").toString().lastIndexOf("\"");
        	int nameEndpoint= object.get("name").toString().lastIndexOf("\"");
        	int stockAtEndpoint= object.get("stock_at").toString().lastIndexOf("\"");
        	int createdAtEndpoint= object.get("created_at").toString().lastIndexOf("\"");
        	int addrEndpoint= object.get("addr").toString().lastIndexOf("\"");
        	int typeEndpoint= object.get("type").toString().lastIndexOf("\"");
        	int remainStatEndpoint= object.get("remain_stat").toString().lastIndexOf("\"");
        	
        	
        	String getCode = object.get("code").toString().substring(1, codeEndpoint);
        	String getName = object.get("name").toString().substring(1, nameEndpoint);
        	String getStockAt = object.get("stock_at").toString().substring(1, stockAtEndpoint);
        	String getCreatedAt = object.get("created_at").toString().substring(1, createdAtEndpoint);
        	String getAddr = object.get("addr").toString().substring(1, addrEndpoint);
        	String getType = object.get("type").toString().substring(1, typeEndpoint);
        	String getRemainStat = object.get("remain_stat").toString().substring(1, remainStatEndpoint);
        	double getLng = Double.valueOf(object.get("lng").toString());
        	double getLat = Double.valueOf(object.get("lat").toString());
        	
        	//임의로 한명 회원아아디 setting
        	vo.setMemberId("wogns");
        	vo.setCode(getCode);
        	vo.setName(getName);
        	vo.setAddr(getAddr);
        	vo.setLng(getLng);
        	vo.setLat(getLat);
        	 
        	System.out.println("출력값확인 "+vo);
        	list.add(vo);
        	
        }
        
        System.out.println(list);
        model.addAttribute("currentLng", currentLng);
        model.addAttribute("currentLat", currentLat);
        model.addAttribute("list",list);
		
		return url;
	}
	
	
}
