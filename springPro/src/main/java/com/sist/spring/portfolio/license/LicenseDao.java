package com.sist.spring.portfolio.license;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Dao;
@Repository
public class LicenseDao implements Dao {
	
private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public LicenseDao() {}
	
	RowMapper<LicenseVO> rowMapper = new RowMapper<LicenseVO>() {

		@Override
		public LicenseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			LicenseVO outData = new LicenseVO();
			outData.setlName(rs.getString("l_name"));
			outData.setlGroup(rs.getString("l_group"));
			outData.setlGrade(rs.getString("l_grade"));
			outData.setlNum(rs.getString("l_num"));
			outData.setlOrgan(rs.getString("l_organ"));
			outData.setlDate(rs.getString("l_date"));
			outData.setMemberId(rs.getString("member_id"));
			
			return outData;
		}
	};
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		LicenseVO inVO = (LicenseVO)dto;
		StringBuilder sb=new StringBuilder();
 		sb.append("INSERT INTO License(                          \n");
		sb.append("		     l_name,                             \n");
		sb.append("		     l_group,                            \n");
		sb.append("		     l_grade,                            \n");
		sb.append("		     l_num,                              \n");
		sb.append("		     l_organ,                            \n");
		sb.append("		     l_date,                             \n");
		sb.append("		     member_id                           \n");
		sb.append(")VALUES(                                      \n");
		sb.append("		     ?,                                  \n");
		sb.append("		     ?,                                  \n");
		sb.append("		     ?,                                  \n");
		sb.append("		     ?,                                  \n");
		sb.append("		     ?,                                  \n");
		sb.append("		     ?,	  	    					     \n");
		sb.append("		     ?                                   \n");
		sb.append(")                                             \n");
		
		LOG.debug("========================================");
		LOG.debug("==============doInsert==================");
		LOG.debug("Query =\n"+sb.toString());
		LOG.debug("param = "+inVO.toString());
		
		Object[] args = {
							inVO.getlName(),
							inVO.getlGroup(),
							inVO.getlGrade(),
							inVO.getlNum(),
							inVO.getlOrgan(),
							inVO.getlDate(),
							inVO.getMemberId()
						};
		flag = this.jdbcTemplate.update(sb.toString(),args);
		LOG.debug("flag = "+flag);
		LOG.debug("========================================");		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		int flag = 0;
		LicenseVO inVO = (LicenseVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE License           \n");
		sb.append("SET l_group = ?          \n");
		sb.append("   ,l_grade = ?          \n");
		sb.append("   ,l_num = ?            \n");
		sb.append("   ,l_date = ?           \n");
		sb.append("   ,l_organ = ?          \n");
		sb.append("WHERE  member_id = ?     \n");
		sb.append("AND l_name=? 			\n");
		    
		//Query 수행
		LOG.debug("==================================");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO.toString());
		LOG.debug("==================================");
		
		Object[] args = {
						 inVO.getlGroup(),
						 inVO.getlGrade(),
						 inVO.getlNum(),
						 inVO.getlDate(),
						 inVO.getlOrgan(),
						 inVO.getMemberId(),
						 inVO.getlName()
		};
		
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("==================================");
		LOG.debug("flag ="+flag);
		LOG.debug("==================================");
		
		return flag;
	}
	

	@Override
	public DTO doSelectOne(DTO dto) {
		LicenseVO inVO = (LicenseVO)dto;
		LicenseVO outVO = new LicenseVO();
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT               \n");
		sb.append("    l_name,          \n");
		sb.append("    l_group,         \n");
		sb.append("    l_grade,         \n");
		sb.append("    l_num,           \n");
		sb.append("    l_date,          \n");
		sb.append("    l_organ,         \n");
		sb.append("    member_id        \n");
		sb.append("FROM                 \n");
		sb.append("    License          \n");
		sb.append("WHERE                \n");
		sb.append("    l_name=?         \n");
		sb.append("    AND member_id= ? \n");
		
		Object args[] = {
						  inVO.getlName(),
						  inVO.getMemberId()
						};
		
		outVO = this.jdbcTemplate.queryForObject(sb.toString(),
												 args,
												 rowMapper);
		LOG.debug("======================================");
		LOG.debug("===========doSelectOne===========");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO.getMemberId());
		LOG.debug("outVO ="+outVO);
		LOG.debug("======================================");
		return outVO;
	}

	//회원 탈퇴시
	@Override
	public int doDelete(DTO dto) {
		int flag=0;
		
		LicenseVO inVO=(LicenseVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM License       \n");
		sb.append("WHERE member_id=? 		 \n");
		
		LOG.debug("==================================");
		LOG.debug("============doDelete=============");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO);
		
		Object[] args = {inVO.getMemberId()};
		
		//jdbcTemplate.update(sql, args(가변배열))
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag ="+flag);
		LOG.debug("==================================");
		
		return flag;
	}
	
	//단순 자격내용 삭제
	public int doDeleteLicense(DTO dto) {
		int flag=0;
		
		LicenseVO inVO=(LicenseVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM License       \n");
		sb.append("WHERE member_id=? 		 \n");
		sb.append("AND l_name=?              \n");
		
		LOG.debug("==================================");
		LOG.debug("============doDelete=============");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO);
		
		Object[] args = {inVO.getMemberId(),
						 inVO.getlName()
						 };
		
		//jdbcTemplate.update(sql, args(가변배열))
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag ="+flag);
		LOG.debug("==================================");
		
		return flag;
	}
	
	@Override
	public List<?> doRetrieve(DTO dto) {
		//member_id로만 조회
		LicenseVO  inVO= (LicenseVO) dto;
		
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT                                    \n");
		sb.append("    l_name,                               \n");
		sb.append("    l_group,                              \n");
		sb.append("    l_grade,                              \n");
		sb.append("    l_num,                                \n");
		sb.append("    l_organ,                              \n");
		sb.append("    TO_CHAR(l_date,'YYYY/MM/DD') l_date,  \n");
		sb.append("    member_id                             \n");
		sb.append("FROM                                      \n");
		sb.append("    license                               \n");
		sb.append("WHERE member_id=?                         \n");
		
		
		//param 
		Object[] args = {inVO.getMemberId()};
		
		//LOG.debug("inVO= "+inVO.getSearchWord());
		
		//param set
		List<LicenseVO> licList = this.jdbcTemplate.query(sb.toString(), args, rowMapper);
		
		LOG.debug("==================================");
		LOG.debug("============doRetrieve============");
		LOG.debug("query \n"+sb.toString());
		LOG.debug("param: "+inVO);
		LOG.debug("==================================");
		
		return licList;
	}
}
