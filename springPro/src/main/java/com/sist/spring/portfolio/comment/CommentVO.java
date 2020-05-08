/**
 *<pre>
 * com.sist.spring.portfolio.license
 * Class Name : LicenseVO.java
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
package com.sist.spring.portfolio.comment;

import com.sist.spring.cmn.DTO;

/**
 * @author sist
 *
 */
public class CommentVO extends DTO {
	 
	private String cNo  ; 
	private String cContent  ; 
	private int cOpen;
	private String regDt ; 
	private String modDt; 
	private String regId; 
	private String memberId  ; 

	 public CommentVO() {}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public int getcOpen() {
		return cOpen;
	}

	public void setcOpen(int cOpen) {
		this.cOpen = cOpen;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	
	public CommentVO(String cNo, String cContent, int cOpen, String regDt, String modDt, String regId,
			String memberId) {
		super();
		this.cNo = cNo;
		this.cContent = cContent;
		this.cOpen = cOpen;
		this.regDt = regDt;
		this.modDt = modDt;
		this.regId = regId;
		this.memberId = memberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cContent == null) ? 0 : cContent.hashCode());
		result = prime * result + ((cNo == null) ? 0 : cNo.hashCode());
		result = prime * result + cOpen;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((modDt == null) ? 0 : modDt.hashCode());
		result = prime * result + ((regDt == null) ? 0 : regDt.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentVO other = (CommentVO) obj;
		if (cContent == null) {
			if (other.cContent != null)
				return false;
		} else if (!cContent.equals(other.cContent))
			return false;
		if (cNo == null) {
			if (other.cNo != null)
				return false;
		} else if (!cNo.equals(other.cNo))
			return false;
		if (cOpen != other.cOpen)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (modDt == null) {
			if (other.modDt != null)
				return false;
		} else if (!modDt.equals(other.modDt))
			return false;
		if (regDt == null) {
			if (other.regDt != null)
				return false;
		} else if (!regDt.equals(other.regDt))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentVO [cNo=" + cNo + ", cContent=" + cContent + ", cOpen=" + cOpen + ", regDt=" + regDt + ", modDt="
				+ modDt + ", regId=" + regId + ", memberId=" + memberId + "]";
	}

	
	 
}
