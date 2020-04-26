package com.sist.spring.portfolio.license;

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
import com.sist.spring.cmn.SearchVO;

public class LicenseDao implements Dao {
	
private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public LicenseDao() {}
	
	RowMapper<LicenseVO> rowMapper = new RowMapper<LicenseVO>() {

		@Override
		public LicenseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			LicenseVO outData = new LicenseVO();
			outData.setlName(rs.getString("lNname"));
			outData.setlGroup(rs.getString("lGroup"));
			outData.setlKind(rs.getString("lKind"));
			outData.setlNum(rs.getString("lNum"));
			outData.setlLevel(rs.getString("lLevel"));
			outData.setlGet(rs.getString("lGet"));
			outData.setlOrgan(rs.getString("lOrgan"));
			outData.setUserId(rs.getString("userId"));
			
			return outData;
		}
	};
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		LicenseVO inVO = (LicenseVO)dto;
		StringBuilder sb=new StringBuilder();
		sb.append("INSERT INTO License(  \n");
		sb.append("		     lname,      \n");
		sb.append("		     lOrgan,     \n");
		sb.append("		     lGroup,     \n");
		sb.append("		     lKind,      \n");
		sb.append("		     lNum,       \n");
		sb.append("		     lLevel,     \n");
		sb.append("		     lGet,       \n");
		sb.append("		     userId,     \n");
		sb.append(")VALUES(              \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?,          \n");
		sb.append("		     ?           \n");
		sb.append(")                     \n");
		
		LOG.debug("========================================");
		LOG.debug("==============doInsert==================");
		LOG.debug("Query =\n"+sb.toString());
		LOG.debug("param = "+inVO.toString());
		
		Object[] args = {
							inVO.getlName(),
							inVO.getlGroup(),
							inVO.getlKind(),
							inVO.getlNum(),
							inVO.getlLevel(),
							inVO.getlGet(),
							inVO.getlOrgan(),
							inVO.getUserId()
						};
		flag = this.jdbcTemplate.update(sb.toString(),args);
		LOG.debug("flag = "+flag);
		LOG.debug("========================================");		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		LicenseVO inVO = (LicenseVO)dto;
		LicenseVO outVO = new LicenseVO();
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT               ");
		sb.append("    lname,           ");
		sb.append("    lOrgan,          ");
		sb.append("    lGroup,          ");
		sb.append("    lKind,           ");
		sb.append("    lNum,            ");
		sb.append("    lLevel,          ");
		sb.append("    lGet,            ");
		sb.append("    userId,          ");
		sb.append("FROM                 ");
		sb.append("    License          ");
		sb.append("WHERE                ");
		sb.append("    lname=?          ");
		sb.append("    AND userId= ?    ");
		
		Object args[] = {
						  inVO.getlName(),
						  inVO.getUserId()
						};
		
		outVO = this.jdbcTemplate.queryForObject(sb.toString(),
												 args,
												 rowMapper);
		LOG.debug("======================================");
		LOG.debug("===========doSelectOne===========");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO.getUserId());
		LOG.debug("outVO ="+outVO);
		LOG.debug("======================================");
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		int flag=0;
		
		LicenseVO inVO=(LicenseVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM License   \n");
		sb.append("WHERE userId=? 		 \n");
		
		LOG.debug("==================================");
		LOG.debug("============doDelete=============");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO);
		
		Object[] args = {inVO.getUserId()};
		
		//jdbcTemplate.update(sql, args(가변배열))
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag ="+flag);
		LOG.debug("==================================");
		
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		//userId로만 조회
		SearchVO  inVO= (SearchVO) dto;

		StringBuilder sb=new StringBuilder();
		sb.append("SELECT T1.*,T2.*                                                \n");
		sb.append("FROM(                                                           \n");
		sb.append("    SELECT  B.lname,                                            \n");
		sb.append("            B.lGroup,                                           \n");
		sb.append("            B.lKind,                                            \n");
		sb.append("            B.lNum,                                             \n");
		sb.append("            B.lLevel,                                           \n");
		sb.append("            TO_CHAR(B.lGet,'YYYY/MM/DD') lGet,                  \n");
		sb.append("            B.userId,                                           \n");
		sb.append("            B.lOrgan,                                           \n");
		sb.append("            rnum                                                \n");		
		sb.append("    FROM(                                                       \n");
		sb.append("        SELECT ROWNUM rnum,                                     \n");
		sb.append("               A.*                                              \n");
		sb.append("        FROM (                                                  \n");
		sb.append("            SELECT *                                            \n");
		sb.append("            FROM license                                        \n");
		sb.append("		   WHERE userId like '%' || ? ||'%'  					   \n");
		sb.append("        )A --10                                                 \n");
		//sb.append("        WHERE ROWNUM <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE) \n");
		sb.append("        WHERE ROWNUM <= (?*(?-1)+?) \n");
		sb.append("    )B --1                                                      \n");
		//sb.append("    WHERE B.RNUM >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)              \n");
		sb.append("    WHERE B.RNUM >= (?*(?-1)+1)              				   \n");
		sb.append("    )T1 CROSS JOIN                                              \n");
		sb.append("    (                                                           \n");
		sb.append("    SELECT count(*) total_cnt                                   \n");
		sb.append("    FROM license                                                \n");
		sb.append("		   WHERE userId like '%' || ? ||'%'  					   \n");
		sb.append("    )T2                                                         \n");
		
		//param 
		List<Object> listArg = new ArrayList<Object>();
		listArg.add(inVO.getSearchWord());
//		listArg.add(inVO.getPageSize());
//		listArg.add(inVO.getPageNum());
//		listArg.add(inVO.getPageSize());
//		listArg.add(inVO.getPageSize());
//		listArg.add(inVO.getPageNum());				
		listArg.add(inVO.getSearchWord());
		
		//param set
		List<LicenseVO> retlist = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
		LOG.debug("==================================");
		LOG.debug("============doRetrieve============");
		LOG.debug("query \n"+sb.toString());
		LOG.debug("param: "+listArg);
		LOG.debug("==================================");
		return retlist;
	
	}

	

}
