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

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Dao;

/**
 * @author sist
 *
 */
public class MemberDao implements Dao {
	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	RowMapper<MemberVO> rowMapper = new RowMapper<MemberVO>() {

		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO outData=new MemberVO();
			outData.setMemberId(rs.getString("memberid"));
			outData.setPassword(rs.getString("password"));
			outData.setName(rs.getString("name"));
			outData.setEmail(rs.getString("email"));
			outData.setBirthday(rs.getString("birthday"));
			outData.setPhone(rs.getString("phone"));
			outData.setAuthority(rs.getString("authority"));
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
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" INSERT INTO MEMBER ( 	\n");
		sb.append("     memberid,               \n");
		sb.append("     password,               \n");
		sb.append("     name,          		   \n");
		sb.append("     email,          	  \n");
		sb.append("     birthday,              \n");
		sb.append("     phone,         		 \n");
		sb.append("     authority,          \n");
		sb.append("     open          \n");
		sb.append(" ) VALUES (              \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?                  \n");
		sb.append(" )                       \n");	
		//Query수행
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param=\n"+inVO.toString());
		Object[] args= {inVO.getMemberId()
				       ,inVO.getPassword()
				       ,inVO.getName()
				       ,inVO.getEmail()
				       ,inVO.getBirthday()
				       ,inVO.getPhone()
				       ,inVO.getAuthority()
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
		sb.append(" UPDATE hr_member         \n");
		sb.append(" SET password = ?,               \n");
		sb.append("     name = ?,          		   \n");
		sb.append("     email = ?,          	  \n");
		sb.append("     birthday = ?,              \n");
		sb.append("     phone = ?,         		 \n");
		sb.append("     authority = ?,          \n");
		sb.append("     open = ?          \n");
		sb.append(" WHERE                    \n");
		sb.append("     memberid = ?             \n");
		
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		Object[] args= {inVO.getPassword()
				      ,inVO.getName()
				      ,inVO.getEmail()
				      ,inVO.getBirthday()
				      ,inVO.getPhone()
				      ,inVO.getAuthority()
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
		sb.append(" SELECT                   \n");
		sb.append("     memberid,             \n");
		sb.append("     password,           \n");
		sb.append("     name,          		   \n");
		sb.append("     email,          	  \n");
		sb.append("     birthday,              \n");
		sb.append("     phone,         		 \n");
		sb.append("     authority,          \n");
		sb.append("     open          		\n");
		sb.append("     1 rnum,       \n"); 
		sb.append("     1 total_cnt   \n");
		sb.append(" FROM                      \n");
		sb.append("     member               \n");
		sb.append(" WHERE memberid = ?       \n");
		
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
		sb.append(" DELETE FROM hr_member \n");
		sb.append(" WHERE u_id = ?        \n");
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
		String test=null;
		return null;
		
	}

}
