package com.sist.spring.portfolio.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.spring.cmn.MessageVO;
import com.sist.spring.cmn.SearchVO;
import com.sist.spring.cmn.StringUtil;
import com.sist.spring.portfolio.member.file.FileMemberService;
import com.sist.spring.portfolio.member.file.FileMemberVO;

@Controller
public class MemberController {
	private final Logger LOG = LoggerFactory.getLogger(MemberController.class);
	
	//@Qualifier("dummyMailSender") : root-context.xml bean id
	@Autowired
	MemberService memberService;
	
	@Autowired
	FileMemberService fmService;
	
	@RequestMapping(value = "/portfolio/do_retrieve.spring", method = RequestMethod.GET)
	public String doRetrieve(HttpServletRequest req, SearchVO search, Model model){
		LOG.debug("1===================");
		LOG.debug("1=search="+search);
		LOG.debug("1===================");
		   
		//페이지 사이즈
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		//페이지 num
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		//검색구분
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		
		//검색어
		search.setSearchWord(StringUtil.nvl(search.getSearchWord()));
		model.addAttribute("param",search);
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=search="+search);
		LOG.debug("1.2===================");
		
		List<MemberVO> list = (List<MemberVO>) memberService.doRetrieve(search);
		List<FileMemberVO> fileList=new ArrayList();
		LOG.debug("1.3===================");
		for(MemberVO vo :list) {
			
			FileMemberVO inVO=new FileMemberVO();
			LOG.debug("vo="+vo);
			inVO.setMemberId(vo.getMemberId());
			
			fileList.add((FileMemberVO) fmService.doSelectOne(inVO));
			
		}
		LOG.debug("1.3===================");
		
		model.addAttribute("list", list);
		model.addAttribute("fileList", fileList);
		
		//총글수
		int totalCnt = 0;
		if(null != list && list.size() >0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		model.addAttribute("totalCnt", totalCnt);
		int maxPageNo = ((totalCnt - 1) / 10) + 1;
		model.addAttribute("maxPageNo",maxPageNo);
		
		
//		member/member_mng -> /+member/member_mng+.jsp
		return "portfolio/member/member_list";
	}

	
	@RequestMapping(value = "member/do_update.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doUpdate(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");

		int  flag = memberService.doUpdate(user);
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");

		//메시지 처리
		MessageVO message=new MessageVO();

		message.setMsgId(flag+"");
		//성공
		if(flag ==1) {
			message.setMsgMsg(user.getName()+"님이 수정 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(user.getName()+"님 등록 실패.");			
		}		

		//JSON
		Gson gson=new Gson();
		String json = gson.toJson(message);

		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json); 
		LOG.debug("1.3===================");		

		return json;

	}
	
	
	@RequestMapping(value = "/portfolio/do_select_one.spring",method = RequestMethod.POST)
	public String doSelectOne(HttpServletRequest req ,MemberVO user, Model model) {
		
		user.setMemberId(req.getParameter("hiddenId")); //frm의 hiddenId 값들 가져와서 set
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		
		MemberVO outVO = (MemberVO) memberService.doSelectOne(user); //selectOne해서 한줄 뽑아옴
		LOG.debug("1.2===================");
		LOG.debug("1.2=outVO="+outVO);
		LOG.debug("1.2===================");
		
		FileMemberVO inVO = new FileMemberVO(); //객체생성
		inVO.setMemberId(user.getMemberId()); //
		
		FileMemberVO fileVO= (FileMemberVO) fmService.doSelectOne(inVO);
		
		model.addAttribute("fileVO",fileVO);
		model.addAttribute("memberVO",outVO);
		
		return "portfolio/member/index_test";
	}
	
	
	
	@RequestMapping(value = "member/do_delete.do",method = RequestMethod.POST
					,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doDelete(MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		
		int flag = 0;
		flag = memberService.doDelete(user);
		
		MessageVO message = new MessageVO();
		message.setMsgId(String.valueOf(flag));
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");
		//성공
		if(flag == 1) {
			message.setMsgMsg(user.getMemberId()+"님이 삭제 되었습니다.");
		//실패
		}else {
			message.setMsgMsg(user.getMemberId()+"삭제 실패.");
		}
		
		//JSON
		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json); 
		LOG.debug("1.3===================");
		
		
		return json;
		
	}
	
		@RequestMapping(value = "portfolio/SignUp/doInsertMember.spring", method = RequestMethod.GET
					,produces = "application/json; charset=UTF-8")
		@ResponseBody
		public String doInsert(HttpServletRequest req, MemberVO user) {
		LOG.debug("1===================");
		LOG.debug("1=user="+user);
		LOG.debug("1===================");
		LOG.debug(req.getParameter("birth1"));
		LOG.debug(req.getParameter("birth2"));
		LOG.debug(req.getParameter("birth3"));
		int  flag = memberService.doInsert(user);
		
		LOG.debug("1.2===================");
		LOG.debug("1.2=flag="+flag); 
		LOG.debug("1.2===================");
		
		//메시지 처리
		MessageVO message=new MessageVO();
		
		message.setMsgId(flag+"");
		//성공
		if(flag ==1) {
			message.setMsgMsg(user.getName()+"님이 등록 되었습니다.");
		//실패	
		}else {
			message.setMsgMsg(user.getName()+"님 등록 실패.");			
		}
		
		//JSON
		Gson gson = new Gson();
		String json = gson.toJson(message);
		LOG.debug("1.3===================");
		LOG.debug("1.3=json="+json); 
		LOG.debug("1.3===================");
		
		
		return json;
		}
	
	
}
