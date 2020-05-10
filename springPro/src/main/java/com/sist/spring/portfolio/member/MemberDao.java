/**
 * 
 */
package com.sist.spring.portfolio.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Dao;
import com.sist.spring.cmn.SearchVO;

/**
 * @author sist
 *
 */
@Repository
public class MemberDao implements Dao {
	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	RowMapper<MemberVO> rowMapper = new RowMapper<MemberVO>() {

		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO outData=new MemberVO();
			outData.setMemberId(rs.getString("member_id"));
			outData.setPassword(rs.getString("password"));
			outData.setName(rs.getString("name"));
			outData.setEmail(rs.getString("email"));
			outData.setBirth(rs.getString("birth"));
			outData.setPhone(rs.getString("phone"));
			outData.setAuthority(rs.getString("authority"));
			outData.setInterestOption(rs.getString("interestOption"));
			outData.setOpen(rs.getString("open"));
			outData.setNum(rs.getInt("rnum"));
			outData.setTotalCnt(rs.getInt("total_cnt"));
			return outData;
		}

	};
	
	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao() {}
	
	public DTO doLogin(DTO dto) {
		MemberVO inVO=(MemberVO)dto;
		StringBuilder sb=new StringBuilder();
		
		sb.append("SELECT                \n");
		sb.append("    member_id,        \n");
		sb.append("    password,         \n");
		sb.append("    name,             \n");
		sb.append("    email,            \n");
		sb.append("    birth,            \n");
		sb.append("    phone,            \n");
		sb.append("    authority,        \n");
		sb.append("    interestoption,   \n");
		sb.append("    open,              \n");
		sb.append("    1 rnum,            \n");
		sb.append("    1 total_cnt        \n");
		sb.append("FROM                  \n");
		sb.append("    member            \n");
		sb.append("WHERE                 \n");
		sb.append("    member_id=?       \n");
		sb.append("	AND password=?		\n");	
		Object[]args= {inVO.getMemberId(),
						inVO.getPassword()};
		
		MemberVO outVO = this.jdbcTemplate.queryForObject(sb.toString()
				,args
				,rowMapper); 
		LOG.debug("=outVO=\n"+outVO);
		LOG.debug("==============================");
		
		return outVO;
		
	}
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" INSERT INTO MEMBER ( 			\n");
		sb.append("     member_id,               	\n");
		sb.append("     password,               	\n");
		sb.append("     name,          		   		\n");
		sb.append("     email,          	  		\n");
		sb.append("     birth,              		\n");
		sb.append("     phone,         		 		\n");
		sb.append("     authority,          		\n");
		sb.append("     interestOption,          	\n");
		sb.append("     open          				\n");
		sb.append(" ) VALUES (              		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?,                  		\n");
		sb.append("     ?                  			\n");
		sb.append(" )                       		\n");	
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.toString());
		Object[] args= {inVO.getMemberId()
				       ,inVO.getPassword()
				       ,inVO.getName()
				       ,inVO.getEmail()
				       ,inVO.getBirth()
				       ,inVO.getPhone()
				       ,inVO.getAuthority()
				       ,inVO.getInterestOption()
				       ,inVO.getOpen()
		};
		flag = this.jdbcTemplate.update(sb.toString(), args);
		
		
		LOG.debug("==============================");
		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;
		StringBuilder sb=new StringBuilder();
		sb.append(" UPDATE hr_member         		\n");
		sb.append(" SET password = ?,               \n");
		sb.append("     name = ?,          		   	\n");
		sb.append("     email = ?,          	  	\n");
		sb.append("     birth = ?,              	\n");
		sb.append("     phone = ?,         		 	\n");
		sb.append("     authority = ?,          	\n");
		sb.append("     interestOption = ?,         \n");
		sb.append("     open = ?          			\n");
		sb.append(" WHERE                    		\n");
		sb.append("     member_id = ?             	\n");
		
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		Object[] args= {inVO.getPassword()
				      ,inVO.getName()
				      ,inVO.getEmail()
				      ,inVO.getBirth()
				      ,inVO.getPhone()
				      ,inVO.getAuthority()
				      ,inVO.getInterestOption()
				      ,inVO.getOpen()
				      ,inVO.getMemberId()};
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag= "+flag);
		LOG.debug("==============================");
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		MemberVO outVO = null;        //return UserVO
		MemberVO inVO  = (MemberVO) dto;//Param UserVO
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT                   	\n");
		sb.append("     member_id,             	\n");
		sb.append("     password,           	\n");
		sb.append("     name,          		   	\n");
		sb.append("     email,          	  	\n");
		sb.append("     birth,              	\n");
		sb.append("     phone,         		 	\n");
		sb.append("     authority,          	\n");
		sb.append("     interestOption,         \n");
		sb.append("     open,          			\n");
		sb.append("     1 rnum,       			\n"); 
		sb.append("     1 total_cnt  		 	\n");
		sb.append(" FROM                      	\n");
		sb.append("     member               	\n");
		sb.append(" WHERE member_id = ?       	\n");
		
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.getMemberId());
		
		Object []args = {inVO.getMemberId()};
		outVO = this.jdbcTemplate.queryForObject(sb.toString()
				,args
				,rowMapper); 
		LOG.debug("=outVO=\n"+outVO);
		LOG.debug("==============================");
		
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;
		StringBuilder  sb=new StringBuilder();
		sb.append(" DELETE FROM hr_member 		\n");
		sb.append(" WHERE member_id = ?        	\n");
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param="+inVO);
		
		Object[] args = {inVO.getMemberId()};
		flag = jdbcTemplate.update(sb.toString(), args);
		
		LOG.debug("=flag="+flag);		
		LOG.debug("==============================");	
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO  inVO= (SearchVO) dto;
		//검색구분
		  //ID : 10
		  //이름: 20
		//검색어
		StringBuilder whereSb=new StringBuilder();
		
		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
			if(inVO.getSearchDiv().equals("10")) {
				whereSb.append("WHERE u_id like '%' || ? ||'%'   \n");
			}else if(inVO.getSearchDiv().equals("20")) {
				whereSb.append("WHERE name like '%' || ? ||'%'   \n");
			}
		}
		
		
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT T1.*,T2.*                                              \n");
		sb.append("FROM(                                                         \n");
		sb.append("    SELECT  B.member_id,                                      \n");
		sb.append("            B.password,                                       \n");
		sb.append("            B.name,                                           \n");
		sb.append("            B.email,                                          \n");
		sb.append("            B.birth,                                          \n");
		sb.append("            B.phone,                                     	 \n");
		sb.append("            B.authority,                                      \n");
		sb.append("            B.interestOption,                                 \n");
		sb.append("            B.open,          								 \n");
		sb.append("            rnum                                              \n");		
		sb.append("    FROM(                                                     \n");
		sb.append("        SELECT ROWNUM rnum,                                   \n");
		sb.append("               A.*                                            \n");
		sb.append("        FROM (                                                \n");
		sb.append("            SELECT *                                          \n");
		sb.append("            FROM member                                    	 \n");
		//sb.append("            ORDER BY reg_dt DESC                              \n");
		sb.append("            --검색조건                                                                           \n");
		//--검색----------------------------------------------------------------------
		sb.append(whereSb.toString());
		//--검색----------------------------------------------------------------------				
		sb.append("        )A --10                                               \n");
		//sb.append("        WHERE ROWNUM <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE) \n");
		sb.append("        WHERE ROWNUM <= (?*(?-1)+?) 							 \n");
		sb.append("    )B --1                                                    \n");
		//sb.append("    WHERE B.RNUM >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)              \n");
		sb.append("    WHERE B.RNUM >= (?*(?-1)+1)              				 \n");
		sb.append("    )T1 CROSS JOIN                                            \n");
		sb.append("    (                                                         \n");
		sb.append("    SELECT count(*) total_cnt                                 \n");
		sb.append("    FROM member                                            	 \n");
		sb.append("    --검색조건                                                  						 \n");
		//--검색----------------------------------------------------------------------
		sb.append(whereSb.toString()); 
		//--검색----------------------------------------------------------------------
		sb.append("    )T2                                                       \n");

		//param 
		List<Object> listArg = new ArrayList<Object>();
		
		
		//param set
		if(null !=inVO && !"".equals(inVO.getSearchDiv())) {
			listArg.add(inVO.getSearchWord());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());
			listArg.add(inVO.getSearchWord());
		}else {
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageSize());
			listArg.add(inVO.getPageNum());			
		}
		
		List<MemberVO> retList = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
		LOG.debug("query \n"+sb.toString());
		LOG.debug("param:"+listArg);
		return retList;
	}

	
	
}
