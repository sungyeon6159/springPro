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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sist.spring.cmn.MessageVO;

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
	
	private List<CovidParmVO> list;
	
	/**
	 * email 보내기전 약국 검색기능
	 * @param req
	 * @param vo
	 * @param model
	 * @return
	 * @throws JSONException
	 * @throws IOException
	 */
	@RequestMapping(value = "covid/do_retrieve.spring",method = RequestMethod.GET)
	public String doRetrieve(HttpServletRequest req, CovidParmVO vo, Model model) throws JSONException, IOException {
		String url = "covid/index";
		String currentLng = req.getParameter("lng");
		String currentLat = req.getParameter("lat");
	
//		String currentLat="37.544169";	//나중에 주소 api검색시 값을 받아 저장 default=쌍용 
//		String currentLng="127.049948";
		JSONObject json1 = covidService.readJsonFromUrl("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/storesByGeo/json?lat="+currentLat+"&lng="+currentLng+"&m=1000");
		JsonParser parser=new JsonParser();
        JsonObject jsonObj=(JsonObject)parser.parse(json1.toString());
        JsonArray memberArray=(JsonArray)jsonObj.get("stores");
        
        list = new ArrayList<CovidParmVO>();
        for(int i=0; i<memberArray.size(); i++) {
        	vo = new CovidParmVO();
        	JsonObject object=(JsonObject)memberArray.get(i);
        	
        	if(object.get("remain_stat").isJsonNull()) {
        		int codeEndpoint= object.get("code").toString().lastIndexOf("\"");	//api 뿌려지는 value값이  ""로 싸여있므로 짜름
            	int nameEndpoint= object.get("name").toString().lastIndexOf("\"");
            	int addrEndpoint= object.get("addr").toString().lastIndexOf("\"");
            	int typeEndpoint= object.get("type").toString().lastIndexOf("\"");
            	
            	
            	String getCode = object.get("code").toString().substring(1, codeEndpoint);
            	String getName = object.get("name").toString().substring(1, nameEndpoint);

            	String getAddr = object.get("addr").toString().substring(1, addrEndpoint);
            	String getType = object.get("type").toString().substring(1, typeEndpoint);

            	double getLng = Double.valueOf(object.get("lng").toString());
            	double getLat = Double.valueOf(object.get("lat").toString());
            	
             	//임의로 한명 회원아아디 setting
            	vo.setMemberId("wogns");
            	vo.setpCode(getCode);
            	vo.setpName(getName);
            	vo.setpAddr(getAddr);
            	vo.setpLng(getLng);
            	vo.setpLat(getLat);
            	vo.setpRemainStat("empty");		//또는 empty로 변경, break를 empty로 변경(어차피 없는것이므로
        	} else {
        		int codeEndpoint= object.get("code").toString().lastIndexOf("\"");
            	int nameEndpoint= object.get("name").toString().lastIndexOf("\"");
            	
            	//나중에 필요하면 null체크하고 쓰면됨
//            	int stockAtEndpoint= object.get("stock_at").toString().lastIndexOf("\"");
//            	int createdAtEndpoint= object.get("created_at").toString().lastIndexOf("\"");
            	int addrEndpoint= object.get("addr").toString().lastIndexOf("\"");
            	int typeEndpoint= object.get("type").toString().lastIndexOf("\"");
            	int remainStatEndpoint= object.get("remain_stat").toString().lastIndexOf("\"");
            	
            	
            	String getCode = object.get("code").toString().substring(1, codeEndpoint);
            	String getName = object.get("name").toString().substring(1, nameEndpoint);
//            	String getStockAt = object.get("stock_at").toString().substring(1, stockAtEndpoint);
//            	String getCreatedAt = object.get("created_at").toString().substring(1, createdAtEndpoint);
            	String getAddr = object.get("addr").toString().substring(1, addrEndpoint);
            	String getType = object.get("type").toString().substring(1, typeEndpoint);
            	String getRemainStat = object.get("remain_stat").toString().substring(1, remainStatEndpoint);
            	double getLng = Double.valueOf(object.get("lng").toString());
            	double getLat = Double.valueOf(object.get("lat").toString());
            	//임의로 한명 회원아아디 setting
            	vo.setMemberId("wogns");
            	vo.setpCode(getCode);
            	vo.setpName(getName);
            	vo.setpAddr(getAddr);
            	vo.setpLng(getLng);
            	vo.setpLat(getLat);
            	vo.setpRemainStat(getRemainStat);
        	}
        	
        	System.out.println("출력값확인 "+vo);
        	list.add(vo);
        	
        }
        
        System.out.println(list);
        model.addAttribute("currentLng", currentLng);
        model.addAttribute("currentLat", currentLat);
        model.addAttribute("list",list);
		
		return url;
	}
	
	@RequestMapping(value = "covid/do_insert.spring",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doSelectOne(HttpServletRequest req, RxJoinVO vo, Model model) {
		
		String searchlng = req.getParameter("searchlng");
		String searchlat = req.getParameter("searchlat");
		Double lng = Double.valueOf(searchlng);
		Double lat = Double.valueOf(searchlat);
		
		
		LOG.debug("1===============");
		LOG.debug("1==============="+ list);
		LOG.debug("1==============="+ lng);
		LOG.debug("1==============="+ lat);
		LOG.debug("1===============");
		
		vo = new RxJoinVO();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getpLng() == lng &&  list.get(i).getpLat() == lat) {
				LOG.debug("관심약국"+list.get(i));
				vo.setMemberId(list.get(i).getMemberId());
				vo.setpCode(list.get(i).getpCode());
				vo.setpName(list.get(i).getpName());
				vo.setpAddr(list.get(i).getpAddr());
				vo.setpLng(list.get(i).getpLng());
				vo.setpLat(list.get(i).getpLat());
				vo.setpRemainStat(list.get(i).getpRemainStat());
			}
		}
		//ID가 wogns이라는 가정하에 진행, 단건 조회한 vo랑 다건조회리스트와 비교
		List<RxJoinVO> checkCntList= (List<RxJoinVO>) covidService.doRetrieve(vo);
