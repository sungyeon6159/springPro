package com.sist.spring.portfolio.member;

import com.sist.spring.cmn.DTO;

public class MemberVO extends DTO {
	
	/** 아이디 */
	private String memberId;
	/** 비밀번호 */
	private String password;
	/** 이름 */
	private String name;
	/** 이메일 */
	private String email;
	/** 생년월일 */
	private String birth;
	/** 핸드폰번호 */
	private String phone;
	/** 권한 */
	private String authority;
	/** 공개여부 */
	private String open;
	
	public MemberVO () {}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", birth=" + birth + ", phone=" + phone + ", authority=" + authority + ", open=" + open
				+ ", toString()=" + super.toString() + "]";
	}

	public MemberVO(String memberId, String password, String name, String email, String birth, String phone,
			String authority, String open) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.phone = phone;
		this.authority = authority;
		this.open = open;
	}

	
	
}
