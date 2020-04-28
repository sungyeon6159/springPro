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
	private String cOpen;
	private String regDt ; 
	private String modDt; 
	private String memberId  ; 

	 public CommentVO() {}

	public CommentVO(String memberId, String cNo, String cContent, String cOpen, String regDt, String modDt) {
		super();
		this.memberId = memberId;
		this.cNo = cNo;
		this.cContent = cContent;
		this.cOpen = cOpen;
		this.regDt = regDt;
		this.modDt = modDt;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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

	public String getcOpen() {
		return cOpen;
	}

	public void setcOpen(String cOpen) {
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

	@Override
	public String toString() {
		return "CommentVO [memberId=" + memberId + ", cNo=" + cNo + ", cContent=" + cContent + ", cOpen=" + cOpen
				+ ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}

	

	 
	 
}