//		RxJoinVO checkVO = (RxJoinVO) covidService.doSelectOne(vo);
		int cnt = 0;
		boolean bool = false;
		for(int i=0; i<checkCntList.size();i++) {
			//널은 나중에 제외(회원가입을 하고 들어올것이므로)
			if((vo.getMemberId() == null || "".equals(vo.getMemberId())) ||
					(checkCntList.get(i).getMemberId().equals(vo.getMemberId()) && checkCntList.get(i).getpCode().equals(vo.getpCode()))) {
				bool = true;
				break;
			} else if(checkCntList.get(i).getMemberId().equals(vo.getMemberId())) {
				cnt++;
			}
		}
		
		int flag = 0;
		if(cnt<5 && bool == false) {
			flag = covidService.doRxInsert(vo);
		} else {
			flag = 0;
			bool = true;
		}
		LOG.debug("1.2===============");
		LOG.debug("1.2=flag=" + flag);
		LOG.debug("1.2===============");
		
		//메시지 처리
		MessageVO message = new MessageVO();
		message.setMsgId(flag+""); 	//String으로 변환		msgId아이디에는 flag값만 넣음 
		//성공
		if(flag ==1) {
			message.setMsgMsg(vo.getpName() + "이 관심약국으로 등록되었습니다.");
		//실패
		} else if(bool == true){
			message.setMsgMsg("이미 등록되어 있는 관심약국입니다.");
		}
		else if(cnt<5){
			message.setMsgMsg("관심약국등록 제한횟수를 초과했습니다.");
		} 
		
		
		Gson gson = new Gson();
		String json =gson.toJson(message);
		
		LOG.debug("1.3===============");
		LOG.debug("1.3=json=" + json);
		LOG.debug("1.3===============");
		
		return json;
	}
	
	
}
