package com.sist.spring.portfolio.comment;

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
import com.sist.spring.portfolio.license.LicenseVO;

public class CommentDao implements Dao {
	
private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CommentDao() {}
	
	
	RowMapper<CommentVO> rowMapper = new RowMapper<CommentVO>() {

		@Override
		public CommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentVO outData = new CommentVO();
			outData.setMemberId(rs.getString("memberId"));
			outData.setRegId(rs.getString("regId"));
			outData.setModId(rs.getString("modId"));
			outData.setRegDt(rs.getString("regDt"));
			outData.setModDt(rs.getString("modDt"));
			outData.setcommentNo(rs.getString("commentNo"));
			outData.setOpen(rs.getString("open"));
			outData.setContent(rs.getString("content"));
			
			return outData;
		}
	};

	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		CommentVO inVO = (CommentVO)dto;
		StringBuilder sb=new StringBuilder();
		sb.append("INSERT INTO Comment(  \n");
		sb.append("		     memberId,      \n");
		sb.append("		     regId,     \n");
		sb.append("		     modId,     \n");
		sb.append("		     regDt,      \n");
		sb.append("		     modDt,       \n");
		sb.append("		     commentNo,     \n");
		sb.append("		     open,       \n");
		sb.append("		     content,     \n");
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
							inVO.getMemberId(),
							inVO.getRegId(),
							inVO.getModId(),
							inVO.getRegDt(),
							inVO.getModDt(),
							inVO.getcommentNo(),
							inVO.getOpen(),
							inVO.getContent()
						};
		flag = this.jdbcTemplate.update(sb.toString(),args);
		LOG.debug("flag = "+flag);
		LOG.debug("========================================");		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		int flag=0;
		CommentVO inVO=(CommentVO)dto;
		StringBuilder sb=new StringBuilder();
		
		
		sb.append("UPDATE COMMENT       ");
		sb.append("SET                  ");
		sb.append("    modId = ?    ");
		sb.append("    ,modDt = ?    ");
		sb.append("    ,open = ?");
		sb.append("    ,content = ?   ");
		
		sb.append("WHERE                ");
		sb.append("    commentNo = ?     ");
		LOG.debug("==============================");
		LOG.debug("=Query=\n"+sb.toString());
		LOG.debug("=Param= "+inVO.toString());
		
		
		Object[] args= {inVO.getModId()
						,inVO.getModDt()
						,inVO.getOpen()
						,inVO.getContent()
						,inVO.getcommentNo()
						
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
		sb.append("		     memberId,      \n");
		sb.append("		     regId,     \n");
		sb.append("		     modId,     \n");
		sb.append("		     regDt,      \n");
		sb.append("		     modDt,       \n");
		sb.append("		     commentNo,     \n");
		sb.append("		     open,       \n");
		sb.append("		     content,     \n");
		sb.append("FROM                 ");
		sb.append("    Comment          ");
		sb.append("WHERE                ");
		sb.append("    commentNo=?          ");
		
		
		Object args[] = {
						  inVO.getcommentNo()
						};
		
		outVO = this.jdbcTemplate.queryForObject(sb.toString(),
												 args,
												 rowMapper);
		LOG.debug("======================================");
		LOG.debug("===========doSelectOne===========");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO.getRegId());
		LOG.debug("outVO ="+outVO);
		LOG.debug("======================================");
		return outVO;
	}

	@Override
	public int doDelete(DTO dto) {
		int flag=0;
		
		CommentVO inVO=(CommentVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM Comment   \n");
		sb.append("WHERE commentNo=? 		 \n");
		
		LOG.debug("==================================");
		LOG.debug("============doDelete=============");
		LOG.debug("QEURY =\n"+sb.toString());
		LOG.debug("Param ="+inVO);
		
		Object[] args = {inVO.getcommentNo()};
		
		//jdbcTemplate.update(sql, args(가변배열))
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag ="+flag);
		LOG.debug("==================================");
		
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO  inVO= (SearchVO) dto;

		StringBuilder sb=new StringBuilder();
		sb.append("SELECT T1.*,T2.*                                                \n");
		sb.append("FROM(                                                           \n");
		sb.append("    SELECT  B.memberId,                                            \n");
		sb.append("            B.regId,                                           \n");
		sb.append("            B.modId,                                            \n");
		sb.append("            B.regDt,                                             \n");
		sb.append("            B.modDt,                                           \n");
		sb.append("            B.commentNo,                  \n");
		sb.append("            B.open,                                           \n");
		sb.append("            B.content,                                           \n");
		sb.append("            rnum                                                \n");		
		sb.append("    FROM(                                                       \n");
		sb.append("        SELECT ROWNUM rnum,                                     \n");
		sb.append("               A.*                                              \n");
		sb.append("        FROM (                                                  \n");
		sb.append("            SELECT *                                            \n");
		sb.append("            FROM Comment                                        \n");
		sb.append("		   WHERE content like '%' || ? ||'%'  					   \n");
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
		sb.append("		   WHERE content like '%' || ? ||'%'  					   \n");
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
		List<CommentVO> retlist = this.jdbcTemplate.query(sb.toString(), listArg.toArray(), rowMapper);
		LOG.debug("==================================");
		LOG.debug("============doRetrieve============");
		LOG.debug("query \n"+sb.toString());
		LOG.debug("param: "+listArg);
		LOG.debug("==================================");
		return retlist;
	
	}



}
