package com.sist.spring.portfolio.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Service;

public class ProjectService implements Service {

	public ProjectService() {
	}
	
	@Autowired
	ProjectDao pjtDao;
	
	
	@Override
	public int doInsert(DTO dto) {
		return this.pjtDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return this.pjtDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return this.pjtDao.doSelectOne(dto);
	}

	@Override
	public int doDelete(DTO dto) {
		return this.pjtDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return this.pjtDao.doRetrieve(dto);

	}

}
