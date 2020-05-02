package com.sist.spring.portfolio.project;

import com.sist.spring.cmn.DTO;

public class PjtFileVO extends DTO {
	private String savePNm;
	private String orgNm;
	private long fileSize;
	private String ext;
	private String divFile;
	private String gitAddress;
	private String memberId;
	
	public PjtFileVO() {
	}
	
	
	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getSavePNm() {
		return savePNm;
	}
	public void setSavePNm(String savePNm) {
		this.savePNm = savePNm;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getDivFile() {
		return divFile;
	}
	public void setDivFile(String divFile) {
		this.divFile = divFile;
	}
	public String getGitAddress() {
		return gitAddress;
	}
	public void setGitAddress(String gitAddress) {
		this.gitAddress = gitAddress;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "PjtFileVO [savePNm=" + savePNm + ", orgNm=" + orgNm + ", fileSize=" + fileSize + ", ext=" + ext
				+ ", divFile=" + divFile + ", gitAddress=" + gitAddress + ", memberId=" + memberId + "]";
	}
	
	
	
	
}
