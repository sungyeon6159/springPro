package com.sist.spring.portfolio.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
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
public class CommentDao implements Dao {
	
private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	private final String NAMESPACE= "com.sist.spring.portfolio.comment";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	
	public CommentDao() {}
	
	
	RowMapper<CommentVO> rowMapper = new RowMapper<CommentVO>() {

		@Override
		public CommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentVO outData = new CommentVO();
			outData.setcNo(rs.getInt("c_No"));
			outData.setcContent(rs.getString("c_Cont"));
			outData.setRegDt(rs.getString("reg_Dt"));
			outData.setModDt(rs.getString("mod_Dt"));
			outData.setRegId(rs.getString("reg_Id"));
			outData.setPortfolioId(rs.getString("portfolio_Id"));
			
			return outData;
		}
	};

	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		CommentVO inVO = (CommentVO)dto;

		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");

		// namespace+id = com.sist.ehr.user.doInsert
		String statement = NAMESPACE+".doInsert";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");

		flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");

		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		int flag=0;
		CommentVO inVO=(CommentVO)dto;
		StringBuilder sb=new StringBuilder();
		
		
		sb.append("UPDATE COMMENTS       ");
		sb.append("SET                  ");
		sb.append("    reg_dt =  TO_CHAR(SYSDATE, 'YYYY/MM/DD')    ");
		sb.append("    ,c_cont = ?   ");
		
		sb.append("WHERE                ");
		sb.append("    c_no = ?     ");
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		
		
		Object[] args= {inVO.getcContent()
						,inVO.getcNo()
						
					};
		flag=this.jdbcTemplate.update(sb.toString(),args);
		LOG.debug("==============================");
		LOG.debug("=flag: "+flag);
		LOG.debug("==============================");
		
		return flag;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		CommentVO inVO = (CommentVO)dto;
		CommentVO outVO = new CommentVO();
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT               ");
		sb.append("		     c_no,      \n");
		sb.append("		     c_cont,     \n");
		sb.append("		     reg_dt,     \n");
		sb.append("		     mod_dt,     \n");
		sb.append("		     reg_id,     \n");
		sb.append("		     portfolio_Id     \n");
		sb.append("FROM                 ");
		sb.append("    Comments          ");
		sb.append("WHERE                ");
		sb.append("    portfolio_Id=?          ");
		sb.append("AND 	reg_id=?          ");
		
		
		Object args[] = {
						  inVO.getPortfolioId(),
						  inVO.getRegId()
						};
		
		outVO = this.jdbcTemplate.queryForObject(sb.toString(),
												 args,
												 rowMapper);
		LOG.debug("======================================");
		LOG.debug("===========doSelectOne===========");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO.getcNo());
		LOG.debug("outVO ="+outVO);
		LOG.debug("======================================");
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		int flag=0;
		CommentVO inVO=(CommentVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");

		// namespace+id = com.sist.ehr.user.doInsert
		String statement = NAMESPACE+".doDelete";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");

		flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");

		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO  inVO= (SearchVO) dto;

		StringBuilder sb=new StringBuilder();
		sb.append("SELECT T1.*,T2.*                                                \n");
		sb.append("FROM(                                                           \n");
		sb.append("    SELECT  B.c_no 	C_NO,                                        \n");
		sb.append("            B.c_cont C_CONT,                                    \n");
		sb.append("            CASE TO_CHAR(B.REG_DT,'YYYY/MM/DD') WHEN TO_CHAR(SYSDATE,'YYYY/MM/DD')  \n");
		sb.append("                                                THEN TO_CHAR(SYSDATE,'HH24:MI')     \n");
		sb.append("            ELSE TO_CHAR(B.REG_DT,'YYYY/MM/DD') END reg_dt,                          \n");
		sb.append("            B.mod_dt MOD_DT,       							   \n");
		sb.append("		       B.reg_id REG_ID,    									\n");
		sb.append("            B.portfolio_Id PORTFOLIO_ID                          \n");
		sb.append("    FROM(                                                       \n");
		sb.append("        SELECT ROWNUM rnum,                                     \n");
		sb.append("               A.*                                              \n");
		sb.append("        FROM (                                                  \n");
		sb.append("            SELECT *                                            \n");
		sb.append("            FROM Comments                                       \n");
		sb.append("		   WHERE portfolio_Id like '%' || ? ||'%'  				   \n");
		sb.append("        )A --10                                                 \n");
		//sb.append("        WHERE ROWNUM <= (&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE) \n");
		sb.append("        WHERE ROWNUM <= (?*(?-1)+?) 							   \n");
		sb.append("    )B --1                                                      \n");
		//sb.append("    WHERE B.RNUM >= (&PAGE_SIZE*(&PAGE_NUM-1)+1)              \n");
		sb.append("    WHERE B.RNUM >= (?*(?-1)+1)              				   \n");
		sb.append("    )T1 CROSS JOIN                                              \n");
		sb.append("    (                                                           \n");
		sb.append("    SELECT count(*) total_cnt                                   \n");
		sb.append("    FROM Comments                                               \n");
		sb.append("		   WHERE portfolio_Id like '%' || ? ||'%'  				   \n");
		//sb.append("		   WHERE portfolio_Id like '%' || ? ||'%'  				   \n");
		sb.append("    )T2                                                         \n");
		
		//param 
		List<Object> listArg = new ArrayList<Object>();
		listArg.add(inVO.getSearchWord());
		listArg.add(inVO.getPageSize());
		listArg.add(inVO.getPageNum());
		listArg.add(inVO.getPageSize());
		listArg.add(inVO.getPageSize());
		listArg.add(inVO.getPageNum());				
		listArg.add(inVO.getSearchWord());
		
		//param set
		List<CommentVO> retlist = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
		LOG.debug("==================================");
		LOG.debug("============doRetrieve============");
		LOG.debug("query \n"+sb.toString());
		LOG.debug("param: "+listArg);
		LOG.debug("==================================");
		return retlist;
	
	}



}
