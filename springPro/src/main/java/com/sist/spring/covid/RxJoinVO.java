/**
 *<pre>
 * com.sist.spring.covid
 * Class Name : RxJoinVO.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-04-25           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-04-25 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.sist.spring.covid;

import com.sist.spring.cmn.DTO;

/**
 * @author 82104
 * 관심약국 조인VO
 */
public class RxJoinVO extends DTO {
	private String userId;		//회원아이디
	private String code;		//일련번호
	private String name;		//약국명
	private String addr;		//약국주소
	private double lng;			//위도
	private double lat;			//경도
	private String email;		//이메일
	
	public RxJoinVO() {}

	public RxJoinVO(String userId, String code, String name, String addr, double lng, double lat, String email) {
		super();
		this.userId = userId;
		this.code = code;
		this.name = name;
		this.addr = addr;
		this.lng = lng;
		this.lat = lat;
		this.email = email;
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

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RxJoinVO [userId=" + userId + ", code=" + code + ", name=" + name + ", addr=" + addr + ", lng=" + lng
				+ ", lat=" + lat + ", email=" + email + ", toString()=" + super.toString() + "]";
	}
	
	
}
