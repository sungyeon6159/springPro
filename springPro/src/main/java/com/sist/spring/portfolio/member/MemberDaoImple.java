/**
 * 
 */
package com.sist.spring.portfolio.member;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sist.spring.portfolio.DTO;

/**
 * @author sist
 *
 */
public class MemberDaoImple implements MemberDao {
	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberDaoImple() {}
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" INSERT INTO MEMBER ( 	\n");
		sb.append("     user_id,               \n");
		sb.append("     password,               \n");
		sb.append("     name,          		   \n");
		sb.append("     email,          	  \n");
		sb.append("     birthday,              \n");
		sb.append("     sexdstn,        	  \n");
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
				       ,inVO.getSexdstn()
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doDelete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
