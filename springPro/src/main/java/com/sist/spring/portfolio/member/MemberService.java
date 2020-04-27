package com.sist.spring.portfolio.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.spring.cmn.DTO;
import com.sist.spring.cmn.Service;

public class MemberService implements Service {

	@Autowired
	MemberDao memberDao;
	
	
	@Override
	public int doInsert(DTO dto) {
		return this.memberDao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return this.memberDao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return this.memberDao.doSelectOne(dto);
		
	}

	@Override
	public int doDelete(DTO dto) {
		return this.memberDao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return this.memberDao.doRetrieve(dto);
	}

}
