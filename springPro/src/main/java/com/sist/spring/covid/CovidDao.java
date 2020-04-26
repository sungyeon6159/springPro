package com.sist.spring.covid;

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
public class CovidDao implements Dao {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public CovidDao() {}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<RxJoinVO> rowMapper = new RowMapper<RxJoinVO>() {
		
		@Override
		public RxJoinVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			RxJoinVO outData = new RxJoinVO();
			outData.setUserId(rs.getString("user_id"));
			outData.setCode(rs.getString("code"));
			outData.setName(rs.getString("name"));
			outData.setAddr(rs.getString("addr"));
			outData.setLng(rs.getInt("lng"));
			outData.setLat(rs.getInt("lat"));
			outData.setEmail(rs.getString("email"));
			
			
			return outData;
		}
	};
	
	
	
	
	/**
	 * Covid User 회원등록
	 */
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		CovidUserVO inVO =(CovidUserVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO covid_user (	\n");
		sb.append("    user_id,             \n");
		sb.append("    password,            \n");
		sb.append("    email,               \n");
		sb.append("    mobile_phone         \n");
		sb.append(") VALUES (               \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?                    \n");
		sb.append(")                        \n");
		
		LOG.debug("=====================");
		LOG.debug("Query:" + sb.toString());
		LOG.debug("Param:" + inVO.toString());
		LOG.debug("=====================");
		
		Object[] args = {inVO.getUserId(),
				inVO.getPassWord(),
				inVO.getEmail(),
				inVO.getMobilePhone()
		};
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		return flag;
	}
	
	/**
	 * 개인의 관심약국 등록 등록(회원가입 후 가능)
	 * @param dto
	 * @return
	 */
	public int doRxInsert(DTO dto) {
		int flag = 0;
		CovidParmVO inVO = (CovidParmVO) dto;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO pharmacy (	\n");
		sb.append("    user_id,             \n");
		sb.append("    name,                \n");
		sb.append("    addr,                \n");
		sb.append("    lng,                 \n");
		sb.append("    lat,                 \n");
		sb.append("    code                 \n");
		sb.append(") VALUES (               \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("	   ?                    \n");
		sb.append(")                        \n");
		
		LOG.debug("=====================");
		LOG.debug("Query:" + sb.toString());
		LOG.debug("Param:" + inVO.toString());
		LOG.debug("=====================");
		
		Object[] args = {inVO.getUserId(),
						inVO.getName(),
						inVO.getAddr(),
						inVO.getLng(),
						inVO.getLat(),
						inVO.getCode()
		};
		flag = jdbcTemplate.update(sb.toString(), args);
		
		return flag;
	}

	
	/**
	 * 개인 관심약국 수정(다른 약국 클릭시 팝업뜬 후 Update 수행)
	 */
	@Override
	public int doUpdate(DTO dto) {
		int flag = 0;
		CovidParmVO inVO = (CovidParmVO) dto;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE pharmacy	\n");
		sb.append("SET code = ?,    \n");
		sb.append("    name = ?,    \n");
		sb.append("    addr = ?,    \n");
		sb.append("    lng = ?,     \n");
		sb.append("    lat = ?      \n");
		sb.append("WHERE            \n");
		sb.append("    user_id = ?  \n");
		
		LOG.debug("=====================");
		LOG.debug("Query:" + sb.toString());
		LOG.debug("Param:" + inVO.toString());
		LOG.debug("=====================");
		
		Object[] args = {inVO.getCode(),
						inVO.getName(),
						inVO.getAddr(),
						inVO.getLng(),
						inVO.getLat(),
						inVO.getUserId()
		};
		flag = jdbcTemplate.update(sb.toString(), args);
		
		return flag;
	}
	
	/**
	 * 개인 관심약국 조회(email정보 필요하므로 join 필요)
	 */
	@Override
	public DTO doSelectOne(DTO dto) {
		RxJoinVO outVO = null;
		RxJoinVO inVO = (RxJoinVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.user_id,					\n");
		sb.append("       t1.code,                      \n");
		sb.append("       t1.name,                      \n");
		sb.append("       t1.addr,                      \n");
		sb.append("       t1.lng,                       \n");
		sb.append("       t1.lat,                       \n");
		sb.append("       t2.email                      \n");
		sb.append("FROM pharmacy t1, COVID_USER t2      \n");
		sb.append("WHERE t1.user_id = t2.user_id        \n");
		sb.append("AND t1.user_id = ?                   \n");
		
		LOG.debug("=====================");
		LOG.debug("Query:" + sb.toString());
		LOG.debug("Param:" + inVO.toString());
		LOG.debug("=====================");
		
		Object[] args = {inVO.getUserId()};
		
		outVO = this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);
		
		LOG.debug("outVO:" + outVO);
		LOG.debug("=====================");
		
		return outVO;
	}
	
	/**
	 * 관심약국 여러개 선택 시 리스트 출력 - 나중에 사용할 가능성 있음(보류?)
	 */
	@Override
	public List<?> doRetrieve(DTO dto) {
		RxJoinVO inVO = (RxJoinVO) dto;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t1.user_id,					\n");
		sb.append("       t1.code,                      \n");
		sb.append("       t1.name,                      \n");
		sb.append("       t1.addr,                      \n");
		sb.append("       t1.lng,                       \n");
		sb.append("       t1.lat,                       \n");
		sb.append("       t2.email                      \n");
		sb.append("FROM pharmacy t1, COVID_USER t2      \n");
		sb.append("WHERE t1.user_id = t2.user_id        \n");
		sb.append("AND t1.user_id = ?                   \n");
		
		LOG.debug("=====================");
		LOG.debug("Query:" + sb.toString());
		LOG.debug("Param:" + inVO.toString());
		LOG.debug("=====================");
		
		Object[] args = {inVO.getUserId()};
		
		List<RxJoinVO> list =this.jdbcTemplate.query(sb.toString(), args, rowMapper);
		
		LOG.debug("list:" + list);
		LOG.debug("=====================");
		
		return list;
	}
	
	@Override
	public int doDelete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
