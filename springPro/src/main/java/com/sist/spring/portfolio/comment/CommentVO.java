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
	private String memberId ; 
	private String regId; 
	private String modId  ; 
	private String regDt ; 
	private String modDt; 
	private String commentNo  ; 
	private String open;
	private String content;

	 public CommentVO() {}

	public CommentVO(String memberId, String regId, String modId, String regDt, String modDt, String commentNo,
			String open, String content) {
		super();
		this.memberId = memberId;
		this.regId = regId;
		this.modId = modId;
		this.regDt = regDt;
		this.modDt = modDt;
		this.commentNo = commentNo;
		this.open = open;
		this.content = content;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
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

	public String getcommentNo() {
		return commentNo;
	}

	public void setcommentNo(String commentNo) {
		this.commentNo = commentNo;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommentVO [memberId=" + memberId + ", regId=" + regId + ", modId=" + modId + ", regDt=" + regDt
				+ ", modDt=" + modDt + ", commentNo=" + commentNo + ", open=" + open + ", content=" + content
				+ ", toString()=" + super.toString() + "]";
	}
	 
	 

	 
	 
}
