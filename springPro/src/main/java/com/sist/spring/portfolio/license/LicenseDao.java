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
import org.springframework.stereotype.Repository;

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Dao;
import com.sist.spring.cmn.SearchVO;
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
			outData.setlName(rs.getString("lName"));
			outData.setlGroup(rs.getString("lGroup"));
			outData.setlGrade(rs.getString("lGrade"));
			outData.setlNum(rs.getString("lNum"));
			outData.setlDate(rs.getString("lDate"));
			outData.setlOrgan(rs.getString("lOrgan"));
			outData.setMemberId(rs.getString("memberId"));
			
			return outData;
		}
	};
	
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		LicenseVO inVO = (LicenseVO)dto;
		StringBuilder sb=new StringBuilder();
		sb.append("INSERT INTO License(   \n");
		sb.append("		     l_name,      \n");
		sb.append("		     l_group,     \n");
		sb.append("		     l_grade,     \n");
		sb.append("		     l_num,       \n");
		sb.append("		     l_date       \n");
		sb.append("		     l_organ,     \n");
		sb.append("		     member_id,   \n");
		sb.append(")VALUES(               \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?,           \n");
		sb.append("		     ?            \n");
		sb.append(")                      \n");
		
		LOG.debug("========================================");
		LOG.debug("==============doInsert==================");
		LOG.debug("Query =\n"+sb.toString());
		LOG.debug("param = "+inVO.toString());
		
		Object[] args = {
							inVO.getlName(),
							inVO.getlGroup(),
							inVO.getlGrade(),
							inVO.getlNum(),
							inVO.getlDate(),
							inVO.getlOrgan(),
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
		sb.append("ANE l_name=? 			\n");
		    
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
		sb.append("    member_id,       \n");
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
		sb.append("DELETE FROM License   \n");
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
		SearchVO  inVO= (SearchVO) dto;

		StringBuilder sb=new StringBuilder();
		sb.append("SELECT T1.*,T2.*                                                \n");
		sb.append("FROM(                                                           \n");
		sb.append("    SELECT  B.l_name,                                           \n");
		sb.append("            B.l_group,                                          \n");
		sb.append("            B.l_grade,                                          \n");
		sb.append("            B.l_num,                                            \n");
		sb.append("            TO_CHAR(B.lGet,'YYYY/MM/DD') l_date,                \n");
		sb.append("            B.member_id,                                        \n");
		sb.append("            B.l_organ,                                          \n");
		sb.append("            rnum                                                \n");		
		sb.append("    FROM(                                                       \n");
		sb.append("        SELECT ROWNUM rnum,                                     \n");
		sb.append("               A.*                                              \n");
		sb.append("        FROM (                                                  \n");
		sb.append("            SELECT *                                            \n");
		sb.append("            FROM license                                        \n");
		sb.append("		   WHERE member_id like '%' || ? ||'%'  				   \n");
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
		sb.append("		   WHERE member_id like '%' || ? ||'%'  				   \n");
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
