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
package com.sist.spring.portfolio.license;

import com.sist.spring.cmn.DTO;

/**
 * @author sist
 *
 */
public class LicenseVO extends DTO {
	private String lName ; /**자격증명 */
	private String lGroup; /**자격 분류(국가기술,국가전문,민간,외국 등) */
	private String lKind ; /**자격증 종류(기사,기능사 등) */
	private String lNum  ; /**자격증 번호 */
	private String lLevel; /**자격 등급(1급,2급 등) */
	private String lGet  ; /**취득일 */
	private String lOrgan; /**발행기관 */
	private String userId; /**회원ID */

	 public LicenseVO() {}

	/**
	 * @param lName
	 * @param lGroup
	 * @param lKind
	 * @param lNum
	 * @param lLevel
	 * @param lGet
	 * @param lOrgan
	 * @param userId
	 */
	public LicenseVO(String lName, String lGroup, String lKind, String lNum, String lLevel, String lGet, String lOrgan,
			String userId) {
		super();
		this.lName = lName;
		this.lGroup = lGroup;
		this.lKind = lKind;
		this.lNum = lNum;
		this.lLevel = lLevel;
		this.lGet = lGet;
		this.lOrgan = lOrgan;
		this.userId = userId;
	}

	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return the lGroup
	 */
	public String getlGroup() {
		return lGroup;
	}

	/**
	 * @param lGroup the lGroup to set
	 */
	public void setlGroup(String lGroup) {
		this.lGroup = lGroup;
	}

	/**
	 * @return the lKind
	 */
	public String getlKind() {
		return lKind;
	}

	/**
	 * @param lKind the lKind to set
	 */
	public void setlKind(String lKind) {
		this.lKind = lKind;
	}

	/**
	 * @return the lNum
	 */
	public String getlNum() {
		return lNum;
	}

	/**
	 * @param lNum the lNum to set
	 */
	public void setlNum(String lNum) {
		this.lNum = lNum;
	}

	/**
	 * @return the lLevel
	 */
	public String getlLevel() {
		return lLevel;
	}

	/**
	 * @param lLevel the lLevel to set
	 */
	public void setlLevel(String lLevel) {
		this.lLevel = lLevel;
	}

	/**
	 * @return the lGet
	 */
	public String getlGet() {
		return lGet;
	}

	/**
	 * @param lGet the lGet to set
	 */
	public void setlGet(String lGet) {
		this.lGet = lGet;
	}

	/**
	 * @return the lOrgan
	 */
	public String getlOrgan() {
		return lOrgan;
	}

	/**
	 * @param lOrgan the lOrgan to set
	 */
	public void setlOrgan(String lOrgan) {
		this.lOrgan = lOrgan;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "LicenseVO [lName=" + lName + ", lGroup=" + lGroup + ", lKind=" + lKind + ", lNum=" + lNum + ", lLevel="
				+ lLevel + ", lGet=" + lGet + ", lOrgan=" + lOrgan + ", userId=" + userId + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lGet == null) ? 0 : lGet.hashCode());
		result = prime * result + ((lGroup == null) ? 0 : lGroup.hashCode());
		result = prime * result + ((lKind == null) ? 0 : lKind.hashCode());
		result = prime * result + ((lLevel == null) ? 0 : lLevel.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((lNum == null) ? 0 : lNum.hashCode());
		result = prime * result + ((lOrgan == null) ? 0 : lOrgan.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		LicenseVO other = (LicenseVO) obj;
		if (lGet == null) {
			if (other.lGet != null)
				return false;
		} else if (!lGet.equals(other.lGet))
			return false;
		if (lGroup == null) {
			if (other.lGroup != null)
				return false;
		} else if (!lGroup.equals(other.lGroup))
			return false;
		if (lKind == null) {
			if (other.lKind != null)
				return false;
		} else if (!lKind.equals(other.lKind))
			return false;
		if (lLevel == null) {
			if (other.lLevel != null)
				return false;
		} else if (!lLevel.equals(other.lLevel))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (lNum == null) {
			if (other.lNum != null)
				return false;
		} else if (!lNum.equals(other.lNum))
			return false;
		if (lOrgan == null) {
			if (other.lOrgan != null)
				return false;
		} else if (!lOrgan.equals(other.lOrgan))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	 
	 
}
