/**
 *<pre>
 * com.sist.spring.covid
 * Class Name : CovidService.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-04-26           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-04-26 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.sist.spring.covid;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Service;

/**
 * @author 82104
 *
 */
@org.springframework.stereotype.Service
public class CovidService implements Service {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public CovidService() {}
	
	@Autowired
	private CovidDao covidDao;
	
	@Override
	public int doInsert(DTO dto) {
		return covidDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return covidDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return covidDao.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) {
		return covidDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return covidDao.doRetrieve(dto);
	}

}
