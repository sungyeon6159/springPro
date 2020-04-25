package com.sist.spring.cmn;

public class SearchVO extends DTO{

	private String searchDiv;
	private String searchWord;
	
	public SearchVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getSearchDiv() {
		return searchDiv;
	}
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	
	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
