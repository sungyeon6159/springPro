package com.sist.spring.portfolio.skill;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestSkillDao {
	private final Logger  LOG = LoggerFactory.getLogger(TestSkillDao.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;

	SkillVO skill01;
	SkillVO skill02;
	SkillVO skill03;
	SkillVO skill04;
	
	@Autowired
	SkillDaoImple  dao;
	
	@Test
	public void doRetrieve() {
		//1.전체 삭제
		//2.추가:3건
		//3.목록조회:3건
//		
//		dao.doDeleteAll();	
//		
//		int flag = dao.doInsert(skill01);
//		flag += dao.doInsert(skill02);
//		flag += dao.doInsert(skill03);
//		flag += dao.doInsert(skill04);
//		assertThat(flag, is(4));
		
		SkillVO  searchVO=new SkillVO("",	"j_hr001",	20	,"");
		List<SkillVO> list =   (List<SkillVO>) dao.doRetrieve(searchVO);
		
		assertThat(list.size(), is(2));
		for(SkillVO vo: list) {
			LOG.debug(vo.toString());
		}
				
	}
	
	@Test
	@Ignore
	public void doInsert() {
		
		//1. 삭제	
		dao.doDeleteAll();
		
		//2. 입력
		int flag = dao.doInsert(skill01);
		flag += dao.doInsert(skill02);
		flag += dao.doInsert(skill03);
		flag += dao.doInsert(skill04);
		LOG.debug("--------------");
		LOG.debug("flag:"+flag);
		LOG.debug("--------------");
		assertThat(flag, is(4));
		
		//3.단건조회:skill02		
		SkillVO vsVO = (SkillVO) dao.doSelectOne(skill02);
		LOG.debug("--------------");
		LOG.debug("vsVO:"+vsVO);
		LOG.debug("--------------");		
		
	
	}
	
	@Test
	@Ignore
	public void addAndGet() {
		//1.전체 삭제		
		//2.추가		
		//3.단건조회		
		//4.수정		
		//5.비교
		
		//1.전체 삭제		
		dao.doDeleteAll();
		
		//2.추가:4건		
		//2. 입력
		int flag = dao.doInsert(skill01);
		flag += dao.doInsert(skill02);
		flag += dao.doInsert(skill03);
		flag += dao.doInsert(skill04);
		LOG.debug("--------------");
		LOG.debug("flag:"+flag);
		LOG.debug("--------------");
		assertThat(flag, is(4));
		
		//3.단건조회:skill02		
		SkillVO vsVO = (SkillVO) dao.doSelectOne(skill02);
		LOG.debug("--------------");
		LOG.debug("vsVO:"+vsVO);
		LOG.debug("--------------");		
		
		//4.수정		
		vsVO.setsMarstery(vsVO.getsMarstery()+1);
		vsVO.setsContent(vsVO.getsContent()+"_U");
		
		//4.1 수정
		flag = dao.doUpdate(vsVO);
		assertThat(flag, is(1));
		
		//4.2.단건조회
		SkillVO orgVO = (SkillVO) dao.doSelectOne(vsVO);
		
		//5.비교
//		this.checkSameUser(orgVO, vsVO);
	}
	
	
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^WebApplicationContext^"+webApplicationContext);
		LOG.debug("^^^^^^^^^^^");
		skill01 = new SkillVO("Oracle",	"j_hr001",	90	,"내용001");   
		skill02 = new SkillVO("JAVA",	"j_hr002",	80	,"내용002");   
		skill03 = new SkillVO("CSS",	"j_hr003",	50	,"내용003"); 
		
		skill04 = new SkillVO("Spring",	"j_hr001",	70	,"내용004"); 
				
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^tearDown^");
		LOG.debug("^^^^^^^^^^^");	
	}

	@Test
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=dao()="+dao);
		LOG.debug("=====================");		
		
		assertNotNull(dao);
		assertThat(1, is(1));
	}

}
